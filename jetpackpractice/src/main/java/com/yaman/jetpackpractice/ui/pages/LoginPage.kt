package com.yaman.jetpackpractice.ui.pages

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.yaman.jetpackpractice.ui.components.LoginAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(
    navController: NavController = rememberNavController(),
    modifier: Modifier = Modifier
) {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize(),

        ) {
        LoginAppBar()
        TextField(
            value = "",
            onValueChange = { text ->

            },
            placeholder = { Text("Enter Address") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp, top = 30.dp, bottom = 0.dp)
        )
        TextField(
            value = "",
            onValueChange = { text -> },
            placeholder = { Text("Password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp, top = 12.dp, bottom = 14.dp)
        )
        Text(
            text = "Forget Password", modifier = Modifier
                .align(alignment = Alignment.End)
                .padding(start = 12.dp, end = 12.dp, top = 20.dp, bottom = 20.dp)
                .clickable {
                    Toast
                        .makeText(context, "CLicked Here...", Toast.LENGTH_SHORT)
                        .show()
                }
        )
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp, top = 20.dp, bottom = 20.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
        ) {
            Text(
                "Login",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LoginPagePreview() {
    LoginPage()
}