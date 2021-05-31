package com.example.workwithkotlin
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.kotlin_work.network.Post
import com.example.kotlin_work.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.kotlin_work.R
import java.util.concurrent.Callable
import java.util.concurrent.ExecutionException
import java.util.concurrent.FutureTask
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
        val editTextEnter = findViewById<EditText>(R.id.editTextEnter)
        val button = findViewById<Button>(R.id.buttonResult)
        button.setOnClickListener {
            val textViewShow = findViewById<TextView>(R.id.editTextEnter)
            val callable: Callable<Int> = getDataFromCallable(editTextEnter)
            val futureTask: FutureTask<Int> = FutureTask(callable)
            Thread(futureTask).start()
            try {
                textViewShow.text = futureTask.get().toString()
            } catch (e: ExecutionException) {
                e.printStackTrace()
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
    }

    fun getDataFromCallable(editTextEnter: EditText): Callable<Int> {
        return Callable {
            var summa = 0
            for (i in 2..editTextEnter.text.toString().toInt()) {
                summa += i
            }
            return@Callable summa
        }
    }
fun taskMonth(month: Int = 3) {
        when (month) {
            1, 2, 12 -> println("Зимушка-зима")
            3, 4, 5 -> println("Весна")
            6, 7, 8 -> println("Лето")
            9, 10, 11 -> println("Осень")
            else -> println("Не знаю")
        }
    }
}