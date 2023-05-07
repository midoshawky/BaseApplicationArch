package com.pomac.baseapplicationarch.ui.view.routes

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pomac.baseapplicationarch.ui.view.BottomNavigation
import com.pomac.baseapplicationarch.ui.view.screens.HomeScreen
import com.pomac.baseapplicationarch.ui.view.screens.ProfileScreen
import com.pomac.baseapplicationarch.ui.view.screens.SettingsScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(navController = navController , startDestination = BottomNavigation.Home.route){
        composable(BottomNavigation.Home.route){
            HomeScreen()
        }
        composable(BottomNavigation.Profile.route){
            ProfileScreen()
        }
        composable(BottomNavigation.Settings.route){
            SettingsScreen()
        }
    }
}