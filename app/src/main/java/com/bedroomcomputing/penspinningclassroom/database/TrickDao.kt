package com.bedroomcomputing.penspinningclassroom.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TrickDao {
    @Query("SELECT * FROM trick")
    fun getAll(): LiveData<List<Trick>>

    @Query("SELECT * FROM trick where is_saved = 1")
    fun getSaved(): LiveData<List<Trick>>

    @Query("SELECT * FROM trick where is_masterd = 1")
    fun getMastered(): LiveData<List<Trick>>

    @Query("SELECT * FROM trick WHERE category = :category")
    fun selectByCategory(category: String): LiveData<List<Trick>>

    @Insert
    fun insertAll(vararg tricks: Trick)
}