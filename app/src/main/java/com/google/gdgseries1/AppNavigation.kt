package com.google.gdgseries1

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Main.route) {
        composable(Screen.Main.route) {
            MainScreen(goToDetails = { quantity ->
                navController.navigate("${Screen.Details.route}/$quantity")
            })
        }
        composable("${Screen.Details.route}/{quantity}", arguments = listOf(
            navArgument("quantity") {
                type = NavType.IntType
            }
        )) { entry ->
            DetailsContent(quantity = entry.arguments?.getInt("quantity"))
        }
    }

}