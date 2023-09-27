package com.larisantos.projetonetflixapi.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

object RetrofitService {




        const val BASE_URL = "https://api.themoviedb.org/3/"
        const val BASE_URL_IMAGEM = "https://image.tmdb.org/t/p/"
        const val API_KEY = "9f0a39d62e556058828c03ef05774fb2"
        const val TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI5ZjBhMzlkNjJlNTU2MDU4ODI4YzAzZWYwNTc3NGZiMiIsInN1YiI6IjY0ZTZhZTEyZTg5NGE2MDEwMTIwMzg1YSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.KvFkWhXUwDOqaVqQuP0ZMm_iK1spGxWXtaDA2NMaLbk"

    private val okHttpClient: OkHttpClient = OkHttpClient.Builder()
        .writeTimeout(10, TimeUnit.SECONDS) //Escrita (salvando na API)
        .readTimeout(20, TimeUnit.SECONDS)  //Leitura (recuperando dados da API)
        .connectTimeout(20, TimeUnit.SECONDS)//Conexão Máxima
        .addInterceptor(AuthInterceptor())
        .build()


    val retrofit = Retrofit.Builder()
            .baseUrl( BASE_URL )
            .addConverterFactory( GsonConverterFactory.create() )
            .client(okHttpClient)
            .build()

        val filmeAPI = retrofit.create( FilmeAPI::class.java )

        fun <T> recuperarApi(classe: Class<T>) : T {
            return retrofit.create(classe)
        }

       /*fun recuperarViaCep() : ViaCepAPI{
            return Retrofit.Builder()
                .baseUrl( "https://viacep.com.br/ws/")
                .addConverterFactory( SimpleXmlConverterFactory.create() )

                .build()
                .create(ViaCepAPI::class.java)
        }*/
    }
