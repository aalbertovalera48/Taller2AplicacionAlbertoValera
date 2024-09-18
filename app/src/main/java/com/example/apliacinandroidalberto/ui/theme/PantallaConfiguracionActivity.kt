package com.example.apliacinandroidalberto.ui.theme

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

class PantallaConfiguracionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                // Un contenedor Surface usando el color 'background' del tema
                Surface(color = MaterialTheme.colorScheme.background) {
                    SettingsScreenContent()
                }
            }
        }
    }
}
@Composable
fun SettingsScreenContent() {
    var backgroundColor by remember { mutableStateOf(Color.White) }
    val context = LocalContext.current

    PantallaConfiguracion(
        backgroundColor = backgroundColor,
        onBackgroundColorChange = { backgroundColor = it },
        onGoBack = {
            val intent = Intent(context, SplashScreenActivity::class.java)
            context.startActivity(intent)
        }
    )
}