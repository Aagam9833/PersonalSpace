package com.aagamshah.presentation.screens.feedscreen

import com.aagamshah.domain.model.CommentsModel
import com.aagamshah.domain.model.Post

sealed interface FeedIntent {
    data object LoadFeed : FeedIntent
    data object RefreshFeed : FeedIntent
    data class LikePost(val postId: Int) : FeedIntent
    data class MoreComments(val postId: Int) : FeedIntent
}

sealed interface FeedEffect {
    data class ShowSnackbar(val message: String) : FeedEffect
}

data class FeedUiState(
    val posts: List<Post> = emptyList(),
    val isLoading: Boolean = false,
    val showMoreComments: List<CommentsModel> = emptyList()
)
