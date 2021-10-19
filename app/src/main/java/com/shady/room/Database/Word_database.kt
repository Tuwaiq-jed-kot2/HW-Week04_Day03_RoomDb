package com.shady.room.Database

class Word_database {

    @Database(entities = [Word::class], version = 1)
    abstract class Word_database : RoomDatabase() {

    }

}