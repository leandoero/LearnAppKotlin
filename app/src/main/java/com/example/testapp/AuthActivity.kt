package com.example.testapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AuthActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_auth)

        val linkToReg = findViewById<TextView>(R.id.link_to_reg)
        val userLogin = findViewById<EditText>(R.id.user_login_auth)
        val userPassword = findViewById<EditText>(R.id.user_password_auth)

        val button = findViewById<Button>(R.id.button_auth)

        linkToReg.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        button.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val password = userPassword.text.toString().trim()

            if(login == "" || password == ""){
                Toast.makeText(this, "Заполните все поля", Toast.LENGTH_LONG).show()
            }
            else{
                val db = DbContext(this, null)
                val isAuth = db.getUser(login,password)
                if(isAuth){
                    Toast.makeText(this, "Пользователь $login авторизован!", Toast.LENGTH_LONG).show()
                    userPassword.text.clear()
                    userLogin.text.clear()
                }
                else Toast.makeText(this, "Проверьте введенные данные", Toast.LENGTH_LONG).show()



            }
        }


    }
}