package com.example.workwithkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_work.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CustomRecyclerAdapter(fillList())
    }

    private fun fillList(): List<String> {
        val data = mutableListOf<String>()
        (0..30).forEach { i -> data.add("\$i cats") }
        return data
    }
}
        class CustomRecyclerAdapter(private val names: List<String>) :
            RecyclerView.Adapter<CustomRecyclerAdapter.MyViewHolder>() {

            class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
                var largeTextView: TextView? = null
                var smallTextView: TextView? = null

                init {
                    largeTextView = itemView.findViewById(R.id.textViewLarge)
                    smallTextView = itemView.findViewById(R.id.textViewSmall)
                }
            }

            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
                val itemView =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.recyclerview_item, parent, false)
                return MyViewHolder(itemView)
            }

            override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
                holder.largeTextView?.text = names[position]
                holder.smallTextView?.text = "кот"
            }

            override fun getItemCount() = names.size
        }
