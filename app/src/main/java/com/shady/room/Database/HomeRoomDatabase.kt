package com.shady.room.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.shady.room.Home
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = arrayOf(Home::class), version = 1, exportSchema = false)
abstract class HomeRoomDatabase : RoomDatabase(){

        abstract fun homeDao(): HomeDao

        companion object {

            @Volatile
            private var INSTANCE: HomeRoomDatabase? = null

            fun getDatabase(context: Context): HomeRoomDatabase {

                return INSTANCE ?: synchronized(this) {
                    val instance = Room.databaseBuilder(
                        context.applicationContext, HomeRoomDatabase::class.java,
                        "word_database"
                    ).build()
                    INSTANCE = instance
                    // return instance
                    instance
                }
            }
        }
    private class WHomeDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.homeDao())
                }
            }
        }

        suspend fun populateDatabase(wordDao: HomeDao) {

            HomeDao.deleteAll()

            var home = Home("Hello")
            wordDao.inster(home)
            home = Home("World!")
            wordDao.inster(home)


        }
    }
    }
