package com.shady.room

import androidx.lifecycle.*
import com.shady.room.Database.HomeRepostry
import kotlinx.coroutines.launch


class HomeViewModel(private val repository: HomeRepostry) : ViewModel() {


    val allWords: LiveData<List<Home>> = repository.allHoms.asLiveData()

    fun insert(home: Home) = viewModelScope.launch {
        repository.insert(home)
    }
}

class HomeViewModelFactory(private val repository: HomeRepostry) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}