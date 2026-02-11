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

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val signupCard = findViewById<LinearLayout>(R.id.signupCard)
        val signupTitle = findViewById<TextView>(R.id.signupTitle)
        val goLogin = findViewById<TextView>(R.id.goLogin)
        val signupButton = findViewById<Button>(R.id.signupButton)
        
        val passwordInput = findViewById<EditText>(R.id.passwordInputSignup)
        val confirmPasswordInput = findViewById<EditText>(R.id.confirmPasswordInput)

        val slideUp = AnimationUtils.loadAnimation(this, R.anim.login_anim)
        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)

        signupCard.startAnimation(slideUp)
        signupTitle.startAnimation(fadeIn)
        goLogin.startAnimation(fadeIn)

        signupButton.setOnClickListener {
            val pass = passwordInput.text.toString()
            val confirmPass = confirmPasswordInput.text.toString()

            if (pass == confirmPass && pass.isNotEmpty()) {
                Toast.makeText(this, "Account Created!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            } else if (pass.isEmpty()) {
                Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Passwords do not match!", Toast.LENGTH_SHORT).show()
            }
        }

        goLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
