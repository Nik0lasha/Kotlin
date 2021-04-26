package com.example.workwithkotlin
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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