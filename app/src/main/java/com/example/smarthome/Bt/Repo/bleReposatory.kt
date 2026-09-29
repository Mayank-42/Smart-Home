package com.example.smarthome.Bt.Repo

import android.bluetooth.BluetoothAdapter
import android.bluetooth.le.BluetoothLeScanner
import android.bluetooth.le.ScanCallback
import android.bluetooth.le.ScanResult

class BleRepository(
    private val bluetoothAdapter: BluetoothAdapter
) {

    private val bleScanner: BluetoothLeScanner?
        get() = bluetoothAdapter.bluetoothLeScanner


    private val scanCallback =
        object : ScanCallback() {

            override fun onScanResult(
                callbackType: Int,
                result: ScanResult
            ) {

                val device = result.device

                println(
                    "BLE DEVICE FOUND: name=${device.name}, address=${device.address}"
                )
            }
        }
}