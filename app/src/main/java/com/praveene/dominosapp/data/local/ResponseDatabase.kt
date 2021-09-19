package com.praveene.dominosapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(
    entities = [ResponseEntity::class],
    version = 1,
    exportSchema = false
)

abstract class ResponseDatabase:RoomDatabase() {
abstract fun responseDao():ResponseDao

}