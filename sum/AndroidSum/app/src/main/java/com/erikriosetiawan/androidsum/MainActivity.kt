package com.erikriosetiawan.androidsum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var edtFirstNumber: EditText
    private lateinit var edtSecondNumber: EditText
    private lateinit var tvResult: TextView
    private lateinit var btnCalculate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {
        edtFirstNumber = findViewById(R.id.edt_first_number)
        edtSecondNumber = findViewById(R.id.edt_second_number)
        tvResult = findViewById(R.id.tv_result)
        btnCalculate = findViewById(R.id.btn_calculate)
        btnCalculate.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_calculate -> {
                var isEmptyField = false

                if (TextUtils.isEmpty(edtFirstNumber.text.toString())) {
                    edtFirstNumber.error = "This Field Must Not Empty"
                    isEmptyField = true
                }

                if (TextUtils.isEmpty(edtSecondNumber.text.toString())) {
                    edtSecondNumber.error = "This Field Must Not Empty"
                    isEmptyField = true
                }

                if (!isEmptyField) {
                    val firstNumber: Double = edtFirstNumber.text.toString().toDouble()
                    val secondNumber: Double = edtSecondNumber.text.toString().toDouble()

                    val result = firstNumber + secondNumber
                    tvResult.text = result.toString()
                }
            }
        }
    }
}
