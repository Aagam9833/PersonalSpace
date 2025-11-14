package com.aagamshah.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aagamshah.presentation.screens.chatscreen.ChatScreen
import com.aagamshah.presentation.screens.feedscreen.FeedScreen
import com.aagamshah.presentation.screens.mainscreen.MainContainerScreen
import com.aagamshah.presentation.screens.profilescreen.ProfileScreen

@Composable
fun RootNavigation() {
    val rootNavController = rememberNavController()

    NavHost(
        navController = rootNavController,
        startDestination = RootRoute.MainRoute
    ) {

        composable<RootRoute.MainRoute> {
            MainContainerScreen()
        }
    }
}

@Composable
fun InternalTabNavigation(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = MainTabRoute.Feed,
        modifier = modifier
    ) {
        composable<MainTabRoute.Feed> {
            FeedScreen()
        }
        composable<MainTabRoute.Chat> {
            ChatScreen()
        }
        composable<MainTabRoute.Profile> {
            ProfileScreen()
        }
    }
}