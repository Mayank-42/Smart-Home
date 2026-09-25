package com.example.smarthome.ui.Screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun connectPage(nav: NavController){
    Scaffold() {
        paddingValues ->
        Box(modifier=Modifier.fillMaxSize()
            .padding(paddingValues)
        ){
        Column(modifier=Modifier.fillMaxSize()
        ){
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
        }
        }
    }

}
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun showww(){
//    connectPage()
//}