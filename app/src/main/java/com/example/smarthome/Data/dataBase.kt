package com.example.smarthome.Data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.smarthome.Data.Tables.switches

@Database(
    entities=[switches::class],
    version=1
)

abstract class dataBase:RoomDatabase() {

    abstract fun localDao():operation
}