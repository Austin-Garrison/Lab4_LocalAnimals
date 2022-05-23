package com.zybooks.lab4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

lateinit var backbtn1 : Button

class eastCoastAnimals : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_east_coast_animals)

        backbtn1 = findViewById(R.id.back_button)

        backbtn1.setOnClickListener {
            val intent = Intent(this, farAnimals::class.java)
            startActivity(intent)
            finish()
        }
    }
}