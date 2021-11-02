package com.shady.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
class Members {
    @PrimaryKey val id : UUID= UUID.randomUUID()

}