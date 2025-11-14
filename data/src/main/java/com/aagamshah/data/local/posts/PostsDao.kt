package com.aagamshah.data.local.posts

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface PostDao {

    @Transaction
    @Query("SELECT * FROM posts")
    fun getPostsWithComments(): Flow<List<PostWithComments>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPosts(posts: List<PostEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertComments(comments: List<CommentEntity>)

    @Query("DELETE FROM posts")
    suspend fun clearPosts()

    @Query("DELETE FROM comments")
    suspend fun clearComments()

    @Transaction
    suspend fun clearAndInsert(posts: List<PostEntity>, comments: List<CommentEntity>) {
        clearPosts()
        insertPosts(posts)
        insertComments(comments)
    }
}