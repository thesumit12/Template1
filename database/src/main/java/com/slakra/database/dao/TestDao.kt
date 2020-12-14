package com.slakra.database.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Query
import com.slakra.database.entity.TestEntity

@Dao
abstract class TestDao: RoomBaseDao<TestEntity>() {

//    @Query("SELECT * FROM test")
//    abstract fun test()
}