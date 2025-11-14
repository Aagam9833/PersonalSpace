package com.aagamshah.domain.usecase

import com.aagamshah.domain.model.PostsModel
import com.aagamshah.domain.repository.PostRepository
import com.aagamshah.domain.util.Resource
import kotlinx.coroutines.flow.Flow

class GetFeedUseCase(
    private val repository: PostRepository
) {
    operator fun invoke(): Flow<Resource<PostsModel>> {
        return repository.getFeed()
    }
}