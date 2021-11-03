package com.shady.room.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.shady.room.Word
import kotlinx.coroutines.flow.Flow


@Dao
interface WordDao {

    @Query("SELECT * FROM word_table ORDER BY word ASC")
         fun getAlphabetizedWords():Flow<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
        suspend fun insert(word: Word)

    @Query("DELETE FROM word_table")
         suspend fun deleteAll()

}