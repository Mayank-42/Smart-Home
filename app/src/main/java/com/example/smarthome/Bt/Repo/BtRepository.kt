package com.example.smarthome.Bt.Repo

import android.Manifest
import android.bluetooth.BluetoothDevice
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.annotation.RequiresPermission
import androidx.core.content.ContextCompat
import com.example.smarthome.Bt.btManager

class BtRepository(
    private val btManager: btManager
) {

    private val context = btManager.context

    fun isBluetoothEnabled(): Boolean {
        return btManager.isBluetoothEnabled()
    }
    private val discoveryReceiver =
        object : BroadcastReceiver() {
            @RequiresPermission(Manifest.permission.BLUETOOTH_CONNECT)
            override fun onReceive(
                context: Context?,
                intent: Intent?
            ) {

                when (intent?.action) {

                    BluetoothDevice.ACTION_FOUND -> {

                        val device =
                            intent.getParcelableExtra<BluetoothDevice>(
                                BluetoothDevice.EXTRA_DEVICE
                            )

                        if (device != null) {
                            println(
                                "BT DEVICE FOUND: ${device.name} - ${device.address}"
                            )
                        }
                    }
                }
            }
        }
    @RequiresPermission(
        allOf = [
            Manifest.permission.BLUETOOTH_SCAN,
            Manifest.permission.BLUETOOTH_CONNECT
        ]
    )
    fun startDiscovery() {

        val adapter = btManager.bluetoothAdapter

        if (adapter == null) {
            println("Bluetooth not supported")
            return
        }

        if (!adapter.isEnabled) {
            println("Bluetooth is OFF")
            return
        }

        val filter = IntentFilter(
            BluetoothDevice.ACTION_FOUND
        )

        ContextCompat.registerReceiver(
            context,
            discoveryReceiver,
            filter,
            ContextCompat.RECEIVER_EXPORTED
        )

        adapter.startDiscovery()

        println("Bluetooth discovery started")
    }
    @RequiresPermission(
        allOf = [
            Manifest.permission.BLUETOOTH_SCAN,
            Manifest.permission.BLUETOOTH_CONNECT
        ]
    )

    fun stopDiscovery() {

        btManager.bluetoothAdapter?.cancelDiscovery()

        try {
            context.unregisterReceiver(discoveryReceiver)
        } catch (e: IllegalArgumentException) {
            // Receiver was not registered
        }

        println("Bluetooth discovery stopped")
    }
}