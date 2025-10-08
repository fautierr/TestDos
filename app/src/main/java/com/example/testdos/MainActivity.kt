package com.example.testdos

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.testdos.navigation.MainScreen
// import com.example.testdos.navigation.AppNavHost
import com.example.testdos.ui.theme.TestDosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        /*poner transparente el system navigation bar inferior
        En Android 10+ la nav bar será translúcida (sin contraste forzado).*/
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            window.setNavigationBarContrastEnforced(false)
        }
        setContent {
            TestDosTheme {
                MainScreen()
                // AppNavHost()
            }
        }
    }
}
