package com.example.smarthome.Data

import android.app.Application
import androidx.room.Room

class dataBaseApplication: Application() {

    val dataBaseBuilder: dataBase by lazy{
    Room.databaseBuilder(
    applicationContext,
dataBase::class.java,
        "SmartHomeDB"
    ).fallbackToDestructiveMigration(true)
        .build()
    }

}