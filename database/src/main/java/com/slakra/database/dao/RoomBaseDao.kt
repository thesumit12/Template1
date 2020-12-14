package com.slakra.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

/**
 * This class provides the basic CRUD operations for Room Database. The Room library generates
 * the implementation for the methods during building.
 * @author sumitlakra
 * @date 12/14/2020
 */
@Dao
abstract class RoomBaseDao<T> {

    /**
     * abstract function to insert entity in the database. Aborts the current statement if constraint violation occurs
     * @author sumitlakra
     * @date 12/14/2020
     * @param [item] T
     * @return [Long] row Id of the inserted record
     */
    @Insert(onConflict = OnConflictStrategy.ABORT)
    abstract fun insertEntity(item: T): Long

    /**
     * abstract function to to insert bulk records in DB
     * @author sumitlakra
     * @date 12/14/2020
     * @param [items] List<T>
     */
    @Insert(onConflict = OnConflictStrategy.ABORT)
    abstract fun insertAll(items: List<T>)

    /**
     * abstract function to to insert bulk records in DB with replace strategy
     * @author sumitlakra
     * @date 12/14/2020
     * @param [items] List<T>
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertAllWithReplaceStrategy(items: List<T>)

    /**
     * abstract function to update entity in the database
     * @author sumitlakra
     * @date 12/14/2020
     * @param [item] T
     * @return [Int] number of rows affected by update
     */
    @Update
    abstract fun updateEntity(item: T): Int

    /**
     * abstract function to delete entity from the database
     * @author sumitlakra
     * @date 12/14/2020
     * @param [item] T
     */
    @Delete
    abstract fun deleteEntity(item: T)
}
