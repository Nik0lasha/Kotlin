package com.example.kotlin_work

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.kotlin_work.network.Post
import com.example.kotlin_work.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        RetrofitClient.getPostsApi().getAllPosts().enqueue(object : Callback<List<Post>> {
            override fun onFailure(call: Call<List<Post>>?, t: Throwable?) {
                TODO("Not yet implemented")
            }
            override fun onResponse(call: Call<List<Post>>?, response: Response<List<Post>>?) {
                findViewById<TextView>(R.id.responceView).text = response?.body().toString()
            }
        })
        RetrofitClient.getPostsApi().getPostById(id = 1).enqueue(object :Callback<Post> {
            override fun onFailure(call: Call<Post>?, t: Throwable?) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<Post>?, response: Response<Post>?) {
   Log.d("CheckResponce","${response?.body()?.title}")
            }
        })
 }
}