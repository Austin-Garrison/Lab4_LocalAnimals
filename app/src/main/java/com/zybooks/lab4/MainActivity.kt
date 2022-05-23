package com.zybooks.lab4

import android.animation.ObjectAnimator
import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.view.MotionEvent



class MainActivity() : AppCompatActivity() {
    lateinit var snake: ImageView
    lateinit var translateImage: ImageView
    lateinit var nearbtn : Button
    lateinit var farbtn : Button
    lateinit var lionbtn : Button
    lateinit var birdbtn : Button
    private var mp: MediaPlayer? = null
    private var mp2: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nearbtn = findViewById(R.id.nearme)
        farbtn = findViewById(R.id.faraway)
        lionbtn = findViewById(R.id.lion)
        birdbtn = findViewById(R.id.bird)
        mp = MediaPlayer.create(this, R.raw.bird_sound)
        mp2 = MediaPlayer.create(this, R.raw.lion_sound)

        val snakeImage: ImageView = findViewById(R.id.snake_drawing)
        snakeImage.setBackgroundResource(R.drawable.animation)
        val snakeAnimation = snakeImage.background as AnimationDrawable
        snake = findViewById(R.id.snake_drawing)
        translateImage= findViewById<ImageView>(R.id.snake_drawing)

        translateImage.setOnClickListener {
            translater()
        }

        snakeImage.setOnClickListener {
            if (snakeAnimation.isRunning) {
                snakeAnimation.stop()
            } else {
                snakeAnimation.start()
            }
        }

        nearbtn.setOnClickListener {
            val intent = Intent(this, nearAnimals::class.java)
            startActivity(intent)
            finish()
        }

        farbtn.setOnClickListener {
                val intent = Intent(this, farAnimals::class.java)
                startActivity(intent)
                finish()
        }

        birdbtn.setOnTouchListener {_, event -> handleTouchNear(event)
            true
        }
        lionbtn.setOnTouchListener {_, event -> handleTouchFar(event)
            true
        }
    }

    private fun handleTouchNear(event: MotionEvent?) {
        if (event != null) {
            when(event.action) {
                MotionEvent.ACTION_DOWN -> {
                    mp?.start()
                }
            }
        }
    }

    private fun handleTouchFar(event: MotionEvent?) {
        if (event != null) {
            when(event.action) {
                MotionEvent.ACTION_DOWN -> {
                    mp2?.start()
                }
            }
        }
    }

    private fun translater() {
        val animator = ObjectAnimator.ofFloat(snake, View.TRANSLATION_X, 200f)
        animator.repeatCount = 1
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.start()
    }
}