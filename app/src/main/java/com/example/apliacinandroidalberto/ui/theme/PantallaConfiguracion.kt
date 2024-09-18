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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun PantallaConfiguracion(
    backgroundColor: Color, // Color de fondo actual
    onBackgroundColorChange: (Color) -> Unit, // Función para cambiar el color de fondo
    onGoBack: () -> Unit // Función para volver a la pantalla principal
) {
    val context = LocalContext.current // Contexto de la actividad actual

    // Columna para organizar los elementos verticalmente
    Column(
        modifier = Modifier
            .fillMaxSize() // Ocupar todo el espacio disponible
            .background(backgroundColor) // Aplicar el color de fondo
            .padding(16.dp), // Agregar padding
        verticalArrangement = Arrangement.Center, // Centrar verticalmente
        horizontalAlignment = Alignment.CenterHorizontally // Centrar horizontalmente
    ) {

        // Composable para la selección de color
        ColorSelection(
            selectedColor = backgroundColor,
            onColorSelected = onBackgroundColorChange
        )

        Spacer(modifier = Modifier.height(16.dp)) // Espacio entre elementos

        // Botón para volver a la pantalla principal
        Button(onClick = onGoBack) {
            Text("Volver a la pantalla principal")
        }
    }
}

// Composable para la selección de colores
@Composable
fun ColorSelection(
    selectedColor: Color, // Color seleccionado actualmente
    onColorSelected: (Color) -> Unit // Función para cambiar el color seleccionado
) {
    val colors = listOf(Color.White, Color.LightGray, Color.Cyan, Color.Yellow, Color.Red, Color.Green) // Lista de colores disponibles

    Column {
        Text(text = "Selecciona un color de fondo", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold, modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.height(30.dp)

        )

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

// Composable para un botón de color
@Composable
fun ColorButton(
    color: Color, // Color del botón
    isSelected: Boolean, // Indica si el botón está seleccionado
    onClick: () -> Unit // Función a ejecutar al hacer clic en el botón
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