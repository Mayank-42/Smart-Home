package com.example.smarthome.Data

import android.widget.Switch
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface operation {

    @Insert
    fun insertSwitch(task: switches)
    @Query("select * from switches")
    fun getAllSwitches(): Flow<List<switches>>
}