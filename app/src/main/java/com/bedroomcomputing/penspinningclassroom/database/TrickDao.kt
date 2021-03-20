package com.bedroomcomputing.penspinningclassroom.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TrickDao {
    @Query("SELECT * FROM trick")
    fun getAll(): List<Trick>

    @Query("SELECT * FROM trick WHERE category = :category")
    fun loadAllByIds(category: String): List<Trick>

    @Insert
    fun insertAll(vararg tricks: Trick)
}