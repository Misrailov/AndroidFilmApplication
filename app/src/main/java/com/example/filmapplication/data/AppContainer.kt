package com.example.filmapplication.data

import com.example.filmapplication.network.actor.ActorApiService
import com.example.filmapplication.repository.ActorRepository
import com.example.filmapplication.repository.NetworkActorRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

interface AppContainer {
    val actorRepository:ActorRepository

}
class DefaultAppContainer : AppContainer {
    private val baseUrl = "https://moviesdatabase.p.rapidapi.com/"

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

    // Define your headers here
    private val headersInterceptor = Interceptor { chain ->
        val request = chain.request().newBuilder()
            .header("X-RapidAPI-Key", "cc38c2dd40msh694c090875ea926p179bb2jsn2ac99e0d4eec")
            .header("X-RapidAPI-Host", "moviesdatabase.p.rapidapi.com")
            // Add more headers if needed
            .build()
        chain.proceed(request)
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(logger)
        .addInterceptor(headersInterceptor)
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(baseUrl)
        .client(client)
        .build()

    private val actorApiService: ActorApiService by lazy {
        retrofit.create(ActorApiService::class.java)
    }

    override val actorRepository: ActorRepository by lazy {
        NetworkActorRepository(actorApiService)
    }
}
