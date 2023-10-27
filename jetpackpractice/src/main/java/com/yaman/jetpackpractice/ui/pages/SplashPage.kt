package com.yaman.jetpackpractice.ui.pages

import android.view.animation.OvershootInterpolator
import android.widget.Toast
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.yaman.jetpackpractice.R
import com.yaman.jetpackpractice.ui.Routes
import com.yaman.jetpackpractice.utils.PrefConstants
import com.yaman.jetpackpractice.utils.PreferencesUtil
import kotlinx.coroutines.delay

@Composable
fun SplashPage(
    navController: NavController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        //Animation
        val scale = remember {
            Animatable(0f)
        }

        val isUserLogin = PreferencesUtil.getBooleanPreference(context, PrefConstants.IS_USER_LOGIN)

        // Animation
        LaunchedEffect(key1 = true) {
            scale.animateTo(
                targetValue = 0.7f,
                // tween Animation
                animationSpec = tween(
                    durationMillis = 800,
                    easing = {
                        OvershootInterpolator(4f).getInterpolation(it)
                    })
            )

            // Customize the delay time
            delay(4000L)

            if (isUserLogin) {
                navController.popBackStack()
                navController.navigate(Routes.DASHBOARD)
            } else {
                navController.popBackStack()
                navController.navigate(Routes.LOGIN_PAGE)
            }
        }

        Image(
            modifier = Modifier
                .padding(start = 12.dp, end = 12.dp, top = 30.dp)
                .align(Alignment.Center)
                .clickable {
                    Toast
                        .makeText(context, "Image View", Toast.LENGTH_SHORT)
                        .show()
                },
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = ""
        )
    }
}


@Preview(showBackground = true)
@Composable
fun SplashPreview() {
    SplashPage()
}