package com.aagamshah.presentation.screens.mainscreen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.aagamshah.presentation.navigation.InternalTabNavigation

@Composable
fun MainContainerScreen() {
    val tabNavController = rememberNavController()

    Scaffold(
        bottomBar = {
            MainScreenBottomBar(navController = tabNavController)
        }
    ) { innerPadding ->
        InternalTabNavigation(
            navController = tabNavController,
            modifier = Modifier.padding(bottom = innerPadding.calculateBottomPadding())
        )
    }
}