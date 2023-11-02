package com.yaman.jetpackpractice.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun HintedBasicTextField(hint: String, text: TextFieldValue, onValueChange: (TextFieldValue) -> Unit) {
    val density = LocalDensity.current.density
    val placeholderTextSize = 16.sp
    val placeholderColor = Color.Gray

    BasicTextField(
        value = text,
        onValueChange = onValueChange,
        textStyle = LocalTextStyle.current.copy(
            fontSize = placeholderTextSize,
            color = placeholderColor
        ),
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Gray)
            .padding(end = 10.dp)
    )

    // Show the hint (placeholder) when the text is empty
    if (text.text.isEmpty()) {
        DrawHintText(hint, placeholderTextSize, placeholderColor, density)
    }
}

@Composable
private fun DrawHintText(
    hint: String,
    placeholderTextSize: TextUnit,
    placeholderColor: Color,
    density: Float
) {
    val placeholderModifier = Modifier.padding(
        start = 12.dp, // Adjust the padding as needed
        top = 8.dp // Adjust the padding as needed
    )

    BasicTextField(
        value = TextFieldValue(hint),
        onValueChange = {},
        textStyle = LocalTextStyle.current.copy(
            fontSize = placeholderTextSize,
            color = placeholderColor
        ),
        modifier = placeholderModifier
    )
}
