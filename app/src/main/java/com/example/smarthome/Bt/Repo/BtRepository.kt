package com.example.smarthome.Bt.Repo

import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.annotation.RequiresPermission
import androidx.core.content.ContextCompat
import com.example.smarthome.Bt.btManager
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class BtRepository(
    private val btManager: btManager
) {

    private val context = btManager.context

    fun isBluetoothEnabled(): Boolean {
        return btManager.isBluetoothEnabled()
    }

    private val _devices = MutableSharedFlow<BluetoothDevice>(
        extraBufferCapacity = 10
    )

    val devices = _devices.asSharedFlow()

    // Tells us whether we want discovery to keep running
    private var isDiscoveryRunning = false


    private val discoveryReceiver =
        object : BroadcastReceiver() {

            @RequiresPermission(Manifest.permission.BLUETOOTH_CONNECT)
            override fun onReceive(
                context: Context?,
                intent: Intent?
            ) {

                when (intent?.action) {

                    // A Bluetooth device was found
                    BluetoothDevice.ACTION_FOUND -> {

                        val device =
                            intent.getParcelableExtra<BluetoothDevice>(
                                BluetoothDevice.EXTRA_DEVICE
                            )

                        if (device != null) {

                            _devices.tryEmit(device)

                            println(
                                "BT DEVICE FOUND: name=${device.name}, address=${device.address}"
                            )
                        }
                    }


                    // Current discovery cycle finished
                    BluetoothAdapter.ACTION_DISCOVERY_FINISHED -> {

                        println("Bluetooth discovery finished")

                        // Start another discovery cycle
                        if (isDiscoveryRunning) {

                            println("Starting discovery again")

                            btManager.bluetoothAdapter?.startDiscovery()
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

        // Receiver listens for both:
        // 1. Device found
        // 2. Discovery finished
        val filter = IntentFilter().apply {

            addAction(BluetoothDevice.ACTION_FOUND)

            addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED)
        }


        ContextCompat.registerReceiver(
            context,
            discoveryReceiver,
            filter,
            ContextCompat.RECEIVER_EXPORTED
        )


        // Tell the repository that discovery should continue
        isDiscoveryRunning = true


        // Start first discovery cycle
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

        // Important:
        // Set this BEFORE cancelling discovery.
        isDiscoveryRunning = false


        btManager.bluetoothAdapter?.cancelDiscovery()


        try {

            context.unregisterReceiver(discoveryReceiver)

        } catch (e: IllegalArgumentException) {

            // Receiver was not registered
        }


        println("Bluetooth discovery stopped")
    }
}