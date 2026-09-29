package com.example.smarthome.Data.Repo

import com.example.smarthome.Data.operation
import com.example.smarthome.Data.Tables.switches

class localRepo(private val work: operation){

    val getAllSwitches=work.getAllSwitches()

    suspend fun insertLocal(name: switches){
        work.insertSwitch(name)
    }

}