package com.example.smarthome.ui.Screen

import android.R.attr.tint
import android.widget.Space
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ScaleFactor
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Cable
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.text.font.FontVariation.weight
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory

private val HomeBlue=Color(0xFF4A5CFF)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(modifier: Modifier) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                      text="My Smart Plugs",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 25.sp,
                        letterSpacing = 0.1.sp
                    )
                },
                actions = {
                    Row(modifier=Modifier.padding(20.dp)){
                        Icon(
                          imageVector = Icons.Default.Menu,
                            contentDescription = null,
                            modifier=Modifier
//                                .padding(30.dp)
                                .size(40.dp)
                                .clip(CircleShape)
                                .background(Color(0xFF4A5CFF)),
                            tint=Color.White
                        )
                        Spacer(modifier=Modifier.width(10.dp))
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = null,
                            modifier=Modifier
//                                .padding(30.dp)
                                .size(40.dp)
                                .clip(CircleShape)
                                .background(HomeBlue),
                        tint=Color.White
                        )
                    }

                }
            )
        }



    ) {paddingValues ->
        Box(modifier=Modifier.fillMaxSize()
            .padding(paddingValues)
            .background(Color.White)
        ){
            Column(modifier=Modifier.fillMaxSize()){
                Spacer(modifier=Modifier.height(20.dp))
                conectedApp()
                Spacer(modifier=Modifier.height(40.dp))
                ConnetedDevice()
            }


        }
    }
}
@Composable
fun conectedApp(){
    Surface(modifier=Modifier.fillMaxWidth()
        .padding(start=10.dp,end=10.dp),
        color=Color(0xFFEAF4FF),
        shape = RoundedCornerShape(20.dp)
    ) {
        Row(modifier=Modifier.fillMaxWidth()
            .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
        Text(
            text = "1 plugs connected",
            fontWeight = FontWeight.SemiBold
        )
            Box(modifier=Modifier.fillMaxWidth()
                .padding(end=10.dp),
                contentAlignment = Alignment.CenterEnd
            ) {
                Box(modifier = Modifier
                    .clip(RoundedCornerShape(30.dp))
                    .background(Color.White)
                ) {
                Text(
                    text = "Home Wi-Fi",
                    modifier = Modifier.padding(vertical = 5.dp, horizontal = 10.dp),
                    color=Color.Blue

                )
            }
            }


    }
    }
}

@Composable
fun ConnetedDevice(){
    var iSTogle by rememberSaveable{ mutableStateOf(true) }
    Box(modifier=Modifier.fillMaxWidth()

        .padding(horizontal = 10.dp)
        .clip(RoundedCornerShape(20.dp))
        .background(Color.White)
        .border(0.dp,Color.White, RoundedCornerShape(20.dp))
        .shadow(20.dp,RoundedCornerShape(20.dp),false,Color.Black,Color.White)
    ){
        Column(modifier=Modifier.fillMaxWidth().padding(vertical = 20.dp),
            verticalArrangement = Arrangement.Center
        ){
            Row(modifier=Modifier.fillMaxWidth()
                .padding(start=20.dp),
                verticalAlignment =Alignment.CenterVertically)
            {
                Box(modifier=Modifier
                    .clip(RoundedCornerShape(15.dp))
                    .background(if(iSTogle) HomeBlue else Color.Gray)
                ){
                Icon(
                    imageVector = Icons.Default.Cable,
                    contentDescription = null,
                    tint=if(iSTogle) Color.White else Color.Black,
                    modifier=Modifier.padding(10.dp)
                )
                }
                Spacer(modifier=Modifier.width(20.dp))
                Column(modifier=Modifier.weight(1f)){
                    Text(
                        text="Living Room",
                        fontWeight = FontWeight.Bold,
                        fontSize = 17.sp
                    )
                    Spacer(modifier=Modifier.height(3.dp))
                    Text(
                        text="Connected",
                        fontSize=10.sp
                    )
                }
                Box(modifier=Modifier.padding(end=20.dp)
                    .clickable{iSTogle=!iSTogle},
                    contentAlignment = Alignment.CenterEnd){
                    Box(modifier=Modifier
                        .clip(RoundedCornerShape(30.dp))
                        .background(if(iSTogle) HomeBlue else Color.Gray),
                        contentAlignment = Alignment.CenterEnd
                    ) {
                        Row(modifier=Modifier.padding(10.dp)) {
                            if(!iSTogle) {
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(30.dp))
                                        .background(Color.White)
                                ) {
                                    Text(
                                        text = "Of",
                                        modifier = Modifier.padding(2.dp)
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.width(20.dp))
                            if(iSTogle) {
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(30.dp))
                                        .background(Color.White)
                                ) {
                                    Text(
                                        text = "On",
                                        fontWeight = FontWeight.Black,
                                        modifier = Modifier.padding(4.dp)
                                    )
                                }
                            }
                        }
                    }

                }

            }
            Spacer(modifier=Modifier.height(10.dp))
            Row(modifier = Modifier.fillMaxWidth().padding(35.dp), verticalAlignment = Alignment.CenterVertically){
                Text(
                    text="Updated",
                    color=Color.Gray,
                    fontSize = 10.sp
                )
                Text(
                    text="  Just now",
                    fontWeight = FontWeight.Normal
                )
                Spacer(modifier=Modifier.width(60.dp))
                Text(
                    text="Test Ofline",
                    color=Color(0xFFFF9800),
                    fontWeight = FontWeight.Normal,

                )
                Spacer(modifier=Modifier.width(20.dp))
                Text(
                    text="Control",
                    color=Color.Blue,
                    fontWeight = FontWeight.Normal
                )
            }
        }

    }
}



