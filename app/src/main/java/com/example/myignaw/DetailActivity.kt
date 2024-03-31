package com.example.myignaw

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    companion object {
        const val KEY_FRAGRANCE = "key_fragrance"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val name : TextView = findViewById(R.id.tv_item_name)
        val photo_item : ImageView = findViewById(R.id.img_item_photo)
        val fragranceDescription:TextView = findViewById(R.id.tv_fragranceDesc)
        val topNotes:TextView = findViewById(R.id.tv_topNotes)
        val bottomNotes:TextView = findViewById(R.id.tv_bottomNotes)
        val middleNotes:TextView = findViewById(R.id.tv_middleNotes)




        val dataFragrance = if (Build.VERSION.SDK_INT >= 33){
            intent.getParcelableExtra<Fragrance>(KEY_FRAGRANCE, Fragrance::class.java )
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Fragrance>(KEY_FRAGRANCE)
        }

        if(dataFragrance != null){
            name.text = dataFragrance.name
            photo_item.setImageResource(dataFragrance.photo)

            fragranceDescription.text = dataFragrance.fragranceDescription
            topNotes.text = dataFragrance.topNotes
            bottomNotes.text = dataFragrance.bottomNotes
            middleNotes.text = dataFragrance.middleNotes

        }
        val actionButton: View = findViewById(R.id.action_share)
        actionButton.setOnClickListener { view ->
            val intent = Intent()
            intent.setAction(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_TEXT, fragranceDescription.text)
            intent.setType("text/plain")
            if(intent.resolveActivity(packageManager) != null){
                startActivity(intent)
            }
        }
    }

}