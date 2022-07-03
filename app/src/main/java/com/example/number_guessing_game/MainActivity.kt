package com.example.number_guessing_game

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnLeft = findViewById<Button>(R.id.btnLeft)
        val btnRight = findViewById<Button>(R.id.btnRight)
        assignNumbersToButtons(btnLeft, btnRight)

        var backgroundView = findViewById<ConstraintLayout>(R.id.mainLayout)

        btnLeft.setOnClickListener {
            val randomNumberLeft = btnLeft.text.toString().toInt()
            val randomNumberRight = btnRight.text.toString().toInt()
            if (randomNumberLeft > randomNumberRight)
                backgroundView.setBackgroundColor(Color.GREEN)
            //Show a Toast
            else {
                backgroundView.setBackgroundColor(Color.RED)
            }
            assignNumbersToButtons(btnLeft, btnRight)
        }

        btnRight.setOnClickListener {
            val randomNumberLeft = btnLeft.text.toString().toInt()
            val randomNumberRight = btnRight.text.toString().toInt()
            if (randomNumberLeft < randomNumberRight)
                backgroundView.setBackgroundColor(Color.GREEN)
            else {
                backgroundView.setBackgroundColor(Color.RED)
            }
            assignNumbersToButtons(btnLeft, btnRight)
        }
    }

    private fun checkAnswer(btnLeft: Button, btnRight: Button, backgroundView: ConstraintLayout, isLeftButtonSelected: Boolean) {
        val leftNum = btnLeft.toString().toInt()
        val rightNum = btnRight.toString().toInt()
        val isAnswerCorrect = if (isLeftButtonSelected) leftNum > rightNum else rightNum > leftNum
        if (isAnswerCorrect) {
            //Correct answer!!
            //Change background color
            backgroundView.setBackgroundColor(Color.GREEN)
        } else {
            //Wrong answer
            backgroundView.setBackgroundColor(Color.RED)
        }
    }

    private fun assignNumbersToButtons(btnLeft: Button, btnRight: Button) {
        val randomNumberLeft = Random.nextInt(0, 10)
        var randomNumberRight = randomNumberLeft

        while (randomNumberLeft == randomNumberRight) {
                randomNumberRight = Random.nextInt(0, 10)
        }

        btnLeft.text = randomNumberLeft.toString()
        btnRight.text = randomNumberRight.toString()
    }
}






















