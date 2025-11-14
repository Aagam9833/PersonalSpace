package com.aagamshah.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PostsModelDto(
    @SerialName("posts")
    val posts: List<PostDto>
)

@Serializable
data class PostDto(
    @SerialName("id")
    val id: Int,
    @SerialName("username")
    val username: String,
    @SerialName("userProfileIcon")
    val userProfileIcon: String,
    @SerialName("type")
    val type: String,
    @SerialName("imageUrl")
    val imageUrl: String? = null,
    @SerialName("videoUrl")
    val videoUrl: String? = null,
    @SerialName("caption")
    val caption: String? = null,
    @SerialName("likesCount")
    val likesCount: Int,
    @SerialName("commentsCount")
    val commentsCount: Int,
    @SerialName("timestamp")
    val timestamp: Long,
    @SerialName("comments")
    val comments: List<CommentDto>
)

@Serializable
data class CommentDto(
    @SerialName("id")
    val id: Int,
    @SerialName("username")
    val username: String,
    @SerialName("userProfileIcon")
    val userProfileIcon: String,
    @SerialName("comment")
    val comment: String,
    @SerialName("commentLikesCount")
    val commentLikesCount: Int,
    @SerialName("timestamp")
    val timestamp: Long
)