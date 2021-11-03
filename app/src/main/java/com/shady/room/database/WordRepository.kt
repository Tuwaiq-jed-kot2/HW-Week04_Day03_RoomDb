package com.shady.room.database

import android.content.Context
import androidx.annotation.WorkerThread
import androidx.room.Room
import com.shady.room.Word
import kotlinx.coroutines.flow.Flow


class WordRepository (private val wordDao: WordDao){

 val allWords: Flow<List<Word>> = wordDao.getAlphabetizedWords()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }

     }


