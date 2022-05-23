package com.zybooks.lab4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

lateinit var backbtn : Button

class westCoastAnimals : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_west_coast_animals)

        backbtn = findViewById(R.id.back_button)

        backbtn.setOnClickListener {
            val intent = Intent(this, farAnimals::class.java)
            startActivity(intent)
            finish()
        }
    }
}