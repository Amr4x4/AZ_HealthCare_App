package com.example.azhealthcare.screens

import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.os.LocaleListCompat
import androidx.navigation.NavHostController
import com.example.azhealthcare.common_ui.BackgroundScreen
import com.example.azhealthcare.common_ui.MyButton
import com.example.azhealthcare.common_ui.TopBox
import com.example.azhealthcare.ui.theme.OrangeDark
import com.example.azhealthcare.ui.theme.OrangeLight
import com.example.azhealthcare.ui.theme.Purple500
import com.example.azhealthcare.ui.theme.Purple700
import com.example.azhealthcare.ui.theme.Selected
import com.example.azhealthcare.ui.theme.UnSelected

@Composable
fun Languages(
    navController: NavHostController
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
                    colors = ButtonDefaults.outlinedButtonColors(
                        backgroundColor =
                        if (selectedLanguage == languageTag) Selected
                        else UnSelected
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
            enabled = selectedLanguage != null ,
            onClick = {
                // Action
            },
            modifier = Modifier.padding(16.dp)
        )

        Spacer(modifier = Modifier.height(64.dp))
    }
}



@Preview
@Composable
private fun LanguagePreview() {
    Languages(navController = NavHostController(LocalContext.current))
}
