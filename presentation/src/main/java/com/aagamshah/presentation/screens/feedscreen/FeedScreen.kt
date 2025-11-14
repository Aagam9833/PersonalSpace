package com.aagamshah.presentation.screens.feedscreen

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.aagamshah.presentation.composables.CommentsBottomSheetComposable
import com.aagamshah.presentation.composables.PostComposable
import com.aagamshah.presentation.ui.theme.AppTypography
import org.koin.androidx.compose.koinViewModel

@Composable
fun FeedScreen(
    viewModel: FeedViewModel = koinViewModel()
) {

    val state by viewModel.uiState.collectAsState()
    val context = LocalContext.current
    LaunchedEffect(key1 = true) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is FeedEffect.ShowSnackbar -> {
                    Toast.makeText(context, effect.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    FeedContent(
        state = state,
        onEvent = viewModel::onEvent
    )
}

@Composable
fun FeedContent(
    state: FeedUiState,
    onEvent: (FeedIntent) -> Unit
) {

    val sheetState = rememberModalBottomSheetState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Your Feed") }
            )
        }
    ) { innerPadding ->
        Box {
            LazyColumn(
                contentPadding = PaddingValues(bottom = 40.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = innerPadding.calculateTopPadding())
            ) {
                items(state.posts, key = { it.id }) { post ->
                    PostComposable(post = post, onEvent = onEvent)
                }
            }
            if (state.showCommentsSheet) {
                ModalBottomSheet(
                    scrimColor = Color.Black.copy(0.8f),
                    onDismissRequest = { onEvent(FeedIntent.DismissCommentsBottomSheet) },
                    sheetState = sheetState
                ) {
                    if (state.comments.isEmpty()) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(0.6f),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(text = "No comments", style = AppTypography.titleLarge)
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "Be the first one to comment",
                                style = AppTypography.bodyLarge
                            )
                        }
                    } else {
                        CommentsBottomSheetComposable(comments = state.comments)
                    }
                }
            }
        }
    }
}
