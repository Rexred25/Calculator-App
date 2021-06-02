package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_about_menu.*
import kotlinx.android.synthetic.main.activity_about_menu.back_button
import kotlinx.android.synthetic.main.activity_history.*
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader

public class listCreation2() {
    var list2: MutableList<String> = mutableListOf()
}

class history : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        title = "Tip Calculator"



        var fileInputStream: FileInputStream? = null
        fileInputStream = openFileInput("receipts")
        var inputStreamReader: InputStreamReader = InputStreamReader(fileInputStream)
        val bufferedReader: BufferedReader = BufferedReader(inputStreamReader)
        val stringBuilder: StringBuilder = StringBuilder()
        var text: String? = null
        while ({ text = bufferedReader.readLine(); text }() != null) {
            history_text_box.append(text)
            history_text_box.append("\n")
        }


        back_button2.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }
}