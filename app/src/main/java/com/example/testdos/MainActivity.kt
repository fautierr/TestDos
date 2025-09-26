package com.example.testdos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.testdos.navigation.AppNavHost
import com.example.testdos.ui.theme.TestDosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            TestDosTheme {
                AppNavHost()
            }
        }
    }
}
