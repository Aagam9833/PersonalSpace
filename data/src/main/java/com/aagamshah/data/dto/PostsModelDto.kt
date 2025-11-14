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
    @SerialName("type")
    val type: String,
    @SerialName("like")
    val like: Int,
    @SerialName("comments")
    val comments: List<CommentDto>
)

@Serializable
data class CommentDto(
    @SerialName("id")
    val id: Int,
    @SerialName("username")
    val username: String,
    @SerialName("comment")
    val comment: String,
    @SerialName("timestamp")
    val timestamp: Long
)