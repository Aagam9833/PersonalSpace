package com.aagamshah.domain.model

data class PostsModel(
    val posts: List<Post>
)

data class Post(
    val id: Int,
    val username: String,
    val type: PostType,
    val like: Int,
    val comments: List<CommentsModel>
)

data class CommentsModel(
    val id: Int,
    val username: String,
    val comment: String,
    val timestamp: Long
)
