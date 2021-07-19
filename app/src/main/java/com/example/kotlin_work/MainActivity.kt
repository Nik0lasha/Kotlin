package com.example.kotlin_work

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView



class MainActivity : AppCompatActivity() {
    var counter=0
    var pref: SharedPreferences? = null

    val manager= supportFragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pref=getSharedPreferences("TABLE",Context.MODE_PRIVATE)
        counter=pref?.getInt("counter",0)!!


    }
    fun ShowFragmentOne(){
    val transaction=manager.beginTransaction()
        val fragment=FragmentOne()
        transaction.replace(R.id.conteiner,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        findViewById<TextView>(R.id.tvRezult).text = counter.toString()

    }

    fun onClickAdd(view: View) {
        counter++
      findViewById<TextView>(R.id.tvRezult).text = counter.toString()
    }


    fun saveData(res: Int)
    {
        val editor=pref?.edit()
        editor?.putInt("counter", res)
        editor?.apply()
    }
    override fun onDestroy()
  {
      super.onDestroy()
     saveData(counter)
  }



}

