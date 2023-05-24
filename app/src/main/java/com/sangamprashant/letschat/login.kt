package com.sangamprashant.letschat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth

class login : AppCompatActivity() {

    private lateinit var edtEmail:EditText
    private lateinit var edtPassword:EditText
    private lateinit var btnLogin:Button
    private lateinit var btnSignup:Button

private  lateinit var  mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mAuth = FirebaseAuth.getInstance()

        edtEmail = findViewById(R.id.etxEmail)
        edtPassword = findViewById(R.id.etxPassword)
        btnLogin = findViewById(R.id.buttonLogin)
        btnSignup = findViewById(R.id.buttonSignup)

        btnSignup.setOnClickListener{
            val intent = Intent(this,signup::class.java)
            startActivity(intent)
        }


        btnLogin.setOnClickListener {
            val email = edtEmail.text.toString()
            val password = edtPassword.text.toString()
            Login(email,password);
        }


    }

    private fun Login(email:String, password:String){

    }




}