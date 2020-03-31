package com.danusuhendra.suitgame

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_vs_comp.*
import kotlin.system.exitProcess

class VsCompActivity : AppCompatActivity(), IMainSuit {
    var player = 0
    var comp = 0
    var state = true
    var name = ""
    private val imgclick by lazy {
        listOf(ivbatu1, ivkertas1, ivgunting1)
    }
    val pilihanComp = mutableListOf(R.id.ivbatu2, R.id.ivgunting2, R.id.ivkertas2)
    private lateinit var controller: Controller
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vs_comp)
        val name = intent.getStringExtra("nama") as String
        tvpemain.text = name
        controller = Controller(this)
        for (suit in imgclick) {
            suit.setOnClickListener {
                if (state) {
                    val playerName = tvpemain.text.toString()
                    it.background = getDrawable(R.drawable.select)
                    Log.d("Pemain ", suit.contentDescription.toString())
                    comp = pilihanComp.random()
                    getRandom(comp)
                    player = suit.id.toString().toInt()
                    controller.getVersusComp(playerName, player, comp)
                    state = false
                } else {
                    Toast.makeText(this, "Reset terlebih dahulu", Toast.LENGTH_SHORT).show()
                }
            }
        }
        //reset
        ivreset.setOnClickListener {
            val bgreset =
                listOf<ImageView>(ivbatu1, ivbatu2, ivgunting1, ivgunting2, ivkertas1, ivkertas2)
            for (reset in bgreset) {
                reset.background = getDrawable(android.R.color.transparent)
                ivwin.background = getDrawable(android.R.color.transparent)
                ivwin.setTextColor(Color.parseColor("#cc0000"))
                ivwin.text = "VS"
                ivwin.textSize = 50f
                state = true
                player = 0
                comp = 0
            }
        }
        //back home
        ivhome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("nama", name)
            startActivity(intent)
            finish()
        }
        //close
        ivclose.setOnClickListener {
            val alertDialog = this.let {
                val builder = AlertDialog.Builder(it)
                builder.apply {
                    setPositiveButton("YA") { _, _ ->
                        finishAffinity()
                    }
                    setNegativeButton("TIDAK") { dialog, _ ->
                        dialog.cancel()
                    }
                    setNeutralButton("MAIN MENU") { _, _ ->
                        intent = Intent(context, MainActivity::class.java)
                        intent.putExtra("nama", name)
                        startActivity(intent)
                        finish()
                    }
                    setTitle("KELUAR")
                    setMessage("Yakin Mau Keluar ?")
                }
                builder.create()
            }
            alertDialog.show()
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

    override fun onBackPressed() {
        val alertDialog = this.let {
            val builder = AlertDialog.Builder(it)
            builder.apply {
                setPositiveButton("YA") { _, _ ->
                    finishAffinity()
                }
                setNegativeButton("TIDAK") { dialog, _ ->
                    dialog.cancel()
                }
                setNeutralButton("MAIN MENU") { _, _ ->
                    intent = Intent(context, MainActivity::class.java)
                    intent.putExtra("nama", name)
                    startActivity(intent)
                    finish()
                }
                setTitle("KELUAR")
                setMessage("Yakin Mau Keluar ?")
            }
            builder.create()
        }
        alertDialog.show()
    }

    override fun getResult(result: String) {
        ivwin.text = result
        ivwin.setTextColor(Color.parseColor("#FFFFFF"))
        if (result == "DRAW"){
            ivwin.textSize = 35f
            ivwin.setBackgroundColor(Color.parseColor("#5426eb"))
        }else{
            ivwin.textSize = 25f
            ivwin.setBackgroundColor(Color.parseColor("#3feb48"))
        }
    }
}
