package com.yaman.jetpackpractice.ui.pages

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.yaman.jetpackpractice.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgotPasswordPage(
    navController: NavController = rememberNavController(),
    modifier: Modifier = Modifier
) {

    val context = LocalContext.current

    val maxLengthMobileNumber: Int=10
    val interactionSource = remember { MutableInteractionSource() }
    var text by remember { mutableStateOf("") }
    // Creating a variable to store password
    var password by remember { mutableStateOf("") }
    // Creating a variable to store toggle state
    var passwordVisible by remember { mutableStateOf(false) }

    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())) {
        Image(
            painter = painterResource(id = R.drawable.ic_back), // Replace 'your_image' with the actual resource ID of your image
            contentDescription = null, // Provide a content description for accessibility
            modifier = Modifier
                .padding(
                    start = 12.dp,
                    top = 12.dp
                )
                .clickable {
                    Toast
                        .makeText(context, "Dhik nhi rha kaam chal raha h!!", Toast.LENGTH_SHORT)
                        .show()
                }
        )

        Image(
            painter = painterResource(id = R.drawable.forget), // Replace 'your_image' with the actual resource ID of your image
            contentDescription = null, // Provide a content description for accessibility
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(top = 20.dp)

        )

        Text(
            text = "Reset Password",
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp)
        )

        Text(
            text = "Don't worry! it happens, please enter the address associated with your account.",
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, top = 12.dp, end = 12.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp, top = 50.dp)
                .clip(shape = RoundedCornerShape(30.dp))
                .background(colorResource(id = R.color.app_grey))
                .height(50.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {


            Image(
                painter = painterResource(id = R.drawable.flag_india), // Replace 'your_image' with the actual resource ID of your image
                contentDescription = null, // Provide a content description for accessibility
                modifier = Modifier
                    .width(40.dp)
                    .padding(start = 12.dp)
                    .height(40.dp)
            )

            TextField(
                value = text,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                onValueChange = { if (it.length <= maxLengthMobileNumber) text = it },
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
            )

        }

        Text(
            text = "Recover using email",
            fontSize = 14.sp,
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp, end = 12.dp)
        )


        Button(
            onClick = {
//                if (text.equals("")) {
//                    Toast
//                        .makeText(context, "Mobile Number is Required!!", Toast.LENGTH_SHORT)
//                        .show()} else{
//                    context.startActivity(Intent(context, SignupActivity::class.java))}
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(20.dp), modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp, start = 12.dp, end = 12.dp)
        ) {
            Text(text = "Continue", fontWeight = FontWeight.Bold)
        }

    }
}


@Preview(showBackground = true)
@Composable
fun ForgotPasswordPreview() {
    ForgotPasswordPage()
}