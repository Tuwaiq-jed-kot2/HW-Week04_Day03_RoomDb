package com.shady.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = arrayOf(Word::class),version = 1)
abstract  class WordRoomDatabase  : RoomDatabase(){

    abstract fun wordDao(): WordDao

    companion object{

        @Volatile
        private var INSTANCE : WordRoomDatabase? = null

        fun getDatabase(
            context: Context,
            scope : CoroutineScope):
                WordRoomDatabase{
           val instance = Room.databaseBuilder(
               context.applicationContext,
               WordRoomDatabase::class.java,
               "word_database")
               .fallbackToDestructiveMigration()
               .addCallback(WordDatabaseCallback(scope))
               .build()
           INSTANCE = instance
           return instance
        }

        private class WordDatabaseCallback(private val scope: CoroutineScope):RoomDatabase.Callback(){

            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO){
                        populateDatabase(database.wordDao())
                    }

                }
            }
        }

        suspend fun populateDatabase(wordDao: WordDao){
            wordDao.deleteAll()
            var word = Word ("Hello")
            wordDao.insert(word)
            word = Word ("Hello2")
            wordDao.insert(word)
        }

    }



}