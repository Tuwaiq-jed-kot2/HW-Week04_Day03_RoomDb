package com.shady.room.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.Members

@Dao
interface MembersDao {

    @Query("SELECT * FROM members ")
    fun getAllMembers(): LiveData<List<Members>>

    @Query("SELECT * FROM  members ")
    fun getAlphabetizedWords(): List<Members>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(members: Members)

    @Query("DELETE FROM members")
    suspend fun deleteAll()
}