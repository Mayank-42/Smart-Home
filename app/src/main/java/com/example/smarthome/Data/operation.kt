package com.example.smarthome.Data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.smarthome.Data.Tables.switches
import kotlinx.coroutines.flow.Flow

@Dao
interface operation {

    @Insert
    fun insertSwitch(task: switches)
    @Query("select * from switches")
    fun getAllSwitches(): Flow<List<switches>>
}