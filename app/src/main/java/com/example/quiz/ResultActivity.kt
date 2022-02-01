package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible
import com.example.quiz.R
import pl.droidsonroids.gif.GifImageView

class ResultActivity : AppCompatActivity() {
    private lateinit var scoreBoard : TextView
    private lateinit var resultMsg : TextView
    private lateinit var backButton : Button
    private lateinit var resultImage : GifImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        resultMsg  = findViewById(R.id.textView7)
        scoreBoard = findViewById(R.id.textView8)
        backButton = findViewById(R.id.button4)

        var score = intent.getStringExtra("score")

        scoreBoard.text = score+"/100"

        if (score != null) {
            if(score < "30"){
                resultMsg.text = "Better Luck Next Time"
            }else if (score < "60"){
                resultMsg.text = "Well Done🙂"
            }else {
                resultMsg.text = "Congratulations🥳"
            }
        }

        backButton.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
   }
}


