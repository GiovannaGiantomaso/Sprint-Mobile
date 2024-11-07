package com.example.sprint2_mobile;

import android.app.Activity
import android.content.Intent


import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sprint2_mobile.Tratamento

class Gerenciar_tratamentos_MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gerenciar_tratamentos_main2)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewTratamentos)

        // Exemplo de lista de tratamentos
        val tratamentos = listOf(
            Tratamento(1, "Tratamento emergencial", "Emergencial", 300.00),
            Tratamento(2, "Tratamento preventivo", "Preventivo", 150.00),
            Tratamento(3, "Tratamento estético", "Estética", 500.00),
            Tratamento(4, "Tratamento periodontal", "Periodontal", 290.00),
            // Adicione mais tratamentos conforme necessário
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = TratamentoAdapter(tratamentos)
        // Configura o botão de voltar para tratamento_activity_main2
        val backButton = findViewById<ImageButton>(R.id.Button_back_TRATA)
        backButton.setOnClickListener {
            val intent = Intent(this, TratamentoActivityMain2::class.java)
            startActivity(intent)
            finish() // Encerra a Activity atual para que o usuário não volte para ela
        }
    }
}
