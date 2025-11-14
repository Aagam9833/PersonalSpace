package com.aagamshah.presentation.composables

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import com.aagamshah.presentation.model.TabItem
import com.aagamshah.presentation.navigation.MainTabRoute

@Composable
fun AppBottomBar(
    tabs: List<TabItem>,
    currentDestination: NavDestination?,
    onTabClick: (MainTabRoute) -> Unit
) {
    NavigationBar {
        tabs.forEach { tab ->
            val isSelected = currentDestination?.hierarchy?.any {
                it.hasRoute(tab.route::class)
            } == true

            NavigationBarItem(
                icon = { Icon(tab.icon, contentDescription = tab.name) },
                label = { Text(tab.name) },
                selected = isSelected,
                onClick = { onTabClick(tab.route) }
            )
        }
    }
}