package com.shady.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName="home_table")
data class Home(
    //?
    @PrimaryKey(autoGenrate = true) val id: String,
    @ColumnInfo(name="Home") val home:String)