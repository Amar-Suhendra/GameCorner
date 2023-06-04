package com.example.gamecorner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailGameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_game)

        val game = intent.getParcelableExtra<Game>("key")!! as Game

        val tvName = findViewById<TextView>(R.id.tv_game_name)
        val tvDescription = findViewById<TextView>(R.id.tv_game_description)
        val imgPhoto = findViewById<ImageView>(R.id.iv_game)
        val tvDetail = findViewById<TextView>(R.id.tv_game_detail)

        tvName.text = game.name
        tvDescription.text = game.description
        imgPhoto.setImageResource(game.image)
        tvDetail.text = game.detail
    }
}