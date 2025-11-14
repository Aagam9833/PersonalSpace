package com.aagamshah.data.local.posts

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "posts")
data class PostEntity(
    @PrimaryKey
    val id: Int,
    val username: String,
    val userProfileIcon: String,
    val type: String,
    val imageUrl: String?,
    val videoUrl: String?,
    val caption: String?,
    val likesCount: Int,
    val commentsCount: Int,
    val timestamp: Long,
)

@Entity(
    tableName = "comments",
    foreignKeys = [
        ForeignKey(
            entity = PostEntity::class,
            parentColumns = ["id"],
            childColumns = ["post_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class CommentEntity(
    @PrimaryKey
    val id: Int,
    val username: String,
    val userProfileIcon: String,
    val comment: String,
    val commentLikesCount: Int,
    val timestamp: Long,

    @ColumnInfo(name = "post_id", index = true)
    val postId: Int
)