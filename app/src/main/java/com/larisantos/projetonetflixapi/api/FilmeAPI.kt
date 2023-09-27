package com.larisantos.projetonetflixapi.api

import com.larisantos.projetonetflixapi.model.FilmeRecente
import com.larisantos.projetonetflixapi.model.FilmeResposta
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface FilmeAPI {

    // "https://api.themoviedb.org/3/ + movie/latest

    // Interceptor: ?api_key=01
    //@GET("movie/latest?api_key=${RetrofitService.API_KEY}")
    @GET("movie/latest")
    suspend fun recuperarFilmeRecente() :Response<FilmeRecente>

    //@GET("movie/popular?api_key=${RetrofitService.API_KEY}")
    @GET("movie/popular")
    suspend fun recuperarFilmesPopulares(
        @Query("page") pagina: Int
    ) :Response<FilmeResposta>
}