package com.danusuhendra.suitgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Context as Context1
@GlideModule
class MainActivity : AppCompatActivity() {
    var name= ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = intent.getStringExtra("nama") as String

        tvVsPlayer.text = "$name vs Pemain"
        tvVsComp.text = "$name vs CPU"
        
        Glide.with(this)
            .load("https://docs.google.com/uc?id=1u2hdu9hxd79aeC6hGDJ1s23Vsce3I_07")
            .into(ivVsPlayer)

        Glide.with(this)
            .load("https://docs.google.com/uc?id=1RrJN4h-Sv6IRimIQQEbfis6ujKobdfxn")
            .into(ivVsComp)

        ivVsPlayer.setOnClickListener {
            val intent = Intent(this, VsPlayerActivity::class.java)
            intent.putExtra("nama", name)
            startActivity(intent)
            finish()
        }

        ivVsComp.setOnClickListener {
            val intent = Intent(this, VsCompActivity::class.java)
            intent.putExtra("nama", name)
            startActivity(intent)
            finish()
        }
    }
}