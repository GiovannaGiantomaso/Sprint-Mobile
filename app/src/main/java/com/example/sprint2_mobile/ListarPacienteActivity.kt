package com.example.sprint2_mobile

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sprint2_mobile.adapters.PacienteAdapter
import com.example.sprint2_mobile.services.Paciente
import com.google.firebase.database.*

class ListarPacienteActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference
    private lateinit var recyclerView: RecyclerView
    private lateinit var pacienteAdapter: PacienteAdapter
    private val pacientesList = mutableListOf<Paciente>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar_paciente)

        // Inicializa o Firebase Database
        database = FirebaseDatabase.getInstance().getReference("pacientes")

        // Inicializa RecyclerView
        recyclerView = findViewById(R.id.recyclerViewListarPacientes)
        recyclerView.layoutManager = LinearLayoutManager(this)
        pacienteAdapter = PacienteAdapter(pacientesList)
        recyclerView.adapter = pacienteAdapter

        // Carrega pacientes do Firebase
        loadPacientes()

        // Configura o botão de voltar
        val backButton = findViewById<ImageButton>(R.id.Button_back_listar)
        backButton.setOnClickListener {
            finish() // Encerra a Activity atual para voltar à anterior
        }
    }

    private fun loadPacientes() {
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                pacientesList.clear()
                for (pacienteSnapshot in snapshot.children) {
                    val paciente = pacienteSnapshot.getValue(Paciente::class.java)
                    if (paciente != null) {
                        pacientesList.add(paciente)
                    }
                }
                pacienteAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                // Tratar erro se necessário
            }
        })
        // Configura o botão de voltar para a tela anterior
        val backButton = findViewById<ImageButton>(R.id.Button_back_TRATA)
        backButton.setOnClickListener {
            finish() // Encerra a Activity atual para voltar à anterior
        }
    }
}
