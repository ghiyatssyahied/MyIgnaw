package com.example.myignaw

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {


    private lateinit var rvFragrances: RecyclerView
    private val list = ArrayList<Fragrance>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvFragrances = findViewById(R.id.rv_fragrance)
        rvFragrances.setHasFixedSize(true)

        list.addAll(getListFragrance())
        showRecyclerList()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                rvFragrances.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid -> {
                rvFragrances.layoutManager = GridLayoutManager(this, 2)
            }
            R.id.about_page ->{
                val intentAbout = Intent(this@MainActivity, aboutActivity::class.java)
                startActivity(intentAbout)
            }
        }
        return super.onOptionsItemSelected(item)
    }

        private fun getListFragrance(): ArrayList<Fragrance> {
            val dataName = resources.getStringArray(R.array.data_name)
            val dataDescription = resources.getStringArray(R.array.data_notes_complete)
            val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
            val dataDescriptionFragrance = resources.getStringArray(R.array.fragrance_description)
            val dataTopNotes = resources.getStringArray(R.array.data_notes_top)
            val dataMiddleNotes = resources.getStringArray(R.array.data_notes_middle)
            val dataBottomNotes = resources.getStringArray(R.array.data_notes_bottom)
            val listFragrence = ArrayList<Fragrance>()
            for (i in dataName.indices) {
                val fragrance = Fragrance(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1),dataDescriptionFragrance[i],dataTopNotes[i],dataMiddleNotes[i],dataBottomNotes[i])
                listFragrence.add(fragrance)
            }
            return listFragrence
        }

        private fun showRecyclerList() {
            rvFragrances.layoutManager = LinearLayoutManager(this)
            val listFragranceAdapter = ListFragranceAdapter(list)
            rvFragrances.adapter = listFragranceAdapter
        }
    }
