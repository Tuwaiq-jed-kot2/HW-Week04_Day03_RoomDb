package com.shady.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shady.room.Database.HomeRepostry


class HomeViewModel(private val repository: HomeRepostry) : ViewModel() {


    val allWords: LiveData<List<Home>> = repository.allHoms.asLiveData()

    fun insert(home: Home) = viwModleScope.launch {
        repository.insert(Home())
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