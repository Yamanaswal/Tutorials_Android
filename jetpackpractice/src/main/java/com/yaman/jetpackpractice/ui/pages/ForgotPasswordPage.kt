package com.yaman.jetpackpractice.ui.pages

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun ForgotPasswordPage(
    navController: NavController = rememberNavController(),
    modifier: Modifier = Modifier
) {

    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Text(text = "HIII")
    }
}


@Preview(showBackground = true)
@Composable
fun ForgotPasswordPreview() {
    ForgotPasswordPage()
}