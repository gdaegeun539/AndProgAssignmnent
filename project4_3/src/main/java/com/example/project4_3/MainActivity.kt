package com.example.project4_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var toastText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toastText = findViewById(R.id.toastText)
        toastText.inputType = 0
        toastText.setOnKeyListener { _, _, _ ->
            Toast.makeText(this, toastText.text.toString(), Toast.LENGTH_SHORT).show()
            false
        }
    }
}