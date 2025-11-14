package com.aagamshah.data.di

import androidx.room.Room
import com.aagamshah.data.AppDatabase
import com.aagamshah.data.repository.PostRepositoryImpl
import com.aagamshah.domain.repository.PostRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {

    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        ).build()
    }

    single { get<AppDatabase>().postDao() }

    single<PostRepository> {
        PostRepositoryImpl(dao = get())
    }
}