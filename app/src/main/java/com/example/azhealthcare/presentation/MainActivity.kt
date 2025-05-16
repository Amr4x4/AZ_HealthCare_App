package com.example.azhealthcare.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.azhealthcare.presentation.navegation.AppNavHost
import com.example.azhealthcare.presentation.screens.profile.ProfileScreen
import com.example.azhealthcare.presentation.theme.AzHealthCareTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AzHealthCareTheme {
                ProfileScreen()
            }
        }
    }
}
