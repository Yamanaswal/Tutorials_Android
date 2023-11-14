package com.yaman.jetpackpractice.ui.pages

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.yaman.jetpackpractice.R
import com.yaman.jetpackpractice.data.models.EncryptionData
import com.yaman.jetpackpractice.ui.routes.Routes
import com.yaman.jetpackpractice.view_model.LoginViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginBottomSection(
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
    var loginTypeMsg by rememberSaveable { mutableStateOf("Login with email") }
    val loginViewModel: LoginViewModel = viewModel()
    val loginRes by loginViewModel.loginResponseLiveData.observeAsState()
    val error by loginViewModel.errorResponseLivedata.observeAsState()
    val interactionSource = remember { MutableInteractionSource() }

    Column(
        modifier = Modifier
            .fillMaxSize(),

        ) {

        AnimatedVisibility(visible = showMobileField) {
            TextField(
                value = mobile,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                onValueChange = { if (it.length <= maxLengthMobileNumber) mobile = it },
                singleLine = true,
                shape = RoundedCornerShape(30.dp),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = colorResource(id = R.color.black),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    containerColor = colorResource(id = R.color.app_grey)
                ),
                placeholder = { Text("Mobile Number") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp, end = 12.dp, top = 20.dp, bottom = 0.dp)
            )
        }


        AnimatedVisibility(visible = showEmailField) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp, end = 12.dp, top = 20.dp, bottom = 12.dp)
                    .background(
                        color = colorResource(id = R.color.app_grey),
                        shape = RoundedCornerShape(30.dp)
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                Image(
                    painter = painterResource(id = R.drawable.flag_india),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(start = 12.dp, top = 12.dp, bottom = 12.dp)
                        .align(Alignment.CenterVertically)
                )

                Spacer(modifier = Modifier.width(16.dp))

                TextField(
                    value = email,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    onValueChange = { if (it.length <= maxLengthMobileNumber) email = it },
                    singleLine = true,
                    shape = RoundedCornerShape(30.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = colorResource(id = R.color.black),
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        containerColor = colorResource(id = R.color.app_grey)
                    ),
                    placeholder = { Text("Email Address") },
                    modifier = Modifier
                        .fillMaxWidth()
                )

            }
        }


        TextField(
            value = password,
            onValueChange = { password = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            placeholder = { Text("Password") },
            singleLine = true,
            shape = RoundedCornerShape(30.dp),
            colors = TextFieldDefaults.textFieldColors(
                textColor = colorResource(id = R.color.black),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                containerColor = colorResource(id = R.color.app_grey)
            ),
            trailingIcon = {

                val image = if (passwordVisible) {
                    R.drawable.ic_eye
                } else {
                    R.drawable.ic_eye
                }

                Icon(painter = painterResource(id = image), contentDescription = "",
                    Modifier.clickable {
                        passwordVisible = !passwordVisible
                    })
            },
            visualTransformation = if (passwordVisible) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp, top = 12.dp, bottom = 14.dp)
        )


        Text(
            text = "Forget Password?",
            modifier = Modifier
                .align(alignment = Alignment.End)
                .padding(start = 12.dp, end = 12.dp, top = 12.dp, bottom = 12.dp)
                .clickable(
                    indication = null, // This is mandatory stop ripple effect
                    interactionSource = remember { MutableInteractionSource() } // This is mandatory stop ripple effect
                ) {
                    navController.navigate(Routes.FORGOT_PASSWORD)
                }
        )


        Button(
            onClick = {

                val encryptionData = EncryptionData()
                encryptionData.mobile = mobile
                encryptionData.password = password
                encryptionData.email = email
                encryptionData.device_id = "1"
                encryptionData.is_social = "0"
                encryptionData.c_code = "91"
                encryptionData.device_token = "123124124241"

                loginViewModel.loginApiCall(context, encryptionData)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp, top = 20.dp, bottom = 20.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
        ) {
            Text(
                "Login",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp, bottom = 5.dp),
                textAlign = TextAlign.Center
            )
        }


        Text(
            text = loginTypeMsg,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(start = 12.dp, end = 12.dp, top = 0.dp, bottom = 20.dp)
                .clickable(
                    indication = null, // This is mandatory stop ripple effect
                    interactionSource = remember { MutableInteractionSource() } // This is mandatory stop ripple effect
                ) {
                    if (showMobileField) {
                        showEmailField = true
                        showMobileField = false
                        loginTypeMsg = "Login with mobile number"
                    } else {
                        showEmailField = false
                        showMobileField = true
                        loginTypeMsg = "Login with email"
                    }
                }
        )
    }

}


@Preview(showBackground = true)
@Composable
fun LoginBottomSectionPreview() {
    LoginBottomSection()
}