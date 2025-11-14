package com.aagamshah.presentation.navigation

import kotlinx.serialization.Serializable

sealed interface RootRoute {
    @Serializable
    data object LoginRoute : RootRoute

    @Serializable
    data object MainRoute : RootRoute
}

sealed interface MainTabRoute {
    @Serializable
    data object Feed : MainTabRoute

    @Serializable
    data object Chat : MainTabRoute

    @Serializable
    data object Profile : MainTabRoute

}