package com.example.animationapp

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginCard = findViewById<LinearLayout>(R.id.loginCard)
        val emailInput = findViewById<EditText>(R.id.emailInput)
        val loginButton = findViewById<Button>(R.id.loginButton)
        val welcomeTitle = findViewById<TextView>(R.id.welcomeTitle)
        val goSignup = findViewById<TextView>(R.id.goSignup)

        val slideUp = AnimationUtils.loadAnimation(this, R.anim.login_anim)
        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)

        welcomeTitle.startAnimation(fadeIn)
        loginCard.startAnimation(slideUp)

        loginButton.setOnClickListener {
            val email = emailInput.text.toString()
            if (email.isNotEmpty()) {
                Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show()
            }
        }

        goSignup.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}
