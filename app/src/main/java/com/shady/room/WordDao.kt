package com.example.roomwordsample

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import java.util.concurrent.Flow

@Dao

interface WordDao {
    @Query("SELECT * FROM `word _table` ORDER by word ASC")
    fun getAlphabetizedWords(): kotlinx.coroutines.flow.Flow<List<Word>>


@Insert(onConflict = OnConflictStrategy.IGNORE)
suspend fun insert(word: Word)

@Query("DELETE FROM `word _table`")
suspend fun deleteAll()

}