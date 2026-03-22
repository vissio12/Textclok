package com.example.textclok

import android.os.Bundle
import android.widget.TextClock
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Manejo de Insets para pantalla completa
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 1. Obtener la referencia del objeto gráfico TextClock
        val textClock = findViewById<TextClock>(R.id.textClock)

        // 2. Aplicar propiedades por código (opcional, ya que están en el XML)
        // Ejemplo: Cambiar el formato de 24 horas dinámicamente
        textClock.format24Hour = "HH:mm:ss 'hrs'"

        // 3. Implementar un evento del objeto (OnClick)
        textClock.setOnClickListener {
            val horaActual = textClock.text
            Toast.makeText(this, "Hora seleccionada: $horaActual", Toast.LENGTH_SHORT).show()
        }
    }
}
