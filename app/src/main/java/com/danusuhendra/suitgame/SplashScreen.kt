package com.danusuhendra.suitgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

//        animation_title.apply {
//            playAnimation()
//        }
        Handler().postDelayed({
            startActivity(Intent(this, LandingActivity::class.java))
            finish()
        }, 3000)
    }
}
