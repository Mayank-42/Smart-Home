package com.example.smarthome.ui.Screen

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bluetooth
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import androidx.navigation.NavController
import com.example.smarthome.Bt.ViewModel.BtViewModel
import java.lang.annotation.RetentionPolicy

private val btBlue=Color(0xFF4A5CFF)
private val btLightBlue=Color(0xFFEAF4FF)
@Composable
fun btPage(nav: NavController, btViewModel: BtViewModel){

    val context = LocalContext.current

    val bluetoothPermissionLauncher =
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.RequestMultiplePermissions()
        ) { permissions ->

            val scanGranted =
                permissions[Manifest.permission.BLUETOOTH_SCAN] == true

            val connectGranted =
                permissions[Manifest.permission.BLUETOOTH_CONNECT] == true

            if (scanGranted && connectGranted) {

                if (btViewModel.isBluetoothEnabled()) {
                    if (btViewModel.isBluetoothEnabled()) {
                        nav.navigate("ConnectingPage")
                    }
                }

            }
        }

    Scaffold(

    ) {paddingValues ->
        Box(modifier=Modifier.padding(paddingValues).fillMaxSize()
        ){
            Column(modifier=Modifier.fillMaxSize()
            ){
                Column(modifier=Modifier.fillMaxWidth().padding(horizontal = 10.dp, vertical = 10.dp)){
                    Text(
                        text="Add your Smart Plug",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Spacer(modifier=Modifier.height(20.dp))
                    Text(
                        text="Lets connect your smart Plug to your home Wi-Fi in just a minute .",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Light
                    )
                }
                Box(modifier=Modifier.fillMaxWidth()
                    .padding(horizontal = 40.dp, vertical = 20.dp)
                    .shadow(
                        elevation = 8.dp,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .clip(RoundedCornerShape(15.dp))
                    .background(btBlue),
                    contentAlignment =Alignment.Center
                ) {
                    Box(modifier=Modifier.fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 30.dp)
                        .shadow(
                            elevation = 6.dp,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .clip(RoundedCornerShape(15.dp))
                        .background(btLightBlue),
                        contentAlignment =Alignment.Center) {
                    Box(modifier = Modifier
                        .height(220.dp)
                        .width(220.dp)
                        .padding(horizontal = 20.dp, vertical = 20.dp)
                        .shadow(
                            elevation = 10.dp,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.White),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Bluetooth,
                            contentDescription = null,
                            modifier=Modifier.size(50.dp)
                        )
                    }
                }

                }
                Spacer(modifier=Modifier.padding(20.dp))
                Column(modifier=Modifier.padding(start=20.dp)){
                    Text(
                        text="Plug your device into a wall power outlet."
                    )
                    Spacer(modifier=Modifier.padding(5.dp))
                    Text(
                        text="Have your home Wi-Fi password ready."
                    )
                }
                Box(modifier=Modifier.fillMaxSize()
                    .padding(bottom = 30.dp),
                    contentAlignment = Alignment.BottomCenter
                ){
                Box(modifier = Modifier.fillMaxWidth()
                    .clickable{nav.navigate("ConnectingPage")}
                    .padding(20.dp)
                    .shadow(7.dp,RoundedCornerShape(10.dp))
                    .height(60.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(btBlue),
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        text="Start Setup ->",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color=Color.White
                    )
                }
                }
            }
        }
    }

}

//@Preview(showSystemUi = true, showBackground = true)
//@Composable
//fun showw(){btPage()}
//
//
