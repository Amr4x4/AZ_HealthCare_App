package com.example.azhealthcare.navegation

sealed class Screen(val route: String) {
    object Onboarding : Screen("onboarding")
    object GetStartScreen : Screen("get_start_screen")
    object Languages : Screen("languages")
    object LogIn : Screen("log_in")
    object SignUpFirstScreen : Screen("sign_up_first_screen")
    object SignUpSecondScreen : Screen("sign_up_second_screen")
    object Home : Screen("home")
}
