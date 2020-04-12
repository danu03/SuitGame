package com.danusuhendra.suitgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.danusuhendra.suitgame.Adapter.AdapterViewPager
import kotlinx.android.synthetic.main.activity_landing.*
import kotlinx.android.synthetic.main.fragment_landing3.*

class LandingActivity : AppCompatActivity() {
    var indexPage = 0
    var name = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)

        val adapter = AdapterViewPager(
            supportFragmentManager
        )
        view_pager.adapter = adapter
        dots_indicator.setViewPager(view_pager)

        ivnext.visibility = View.GONE
        view_pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                indexPage = position
                Log.d("POSITION", indexPage.toString())
                if (indexPage > 0) {
                    ivnext.visibility = View.VISIBLE
                }
            }
        })
        ivnext.setOnClickListener {
            if (indexPage == 1) {
                view_pager.currentItem = indexPage + 1
            } else if (indexPage == 2) {
                if (edtNama.text.isNullOrBlank()) {
                    Toast.makeText(this, "Masukan nama terlebih dahulu", Toast.LENGTH_SHORT).show()
                } else {
                    name = edtNama.text.toString()
                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("nama", name)
                    startActivity(intent)
                    finish()
                }
            }
        }
    }
}