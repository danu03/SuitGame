package com.danusuhendra.suitgame

import android.util.Log

class Controller(var iMainSuit: IMainSuit) {
    val win = mutableListOf(R.drawable.pemain1win, R.drawable.draw, R.drawable.komputerwin) //get image winner from drawable
    val pilihanPlayer = mutableListOf<Int>(R.id.ivbatu1, R.id.ivgunting1, R.id.ivkertas1, R.id.ivbatu2, R.id.ivgunting2, R.id.ivkertas2) //get ID ImageView in activity
    //logic game
    fun getVersusComp(player: Int, comp: Int) {
        if (player == pilihanPlayer[0] && comp == pilihanPlayer[3] ||
            player == pilihanPlayer[1] && comp == pilihanPlayer[4] ||
            player == pilihanPlayer[2] && comp == pilihanPlayer[5]
        ) {
            iMainSuit.getResult(win[1])
            Log.d("Hasil ", "DRAW!")
        } else if (player == pilihanPlayer[0] && comp == pilihanPlayer[5] ||
            player == pilihanPlayer[1] && comp == pilihanPlayer[3] ||
            player == pilihanPlayer[2] && comp == pilihanPlayer[4]
        ) {
            iMainSuit.getResult(win[2])
            Log.d("Hasil ", "Komputer Menang!")
        } else if (player == pilihanPlayer[0] && comp == pilihanPlayer[4] ||
            player == pilihanPlayer[1] && comp == pilihanPlayer[5] ||
            player == pilihanPlayer[2] && comp == pilihanPlayer[3]
        ) {
            iMainSuit.getResult(win[0])
            Log.d("Hasil ", "Pemain 1 Menang!")
        }
    }
}