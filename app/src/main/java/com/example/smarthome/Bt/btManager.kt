package com.example.smarthome.Bt

import android.bluetooth.BluetoothManager
import android.content.Context

class btManager(val context: Context) {
    private val btmanager=context.getSystemService(BluetoothManager::class.java)

    val bluetoothAdapter = btmanager.adapter


}