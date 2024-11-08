package com.example.sprint2_mobile

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sprint2_mobile.services.RetrofitInstance
import com.example.sprint2_mobile.services.Tratamento
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Gerenciar_tratamentos_MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gerenciar_tratamentos_main2)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewTratamentos)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Chamar a API para obter a lista de tratamentos
        RetrofitInstance.api.getTratamentos().enqueue(object : Callback<List<Tratamento>> {
            override fun onResponse(call: Call<List<Tratamento>>, response: Response<List<Tratamento>>) {
                if (response.isSuccessful) {
                    val tratamentos = response.body() ?: emptyList()
                    recyclerView.adapter = TratamentoAdapter(tratamentos)
                }
            }

            override fun onFailure(call: Call<List<Tratamento>>, t: Throwable) {
                Log.e("API_ERROR", "Erro ao carregar tratamentos", t)
            }
        })
    }
}
