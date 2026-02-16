package com.example.animationapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val logoText = findViewById<TextView>(R.id.welcomeLogo)
        val welcomeText = findViewById<TextView>(R.id.welcomeText)
        val startBtn = findViewById<Button>(R.id.startBtn)

        // Logo Animation
        val logoAnim = AnimationUtils.loadAnimation(this, R.anim.logo_animation)
        logoText.startAnimation(logoAnim)

        // Logo Image Animation
        val logo = findViewById<ImageView>(R.id.logoImage)
        val imageAnim = AnimationUtils.loadAnimation(this, R.anim.image_animation)
        logo.startAnimation(imageAnim)

        // Typing Effect
        val text = "Welcome to Animation App"
        var i = 0
        Handler(Looper.getMainLooper()).postDelayed(object : Runnable {
            override fun run() {
                if (i < text.length) {
                    welcomeText.text = text.substring(0, i + 1)
                    i++
                    Handler(Looper.getMainLooper()).postDelayed(this, 80)
                }
            }
        }, 500)

//        coment
//        2nd comite
//        3rd comite

        // Button Fade In
        val fadeAnim = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        startBtn.startAnimation(fadeAnim)

        // Button Click -> MainActivity
        startBtn.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
            finish()
        }
    }
}
