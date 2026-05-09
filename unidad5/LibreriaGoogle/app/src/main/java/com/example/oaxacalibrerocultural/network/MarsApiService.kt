package com.example.oaxacalibrerocultural.network

import com.example.oaxacalibrerocultural.model.BookShelfResponse
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://www.googleapis.com/books/v1/"

private val json = Json { ignoreUnknownKeys = true }

private val retrofit = Retrofit.Builder()
    .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface OaxacaLibreroCulturalApiService {
    @GET("volumes")
    suspend fun getBooks(@Query("q") query: String): BookShelfResponse

    companion object {
        val retrofitService: OaxacaLibreroCulturalApiService by lazy {
            retrofit.create(OaxacaLibreroCulturalApiService::class.java)
        }
    }
}