package com.aagamshah.presentation.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


data class ScreenDimensions(
    val height: Dp,
    val width: Dp
) {

    fun heightPercent(percent: Float): Dp {
        return height * percent
    }

    fun widthPercent(percent: Float): Dp {
        return width * percent
    }
}

@Composable
fun rememberScreenDimensions(): ScreenDimensions {
    val configuration = LocalConfiguration.current

    return remember(configuration) {
        ScreenDimensions(
            height = configuration.screenHeightDp.dp,
            width = configuration.screenWidthDp.dp
        )
    }
}