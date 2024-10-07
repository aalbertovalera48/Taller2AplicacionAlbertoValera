package com.example.apliacinandroidalberto

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.apliacinandroidalberto.ui.theme.PantallaConfiguracionActivity
import com.example.apliacinandroidalberto.ui.theme.Servicio
import com.example.apliacinandroidalberto.ui.theme.TareaEnSegundoPlano

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MainActivity", "onCreate: Actividad creada")
        setContent {
            MainScreen()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart: Actividad visible")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume: Actividad en primer plano")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause: Actividad pausada")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop: Actividad ya no visible")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    var name by remember { mutableStateOf("") }
    var savedName by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    var showSnackbar by remember { mutableStateOf(false) }
    var snackbarMessage by remember { mutableStateOf("") }
    val context = LocalContext.current
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(showSnackbar) {
        if (showSnackbar) {
            snackbarHostState.showSnackbar(snackbarMessage)
            showSnackbar = false
        }
    }

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
            text = "Nombre guardado: $savedName",
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

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                // Iniciar AsyncTask
                isLoading = true
                TareaEnSegundoPlano {
                    isLoading = false
                    Log.d("AsyncTask", "Tarea completada")
                }.execute()
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.teal_700),
                contentColor = Color.White
            )
        ) {
            Text("Iniciar Tarea en Segundo Plano (AsyncTask)")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                // Iniciar un hilo
                isLoading = true
                Thread {
                    // Simula tarea de larga duración
                    Thread.sleep(3000)
                    Log.d("Thread", "Tarea completada")
                    (context as MainActivity).runOnUiThread {
                        isLoading = false
                    }
                }.start()
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.teal_700),
                contentColor = Color.White
            )
        ) {
            Text("Iniciar Tarea en Segundo Plano (Thread)")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                snackbarMessage = "Servicio iniciado"
                showSnackbar = true
                context.startService(Intent(context, Servicio::class.java))
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.teal_700),
                contentColor = Color.White
            )
        ) {
            Text("Iniciar Servicio")
        }

        if (isLoading) {
            Spacer(modifier = Modifier.height(16.dp))
            CircularProgressIndicator()
        }

        SnackbarHost(hostState = snackbarHostState)
    }
}
