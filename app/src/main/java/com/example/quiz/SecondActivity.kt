package com.example.quiz


import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    private lateinit var scoreboardTxt: TextView
    private lateinit var questionNumberTxt: TextView
    private lateinit var questionTxt: TextView
    private lateinit var optionATxt: RadioButton
    private lateinit var optionBTxt: RadioButton
    private lateinit var optionCTxt: RadioButton
    private lateinit var optionDTxt: RadioButton
    private lateinit var submitTxt: Button


    private lateinit var questionBank: ArrayList<Question>
    private var questionNo: Int = 0
    private var score: Int = 0
    private var answer: String = ""
    private var canGoNext: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        scoreboardTxt = findViewById(R.id.textView4)
        questionNumberTxt = findViewById(R.id.textView2)
        questionTxt = findViewById(R.id.textView10)

        optionATxt = findViewById(R.id.radioButton1)
        optionBTxt = findViewById(R.id.radioButton2)
        optionCTxt = findViewById(R.id.radioButton3)
        optionDTxt = findViewById(R.id.radioButton4)

        submitTxt = findViewById(R.id.button3)

        questionBank = ArrayList()

        setUpQuestion()

        initListeners()

        display(questionNo)
    }

    @SuppressLint("ResourceAsColor")
    fun clearAll() {
        optionATxt.isChecked = false
        optionBTxt.isChecked = false
        optionCTxt.isChecked = false
        optionDTxt.isChecked = false
        optionATxt.setTextColor(Color.parseColor("#000000"))
        optionBTxt.setTextColor(Color.parseColor("#000000"))
        optionCTxt.setTextColor(Color.parseColor("#000000"))
        optionDTxt.setTextColor(Color.parseColor("#000000"))

    }

    fun display(index: Int) {
        var questionObject = questionBank.get(index)
        questionTxt.text = questionObject.question
        optionATxt.text = questionObject.optionA
        optionBTxt.text = questionObject.optionB
        optionCTxt.text = questionObject.optionC
        optionDTxt.text = questionObject.optionD
        questionNumberTxt.text = "Question No: " + (questionNo + 1).toString()
        scoreboardTxt.text = "Score: " + (score).toString()
    }

    fun setUpQuestion() {
        questionBank.add(
            Question(
                "What does DSLR stand for?",
                "Digital single light reflex",
                "Digital single light refraction",
                "Digital single lens reflex",
                "Digital single lens refraction",
                "Digital single lens reflex"
            )
        )
        questionBank.add(
            Question(
                "The amount of light or darkness on a photograph is known as the:",
                "Exposure",
                "Shutter Speed",
                "Contrast",
                "Sharpness",
                "Exposure"
            )
        )
        questionBank.add(
            Question(
                "The amount of light passing through a lens is defined by the:",
                "Shutter Speed",
                "Aperture",
                "Film speed",
                "Exposure",
                "Aperture"
            )
        )
        questionBank.add(
            Question(
                "What is Aperture measured in?",
                "Spots",
                "Stops",
                "F Numbers",
                "Fractions",
                "F Numbers"
            )
        )
        questionBank.add(
            Question(
                "What is shutter speed measured in?",
                "Stops",
                "F Numbers",
                "Seconds",
                "Exposure",
                "Seconds"
            )
        )
        questionBank.add(
            Question(
                "The balancing of light within a photograph is known as :",
                "White balance",
                "The aperture",
                "The shutter speed",
                "The exposure",
                "The exposure"
            )
        )
        questionBank.add(
            Question(
                "Which is a larger aperture?",
                "1.4",
                "2.8",
                "1600",
                "1/300",
                "1.4"
            )
        )

        questionBank.add(
            Question(
                "Macro Photography refers to what type of photography?",
                "Landscape Photography",
                "Spy Plane Photography",
                "Telescope Photography",
                "Close-Up Photography",
                "Close-Up Photography"
            )
        )
        questionBank.add(
            Question(
                "What does the term pixel stand for? ",
                "Picture Element",
                "Pix Elite",
                "Digital Photograph",
                "Picture Extra",
                "Picture Element"
            )
        )
        questionBank.add(
            Question(
                "When was the First colour photograph taken?",
                "1821",
                "1899",
                "1861",
                "1906",
                "1861"
            )
        )

    }

    fun isCorrect(value: String): Boolean {
        return answer == value
    }

    fun corectAns(value: String) {
        if (optionATxt.text == value) {
            optionATxt.setTextColor(Color.parseColor("#008000"))
        } else if (optionBTxt.text == value) {
            optionBTxt.setTextColor(Color.parseColor("#008000"))
        } else if (optionCTxt.text == value) {
            optionCTxt.setTextColor(Color.parseColor("#008000"))
        } else {
            optionDTxt.setTextColor(Color.parseColor("#008000"))
        }
    }

    fun initListeners() {
        optionATxt.setOnClickListener {
            clearAll()
            optionATxt.isChecked = true
            answer = optionATxt.text.toString()

        }
        optionBTxt.setOnClickListener {
            clearAll()
            optionBTxt.isChecked = true
            answer = optionBTxt.text.toString()

        }
        optionCTxt.setOnClickListener {
            clearAll()
            optionCTxt.isChecked = true
            answer = optionCTxt.text.toString()

        }
        optionDTxt.setOnClickListener {
            clearAll()
            optionDTxt.isChecked = true
            answer = optionDTxt.text.toString()

        }
        submitTxt.setOnClickListener {
            canGoNext = !canGoNext
            if (canGoNext) {
                if (isCorrect(questionBank[questionNo].answer)) {
                    score += 10
                    scoreboardTxt.text = "Score: " + score.toString()
                }
                corectAns(questionBank[questionNo].answer)
                submitTxt.text = "NEXT"
            } else {
                clearAll()
                submitTxt.text = "SUBMIT"
                if (questionNo < (questionBank.size - 1)) {
                    questionNo++
                    display(questionNo)
                } else {
                    //go to next page
                    var intent = Intent(this, ResultActivity::class.java)
                    intent.putExtra("score", score.toString())
                    startActivity(intent)
                    finish()
                }

            }

        }

    }
}


data class Question(
    var question: String,
    var optionA: String,
    var optionB: String,
    var optionC: String,
    var optionD: String,
    var answer: String
)