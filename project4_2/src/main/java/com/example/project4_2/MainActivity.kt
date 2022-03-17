package com.example.project4_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.widget.SwitchCompat

class MainActivity : AppCompatActivity() {
    lateinit var text1 : TextView
    lateinit var text2 : TextView
    lateinit var swAgree : SwitchCompat
    lateinit var rGroup1 : RadioGroup
    lateinit var rdoOreo : RadioButton
    lateinit var rdoPie : RadioButton
    lateinit var rdoQueenCake : RadioButton
    lateinit var btnExit : Button
    lateinit var imgAndro : ImageView
    lateinit var btnClear: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "2018156029 이대근"

        text1 = findViewById(R.id.Text1)
        swAgree = findViewById(R.id.ChkAgree)
        text2 = findViewById(R.id.Text2)
        rGroup1 = findViewById(R.id.Rgroup1)
        rdoOreo = findViewById(R.id.RdoOreo)
        rdoPie = findViewById(R.id.RdoPie)
        rdoQueenCake = findViewById(R.id.RdoQueenCake)
        imgAndro = findViewById(R.id.ImgAndroid)
        btnExit = findViewById(R.id.BtnExit)
        btnClear = findViewById(R.id.BtnClear)

        // 시작함 스위치의 체크가 변경되면
        swAgree.setOnCheckedChangeListener { compoundButton, b ->
            // 체크되면 모두 보이도록 설정
            if (swAgree.isChecked) {
                text2.visibility = android.view.View.VISIBLE
                rGroup1.visibility = android.view.View.VISIBLE
                imgAndro.visibility = android.view.View.VISIBLE
                btnExit.visibility = android.view.View.VISIBLE
                btnClear.visibility = android.view.View.VISIBLE
            } else {
                toInvisible()
            }
        }
        
        // 라디오 그룹 내에서 해당 버튼이 눌렸을 때 바꾸기
        rGroup1.setOnCheckedChangeListener { _, btnId ->
            when (btnId) {
                R.id.RdoOreo -> { // 오레오 이미지
                    imgAndro.setImageResource(R.drawable.oreo)
                }
                R.id.RdoPie -> { // 파이 이미지
                    imgAndro.setImageResource(R.drawable.pie)
                }
                R.id.RdoQueenCake -> { // 10 이미지
                    imgAndro.setImageResource(R.drawable.q10)
                }
            }
        }

        // 종료 버튼 클릭
        btnExit.setOnClickListener {
            finish()
        }
        
        // 처음으로 버튼 클릭
        btnClear.setOnClickListener {
            // 이미지뷰는 투명 색상을 통해 사라진 것 처럼 설정
            rGroup1.clearCheck()
            imgAndro.setImageResource(android.R.color.transparent)
            swAgree.isChecked = false
            toInvisible()
        }
    }

    // 위젯 가리는 메소드
    private fun toInvisible() {
        text2.visibility = android.view.View.INVISIBLE
        rGroup1.visibility = android.view.View.INVISIBLE
        imgAndro.visibility = android.view.View.INVISIBLE
        btnExit.visibility = android.view.View.INVISIBLE
        btnClear.visibility = android.view.View.INVISIBLE
    }
}