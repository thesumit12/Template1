package com.slakra.di

import org.koin.dsl.module.module
import androidx.room.Room
import com.slakra.database.Template1Database
import org.koin.android.ext.koin.androidApplication

internal val databaseModule = module {

    single {
        Room.databaseBuilder(androidApplication(), Template1Database::class.java, "test-db")
            .allowMainThreadQueries().build()
    }

    single { get<Template1Database>().testDao() }
}