package com.shady.room.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.shady.room.Home
import java.util.concurrent.Flow

@Dao
interface HomeDao {
    @Query("SELECT*FROM home_table ORDER By home ASC")
    fun getAlphabetizedWords(): kotlinx.coroutines.flow.Flow<List<Home>>
    @Insert(onConflict= OnConflictStrategy.IGNORE)
    suspend fun inster(home: Home)
    @Query("DELETE FROM home_table")
    suspend fun deleteAll()

}