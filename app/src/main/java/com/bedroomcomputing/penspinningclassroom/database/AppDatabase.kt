package com.bedroomcomputing.penspinningclassroom.database

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.*
import java.time.LocalDate
import java.time.LocalDateTime

@Database(entities = arrayOf(Trick::class), version = 2)
@TypeConverters(DateTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun trickDao(): TrickDao

    companion object{

        @Volatile
        private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance =

                    Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                    "app_database")
                    .createFromAsset("myapp.db")
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }

    }


}

class DateTypeConverter {
    @RequiresApi(Build.VERSION_CODES.O)
    @TypeConverter
    fun fromTimestamp(value: String?): LocalDate? {
        if(value == "null"){
            return null
        }
        return value?.let {  LocalDate.parse(value) }
    }

    @TypeConverter
    fun dateToTimestamp(localDate: LocalDate?): String? {
        return localDate?.toString()
    }
}
