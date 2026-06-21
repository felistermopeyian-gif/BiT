package com.example.studentmanagementapp.data.remote

import com.example.studentmanagementapp.model.RemoteUser
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

data class AcademyNews(val title: String, val content: String, val date: String)

interface ApiService {
    @GET("users")
    suspend fun getRemoteUsers(): List<RemoteUser>

    @GET("https://raw.githubusercontent.com/jrvirani/Simple-JSON-Parsing-Retrofit/master/users.json")
    suspend fun getAcademyNews(): List<AcademyNews>

    companion object {
        private var instance: ApiService? = null
        fun getInstance(): ApiService {
            if (instance == null) {
                instance = Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ApiService::class.java)
            }
            return instance!!
        }
    }
}
