package com.example.apliacinandroidalberto.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import android.content.Context


@Composable
fun PantallaConfiguracion(
    backgroundColor: Color,
    onBackgroundColorChange: (Color) -> Unit,
    onGoBack: () -> Unit
) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SeleccionColor(
            selectedColor = backgroundColor,
            onColorSelected = {
                saveBackgroundColor(context, it)
                onBackgroundColorChange(it)
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = onGoBack) {
            Text("Volver a la pantalla principal")
        }
    }
}
@Composable
fun SeleccionColor(
    selectedColor: Color,
    onColorSelected: (Color) -> Unit
) {
    val colors = listOf(Color.White, Color.LightGray, Color.Cyan, Color.Yellow, Color.Red, Color.Green)

    Column {
        Text(
            text = "Selecciona un color de fondo",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(30.dp))

        Row {
            colors.forEach { color ->
                ColorButton(
                    color = color,
                    isSelected = color == selectedColor,
                    onClick = { onColorSelected(color) }
                )
            }
        }
    }
}


@Composable
fun ColorButton(
    color: Color,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .size(48.dp)
            .padding(4.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = color,
            contentColor = if (color == Color.White) Color.Black else Color.White
        )
    ) {
        if (isSelected) {
            Icon(
                imageVector = Icons.Filled.Check,
                contentDescription = "Selected",
                tint = if (color == Color.White) Color.Black else Color.White
            )
        }
    }
}

fun saveBackgroundColor(context: Context, color: Color) {
    val sharedPref = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
    with(sharedPref.edit()) {
        putInt("backgroundColor", color.toArgb())
        apply()
    }
}

fun getBackgroundColor(context: Context): Color {
    val sharedPref = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
    val colorArgb = sharedPref.getInt("backgroundColor", Color.White.toArgb())
    return Color(colorArgb)
}