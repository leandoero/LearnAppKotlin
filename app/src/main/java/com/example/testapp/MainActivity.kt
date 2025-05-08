package com.example.testapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val listTodo = findViewById<ListView>(R.id.list_todo)
        val userData = findViewById<EditText>(R.id.user_data)
        val button = findViewById<Button>(R.id.button)

        val todos = mutableListOf<String>()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, todos)
        listTodo.adapter = adapter

        listTodo.setOnItemClickListener { _, _, position, _ ->

            val text = listTodo.getItemAtPosition(position).toString()
            adapter.remove(text)

            Toast.makeText(this, "Удалено: $text", Toast.LENGTH_SHORT).show()
        }

        button.setOnClickListener {
            val textInput = userData.text.toString().trim()
            if(textInput.isNotEmpty()){
                adapter.add(textInput)
                userData.text.clear()
            }
        }

    }
}