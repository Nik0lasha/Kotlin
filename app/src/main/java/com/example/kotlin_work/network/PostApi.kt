package com.example.kotlin_work.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PostApi {
    @GET("/posts")
    fun getAllPosts():Call<List<Post>>
    @GET("/posts/id")
    fun getPostById(@Path("id")id:Int):Call<Post>
}