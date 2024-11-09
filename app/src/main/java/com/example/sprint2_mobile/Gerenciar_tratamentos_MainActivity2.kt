package com.example.sprint2_mobile

import TratamentoAdapter
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sprint2_mobile.services.Tratamento
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class Gerenciar_tratamentos_MainActivity2 : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var tratamentoAdapter: TratamentoAdapter
    private val tratamentosList = mutableListOf<Tratamento>() // Lista que armazenará os tratamentos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gerenciar_tratamentos_main2)

        recyclerView = findViewById(R.id.recyclerViewTratamentos)

        // Inicializa o RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        tratamentoAdapter = TratamentoAdapter(tratamentosList)
        recyclerView.adapter = tratamentoAdapter

        // Lê os tratamentos cadastrados
        lerTratamentos()

        // Configura o botão de voltar
        val backButton = findViewById<ImageButton>(R.id.Button_back_TRATA)
        backButton.setOnClickListener {
            val intent = Intent(this, TratamentoActivityMain2::class.java)
            startActivity(intent)
            finish() // Encerra a Activity atual
        }
    }

    // Método para ler tratamentos cadastrados
    private fun lerTratamentos() {
        val database = FirebaseDatabase.getInstance()
        val tratamentosRef = database.getReference("tratamentos")

        tratamentosRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                tratamentosList.clear()
                for (tratamentoSnapshot in snapshot.children) {
                    val tratamento = tratamentoSnapshot.getValue(Tratamento::class.java)
                    tratamento?.let { tratamentosList.add(it) }
                }
                tratamentoAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w("GerenciarTratamentos", "Erro ao ler tratamentos.", error.toException())
            }
        })
    }
}
