package com.aagamshah.presentation.screens.feedscreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aagamshah.domain.usecase.GetFeedUseCase
import com.aagamshah.domain.util.Resource
import kotlinx.coroutines.launch

class FeedViewModel(
    private val getFeedUseCase: GetFeedUseCase
) : ViewModel() {

    init {
        getFeed()
    }

    private fun getFeed() {
        viewModelScope.launch {
            getFeedUseCase().collect { resource ->
                when (resource) {
                    is Resource.Error<*> -> {
                        Log.d("TAGGED", "ERROR ${resource.error}")
                    }

                    is Resource.Loading<*> -> {
                        Log.d("TAGGED", "LOADING")
                    }

                    is Resource.Success<*> -> {
                        Log.d("TAGGED", "SUCCESS ${resource.data}")
                    }
                }
            }
        }
    }

}