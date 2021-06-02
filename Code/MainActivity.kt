package com.example.finalproject

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.transition.Slide
import android.transition.TransitionManager
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_history.*
import kotlinx.android.synthetic.main.activity_main.*
import java.io.FileOutputStream
import java.io.FileWriter
import java.io.PrintWriter


public class listCreation() {
    var list: MutableList<String> = mutableListOf()
}
public class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Tip Calculator"
        var initial_cost = findViewById<EditText>(R.id.button_input_price)

        Log.d("jeff", "Total Cost is ${initial_cost.text}")


        val seek = findViewById<SeekBar>(R.id.seekBar2)
        seek?.setOnSeekBarChangeListener(object :
                SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
                // write custom code for progress is changed
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
                // write custom code for progress is stopped
                button_tip_custom.text = "${seekBar2.progress}%"

                var tip_total = initial_cost.text.toString().toDouble()

                var custom_tip = (seekBar2.progress.toDouble() / 100) * tip_total

                tip_amount.text = "$${String.format("%.2f", custom_tip)}"

                var total_price = tip_total + custom_tip

                total_cost.text = "$${String.format("%.2f", total_price)}"
            }
        })

        button_tip_1.setOnClickListener {
            var tip_total = initial_cost.text.toString().toDouble()

            var before_tip = tip_total

            seekBar2.progress = 10
            button_tip_custom.text = "${seekBar2.progress}%"
            tip_total = tip_total * .1


            tip_amount.text = "$${String.format("%.2f", tip_total)}"

            var total_price = tip_total + before_tip

            total_cost.text = "$${String.format("%.2f", total_price)}"
        }

        button_tip_2.setOnClickListener {
            var tip_total = initial_cost.text.toString().toDouble()

            var before_tip = tip_total

            seekBar2.progress = 15
            button_tip_custom.text = "${seekBar2.progress}%"
            tip_total = tip_total * .15

            //Log.d("jeff", "Total Cost is $tip_total")
            tip_amount.text = "$${String.format("%.2f", tip_total)}"

            var total_price = tip_total + before_tip

            total_cost.text = "$${String.format("%.2f", total_price)}"
        }

        button_tip_3.setOnClickListener {
            var tip_total = initial_cost.text.toString().toDouble()

            var before_tip = tip_total

            seekBar2.progress = 20
            button_tip_custom.text = "${seekBar2.progress}%"
            tip_total = tip_total * .20


            tip_amount.text = "$${String.format("%.2f", tip_total)}"

            var total_price = tip_total + before_tip

            total_cost.text = "$${String.format("%.2f", total_price)}"
        }

        button_tip_4.setOnClickListener {
            var tip_total = initial_cost.text.toString().toDouble()

            var before_tip = tip_total

            seekBar2.progress = 25
            button_tip_custom.text = "${seekBar2.progress}%"
            tip_total = tip_total * .25

            tip_amount.text = "$${String.format("%.2f", tip_total)}"

            var total_price = tip_total + before_tip

            total_cost.text = "$${String.format("%.2f", total_price)}"
        }

        save_button.setOnClickListener {
            var saved_tip_percentage = seekBar2.progress.toDouble()
            var ratings_score = ratingBar.progress.toDouble()
            ratings_score = ratings_score / 2
            
            var string = "\n------------------------------------- \nInitial cost: $${button_input_price.text}" + " \nTip Percentage: ${saved_tip_percentage}%" + " \nTip Price: ${tip_amount.text}" +
                    " \nTotal Cost: ${total_cost.text}" + " \nRating: ${ratings_score} Stars" + "\n-------------------------------------"

            val file: String = "receipts"
            val data: String = string

            val fileOutputStream: FileOutputStream
            try {

                fileOutputStream = openFileOutput(file, Context.MODE_APPEND)
                fileOutputStream.write(data.toByteArray())


            } catch (e: Exception) {
                e.printStackTrace()
            }
            val intent = Intent(this, history::class.java)
            startActivity(intent)

        }
            about_button.setOnClickListener {
                val intent = Intent(this, about_menu::class.java)
                startActivity(intent)
            }

            history_button.setOnClickListener {
                val intent = Intent(this, history::class.java)
                startActivity(intent)
            }

    }
}
