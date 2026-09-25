package com.example.smarthome.Bt.ViewModel

import android.Manifest
import androidx.annotation.RequiresPermission
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.smarthome.Bt.Repo.BtRepository

class BtViewModel(
    private val repository: BtRepository
) : ViewModel() {

    @RequiresPermission(
        allOf = [
            Manifest.permission.BLUETOOTH_SCAN,
            Manifest.permission.BLUETOOTH_CONNECT
        ]
    )
    fun startDiscovery() {
        repository.startDiscovery()
    }
    fun isBluetoothEnabled(): Boolean {
        return repository.isBluetoothEnabled()
    }

    fun stopDiscovery() {
        repository.stopDiscovery()
    }

    override fun onCleared() {
        repository.stopDiscovery()
        super.onCleared()
    }
}
class BtViewModelFactory(
    private val repository: BtRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {

        if (modelClass.isAssignableFrom(BtViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return BtViewModel(repository) as T
        }

        throw IllegalArgumentException(
            "Unknown ViewModel class"
        )
    }
}