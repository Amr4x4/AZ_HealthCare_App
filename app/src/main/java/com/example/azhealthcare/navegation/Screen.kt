package com.example.azhealthcare.navegation

sealed class Screen(val route: String) {
    data object Onboarding : Screen("onboarding")
    data object GetStartScreen : Screen("get_start_screen")
    data object Languages : Screen("languages")
    data object LogIn : Screen("log_in")
    data object SignUpFirstScreen : Screen("sign_up_first_screen")
    data object SignUpSecondScreen : Screen("sign_up_second_screen")
    data object Home : Screen("home")
    data object Profile : Screen("profile")
    data object Settings : Screen("settings")
}
