package com.aagamshah.presentation.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.aagamshah.presentation.navigation.MainTabRoute

data class TabItem(
    val route: MainTabRoute,
    val name: String,
    val icon: ImageVector
)

val mainTabItems: List<TabItem> = listOf(
    TabItem(
        route = MainTabRoute.Feed,
        name = "Feed",
        icon = Icons.Default.Home
    ),
    TabItem(
        route = MainTabRoute.Chat,
        name = "Chat",
        icon = Icons.Default.Email
    ),
    TabItem(
        route = MainTabRoute.Profile,
        name = "Profile",
        icon = Icons.Default.Person
    )
)