package com.example.smarthome.ui.Screen

import android.R.attr.tint
import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
fun HomePage() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                      text="My Smart Plugs",
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        letterSpacing = 0.3.sp
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
                Spacer(modifier=Modifier.height(20.dp))
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
    Box(modifier=Modifier.fillMaxWidth()
        .height(120.dp)
        .padding(horizontal = 10.dp)
        .clip(RoundedCornerShape(20.dp))
        .background(Color.White)
        .border(0.dp,Color.White, RoundedCornerShape(20.dp))
        .shadow(20.dp,RoundedCornerShape(20.dp),true,Color.Black,Color.White)
    ){
        Column(modifier=Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ){
            Row(modifier=Modifier.fillMaxWidth()
                .padding(start=20.dp),
                verticalAlignment =Alignment.CenterVertically)
            {
                Box(modifier=Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(HomeBlue)
                ){
                Icon(
                    imageVector = Icons.Default.Cable,
                    contentDescription = null,
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
                Box(modifier=Modifier.padding(end=20.dp), contentAlignment = Alignment.CenterEnd){
                    Box(modifier=Modifier
                        .clip(RoundedCornerShape(30.dp))
                        .background(HomeBlue),
                        contentAlignment = Alignment.CenterEnd
                    ) {
                        Row(modifier=Modifier.padding(10.dp)){
                            Text(
                                text = "On"
                            )
                            Spacer(modifier = Modifier.width(20.dp))

                            Text(
                                text = "Of"
                            )
                        }
                    }

                }

            }
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun show(){
    HomePage()
}