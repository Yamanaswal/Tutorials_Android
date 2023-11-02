package com.yaman.jetpackpractice.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.yaman.jetpackpractice.R
import com.yaman.jetpackpractice.ui.components.LoginAppBar
import com.yaman.jetpackpractice.view_model.LoginViewModel

@Composable
fun LoginPage(
    navController: NavController = rememberNavController(),
    modifier: Modifier = Modifier
) {

    val context = LocalContext.current
    var email by rememberSaveable { mutableStateOf("") }
    var mobile by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) } //rememberSaveable in survived configuration change and save state in bundle.
    var showEmailField by rememberSaveable { mutableStateOf(false) }
    var showMobileField by rememberSaveable { mutableStateOf(true) }
    val maxLengthMobileNumber = 10
    val loginViewModel: LoginViewModel = viewModel()
    val loginRes by loginViewModel.loginResponse.observeAsState()
    val tabs = listOf("Login", "Sign Up")
    var tabIndex by remember { mutableStateOf(0) }


    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        LoginAppBar()
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp, end = 12.dp, top = 20.dp, bottom = 20.dp)
            ) {

                TabRow(
                    selectedTabIndex = tabIndex,
                    modifier = Modifier
                        .background(
                            color = colorResource(id = R.color.white),
                            shape = RoundedCornerShape(30.dp)
                        )
                        .padding(start = 5.dp, end = 5.dp, top = 5.dp, bottom = 5.dp),
                    containerColor = Color.Transparent,
                    divider = {}, //no bottom divider
                    indicator = { tabPositions ->
                        // Create a custom indicator that's transparent
                        // This effectively removes the indicator line
                        TabRowDefaults.Indicator(
                            color = Color.Transparent,
                        )
                    },
                    contentColor = Color.White,
                ) {
                    tabs.forEachIndexed { index, title ->
                        /*Login*/
                        if (index == 0) {
                            Tab(
                                modifier = Modifier
                                    .background(
                                        color = colorResource(id = if (tabIndex == 0) R.color.colorPrimary else R.color.white),
                                        shape = RoundedCornerShape(30.dp)
                                    ),
                                text = {
                                    Text(title, fontSize = 16.sp, color = colorResource(id = if (tabIndex == 0) R.color.white else R.color.black))
                                },
                                selected = tabIndex == 0,
                                onClick = { tabIndex = index })
                        }
                        /*SignUp*/
                        else if (index == 1) {
                            Tab(modifier = Modifier
                                .background(
                                    color = colorResource(id = if (tabIndex == 1) R.color.colorPrimary else R.color.white),
                                    shape = RoundedCornerShape(30.dp)
                                ),
                                text = {
                                    Text(title, fontSize = 16.sp, color = colorResource(id = if (tabIndex == 1) R.color.white else R.color.black))
                                },
                                selected = tabIndex == 1,
                                onClick = { tabIndex = index })
                        }
                    }
                }
            }
            when (tabIndex) {
                0 -> LoginBottomSection(navController)
                1 -> SignUpBottomSection(navController)
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun LoginPagePreview() {
    LoginPage()
}