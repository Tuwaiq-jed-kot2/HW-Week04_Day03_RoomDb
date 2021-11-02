package com.shady.room

import android.app.Application

class WordsApplication : Application() {
    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database by lazy { wordRoomDataBace.WordRoomDatabase.getDatabase(this) }
    val repository by lazy { wordRepository.WordRepository(database.wordDao()) }
}