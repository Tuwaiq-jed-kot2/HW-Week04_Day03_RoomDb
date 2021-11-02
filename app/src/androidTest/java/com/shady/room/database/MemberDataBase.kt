package com.shady.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.myapplication.Members

@Database(entities = [Members::class],version = 1)
@TypeConverters(MembersTypeConverters::class)
abstract class MemberDataBase : RoomDatabase(){
    abstract fun membersDao():MembersDao


}

