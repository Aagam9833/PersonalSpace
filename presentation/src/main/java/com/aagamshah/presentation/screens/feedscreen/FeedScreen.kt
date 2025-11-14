package com.aagamshah.presentation.screens.feedscreen

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.koin.androidx.compose.koinViewModel

@Composable
fun FeedScreen(
    viewModel: FeedViewModel = koinViewModel()
) {

}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun Preview() {
    CenterAlignedTopAppBar(
        {
            Text("Your Feed")
        }
    )
}