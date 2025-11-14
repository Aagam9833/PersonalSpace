package com.aagamshah.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aagamshah.data.local.posts.CommentEntity
import com.aagamshah.data.local.posts.PostDao
import com.aagamshah.data.local.posts.PostEntity

@Database(
    entities = [PostEntity::class, CommentEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun postDao(): PostDao

    companion object {
        const val DATABASE_NAME = "personal_space_db"
    }
}