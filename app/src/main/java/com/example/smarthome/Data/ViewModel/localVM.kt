package com.example.smarthome.Data.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smarthome.Data.Repo.localRepo
import com.example.smarthome.Data.Tables.switches
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class localVM(var work: localRepo): ViewModel() {

    var getAllSwitches: Flow<List<switches>> = work.getAllSwitches

    fun insertSwitch(name: switches){
        viewModelScope.launch{
            work.insertLocal(name)
        }
    }
}