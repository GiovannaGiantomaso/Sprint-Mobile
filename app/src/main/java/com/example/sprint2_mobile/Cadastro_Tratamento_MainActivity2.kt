package com.example.sprint2_mobile

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sprint2_mobile.services.RetrofitInstance
import com.example.sprint2_mobile.services.Tratamento
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Cadastro_Tratamento_MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_tratamento_main2)

        val descricaoEditText = findViewById<EditText>(R.id.editTextDescricao)
        val tipoEditText = findViewById<EditText>(R.id.editTextTipo)
        val custoEditText = findViewById<EditText>(R.id.editTextCusto)
        val registrarButton = findViewById<Button>(R.id.buttonRegistrar)

        registrarButton.setOnClickListener {
            val descricao = descricaoEditText.text.toString()
            val tipo = tipoEditText.text.toString()
            val custo = custoEditText.text.toString().toDoubleOrNull()

            if (descricao.isNotEmpty() && tipo.isNotEmpty() && custo != null) {
                val novoTratamento = Tratamento(0, descricao, tipo, custo)
                RetrofitInstance.api.cadastrarTratamento(novoTratamento).enqueue(object : Callback<Void> {
                    override fun onResponse(call: Call<Void>, response: Response<Void>) {
                        if (response.isSuccessful) {
                            Toast.makeText(this@Cadastro_Tratamento_MainActivity2, "Tratamento cadastrado com sucesso!", Toast.LENGTH_SHORT).show()
                            finish() // Volta para a tela anterior
                        } else {
                            Toast.makeText(this@Cadastro_Tratamento_MainActivity2, "Erro ao cadastrar tratamento", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<Void>, t: Throwable) {
                        Toast.makeText(this@Cadastro_Tratamento_MainActivity2, "Erro de conexão", Toast.LENGTH_SHORT).show()
                    }
                })
            } else {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
