package com.aagamshah.presentation.screens.mainscreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.aagamshah.presentation.composables.AppBottomBar
import com.aagamshah.presentation.model.mainTabItems
import com.aagamshah.presentation.navigation.navigateToTab

@Composable
fun MainScreenBottomBar(
    navController: NavHostController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    AppBottomBar(
        tabs = mainTabItems,
        currentDestination = currentDestination,
        onTabClick = { route ->
            navController.navigateToTab(route)
        }
    )
}