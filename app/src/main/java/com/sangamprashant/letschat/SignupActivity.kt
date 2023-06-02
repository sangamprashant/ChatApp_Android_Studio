package com.sangamprashant.letschat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignupActivity : AppCompatActivity() {
    private lateinit var mAuth:FirebaseAuth
    private lateinit var edtName: EditText
    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnLogin: TextView
    private lateinit var btnSignup: Button
    private lateinit var mDbRef:DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        supportActionBar?.hide()

        mAuth = FirebaseAuth.getInstance()
        //text signIn button
        btnLogin = findViewById(R.id.TextSignIn)
        //inputs for signUp
        edtName = findViewById(R.id.etxName)
        edtEmail = findViewById(R.id.etxEmail)
        edtPassword = findViewById(R.id.etxPassword)
        //SignUp button
        btnSignup = findViewById(R.id.buttonSignup)
        //to Switch between log page
        btnLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        // getting SignIn Details
        btnSignup.setOnClickListener {
            val email = edtEmail.text.toString()
            val password = edtPassword.text.toString()
            val name = edtName.text.toString()
            //calling Signup function
            signUp(name,email,password)
        }

    }

    private fun signUp(name:String,email:String, password:String){
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    //code for jumping to home
                    addUserToDataBase(name,email,mAuth.currentUser?.uid!!)
                    val intent =Intent(this@SignupActivity, MainActivity::class.java)
                    finish()
                    startActivity(intent)
                } else {
                    if (password.length<6){
                        Toast.makeText(this@SignupActivity,"Password Length Should be more than 6", Toast.LENGTH_SHORT).show()

                    }
                    else{
                        Toast.makeText(this@SignupActivity,"Something Went Wrong", Toast.LENGTH_SHORT).show()

                    }
                }
            }
    }

    private fun addUserToDataBase(name:String,email:String,uid:String){
        mDbRef=FirebaseDatabase.getInstance().getReference()
        mDbRef.child("user").child(uid).setValue(User(name,email,uid))
    }




}