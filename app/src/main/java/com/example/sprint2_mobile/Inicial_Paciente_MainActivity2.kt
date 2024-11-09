package com.example.sprint2_mobile

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Inicial_Paciente_MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_inicial_paciente_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Configura o botão de voltar para a tela anterior
        val backButton = findViewById<ImageButton>(R.id.Button_back_TRATA)
        backButton.setOnClickListener {
            finish() // Encerra a Activity atual para voltar à anterior
        }

        // Configura o botão para iniciar a Paciente_MainActivity2
        val buttonCadasPaci = findViewById<Button>(R.id.button_cadas_paci)
        buttonCadasPaci.setOnClickListener {
            val intent = Intent(this, Paciente_MainActivity2::class.java)
            startActivity(intent)
        }

        val buttonGerenPaci = findViewById<Button>(R.id.button_geren_paci)
        buttonGerenPaci.setOnClickListener {
            val intent = Intent(this, ListarPacienteActivity::class.java)
            startActivity(intent)
        }


    }
}
