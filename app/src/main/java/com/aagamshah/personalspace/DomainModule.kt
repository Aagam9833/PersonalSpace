package com.aagamshah.personalspace

import com.aagamshah.domain.usecase.GetFeedUseCase
import org.koin.dsl.module

val domainModule = module {
    factory {
        GetFeedUseCase(repository = get())
    }
}