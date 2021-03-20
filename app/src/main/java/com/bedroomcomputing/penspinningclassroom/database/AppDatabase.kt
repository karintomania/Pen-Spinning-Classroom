package com.bedroomcomputing.penspinningclassroom.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Trick::class), version = 2)
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
