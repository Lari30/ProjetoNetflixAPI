package com.larisantos.projetonetflixapi.api

import com.larisantos.projetonetflixapi.model.Endereco
import com.larisantos.projetonetflixapi.model.FilmeRecente
import retrofit2.Response
import retrofit2.http.GET

interface ViaCepAPI {

    @GET("01001000/xml")
    suspend fun recuperarEndereco() : Response<Endereco>
}