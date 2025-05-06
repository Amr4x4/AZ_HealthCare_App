package com.example.azhealthcare.presentation.navegation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.azhealthcare.presentation.common_ui.BottomNavigationBar
import com.example.azhealthcare.presentation.onboarding.OnboardingScreen
import com.example.azhealthcare.presentation.screens.Languages
import com.example.azhealthcare.presentation.screens.LoginScreen
import com.example.azhealthcare.presentation.screens.StartPage
import com.example.azhealthcare.presentation.screens.sign_up.SignUpFirstScreen
import com.example.azhealthcare.presentation.screens.sign_up.SignUpSecondScreen
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier

@Composable
fun AppNavHost(
    navController: NavController = NavController()
) {
    val navHostController = rememberNavController()
    navController.setNavController(navHostController)
    var showBottomBar by remember { mutableStateOf(false) }

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                BottomNavigationBar(navHostController)
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            NavHost(
                navController = navHostController,
                startDestination = Screen.Onboarding.route
            ) {
                composable(Screen.Onboarding.route) {
                    showBottomBar = false
                    OnboardingScreen(navController)
                }
                composable(Screen.GetStartScreen.route) {
                    showBottomBar = false
                    StartPage(navController)
                }

                composable(Screen.Languages.route) {
                    showBottomBar = false
                    Languages(navController)
                }

                composable(Screen.LogIn.route) {
                    showBottomBar = false
                    LoginScreen(navController)
                }

                composable(Screen.SignUpFirstScreen.route) {
                    showBottomBar = false
                    SignUpFirstScreen(navController)
                }

                composable(Screen.SignUpSecondScreen.route) {
                    showBottomBar = false
                    SignUpSecondScreen(navController)
                }

                composable(Screen.Home.route) {
                    showBottomBar = true
                    // Add your home screen content here
                }

                composable(Screen.Profile.route) {
                    showBottomBar = true
                    // Add your profile screen content here
                }

                composable(Screen.Settings.route) {
                    showBottomBar = true
                    // Add your settings screen content here
                }
            }
        }
    }
}