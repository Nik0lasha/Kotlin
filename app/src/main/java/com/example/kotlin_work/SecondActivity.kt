package com.example.kotlin_work

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.workwithkotlin.USER_EMAIL
import com.example.workwithkotlin.USER_PASSWORD
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val userEmail = intent.getStringExtra(USER_EMAIL)
        val userPassword = intent.getStringExtra(USER_PASSWORD)
        textView.text = "Email: $userEmail\nPassword: $userPassword"
    }
}

