package com.aagamshah.data.mapper

import com.aagamshah.data.dto.CommentDto
import com.aagamshah.data.dto.PostDto
import com.aagamshah.data.dto.PostsModelDto
import com.aagamshah.data.local.posts.CommentEntity
import com.aagamshah.data.local.posts.PostEntity
import com.aagamshah.data.local.posts.PostWithComments
import com.aagamshah.domain.model.CommentsModel
import com.aagamshah.domain.model.Post
import com.aagamshah.domain.model.PostType
import com.aagamshah.domain.model.PostsModel

fun PostsModelDto.toDomain(): PostsModel {
    return PostsModel(
        posts = this.posts.map { it.toDomain() }
    )
}

fun PostDto.toDomain(): Post {
    return Post(
        id = this.id,
        username = this.username,
        type = mapPostType(this.type),
        like = this.like,
        comments = this.comments.map { it.toDomain() }
    )
}

private fun mapPostType(type: String): PostType {
    return when (type.lowercase()) {
        "image" -> PostType.IMAGE
        "video" -> PostType.VIDEO
        else -> PostType.UNKNOWN
    }
}

fun CommentDto.toDomain(): CommentsModel {
    return CommentsModel(
        id = this.id,
        username = this.username,
        comment = this.comment,
        timestamp = this.timestamp
    )
}

fun PostWithComments.toDomain(): Post {
    return Post(
        id = this.post.id,
        username = this.post.username,
        type = mapPostType(this.post.type),
        like = this.post.like,
        comments = this.comments.map {
            CommentsModel(it.id, it.username, it.comment, it.timestamp)
        }
    )
}

fun PostDto.toEntity(): PostEntity {
    return PostEntity(
        id = this.id,
        username = this.username,
        type = this.type,
        like = this.like
    )
}

fun CommentDto.toEntity(postId: Int): CommentEntity {
    return CommentEntity(
        id = this.id,
        username = this.username,
        comment = this.comment,
        timestamp = this.timestamp,
        postId = postId
    )
}
