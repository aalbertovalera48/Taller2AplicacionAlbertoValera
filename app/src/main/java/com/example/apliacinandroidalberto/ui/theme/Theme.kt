package com.example.apliacinandroidalberto.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = CustomColorPalette2,
        typography = Typography(
            headlineMedium = TextStyle(fontWeight = FontWeight.Bold, fontSize = 24.sp),
            bodyLarge = TextStyle(fontSize = 16.sp),
            titleMedium = TextStyle(fontWeight = FontWeight.Medium, fontSize = 20.sp)
        ),
        content = content
    )
}