package com.example.azhealthcare.presentation.common_ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

sealed class BottomNavItem(
    val route: String,
    val title: String,
    val icon: @Composable () -> Unit
) {
    data object Home : BottomNavItem(
        route = "home",
        title = "Home",
        icon = { Icon(Icons.Filled.Home, contentDescription = "Home") }
    )
    data object Profile : BottomNavItem(
        route = "profile",
        title = "Profile",
        icon = { Icon(Icons.Filled.Person, contentDescription = "Profile") }
    )
    data object Settings : BottomNavItem(
        route = "settings",
        title = "Settings",
        icon = { Icon(Icons.Filled.Settings, contentDescription = "Settings") }
    )
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Profile,
        BottomNavItem.Settings
    )

    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            NavigationBarItem(
                icon = item.icon,
                label = { Text(item.title) },
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }
            )
        }
    }
} 