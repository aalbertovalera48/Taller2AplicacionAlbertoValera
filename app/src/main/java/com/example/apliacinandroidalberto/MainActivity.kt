package com.example.apliacinandroidalberto

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.apliacinandroidalberto.ui.theme.PantallaConfiguracionActivity
import kotlin.io.path.moveTo

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    var name by remember { mutableStateOf("") }
    var savedName by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Bienvenido",
            style = MaterialTheme.typography.headlineLarge,
            color = colorResource(R.color.teal_200)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Escribe tu nombre") },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                unfocusedBorderColor = Color.Gray
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { savedName = name },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.teal_200),
                contentColor = Color.Black
            )
        ) {
            Text("Guardar")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Nombre guardado:> $savedName",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurface
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                context.startActivity(Intent(context, PantallaConfiguracionActivity::class.java))
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.teal_700),
                contentColor = Color.White
            )
        ) {
            Text("Ir a configuración")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen()
}