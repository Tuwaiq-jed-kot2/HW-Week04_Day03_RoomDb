package com.shady.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.roomwordsample.Word
import kotlinx.coroutines.launch

class WordViewModel {

    class WordViewModel(private val repository: WordRepositoryy) : ViewModel() {

        // Using LiveData and caching what allWords returns has several benefits:
        // - We can put an observer on the data (instead of polling for changes) and only update the
        //   the UI when the data actually changes.
        // - Repository is completely separated from the UI through the ViewModel.
        val allWords: LiveData<List<Word>> = repository.allWords.asLiveData()

        /**
         * Launching a new coroutine to insert the data in a non-blocking way
         */
        fun insert(word: Word) = viewModelScope.launch {
            repository.insert(word)
        }
    }

    class WordViewModelFactory(private val repository: WordRepositoryy) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(WordViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return WordViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}

class WordRepositoryy {
    val allWords: Any
        get() {

        }

    fun insert(word: Word) {

    }

}
