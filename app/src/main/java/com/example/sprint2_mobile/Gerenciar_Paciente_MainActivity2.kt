package com.example.sprint2_mobile

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sprint2_mobile.adapters.PacienteAdapter
import com.example.sprint2_mobile.services.Paciente
import com.google.firebase.database.*

class Gerenciar_Paciente_MainActivity2 : AppCompatActivity() {

    private lateinit var database: DatabaseReference
    private lateinit var recyclerView: RecyclerView
    private lateinit var pacienteAdapter: PacienteAdapter
    private val pacientesList = mutableListOf<Paciente>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_gerenciar_paciente_main2)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        database = FirebaseDatabase.getInstance().getReference("pacientes")

        // Inicializa o RecyclerView
        recyclerView = findViewById(R.id.recyclerViewPacientes)
        recyclerView.layoutManager = LinearLayoutManager(this)
        pacienteAdapter = PacienteAdapter(pacientesList)
        recyclerView.adapter = pacienteAdapter

        loadPacientes()

        // Configura o botão de voltar
        val backButton = findViewById<ImageButton>(R.id.Button_back_TRATA)
        backButton.setOnClickListener {
            finish()
        }
    }

    private fun loadPacientes() {
        // Carregar dados do Firebase
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                pacientesList.clear()
                for (pacienteSnapshot in snapshot.children) {
                    val paciente = pacienteSnapshot.getValue(Paciente::class.java)
                    paciente?.let { pacientesList.add(it) }
                }
                pacienteAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                // Tratar erro se necessário
            }
        })
    }
}


