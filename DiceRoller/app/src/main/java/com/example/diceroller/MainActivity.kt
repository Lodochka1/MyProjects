package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
        rollDice()

        val rollButton2: Button = findViewById(R.id.button)
        rollButton2.setOnClickListener { rollDice() }
        rollDice()
        /*val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()*/
    }

    /**
     * Random number from 1 to number sides of dice
     */
    class Dice(val numSides: Int) {
        fun roll(): Int {
            return (1..numSides).random()
        }
    }

    /**
     * Roll the dice and update the screen with the result.
     */

    private fun rollDice() {
        val dice = Dice(6) //Create object class
        val diceRoll = dice.roll() //applies the method .roll()
        val diceImage: ImageView = findViewById(R.id.imageView) // find image which we will change
        val drawableResource = when (diceRoll) { // set terms for variable diceRoll
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()

        val dice2 = Dice(4)
        val diceRoll2 = dice2.roll()
        val diceImage2: ImageView = findViewById(R.id.imageView2)
        val drawableResource2 = when (diceRoll2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            else -> R.drawable.dice_4
        }

        diceImage2.setImageResource(drawableResource2)
        diceImage2.contentDescription = diceRoll2.toString()

        /*val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()*/

        /*val dice2 = Dice(10)
        val diceRoll2 = dice2.roll()
        val resultTextView2: TextView = findViewById(R.id.textView2)
        resultTextView2.text = diceRoll2.toString()*/
    }
}


/**
 * for reformating code ctrl + alt + l
 */
