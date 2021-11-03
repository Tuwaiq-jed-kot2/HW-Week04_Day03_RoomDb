package com.shady.room

import androidx.lifecycle.*
import com.shady.room.database.WordRepository
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class WordViewModel(private val repository: WordRepository) : ViewModel() {

    val getAlphabetizedWord: LiveData<List<Word>> = repository.getAlphabetizedWord.asLiveData()

    fun insert(word: Word) = viewModelScope.launch {
        repository.insert(word)
    }

}

class WordViewModelFactory(private val repository: WordRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WordViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return WordViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")

    }


}