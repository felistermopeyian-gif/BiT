package com.example.studentmanagementapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

data class AcademyNews(
    val id: Int,
    val title: String,
    val body: String
)

interface ApiService {
    @GET("posts?_limit=5")
    suspend fun getAcademyNews(): List<AcademyNews>

    companion object {
        private var INSTANCE: ApiService? = null

        fun getInstance(): ApiService {
            return INSTANCE ?: synchronized(this) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                val instance = retrofit.create(ApiService::class.java)
                INSTANCE = instance
                instance
            }
        }
    }
}
