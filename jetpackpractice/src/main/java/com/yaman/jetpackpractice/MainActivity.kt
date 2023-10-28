package com.yaman.jetpackpractice

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yaman.jetpackpractice.ui.pages.HomePage
import com.yaman.jetpackpractice.ui.Routes
import com.yaman.jetpackpractice.ui.pages.LoginPage
import com.yaman.jetpackpractice.ui.pages.SignUpPage
import com.yaman.jetpackpractice.ui.pages.SplashPage
import com.yaman.jetpackpractice.ui.theme.JetpackPracticeTheme

@SuppressLint("CustomSplashScreen")
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            JetpackPracticeTheme {
                Surface {
                  Navigation()
                }
            }
        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.SPLASH_PAGE
    ) {
        composable(route = Routes.SPLASH_PAGE) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                SplashPage(navController)
            }
        }
        composable(route = Routes.DASHBOARD) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                HomePage(navController)
            }
        }
        composable(route = Routes.LOGIN_PAGE) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                LoginPage(navController)
            }
        }
        composable(route = Routes.SIGN_UP_PAGE) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                SignUpPage(navController)
            }
        }
        composable(route = Routes.SIGN_UP_PAGE) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                SignUpPage(navController)
            }
        }
    }
}

