package com.aagamshah.data.repository

import com.aagamshah.data.dto.PostsModelDto
import com.aagamshah.data.local.posts.CommentEntity
import com.aagamshah.data.local.posts.PostDao
import com.aagamshah.data.local.posts.PostEntity
import com.aagamshah.data.mapper.toDomain
import com.aagamshah.data.mapper.toEntity
import com.aagamshah.data.postsDummyJson
import com.aagamshah.data.utils.mapExceptionToError
import com.aagamshah.domain.model.PostsModel
import com.aagamshah.domain.repository.PostRepository
import com.aagamshah.domain.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json

class PostRepositoryImpl(
    private val dao: PostDao
) : PostRepository {

    private val safeJson = Json {
        ignoreUnknownKeys = true
        isLenient = true
        coerceInputValues = true
    }

    override fun getFeed(): Flow<Resource<PostsModel>> = channelFlow {

        send(Resource.Loading())

        launch {
            dao.getPostsWithComments().collectLatest { entities ->
                val domainPosts = entities.map { it.toDomain() }
                send(Resource.Success(PostsModel(posts = domainPosts)))
            }
        }

        withContext(Dispatchers.IO) {
            try {
                fetchAndSavePosts()
            } catch (e: Exception) {
                val errorType = e.mapExceptionToError()
                send(Resource.Error(errorType, data = null))
            }
        }
    }

    private suspend fun fetchAndSavePosts() {

        val mockJson = postsDummyJson
        val responseDto = safeJson.decodeFromString<PostsModelDto>(mockJson)

        val postEntities = mutableListOf<PostEntity>()
        val commentEntities = mutableListOf<CommentEntity>()

        responseDto.posts.forEach { postDto ->
            postEntities.add(postDto.toEntity())
            postDto.comments.forEach { commentDto ->
                commentEntities.add(commentDto.toEntity(postId = postDto.id))
            }
        }
        dao.clearAndInsert(postEntities, commentEntities)
    }
}