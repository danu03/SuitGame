package com.danusuhendra.suitgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        intent.getStringExtra("nama").let {
            tvVsPlayer.text = it + " vs Pemain"
            tvVsComp.text = it + " vs CPU"
        }
        Glide.with(this)
            .load("https://bit.ly/2Jlr4qH")
            .into(ivVsPlayer)
        Glide.with(this)
            .load("https://bit.ly/33SqfPA")
            .into(ivVsComp)
        ivVsPlayer.setOnClickListener {
            startActivity(Intent(this, VsPlayerActivity::class.java))
        }

        ivVsComp.setOnClickListener {
            startActivity(Intent(this, VsCompActivity::class.java))
        }
    }
}