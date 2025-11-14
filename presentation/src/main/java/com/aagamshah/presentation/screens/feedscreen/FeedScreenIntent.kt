package com.aagamshah.presentation.screens.feedscreen

import com.aagamshah.domain.model.CommentsModel
import com.aagamshah.domain.model.Post

sealed interface FeedIntent {
    data object LoadFeed : FeedIntent
    data object RefreshFeed : FeedIntent
    data class ShowCommentsBottomSheet(val comments: List<CommentsModel>) : FeedIntent
    data object DismissCommentsBottomSheet : FeedIntent
}

sealed interface FeedEffect {
    data class ShowSnackbar(val message: String) : FeedEffect
}

data class FeedUiState(
    val posts: List<Post> = emptyList(),
    val isLoading: Boolean = false,
    val showCommentsSheet: Boolean = false,
    val comments: List<CommentsModel> = emptyList()
)
