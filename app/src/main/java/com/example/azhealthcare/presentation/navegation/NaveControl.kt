package com.example.azhealthcare.presentation.navegation

import androidx.navigation.NavHostController

class NavController {
    private var navController: NavHostController? = null

    fun setNavController(controller: NavHostController) {
        navController = controller
    }

    fun navigateTo(route: String) {
        navController?.navigate(route)
    }

    fun navigateBack() {
        navController?.popBackStack()
    }

    fun navigateAndClearBackStack(route: String) {
        navController?.navigate(route) {
            popUpTo(0) { inclusive = true }
        }
    }
}