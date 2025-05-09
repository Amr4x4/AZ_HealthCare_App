package com.example.azhealthcare.presentation.screens

import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.os.LocaleListCompat
import com.example.azhealthcare.presentation.common_ui.BackgroundScreen
import com.example.azhealthcare.presentation.common_ui.MyButton
import com.example.azhealthcare.presentation.common_ui.TopBox
import com.example.azhealthcare.presentation.navegation.NavController
import com.example.azhealthcare.presentation.navegation.Screen


@Composable
fun Languages(
    navController: NavController
) {
    val localeOptions = mapOf(
        "العربية" to "ar",
        "English" to "en"
    )

    // State to hold the selected language
    var selectedLanguage by remember { mutableStateOf<String?>(null) }

    BackgroundScreen()
    Column(
        Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopBox(title = "Select Language")

        // Language options
        Column(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            localeOptions.forEach { (languageName, languageTag) ->
                OutlinedButton(
                    onClick = {
                        selectedLanguage = languageTag
                        AppCompatDelegate.setApplicationLocales(
                            LocaleListCompat.forLanguageTags(languageTag)
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 7.dp, start = 8.dp, end = 8.dp)
                        .shadow(
                            10.dp,
                            shape = RoundedCornerShape(10.dp),
                            ambientColor = Color.Black
                        ),
                    shape = RoundedCornerShape(20.dp),
                ) {
                    Text(
                        text = languageName, style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                        ), modifier = Modifier.padding(vertical = 6.dp),
                        color = Color.White
                    )
                }
            }
        }

        // Disable the Next button until a language is selected
        MyButton(
            text = "Next",
            enabled = selectedLanguage != null,
            onClick = {
                navController.navigateTo(Screen.LogIn.route)
            },
            modifier = Modifier.padding(16.dp)
        )

        Spacer(modifier = Modifier.height(64.dp))
    }
}

@Preview
@Composable
private fun LanguagePreview() {
    Languages(navController = NavController())
}