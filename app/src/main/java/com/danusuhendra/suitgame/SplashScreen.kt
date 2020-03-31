package com.danusuhendra.suitgame

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreen : AppCompatActivity() {
    private lateinit var mediaPlayer: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        mediaPlayer = MediaPlayer.create(this, R.raw.intro)
        mediaPlayer.start()
        Handler().postDelayed({
            val intent = Intent(this, LandingActivity::class.java)
            mediaPlayer.stop()
            startActivity(intent)
            finish()
        }, 3000)
    }
}
