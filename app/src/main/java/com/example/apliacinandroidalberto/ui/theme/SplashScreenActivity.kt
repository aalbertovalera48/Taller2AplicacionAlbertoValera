package com.example.apliacinandroidalberto.ui.theme

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.apliacinandroidalberto.MainActivity
import com.example.apliacinandroidalberto.R
import java.util.Calendar

class SplashScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SplashScreen()
        }
    }
}

@Composable
fun SplashScreen() {
    val context = LocalContext.current
    val currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
    val greeting = when (currentHour) {
        in 0..11 -> stringResource(id = R.string.good_morning)
        in 12..18 -> stringResource(id = R.string.good_afternoon)
        else -> stringResource(id = R.string.good_evening)
    }

    Column(
        modifier = Modifier.fillMaxSize().background(Color.White), // Add this line
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "$greeting!", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            context.startActivity(Intent(context, MainActivity::class.java))
        }) {
            Text(stringResource(id = R.string.continue_button))
        }
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    SplashScreen()}
