package com.example.smarthome.ui.Screen

import android.Manifest
import android.R.attr.font
import android.R.attr.fontWeight
import android.R.attr.text
import android.bluetooth.BluetoothDevice
import android.graphics.Paint
import android.icu.util.ULocale
import androidx.annotation.RequiresPermission
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.Cable
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.Ro
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.smarthome.Bt.ViewModel.BtViewModel
import kotlin.collections.emptyList

private val HomeBlue=Color(0xFF4A5CFF)
@OptIn(ExperimentalMaterial3Api::class)
@RequiresPermission(Manifest.permission.BLUETOOTH_CONNECT)
@Composable
//fun connectPage(nav: NavController){
fun connectPage(nav: NavController,btVM: BtViewModel){

    val scope= rememberScrollState()

    LaunchedEffect(Unit) {
        btVM.startDiscovery()
    }
    val devices by btVM.devices.collectAsState(
        initial = emptyList()
    )
    print(devices.size)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = {nav.popBackStack()}){
                        Icon(
                            imageVector = Icons.Default.ArrowBackIos,
                            contentDescription = null,

                        )
                    }
                }
            )
        }
    ) {
        paddingValues ->
        Box(modifier=Modifier.fillMaxSize()
            .padding(paddingValues)
        ){
        Column(modifier=Modifier.fillMaxSize()
        ){
            Spacer(modifier=Modifier.height(20.dp))

            Column(modifier = Modifier.padding(start = 20.dp).verticalScroll(scope)){
                Text(
                    text="Looking For your Smart Plug",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text="Make sure your Smart Plug is powerd on"
                )
            }
            Spacer(modifier=Modifier.height(20.dp))
            Box(modifier=Modifier.fillMaxWidth().height(300.dp).verticalScroll(scope),
                contentAlignment = Alignment.Center
                ){
                    Box(
                        modifier=Modifier.width(60.dp)
                            .height(60.dp)
                            .shadow(12.dp, RoundedCornerShape(20.dp))
                            .clip(RoundedCornerShape(20.dp))
                            .background(HomeBlue),
                        contentAlignment = Alignment.Center
                    ){

                    Icon(
                        imageVector = Icons.Default.Cable,
                        contentDescription = null,
                        tint=Color.White,
                        modifier=Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .background(HomeBlue)


                    )
                    }
            }


                Column(modifier=Modifier.fillMaxSize().verticalScroll(scope)){
                devices.forEach { device ->
                    if (device.name != null) {
                        btDevices(device)
                    }
                }
                }
//            LazyColumn(
//                modifier = Modifier.weight(1f)
//            ) {
//                items(
//                    items = devices,
//                    key = { it.address }
//                ) { device ->
//                    btDevices(device)
//                }
//            }



        }

        }
    }

}

@RequiresPermission(Manifest.permission.BLUETOOTH_CONNECT)
@Composable
fun btDevices(device: BluetoothDevice){
    Box(modifier=Modifier.fillMaxWidth()
        .padding(horizontal = 10.dp, vertical = 5.dp)
        .clip(RoundedCornerShape(10.dp))
        .shadow(15.dp, RoundedCornerShape(10.dp))
        .background(Color.White)
        .border(1.dp,Color.Green, RoundedCornerShape(10.dp))
        .clickable{}

    ){
        if (device.name != null) {
        Row(modifier=Modifier.padding(20.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = null,
                tint = Color.Green,
                modifier = Modifier.size(30.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .background(Color(0xFFE8FFF5))
            )
             Spacer(modifier=Modifier.width(10.dp))
            Column(){
                Text(
                    text = "Smart plug Found",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 15.sp,
                    color = Color.Green
                )
                Text(
                    text = device.name?:"Unonknown error",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                Text(
                    text=device.address,
                    fontWeight = FontWeight.Normal,
                    fontSize = 10.sp
                )
            }
            }
        }

  }
}




//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun showww(){
//    connectPage()
//}