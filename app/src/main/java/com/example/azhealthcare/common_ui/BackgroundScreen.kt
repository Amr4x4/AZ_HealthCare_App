package com.example.azhealthcare.common_ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.azhealthcare.R

@Composable
fun BackgroundScreen(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.background_screen),
        contentDescription = "Background Image",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize(),
        alpha = 0.7f
    )
}

@Preview
@Composable
private fun PreviewBackground() {
    BackgroundScreen()
}