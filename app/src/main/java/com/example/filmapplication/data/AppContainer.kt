package com.example.filmapplication.data

import com.example.filmapplication.network.actor.ActorApiService
import com.example.filmapplication.network.movie.FilmApiService
import com.example.filmapplication.network.serie.SerieApiService
import com.example.filmapplication.repository.ActorRepository
import com.example.filmapplication.repository.FilmRepository
import com.example.filmapplication.repository.NetworkActorRepository
import com.example.filmapplication.repository.NetworkFilmRepository
import com.example.filmapplication.repository.NetworkSerieRepository
import com.example.filmapplication.repository.SerieRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

interface AppContainer {
    val actorRepository:ActorRepository
    val filmRepository:FilmRepository
    val serieRepository:SerieRepository


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

    private val filmApiService:FilmApiService by lazy{
        retrofit.create(FilmApiService::class.java)
    }
    override  val filmRepository:FilmRepository by lazy{
        NetworkFilmRepository(filmApiService)
    }

    private val serieApiService: SerieApiService by lazy{
        retrofit.create(SerieApiService::class.java)
    }
    override val serieRepository:SerieRepository by lazy{
        NetworkSerieRepository(serieApiService)
    }
}
