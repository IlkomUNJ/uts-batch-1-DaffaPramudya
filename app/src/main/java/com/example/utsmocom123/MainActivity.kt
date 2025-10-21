package com.example.utsmocom123

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.utsmocom123.ui.theme.UTSmocom123Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UTSmocom123Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    var currentScreen by remember { mutableStateOf(0) }

    when (currentScreen) {
        0 -> LoginScreen(onLoginSuccess = { currentScreen = 1 })
        1 -> DashboardScreen(onAddStudentClick = { currentScreen = 2 })
        2 -> AddStudentScreen(onStudentAdded = { currentScreen = 1 })
    }
}