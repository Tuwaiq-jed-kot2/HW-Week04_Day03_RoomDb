package com.shady.room

import androidx.lifecycle.ViewModel
import com.example.myapplication.database.MembersRepository

class MembersListViewModel:ViewModel() {



    val membersRepository=MembersRepository.get()

    val LiveDataMembers = membersRepository.getAllMembers()

}