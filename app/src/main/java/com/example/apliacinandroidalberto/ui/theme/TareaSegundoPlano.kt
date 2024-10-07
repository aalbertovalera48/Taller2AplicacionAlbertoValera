package com.example.apliacinandroidalberto.ui.theme

import android.os.AsyncTask

class TareaEnSegundoPlano(private val callback: () -> Unit) : AsyncTask<Void, Void, Void>() {
    override fun doInBackground(vararg params: Void?): Void? {
        Thread.sleep(3000) // Simula tarea de larga duración
        return null
    }

    override fun onPostExecute(result: Void?) {
        super.onPostExecute(result)
        callback() // Llama al callback al completar la tarea
    }
}
