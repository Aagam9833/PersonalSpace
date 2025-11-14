package com.aagamshah.domain.model

data class PostsModel(
    val posts: List<Post>
)

data class Post(
    val id: Int,
    val username: String,
    val userProfileIcon: String,
    val type: PostType,
    val imageUrl: String? = null,
    val videoUrl: String? = null,
    val caption: String? = null,
    val likesCount: Int,
    val commentsCount: Int,
    val timestamp: Long,
    val comments: List<CommentsModel>
)

data class CommentsModel(
    val id: Int,
    val username: String,
    val userProfileIcon: String,
    val comment: String,
    val commentLikesCount: Int,
    val timestamp: Long
)
