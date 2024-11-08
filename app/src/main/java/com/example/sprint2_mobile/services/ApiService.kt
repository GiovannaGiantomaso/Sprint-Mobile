package com.example.sprint2_mobile.services

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

data class Tratamento(
    val id: Int,
    val descricao: String,
    val tipo: String,
    val custo: Double
)

interface ApiService {
    @GET("tratamentos")
    fun getTratamentos(): Call<List<Tratamento>>

    @POST("tratamentos/cadastrar")
    fun cadastrarTratamento(@Body tratamento: Tratamento): Call<Void>
}
