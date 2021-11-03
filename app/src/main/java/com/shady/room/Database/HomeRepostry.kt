package com.shady.room.Database

import androidx.annotation.WorkerThread
import com.shady.room.Home

class HomeRepostry (private val homeDao: HomeDao){

        val allHoms: kotlinx.coroutines.flow.Flow <List<Home>>
        = homeDao.getAlphabetizedWords()

        @Suppress("RedundantSuspendModifier")
        @WorkerThread
        suspend fun insert(home: Home) {
            homeDao.inster(home)
        }
    }
