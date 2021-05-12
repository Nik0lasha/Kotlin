package com.example.workwithkotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_work.R
import com.example.kotlin_work.SecondActivity
import kotlinx.android.synthetic.main.activity_main.*

const val USER_EMAIL: String = "user_email"
const val USER_PASSWORD: String = "user_password"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            if (edEmailAddress.text.toString().isEmpty() || edPassword.text.toString().isEmpty()) {
                Toast.makeText(this, "All fields must be filled", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra(USER_EMAIL, edEmailAddress.text.toString())
                intent.putExtra(USER_PASSWORD, edPassword.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}