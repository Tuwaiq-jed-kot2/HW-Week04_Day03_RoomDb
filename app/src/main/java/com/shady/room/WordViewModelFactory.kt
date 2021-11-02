package com.shady.room

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shady.room.database.WordRepository


class WordViewModelFactory(private val repository: WordRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WordViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return WordViewModel(repository) as T
        }
        throw IllegalStateException("Unknown ViewModel Class.")
    }

}