package com.example.azhealthcare.navegation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

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