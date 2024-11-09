package com.example.sprint2_mobile

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sprint2_mobile.services.Tratamento
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Cadastro_Tratamento_MainActivity2 : AppCompatActivity() {

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_tratamento_main2)

        // Inicializa o Firebase Database
        database = FirebaseDatabase.getInstance().getReference("tratamentos")

        val descricaoEditText = findViewById<EditText>(R.id.editTextDescricao)
        val tipoEditText = findViewById<EditText>(R.id.editTextTipo)
        val custoEditText = findViewById<EditText>(R.id.editTextCusto)
        val registrarButton = findViewById<Button>(R.id.buttonRegistrar)

        registrarButton.setOnClickListener {
            val descricao = descricaoEditText.text.toString()
            val tipo = tipoEditText.text.toString()
            val custo = custoEditText.text.toString()

            if (descricao.isNotEmpty() && tipo.isNotEmpty() && custo.isNotEmpty()) {
                val novoTratamento = Tratamento(descricao, tipo, custo)

                // Cadastra o tratamento no Firebase
                val tratamentoId = database.push().key
                if (tratamentoId != null) {
                    database.child(tratamentoId).setValue(novoTratamento).addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Tratamento cadastrado com sucesso!", Toast.LENGTH_SHORT).show()
                            finish()
                        } else {
                            Toast.makeText(this, "Erro ao cadastrar tratamento", Toast.LENGTH_SHORT).show()
                        }
                    }.addOnFailureListener {
                        Toast.makeText(this, "Erro de conexão", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            }
        }

        // Configura o botão de voltar para a tela anterior
        val backButton = findViewById<ImageButton>(R.id.Button_back_TRATA)
        backButton.setOnClickListener {
            finish()
        }
    }
}
