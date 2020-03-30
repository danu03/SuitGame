package com.danusuhendra.suitgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_vs_comp.*
import kotlin.system.exitProcess

class VsCompActivity : AppCompatActivity(), IMainSuit {
    var player = 0
    var comp = 0
    var state = true
    private val imgclick by lazy {
        listOf(ivbatu1, ivkertas1, ivgunting1)
    }
    val pilihanComp = mutableListOf(R.id.ivbatu2, R.id.ivgunting2, R.id.ivkertas2)
    private lateinit var controller: Controller
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vs_comp)
        controller = Controller(this)
        for (suit in imgclick) {
            suit.setOnClickListener {
                if (state) {
                    it.background = getDrawable(R.drawable.select)
                    Log.d("Pemain ", suit.contentDescription.toString())
                    comp = pilihanComp.random()
                    getRandom(comp)
                    player = suit.id.toString().toInt()
                    controller.getVersusComp(player, comp)
                    state = false
                } else {
                    Toast.makeText(this, "Reset terlebih dahulu", Toast.LENGTH_SHORT).show()
                }
            }
        }
        //reset
        ivreset.setOnClickListener {
            val bgreset = listOf<ImageView>(ivbatu1, ivbatu2, ivgunting1, ivgunting2, ivkertas1, ivkertas2)
            for (reset in bgreset) {
                reset.background = getDrawable(android.R.color.transparent)
                ivwin.setImageResource(R.drawable.vs)
                state = true
                player = 0
                comp = 0
            }
        }
        //back home
        ivhome.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        //close
        ivclose.setOnClickListener {
            exitProcess(0)
        }
    }

    //getrandom for computer
    private fun getRandom(comp: Int) {
        when (comp) {
            pilihanComp[0] -> {
                ivbatu2.background = getDrawable(R.drawable.select)
                Log.d("Komputer ", ivbatu2.contentDescription.toString())
            }
            pilihanComp[1] -> {
                ivgunting2.background = getDrawable(R.drawable.select)
                Log.d("Komputer ", ivgunting2.contentDescription.toString())
            }
            pilihanComp[2] -> {
                ivkertas2.background = getDrawable(R.drawable.select)
                Log.d("Komputer ", ivkertas2.contentDescription.toString())
            }
        }
    }

    override fun getResult(result: Int) {
        ivwin.setImageResource(result)
    }
}
