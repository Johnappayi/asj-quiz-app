package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.quiz.R

class ResultActivity : AppCompatActivity() {
    private lateinit var scoreBoard : TextView
    private lateinit var resultMsg : TextView
    private lateinit var backButton : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        resultMsg  = findViewById(R.id.textView7)
        scoreBoard = findViewById(R.id.textView8)
        backButton = findViewById(R.id.button4)

        scoreBoard.text = intent.getStringExtra("score")+"/100"

        backButton.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
   }
}


