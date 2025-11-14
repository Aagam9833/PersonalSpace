package com.aagamshah.presentation.di

import com.aagamshah.presentation.screens.feedscreen.FeedViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel {
        FeedViewModel(getFeedUseCase = get())
    }
}