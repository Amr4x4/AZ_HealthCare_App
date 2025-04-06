package com.example.azhealthcare.navegation

sealed class Screen(val route: String) {
    object GetStartScreen : Screen("get_start_screen")
    object Languages : Screen("languages")
    object LogIn : Screen("login")
    object SignUpFirstScreen : Screen("sign_up_first_screen")
    object SignUpSecondScreen : Screen("sign_up_second_screen")
    object Home : Screen("home")
}