package com.example.sprint2_mobile

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class Cadastro_Tratamento_MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_tratamento_main2)

        // Configura o botão de voltar para tratamento_activity_main2
        val backButton = findViewById<ImageButton>(R.id.Button_back_TRATA)
        backButton.setOnClickListener {
            val intent = Intent(this, TratamentoActivityMain2::class.java)
            startActivity(intent)
            finish() // Encerra a Activity atual para que o usuário não volte para ela
        }
    }
}
