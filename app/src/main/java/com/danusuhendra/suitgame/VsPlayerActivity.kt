package com.danusuhendra.suitgame

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_vs_player.*

class VsPlayerActivity : AppCompatActivity(), IMainSuit {
    var player = 0
    var player2 = 0
    var state = true
    var state2 = true
    var name = ""
    private val imgClickPlayer by lazy {
        listOf(ivbatu1, ivkertas1, ivgunting1)
    }
    private val imgClickPlayer2 by lazy {
        listOf(ivbatu2, ivkertas2, ivgunting2)
    }
    private lateinit var controller: Controller
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vs_player)
        val name = intent.getStringExtra("nama") as String
        tvpemain.text = name
        controller = Controller(this)
        for (suit in imgClickPlayer) {
            suit.setOnClickListener {
                if (state) {
                    val playerName = tvpemain.text.toString()
                    it.background = getDrawable(R.drawable.select)
                    Log.d("$playerName ", suit.contentDescription.toString())
                    player = suit.id.toString().toInt()
                    state = false
                } else {
                    Toast.makeText(this, "Reset terlebih dahulu", Toast.LENGTH_SHORT).show()
                }
            }
        }
        for (suit in imgClickPlayer2) {
            suit.setOnClickListener {
                if (state2 && !state) {
                    val playerName = tvpemain.text.toString()
                    it.background = getDrawable(R.drawable.select)
                    Log.d("Pemain 2 ", suit.contentDescription.toString())
                    player2 = suit.id.toString().toInt()
                    controller.getVersusPlayer(playerName, player, player2)
                    state2 = false
                } else if (state2 == false){
                    Toast.makeText(this, "Reset terlebih dahulu", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Pemain 1 harus memilih duluan", Toast.LENGTH_SHORT).show()
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
                state2 = true
                player = 0
                player2 = 0
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

    override fun onBackPressed() {
        val name = intent.getStringExtra("nama") as String
        tvpemain.text = name
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
        if (result == "DRAW") {
            ivwin.textSize = 35f
            ivwin.setBackgroundColor(Color.parseColor("#5426eb"))
        } else {
            ivwin.textSize = 25f
            ivwin.setBackgroundColor(Color.parseColor("#3feb48"))
        }
    }
}
