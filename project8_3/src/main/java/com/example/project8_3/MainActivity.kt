package com.example.project8_3

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var dp : DatePicker
    lateinit var edtDiary : EditText
    lateinit var btnWrite : Button
    lateinit var fileName : String

    var diaryText: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "간단 일기장 실습03 - 2018156029 이대근"

        var file: File?
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) { // 11 이상은 scoped storage이기 때문에 개인 저장소 활용
            file = getExternalFilesDir(null)
        } else { // 10 이하는 기존 방식 사용 - 목적에 부합
            while (ContextCompat.checkSelfPermission(
                    this,
                    "android.permission.WRITE_EXTERNAL_STORAGE"
                ) == PackageManager.PERMISSION_DENIED
            ) { // 접근 권한 체크 후 계속 요청
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE), Context.MODE_PRIVATE)
            }
            file = File(Environment.getExternalStorageDirectory().absolutePath + "/myDiary")
            if (!file.exists()) {
//                file.mkdir()
                file.createNewFile()
            }
        }

        dp = findViewById(R.id.datePicker1)
        edtDiary = findViewById(R.id.edtDiary)
        btnWrite = findViewById(R.id.btnWrite)

        var cal = Calendar.getInstance()
        var cYear = cal.get(Calendar.YEAR)
        var cMonth = cal.get(Calendar.MONTH)
        var cDay = cal.get(Calendar.DAY_OF_MONTH)

        readFile(cYear, cMonth, cDay, file)

        dp.init(cYear, cMonth, cDay) { _, year, monthOfYear, dayOfMonth ->
            readFile(year, monthOfYear, dayOfMonth, file)
        }

        btnWrite.setOnClickListener {
//            var outFs = openFileOutput(file?.absolutePath + "/" + fileName, Context.MODE_PRIVATE)
            var outFs = FileOutputStream(file?.absolutePath + "/" + fileName)
            var str = edtDiary.text.toString()
            outFs.write(str.toByteArray())
            outFs.close()
            Toast.makeText(applicationContext, "$fileName 이 저장됨", Toast.LENGTH_SHORT).show()
        }
    }

    fun readFile(cYear: Int, cMonth: Int, cDay: Int, file: File?) {
        fileName = (cYear.toString() + "_"
                + (cMonth + 1).toString() + "_"
                + cDay.toString() + ".txt")
        diaryText = readDiary(file?.absolutePath + "/" + fileName)
        edtDiary.setText(diaryText)
        btnWrite.isEnabled = true
    }

    private fun readDiary(fName: String) : String? {
        var diaryStr : String? = null
        var inFs : FileInputStream
        try {
//            inFs = openFileInput(fName)
            inFs = FileInputStream(fName)
            var txt = ByteArray(inFs.available())
            inFs.read(txt)
            inFs.close()
            diaryStr = txt.toString(Charsets.UTF_8).trim()
            btnWrite.text = "수정 하기"
        } catch (e : IOException) {
            edtDiary.hint = "일기 없음"
            btnWrite.text = "새로 저장"
        }
        return diaryStr
    }
}