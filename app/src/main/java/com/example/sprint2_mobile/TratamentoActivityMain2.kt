package com.example.sprint2_mobile

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class TratamentoActivityMain2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tratamento_activity_main2)

        // botão para ir para Cadastro_Tratamento_MainActivity2
        val cadastrarTrataButton = findViewById<Button>(R.id.button_cadastrar_trata)
        cadastrarTrataButton.setOnClickListener {
            val intent = Intent(this, Cadastro_Tratamento_MainActivity2::class.java)
            startActivity(intent)
        }

        // botão para ir para Gerenciar_tratamentos_MainActivity2
        val gerenciarTrataButton = findViewById<Button>(R.id.button_gerenciar_trata)
        gerenciarTrataButton.setOnClickListener {
            val intent = Intent(this, Gerenciar_tratamentos_MainActivity2::class.java)
            startActivity(intent)
        }

        // botão de voltar para a tela anterior
        val backButton = findViewById<ImageButton>(R.id.Button_back_TRATA)
        backButton.setOnClickListener {
            finish() // Encerra a Activity atual para voltar à anterior
        }
    }
}
