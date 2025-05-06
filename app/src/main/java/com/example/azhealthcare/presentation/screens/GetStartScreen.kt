package com.example.azhealthcare.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.azhealthcare.R
import com.example.azhealthcare.presentation.common_ui.BackgroundScreen
import com.example.azhealthcare.presentation.common_ui.MyButton
import com.example.azhealthcare.presentation.navegation.NavController
import com.example.azhealthcare.presentation.navegation.Screen


@Composable
fun StartPage(
    navController: NavController
) {
    BackgroundScreen()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = painterResource(id = R.drawable.oo),
            contentDescription = stringResource(R.string.get_start_image_description),
            contentScale = ContentScale.Crop,
            modifier = Modifier.padding(top = 64.dp)
        )
        Spacer(modifier = Modifier.height(64.dp))
        Text(
            text = stringResource(R.string.app_name),
            style = TextStyle(
                fontWeight = FontWeight.ExtraBold,
                fontSize = 45.sp,
                fontFamily = FontFamily.Serif
            ),
            color = Color.White,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = stringResource(R.string.start_screen_description),
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Cursive
            ),
            color = Color.Gray,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(32.dp))

        MyButton(
            text = stringResource(R.string.get_started),
            enabled = true,
            onClick = {
                navController.navigateTo(Screen.Languages.route)
            }
        )
    }
}

@Preview
@Composable
private fun StartPagePreview() {
    StartPage(navController = NavController())
}