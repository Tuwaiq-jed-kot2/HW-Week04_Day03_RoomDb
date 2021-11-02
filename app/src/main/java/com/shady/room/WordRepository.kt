package com.shady.room

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow


class WordRepository(private val wordDao: WordDog) {


    val allWords: Flow<List<Word>> = wordDao.getAlphabetizedWords()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}