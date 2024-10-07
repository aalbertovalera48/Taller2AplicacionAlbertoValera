package com.example.apliacinandroidalberto.ui.theme

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class Servicio : Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Thread {
            for (i in 1..5) {
                Log.d("Servicio", "Tarea en ejecución $i")
                // Envía mensaje de progreso (a través de un Log o Snackbar, en la actividad)
                intent?.putExtra("message", "Tarea en ejecución $i")
                Thread.sleep(1000) // Simula tarea de larga duración
            }
            stopSelf() // Detiene el servicio cuando termina
        }.start()
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null // Este servicio no se enlaza
    }
}
