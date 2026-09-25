package com.example.smarthome.Bt

import android.bluetooth.BluetoothManager
import android.content.Context

class btManager(val contxt: Context) {
    private val btmanager=contxt.getSystemService(BluetoothManager::class.java)

    val bluetoothAdapter = btmanager.adapter


}