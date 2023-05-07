package com.pomac.baseapplicationarch.ui.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.pomac.baseapplicationarch.ui.view.BottomNavigation
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem

@Composable
fun BottomNavBar(navController: NavController) {

    val screens = listOf(
        BottomNavigation.Home,
        BottomNavigation.Profile,
        BottomNavigation.Settings,
    )

    val navGraphBackStack by navController.currentBackStackEntryAsState()
    val currentDestination = navGraphBackStack?.destination

    BottomNavigation(modifier = Modifier.padding(20.dp).clip(RoundedCornerShape(25.dp))) {
        screens.forEach {
            AddNavItem(selected = currentDestination?.hierarchy?.any { navDestination -> navDestination.route == it.route } == true , icon = it.icon , text = it.title) {
                navController.navigate(it.route) {
                    popUpTo(navController.graph.findStartDestination().id)
                    launchSingleTop = true
                }
            }
        }
    }
}

@Composable
fun RowScope.AddNavItem(selected:Boolean , icon: ImageVector , text : String , onClick : () -> Unit){
    BottomNavigationItem(selected = selected, onClick = onClick , label = { Text(text = text)} , icon = { Image(
        imageVector = icon,
        contentDescription = "ICON"
    )})
}



@Preview
@Composable
fun BottomNavBarPrev() {
    val navController = rememberNavController()
    BottomNavBar(navController)
}