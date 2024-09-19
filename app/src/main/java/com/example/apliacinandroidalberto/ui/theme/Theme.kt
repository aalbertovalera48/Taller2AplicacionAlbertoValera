package com.example.apliacinandroidalberto.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    backgroundColor: Color = White, // Color de fondo predeterminado
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        darkColorScheme(
            primary = Color.Blue,
            secondary = Color.LightGray,
            background = backgroundColor // Usar el color de fondo proporcionado
        )
    } else {
        lightColorScheme(
            primary = Color.Blue,
            secondary = Color.LightGray,
            background = backgroundColor // Usar el color de fondo proporcionado
        )
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
