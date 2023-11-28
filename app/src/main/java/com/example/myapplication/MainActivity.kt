package com.example.myapplication

import android.media.AsyncPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import java.util.Random

class MainActivity : AppCompatActivity() {
    private val elements = arrayOf("камень", "ножницы", "бумага", "ящерица", "Спок")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonPaper: ImageButton = findViewById(R.id.imageButtonPaper)
        val buttonNoz: ImageButton = findViewById(R.id.imageButtonNoz)
        val buttonKamen: ImageButton = findViewById(R.id.imageButtonKamen)
        val buttonYacher: ImageButton = findViewById(R.id.imageButtonYacher)
        val buttonSpok: ImageButton = findViewById(R.id.imageButtonSpok)
        buttonKamen.setOnClickListener({ playerChoise(0) })
        buttonNoz.setOnClickListener({ playerChoise(1) })
        buttonPaper.setOnClickListener({ playerChoise(2) })
        buttonYacher.setOnClickListener({ playerChoise(3) })
        buttonSpok.setOnClickListener({ playerChoise(4) })
    }

    fun playerChoise(playerGame: Int) {
        val computerChoice = Random().nextInt(5)
        val playerV: TextView = findViewById(R.id.textView)
        val compV: TextView = findViewById(R.id.textView2)
        val resultV: TextView = findViewById(R.id.textView3)
        playerV.text = "Ваш выбор: ${elements[playerGame]}"
        compV.text = "Выбор компьютера: ${elements[computerChoice]}"
        val result = determineWinner(playerGame, computerChoice)
        resultV.text = "Результат: $result"
    }

    private fun determineWinner(playerGame: Int, computerChoice: Int): String {
        if (playerGame == computerChoice) {
            return "Ничья"
        } else if (
            (playerGame == 0 && (computerChoice == 1 || computerChoice == 3)) ||
            (playerGame == 1 && (computerChoice == 2 || computerChoice == 3)) ||
            (playerGame == 2 && (computerChoice == 0 || computerChoice == 4)) ||
            (playerGame == 3 && (computerChoice == 2 || computerChoice == 4)) ||
            (playerGame == 4 && (computerChoice == 0 || computerChoice == 1))
        ) {
            return "Вы выиграли"
        } else {
            return "Компьютер выиграл"
        }


    }
}