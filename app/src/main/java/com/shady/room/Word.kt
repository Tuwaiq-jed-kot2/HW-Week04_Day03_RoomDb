package com.example.roomwordsample

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


data class Word (val word:String)

@Entity(tableName="word _table")

class Wors(@PrimaryKey(autoGenerate = true) val id: Int, @ColumnInfo(name="word")val word:String)
