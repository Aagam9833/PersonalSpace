package com.aagamshah.presentation.screens.feedscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aagamshah.domain.model.CommentsModel
import com.aagamshah.domain.usecase.GetFeedUseCase
import com.aagamshah.domain.util.Resource
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FeedViewModel(
    private val getFeedUseCase: GetFeedUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(FeedUiState())
    val uiState: StateFlow<FeedUiState> = _uiState.asStateFlow()

    private val _effect = Channel<FeedEffect>()
    val effect = _effect.receiveAsFlow()

    init {
        onEvent(FeedIntent.LoadFeed)
    }

    fun onEvent(intent: FeedIntent) {
        when (intent) {
            is FeedIntent.LoadFeed -> loadFeed(isRefreshing = false)
            is FeedIntent.RefreshFeed -> loadFeed(isRefreshing = true)
            is FeedIntent.ShowCommentsBottomSheet -> showCommentsBottomSheet(intent.comments)
            is FeedIntent.DismissCommentsBottomSheet -> dismissCommentsBottomSheet()
        }
    }

    private fun loadFeed(isRefreshing: Boolean) {
        viewModelScope.launch {
            getFeedUseCase().collect { result ->
                _uiState.update { currentState ->
                    when (result) {
                        is Resource.Loading -> {
                            currentState.copy(isLoading = true)
                        }

                        is Resource.Success -> {
                            currentState.copy(
                                isLoading = false,
                                posts = result.data?.posts ?: emptyList()
                            )
                        }

                        is Resource.Error -> {
                            sendEffect(FeedEffect.ShowSnackbar(result.error.toString()))
                            currentState.copy(isLoading = false)
                        }
                    }
                }
            }
        }
    }

    private fun sendEffect(effect: FeedEffect) {
        viewModelScope.launch {
            _effect.send(effect)
        }
    }

    private fun showCommentsBottomSheet(comments: List<CommentsModel>) {
        _uiState.update {
            it.copy(
                showCommentsSheet = true,
                comments = comments
            )
        }
    }

    private fun dismissCommentsBottomSheet() {
        _uiState.update {
            it.copy(
                showCommentsSheet = false,
                comments = emptyList()
            )
        }
    }

}