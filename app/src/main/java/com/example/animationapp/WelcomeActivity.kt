package com.example.animationapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.airbnb.lottie.LottieAnimationView

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome)

        val getStartedBtn = findViewById<Button>(R.id.getStartedBtn)
        val lottieView = findViewById<LottieAnimationView>(R.id.lottieAnimationView)

        // Optional: control animation from code
        lottieView.playAnimation()
        lottieView.loop(true)

        getStartedBtn.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() // Welcome screen বন্ধ হবে
        }

    }
}