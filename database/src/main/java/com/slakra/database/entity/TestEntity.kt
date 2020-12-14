package com.slakra.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "test")
data class TestEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "test_name") val name: String?
)