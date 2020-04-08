package com.kuzulu.tictactoeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Xml
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Random


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonClick(view: View) {


        val buttonSelected: Button = view as Button

        var cellId = 0
        when (buttonSelected.id) {
            R.id.button1 -> cellId = 1
            R.id.button2 -> cellId = 2
            R.id.button3 -> cellId = 3
            R.id.button4 -> cellId = 4
            R.id.button5 -> cellId = 5
            R.id.button6 -> cellId = 6
            R.id.button7 -> cellId = 7
            R.id.button8 -> cellId = 8
            R.id.button9 -> cellId = 9
        }

        playGame(cellId, buttonSelected)

    }

    var activePlayer = 1

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    fun playGame(cellId: Int, buttonSelected: Button) {

        if (activePlayer == 1) {
            buttonSelected.text = "X"
            buttonSelected.setBackgroundResource(R.color.blue)
            player1.add(cellId)
            activePlayer = 2
            autoPlay()

        } else {

            buttonSelected.text = "0"
            buttonSelected.setBackgroundResource(R.color.darkGreen)
            player2.add(cellId)
            activePlayer = 1

        }

        buttonSelected.isEnabled = false
        checkWinner()

    }

    fun checkWinner() {

        var winer = -1

        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winer = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winer = 2
        }


        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winer = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winer = 2
        }


        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winer = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winer = 2
        }


        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winer = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winer = 2
        }


        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winer = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winer = 2
        }


        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winer = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winer = 2
        }

        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winer = 1
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winer = 2
        }


        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winer = 1
        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winer = 2
        }



        if (winer == 1) {
            player1WinsCounts += 1
            Toast.makeText(this, "Le joueur 1 à gagné!!", Toast.LENGTH_LONG).show()
            restartGame()
        } else if (winer == 2) {
            player2WinsCounts += 1
            Toast.makeText(this, "Le joueur 2 a gagné!!", Toast.LENGTH_LONG).show()
            restartGame()
        }

    }

    fun autoPlay() {

        var emptyCells = ArrayList<Int>()

        for (cellId in 1..9) {
            if (!(player1.contains(cellId) || player2.contains(cellId))) {
                emptyCells.add(cellId)
            }
        }

        if(emptyCells.size==0){
            restartGame()
        }

        val r = Random()
        val randIndex = r.nextInt(emptyCells.size)
        val cellId = emptyCells[randIndex]

        var buttonSelected: Button?
                buttonSelected= when (cellId) {
            1 -> button1
            2 -> button2
            3 -> button3
            4 -> button4
            5 -> button5
            6 -> button6
            7 -> button7
            8 -> button8
            9 -> button9
            else -> {
                button1
            }

        }
        playGame(cellId,buttonSelected)


    }

    var player1WinsCounts = 0
    var player2WinsCounts = 0

    fun restartGame() {
        activePlayer = 1
        player1.clear()
        player2.clear()

        for (cellId in 1..9) {

            var buttonSelected: Button? = when (cellId) {
                1 -> button1
                2 -> button2
                3 -> button3
                4 -> button4
                5 -> button5
                6 -> button6
                7 -> button7
                8 -> button8
                9 -> button9
                else -> {
                    button1
                }
            }
            buttonSelected!!.text = ""
            buttonSelected!!.setBackgroundResource(R.color.whilebutton)
            buttonSelected!!.isEnabled=true

        }

        Toast.makeText(this, "Joueur 1: $player1WinsCounts, Joueur 2: $player2WinsCounts", Toast.LENGTH_LONG).show()

    }
}
