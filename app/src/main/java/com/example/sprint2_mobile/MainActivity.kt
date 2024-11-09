package com.example.sprint2_mobile

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import com.google.firebase.FirebaseApp // Import necessário para Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializa o Firebase
        FirebaseApp.initializeApp(this)

        // Configura a aparência da janela
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button_trata)
        button.setOnClickListener {
            val intent = Intent(this, TratamentoActivityMain2::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonPaciente = findViewById<Button>(R.id.button_paciente)
        buttonPaciente.setOnClickListener {
            val intent = Intent(this, Inicial_Paciente_MainActivity2::class.java)
            startActivity(intent)
        }
    }
}
