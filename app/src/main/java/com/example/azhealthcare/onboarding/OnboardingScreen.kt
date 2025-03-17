package com.example.azhealthcare.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.azhealthcare.R
import com.example.azhealthcare.common_ui.MyButton

@Composable
fun OnboardingScreen(
    title: String,
    description: String,
    imageRes: Int,
    pageIndicator: @Composable () -> Unit,
    onNextClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Black)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()

        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = description,
                modifier = Modifier
                    .height(303.dp)
                    .width(350.dp)
                    .fillMaxWidth()

            )
            Spacer(modifier = Modifier.height(16.dp))
            pageIndicator()
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = title,
                color = White,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = description, textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(16.dp))
            MyButton(
                text = "Next",
                onClick = { /*TODO*/ }
            )

        }
    }
}

@Preview
@Composable
private fun PreviewOnBoardingScreen() {
    OnboardingScreen(
        title = "What is You age",
        description = "Choice one of the following",
        imageRes = R.drawable.gg,
        pageIndicator = { /*TODO*/ }
    ) {

    }
}
