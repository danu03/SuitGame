package com.danusuhendra.suitgame

import android.util.Log

class Controller(var iMainSuit: IMainSuit) {
    val win = mutableListOf(R.drawable.pemain1win, R.drawable.draw, R.drawable.komputerwin) //get image winner from drawable
    val pilihanPlayer = mutableListOf<Int>(R.id.ivbatu1, R.id.ivgunting1, R.id.ivkertas1, R.id.ivbatu2, R.id.ivgunting2, R.id.ivkertas2) //get ID ImageView in activity
    //logic game
    fun getVersusComp(playerName : String, player: Int, comp: Int) {
        if (player == pilihanPlayer[0] && comp == pilihanPlayer[3] ||
            player == pilihanPlayer[1] && comp == pilihanPlayer[4] ||
            player == pilihanPlayer[2] && comp == pilihanPlayer[5]
        ) {
            iMainSuit.getResult("DRAW")
            Log.d("Hasil ", "DRAW!")
        } else if (player == pilihanPlayer[0] && comp == pilihanPlayer[5] ||
            player == pilihanPlayer[1] && comp == pilihanPlayer[3] ||
            player == pilihanPlayer[2] && comp == pilihanPlayer[4]
        ) {
            iMainSuit.getResult("CPU \nMENANG!")
            Log.d("Hasil ", "CPU MENANG!")
        } else if (player == pilihanPlayer[0] && comp == pilihanPlayer[4] ||
            player == pilihanPlayer[1] && comp == pilihanPlayer[5] ||
            player == pilihanPlayer[2] && comp == pilihanPlayer[3]
        ) {
            iMainSuit.getResult("$playerName \nMENANG!")
            Log.d("Hasil ", "$playerName MEMANG!!")
        }
    }
    fun getVersusPlayer(playerName : String, player: Int, player2 : Int){
        if (player == pilihanPlayer[0] && player2 == pilihanPlayer[3] ||
            player == pilihanPlayer[1] && player2 == pilihanPlayer[4] ||
            player == pilihanPlayer[2] && player2 == pilihanPlayer[5]
        ) {
            iMainSuit.getResult("DRAW")
            Log.d("Hasil ", "DRAW!")
        } else if (player == pilihanPlayer[0] && player2 == pilihanPlayer[5] ||
            player == pilihanPlayer[1] && player2 == pilihanPlayer[3] ||
            player == pilihanPlayer[2] && player2 == pilihanPlayer[4]
        ) {
            iMainSuit.getResult("PEMAIN 2\nMENANG!")
            Log.d("Hasil ", "PEMAIN 2 MENANG!")
        } else if (player == pilihanPlayer[0] && player2 == pilihanPlayer[4] ||
            player == pilihanPlayer[1] && player2 == pilihanPlayer[5] ||
            player == pilihanPlayer[2] && player2 == pilihanPlayer[3]
        ) {
            iMainSuit.getResult("$playerName \nMENANG!")
            Log.d("Hasil ", "$playerName MEMANG!!")
        }
    }
}