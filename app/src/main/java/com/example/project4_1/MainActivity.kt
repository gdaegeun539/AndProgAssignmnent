package com.example.project4_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var edit1 : EditText
    lateinit var edit2 : EditText
    lateinit var btnAdd : Button
    lateinit var btnSub : Button
    lateinit var btnMul : Button
    lateinit var btnDiv : Button
    lateinit var btnMod: Button
    lateinit var textResult : TextView
    lateinit var notEdit: Toast
    var result : Double? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "2018156029 이대근"

        edit1 = findViewById(R.id.Edit1)
        edit2 = findViewById(R.id.Edit2)
        btnAdd = findViewById(R.id.BtnAdd)
        btnSub = findViewById(R.id.BtnSub)
        btnMul = findViewById(R.id.BtnMul)
        btnDiv = findViewById(R.id.BtnDiv)
        btnMod = findViewById(R.id.BtnMod)
        textResult = findViewById(R.id.TextResult)
        notEdit = Toast.makeText(this, R.string.not_input, Toast.LENGTH_SHORT)

        btnAdd.setOnClickListener {
            if (isInput()) {
                notEdit.show()
            } else {
                doCalc("Add")
            }
        }

        btnSub.setOnClickListener {
            if (isInput()) {
                notEdit.show()
            } else {
                doCalc("Sub")
            }
        }

        btnMul.setOnClickListener {
            if (isInput()) {
                notEdit.show()
            } else {
                doCalc("Mul")
            }
        }

        btnDiv.setOnClickListener {
            if (isInput()) {
                notEdit.show()
            } else {
                doCalc("Div")
            }
        }

        btnMod.setOnClickListener {
            if (isInput()) {
                notEdit.show()
            } else {
                doCalc("Mod")
            }
        }

    }

    private fun isInput(/* edit1: EditText, edit2: EditText */): Boolean {
        return edit1.text.toString() == "" || edit2.text.toString() == ""
    }

    private fun doCalc(stat: String) {
        if (edit2.text.toString().toDouble() == 0.0) {
            Toast.makeText(this, R.string.div_zero, Toast.LENGTH_SHORT).show()
            return
        }

        when (stat) {
            "Add" -> {
                result = edit1.text.toString().toDouble() + edit2.text.toString().toDouble()
            }
            "Sub" -> {
                result = edit1.text.toString().toDouble() - edit2.text.toString().toDouble()
            }
            "Mul" -> {
                result = edit1.text.toString().toDouble() * edit2.text.toString().toDouble()
            }
            "Div" -> {
                result = edit1.text.toString().toDouble() / edit2.text.toString().toDouble()
            }
            "Mod" -> {
                result = edit1.text.toString().toDouble() % edit2.text.toString().toDouble()
            }
        }
        textResult.text = "계산 결과 : " + result.toString()
        return
    }
}