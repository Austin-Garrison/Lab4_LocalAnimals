package com.zybooks.lab4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

lateinit var eastbtn : Button
lateinit var midbtn : Button
lateinit var westbtn : Button
lateinit var homebtn : Button


class farAnimals : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_far_animals)

        eastbtn = findViewById(R.id.EastCoast)
        midbtn = findViewById(R.id.Midwest)
        westbtn = findViewById(R.id.WestCoast)
        homebtn = findViewById(R.id.home_button)

        eastbtn.setOnClickListener {
            val intent = Intent(this, eastCoastAnimals::class.java)
            startActivity(intent)
            finish()
        }

        midbtn.setOnClickListener {
            val intent = Intent(this, midwestAnimals::class.java)
            startActivity(intent)
            finish()
        }

        westbtn.setOnClickListener {
            val intent = Intent(this, westCoastAnimals::class.java)
            startActivity(intent)
            finish()
        }

        homebtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}