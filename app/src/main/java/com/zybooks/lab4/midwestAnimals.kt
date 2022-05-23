package com.zybooks.lab4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

lateinit var backbtn2 : Button

class midwestAnimals : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_midwest_animals)

        backbtn2 = findViewById(R.id.back_button)

        backbtn2.setOnClickListener {
            val intent = Intent(this, farAnimals::class.java)
            startActivity(intent)
            finish()
        }
    }
}