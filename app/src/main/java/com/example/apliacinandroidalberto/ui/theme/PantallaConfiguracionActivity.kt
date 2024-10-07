package com.example.apliacinandroidalberto.ui.theme

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

class PantallaConfiguracionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    SettingsScreenContent()
                }
            }
        }
    }
}
@Composable
fun SettingsScreenContent() {

    var backgroundColor = remember { mutableStateOf(Color.White) }
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
    PantallaConfiguracion(
        onGoBack = {
            val intent = Intent(context, SplashScreenActivity::class.java)
            context.startActivity(intent)
            },
        backgroundColor = backgroundColor.value,
        onBackgroundColorChange = { color ->
            backgroundColor.value = color
        })
    }
    }

