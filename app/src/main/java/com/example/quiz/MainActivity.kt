package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.quiz.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    fun init(){

        val button : Button = findViewById(R.id.button2)
        val intent = Intent(this , SecondActivity::class.java)
        button.setOnClickListener {
            startActivity(intent);
            finish()

        }
    }
}