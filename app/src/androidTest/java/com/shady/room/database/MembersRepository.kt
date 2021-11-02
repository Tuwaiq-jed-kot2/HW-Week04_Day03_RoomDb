package com.shady.room.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import java.lang.IllegalStateException
import java.lang.reflect.Member
import java.util.*

private const val DATABASE_NAME = "member-database"
class MembersRepository private constructor(context: Context){
    private val database:MemberDataBase = Room.databaseBuilder(
        context.applicationContext,
        MemberDataBase::class.java,
        DATABASE_NAME
    ).build()

    val membersDao=database.membersDao()
//    fun getAllMembers():LiveData<List<Member>> = MembersDao.getAllMembers()


    companion object{ //the only way to use the class is must to use singleton class
        var INSTANCE:MembersRepository?=null
        fun initialize(context: Context){
            if (INSTANCE==null){
                INSTANCE=MembersRepository(context)
            }
        }

        fun get():MembersRepository{
            return INSTANCE ?: throw IllegalStateException("CrimeRepository didn't initialized")
        }
    }


}