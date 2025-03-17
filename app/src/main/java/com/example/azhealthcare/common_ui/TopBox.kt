package com.example.azhealthcare.common_ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.azhealthcare.ui.theme.Purple500
import com.example.azhealthcare.ui.theme.Purple700

@Composable
fun TopBox(
    title:String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Purple700,
                        Purple500
                    ),
                    startY = 0f,
                    endY = 200f
                ),
                shape = RoundedCornerShape(bottomStart = 64.dp, bottomEnd = 64.dp)
            )
            .height(100.dp),
    ) {
        Text(
            text = title, style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                fontFamily = FontFamily.Serif
            ),
            modifier = Modifier.align(Alignment.Center),
            color = Color.White
        )
    }
}