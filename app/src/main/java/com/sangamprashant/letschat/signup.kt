package com.sangamprashant.letschat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class signup : AppCompatActivity() {

    private lateinit var edtName: EditText
    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var btnSignup: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        edtEmail = findViewById(R.id.etxEmail)
        edtPassword = findViewById(R.id.etxPassword)
        btnLogin = findViewById(R.id.buttonLogin)
        btnSignup = findViewById(R.id.buttonSignup)
        edtName = findViewById(R.id.etxName)

    }
}