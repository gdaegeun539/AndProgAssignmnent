package com.example.project4_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    lateinit var text1 : TextView
    lateinit var text2 : TextView
    lateinit var chkAgree : CheckBox
    lateinit var rGroup1 : RadioGroup
    lateinit var rdoDog : RadioButton
    lateinit var rdoCat : RadioButton
    lateinit var rdoRabbit : RadioButton
    lateinit var btnOK : Button
    lateinit var imgPet : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "2018156029 이대근"

        text1 = findViewById(R.id.Text1)
        chkAgree = findViewById(R.id.ChkAgree)
        text2 = findViewById(R.id.Text2)
        rGroup1 = findViewById(R.id.Rgroup1)
        rdoDog = findViewById(R.id.RdoDog)
        rdoCat = findViewById(R.id.RdoCat)
        rdoRabbit = findViewById(R.id.RdoRabbit)
        btnOK = findViewById(R.id.BtnOK)
        imgPet = findViewById(R.id.ImgPet)

        // 시작함 체크박스의 체크가 변경되면
        chkAgree.setOnCheckedChangeListener { compoundButton, b ->
            // 체크되면 모두 보이도록 설정
            if (chkAgree.isChecked) {
                text2.visibility = android.view.View.VISIBLE
                rGroup1.visibility = android.view.View.VISIBLE
                btnOK.visibility = android.view.View.VISIBLE
                imgPet.visibility = android.view.View.VISIBLE
            } else {
                text2.visibility = android.view.View.INVISIBLE
                rGroup1.visibility = android.view.View.INVISIBLE
                btnOK.visibility = android.view.View.INVISIBLE
                imgPet.visibility = android.view.View.INVISIBLE
            }
        }

        // 선택 완료 버튼을 클릭하면
        btnOK.setOnClickListener {
            when (rGroup1.checkedRadioButtonId) {
                R.id.RdoDog -> imgPet.setImageResource(R.drawable.dog)
                R.id.RdoCat -> imgPet.setImageResource(R.drawable.cat)
                R.id.RdoRabbit -> imgPet.setImageResource(R.drawable.rabbit)
                else -> Toast.makeText(applicationContext, "동물 먼저 선택하세요",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }
}