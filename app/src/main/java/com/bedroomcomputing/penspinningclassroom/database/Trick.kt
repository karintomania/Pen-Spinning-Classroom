package com.bedroomcomputing.penspinningclassroom.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "trick")
data class Trick (
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "category") val category: String,
    @ColumnInfo(name = "trickk_name") val trickName: String,
    @ColumnInfo(name = "is_masterd") val isMasterd: Boolean,
    @ColumnInfo(name = "is_saved") val isSaved: Boolean,
    @ColumnInfo(name = "level") val level: Int
)