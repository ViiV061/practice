package com.example.wordle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val wordToGuess = FourLetterWordList.getRandomFourLetterWord()
        val word = findViewById<TextView>(R.id.word)
        word.text = wordToGuess
        word.visibility = View.INVISIBLE
        var guessCounter = 0

        val guessView1 = findViewById<TextView>(R.id.guessView1)
        val guessView2 = findViewById<TextView>(R.id.guessView2)
        val guessView3 = findViewById<TextView>(R.id.guessView3)
        val guessCheckView1 = findViewById<TextView>(R.id.guessCheckView1)
        val guessCheckView2 = findViewById<TextView>(R.id.guessCheckView2)
        val guessCheckView3 = findViewById<TextView>(R.id.guessCheckView3)
        val inputWord = findViewById<EditText>(R.id.inputWord)
        val guessButton = findViewById<Button>(R.id.guessButton)

        guessButton.setOnClickListener{
            guessCounter += 1
            val guessWord = inputWord.text.toString().uppercase()
            if(guessCounter == 1){
                val guess1 = guessWord
                guessView1.text = guess1
                guessCheckView1.text = checkGuess(guess1, wordToGuess)
                inputWord.text.clear()
            }else if( guessCounter == 2){
                val guess2 = guessWord
                guessView2.text = guess2
                guessCheckView2.text = checkGuess(guess2, wordToGuess)
                inputWord.text.clear()
            }else if(guessCounter == 3){
                val guess3 = guessWord
                guessView3.text = guess3
                inputWord.text.clear()
                guessCheckView3.text = checkGuess(guess3, wordToGuess)
                word.visibility = View.VISIBLE
                guessButton.text = "RESTART"
                guessView1.text = ""
                guessView2.text = ""
                guessView3.text = ""
                guessCheckView1.text = ""
                guessCheckView2.text = ""
                guessCheckView3.text = ""
            }
        }


    }

    private fun checkGuess(guess: String, wordToGuess: String) : String {
        var result = ""
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            }
            else if (guess[i] in wordToGuess) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        return result
    }
}