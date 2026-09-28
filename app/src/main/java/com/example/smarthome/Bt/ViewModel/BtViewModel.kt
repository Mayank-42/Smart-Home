package com.example.smarthome.Bt.ViewModel

import android.Manifest
import android.bluetooth.BluetoothDevice
import androidx.annotation.RequiresPermission
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.smarthome.Bt.Repo.BtRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class BtViewModel(
    private val repository: BtRepository
) : ViewModel() {


    @RequiresPermission(
        allOf = [
            Manifest.permission.BLUETOOTH_SCAN,
            Manifest.permission.BLUETOOTH_CONNECT
        ]
    )
    private val _devices = MutableStateFlow<List<BluetoothDevice>>(emptyList())

    val devices: StateFlow<List<BluetoothDevice>> = _devices.asStateFlow()

    init {
        viewModelScope.launch {
            repository.devices.collect { device ->

                if (_devices.value.none { it.address == device.address }) {
                    _devices.value =
                        _devices.value + device
                }
            }
        }
    }

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