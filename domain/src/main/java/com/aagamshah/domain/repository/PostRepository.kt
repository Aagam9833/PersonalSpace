package com.aagamshah.domain.repository

import com.aagamshah.domain.model.PostsModel
import com.aagamshah.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface PostRepository {

    fun getFeed(): Flow<Resource<PostsModel>>

}