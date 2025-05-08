package com.example.testapp

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val label = findViewById<TextView>(R.id.main_label)
        val userData = findViewById<EditText>(R.id.user_data)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            val textInput = userData.text.toString().trim()
            if(textInput == "toast"){
                val toast = Toast.makeText(applicationContext, "Hello toast!", Toast.LENGTH_SHORT)
                toast.show()
            }
            else{
                label.text = textInput
            }
        }

    }
}