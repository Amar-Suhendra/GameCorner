package com.example.gamecorner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvGames: RecyclerView
    private val list = ArrayList<Game>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvGames = findViewById(R.id.rv_games)
        rvGames.setHasFixedSize(true)

        list.addAll(getListGames())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // go to about activity
        val intentAbout = Intent(this, AboutActivity::class.java)
        startActivity(intentAbout)
        return super.onOptionsItemSelected(item)
    }


    private fun getListGames(): ArrayList<Game> {
        val dataName = resources.getStringArray(R.array.game_names_data)
        val dataDescription = resources.getStringArray(R.array.game_descriptions_data)
        val dataPhoto = resources.obtainTypedArray(R.array.game_image_data)
        val dataDetail = resources.getStringArray(R.array.game_descriptions_detail)

        val listGame = ArrayList<Game>()
        for (position in dataName.indices) {
            val game = Game(
                dataName[position],
                dataDescription[position],
                dataPhoto.getResourceId(position, -1),
                dataDetail[position]
            )
            listGame.add(game)
        }
        return listGame
    }

    private fun showRecyclerList() {
        rvGames.layoutManager = LinearLayoutManager(this)
        val listGameAdapter = ListGameAdapter(list)
        rvGames.adapter = listGameAdapter
    }
}