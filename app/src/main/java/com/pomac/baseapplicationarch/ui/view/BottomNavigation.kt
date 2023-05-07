package com.pomac.baseapplicationarch.ui.view

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigation(
    val route : String,
    val title : String,
    val icon : ImageVector
) {
    object Home : BottomNavigation("home","Home",Icons.Default.Home)
    object Profile : BottomNavigation("profile","Profile",Icons.Default.Person)
    object Settings : BottomNavigation("settings","Settings",Icons.Default.Settings)
}
