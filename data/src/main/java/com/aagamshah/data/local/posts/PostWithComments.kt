package com.aagamshah.data.local.posts

import androidx.room.Embedded
import androidx.room.Relation

data class PostWithComments(
    @Embedded
    val post: PostEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "post_id"
    )
    val comments: List<CommentEntity>
)