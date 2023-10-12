package com.example.wandy_p1_ap2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.wandy_p1_ap2.ui.dividir.DividirScreen
import com.example.wandy_p1_ap2.ui.theme.Wandy_p1_ap2Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Wandy_p1_ap2Theme {
                // A surface container using the 'background' color from the theme
                DividirScreen()
            }
        }
    }
}
