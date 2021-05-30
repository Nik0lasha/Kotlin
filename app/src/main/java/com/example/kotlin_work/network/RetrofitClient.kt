package com.example.kotlin_work.network
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private val retrofit:Retrofit by lazy { getClient() }
    private const val baseUrl1 ="http://jsonplaceholder.typicode.com/"

     private fun getClient()=Retrofit.Builder().baseUrl(baseUrl1).addConverterFactory(GsonConverterFactory.create())
             .build()

    fun getPostsApi()=  retrofit.create(PostApi::class.java)
    }

