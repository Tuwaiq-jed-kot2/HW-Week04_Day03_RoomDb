package com.shady.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.roomwordsample.Word
import java.util.concurrent.Flow

class WordDao {
    fun getAlphabetizedWords() {

    }

    fun insert(word: Word) {

    }

    @Dao
    interface WordDao {

        @Query("SELECT * FROM word_table ORDER BY word ASC")
        fun getAlphabetizedWords(): kotlinx.coroutines.flow.Flow <List<Word>>

        @Insert(onConflict = OnConflictStrategy.IGNORE)
        suspend fun insert(word: Word)

        @Query("DELETE FROM word_table")
        suspend fun deleteAll()
    }
}