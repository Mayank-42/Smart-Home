package com.example.smarthome

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.smarthome.Bt.Repo.BtRepository
import com.example.smarthome.Bt.ViewModel.BtViewModel
import com.example.smarthome.Bt.ViewModel.BtViewModelFactory
import com.example.smarthome.Bt.btManager
import com.example.smarthome.ui.Screen.HomePage
import com.example.smarthome.ui.Screen.btPage
import com.example.smarthome.ui.Screen.connectPage
import com.example.smarthome.ui.theme.SmartHomeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SmartHomeTheme {
                val btManager = btManager(this@MainActivity)

                val repository = BtRepository(btManager)

                val btViewModel: BtViewModel = viewModel(
                    factory = BtViewModelFactory(repository)
                )
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "Home"
                ){
                    composable("Home"){
                        HomePage(navController)
                    }
                    composable("btFinding"){
                        btPage(navController,btViewModel)
                    }
                    composable("ConnectingPage"){
                        connectPage(navController)
                    }

                }


            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SmartHomeTheme {
        Greeting("Android")
    }
}