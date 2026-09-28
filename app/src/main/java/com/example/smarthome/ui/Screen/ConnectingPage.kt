package com.example.smarthome.ui.Screen

import android.R.attr.font
import android.R.attr.text
import android.graphics.Paint
import android.icu.util.ULocale
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cable
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
@Composable
//fun connectPage(nav: NavController){
fun connectPage(nav: NavController,btVM: BtViewModel){

    LaunchedEffect(Unit) {
        btVM.startDiscovery()
    }
    val devices by btVM.devices.collectAsState(
        initial = emptyList()
    )

    Scaffold() {
        paddingValues ->
        Box(modifier=Modifier.fillMaxSize()
            .padding(paddingValues)
        ){
        Column(modifier=Modifier.fillMaxSize()
        ){
            Spacer(modifier=Modifier.height(20.dp))

            Column(modifier = Modifier.padding(start = 20.dp)){
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
            Box(modifier=Modifier.fillMaxWidth().height(300.dp),
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
                btDevices()

        }

        }
    }

}

@Composable
fun btDevices(){
    Box(modifier=Modifier.fillMaxWidth()
        .padding(horizontal = 10.dp)
        .clip(RoundedCornerShape(10.dp))
        .shadow(15.dp, RoundedCornerShape(10.dp))
        .background(Color.White)
        .clickable{}

    ){
        Row(modifier=Modifier.padding(20.dp)){
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = null,
                tint=Color.Green,
                modifier=Modifier
                    .clip(RoundedCornerShape(5.dp))
                    .background(Color.Gray)
            )
            Text(
                text="Device Name ",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        }

    }
}




//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun showww(){
//    connectPage()
//}