package com.example.sprint2_mobile

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sprint2_mobile.services.Paciente
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Paciente_MainActivity2 : AppCompatActivity() {

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_paciente_cadastro_main2)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicializa o Firebase Database
        database = FirebaseDatabase.getInstance().getReference("pacientes")

        val nomeEditText = findViewById<EditText>(R.id.editTextNome)
        val emailEditText = findViewById<EditText>(R.id.editTextEmail)
        val dataNascimentoEditText = findViewById<EditText>(R.id.editTextDataNascimento)
        val telefoneEditText = findViewById<EditText>(R.id.editTextTelefone)
        val logradouroEditText = findViewById<EditText>(R.id.editTextLogradouro)
        val bairroEditText = findViewById<EditText>(R.id.editTextBairro)
        val cepEditText = findViewById<EditText>(R.id.editTextCep)
        val complementoEditText = findViewById<EditText>(R.id.editTextComplemento)
        val numeroEditText = findViewById<EditText>(R.id.editTextNumero)
        val ufEditText = findViewById<EditText>(R.id.editTextUf)
        val cidadeEditText = findViewById<EditText>(R.id.editTextCidade)

        val registrarButton = findViewById<Button>(R.id.buttonSalvar)

        registrarButton.setOnClickListener {
            val nome = nomeEditText.text.toString()
            val email = emailEditText.text.toString()
            val dataNascimento = dataNascimentoEditText.text.toString()
            val telefone = telefoneEditText.text.toString()
            val logradouro = logradouroEditText.text.toString()
            val bairro = bairroEditText.text.toString()
            val cep = cepEditText.text.toString()
            val complemento = complementoEditText.text.toString()
            val numero = numeroEditText.text.toString()
            val uf = ufEditText.text.toString()
            val cidade = cidadeEditText.text.toString()

            // Verifica se todos os campos foram preenchidos corretamente
            if (nome.isNotEmpty() && email.isNotEmpty() && dataNascimento.isNotEmpty() && telefone.isNotEmpty()) {
                val novoPaciente = Paciente(nome, email, dataNascimento, telefone, logradouro, bairro, cep, complemento, numero, uf, cidade)

                // Cadastra o paciente no Firebase
                val pacienteId = database.push().key // Gera uma chave única
                if (pacienteId != null) {
                    database.child(pacienteId).setValue(novoPaciente).addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Paciente cadastrado com sucesso!", Toast.LENGTH_SHORT).show()
                            // Redireciona para a tela de gerenciamento de pacientes
                            val intent = Intent(this, Gerenciar_Paciente_MainActivity2::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(this, "Erro ao cadastrar paciente", Toast.LENGTH_SHORT).show()
                        }
                    }.addOnFailureListener {
                        Toast.makeText(this, "Erro de conexão", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            }
        }

        // Configura o botão de voltar
        val backButton = findViewById<ImageButton>(R.id.Button_back_TRATA)
        backButton.setOnClickListener {
            finish() // Encerra a Activity atual para voltar à anterior
        }
    }
}
