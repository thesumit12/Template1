package com.slakra.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.slakra.database.dao.TestDao
import com.slakra.database.entity.TestEntity

@Database(entities = [TestEntity::class], version = 1, exportSchema = false)
abstract class Template1Database: RoomDatabase() {

    abstract fun testDao(): TestDao
}