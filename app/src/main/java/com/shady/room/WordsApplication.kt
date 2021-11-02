package com.shady.room

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class WordsApplication : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    val databse by lazy { WordRoomDatabase.getDatabase(this) }

    val repository by lazy { WordRepository(databse.wordDao()) }
}