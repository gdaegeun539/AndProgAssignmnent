package com.example.project4_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    lateinit var text1 : TextView
    lateinit var text2 : TextView
    lateinit var swAgree : CheckBox
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
                text2.visibility = android.view.View.INVISIBLE
                rGroup1.visibility = android.view.View.INVISIBLE
                imgAndro.visibility = android.view.View.INVISIBLE
                btnExit.visibility = android.view.View.INVISIBLE
                btnClear.visibility = android.view.View.INVISIBLE
            }
        }

        rdoOreo.setOnCheckedChangeListener { compoundButton, b ->
            TODO("Not yet Impl")
        }

        rdoPie.setOnCheckedChangeListener { compoundButton, b ->
            TODO("Not yet Impl")
        }

        rdoQueenCake.setOnCheckedChangeListener { compoundButton, b ->
            TODO("Not yet Impl")
        }

        // 종료 버튼 클릭
        btnExit.setOnClickListener {
            TODO("Not yet Impl")
//            when (rGroup1.checkedRadioButtonId) {
//                R.id.RdoDog -> imgPet.setImageResource(R.drawable.dog)
//                R.id.RdoCat -> imgPet.setImageResource(R.drawable.cat)
//                R.id.RdoRabbit -> imgPet.setImageResource(R.drawable.rabbit)
//                else -> Toast.makeText(applicationContext, "동물 먼저 선택하세요",
//                    Toast.LENGTH_SHORT).show()
//            }
        }
        
        // 처음으로 버튼 클릭
        btnClear.setOnClickListener {
            TODO("Not Yet Impl")
        }
    }
}