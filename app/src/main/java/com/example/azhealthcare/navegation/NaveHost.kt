package com.example.azhealthcare.navegation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.azhealthcare.onboarding.OnboardingScreen
import com.example.azhealthcare.screens.Languages
import com.example.azhealthcare.screens.LoginScreen
import com.example.azhealthcare.screens.StartPage
import com.example.azhealthcare.screens.sign_up.SignUpFirstScreen
import com.example.azhealthcare.screens.sign_up.SignUpSecondScreen

@Composable
fun AppNavHost(
    navController: NavController = NavController()
) {
    val navHostController = rememberNavController()
    navController.setNavController(navHostController)

    NavHost(
        navController = navHostController,
        startDestination = Screen.Onboarding.route
    ) {
        composable(Screen.Onboarding.route) {
            OnboardingScreen(navController)
        }
        composable(Screen.GetStartScreen.route) {
            StartPage(navController)
        }

        composable(Screen.Languages.route) {
            Languages(navController)
        }

        composable(Screen.LogIn.route) {
            LoginScreen(navController)
        }

        composable(Screen.SignUpFirstScreen.route) {
            SignUpFirstScreen(navController)
        }

        composable(Screen.SignUpSecondScreen.route) {
            SignUpSecondScreen(navController)
        }
    }
}