package com.yaman.jetpackpractice.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.yaman.jetpackpractice.R

@Composable
fun LoginAppBar() {

    Box(
        Modifier
            .fillMaxWidth()
            .background(color = Color.Red)
    ) {
        Column(
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.mipmap.ic_logo_login),
                contentDescription = ""
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppBarPreview() {
    LoginAppBar()
}

