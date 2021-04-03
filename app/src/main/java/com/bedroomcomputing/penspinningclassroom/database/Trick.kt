package com.bedroomcomputing.penspinningclassroom.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.time.LocalDateTime

@Entity(tableName = "trick")
data class Trick (
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "category") val category: String,
    @ColumnInfo(name = "trick_key") val trickKey: String,
    @ColumnInfo(name = "level") val level: Int,
    @ColumnInfo(name = "is_masterd") var isMastered: Boolean,
    @ColumnInfo(name = "masterd") var mastered: LocalDate?,
    @ColumnInfo(name = "is_saved") var isSaved: Boolean
)