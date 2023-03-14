package com.example.myapplication3

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var inputNumber: EditText
    private lateinit var decimalText: TextView
    private lateinit var octalText: TextView
    private lateinit var hexText: TextView
    private lateinit var binaryText: TextView
    private lateinit var clearButton: Button
    private var value: String? = null


    @SuppressLint("MissingInflatedId")
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputNumber = findViewById(R.id.Input)
        decimalText = findViewById(R.id.decimal)
        hexText = findViewById(R.id.hexadecimal)
        octalText = findViewById(R.id.octal)
        binaryText = findViewById(R.id.binary)
        clearButton = findViewById(R.id.btnClear)

        inputNumber.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                value = inputNumber.text.toString().trim()
                if (value!!.isNotEmpty()) {
                    convertNumber()
                }

            }


        })
        clearButton.setOnClickListener {
            decimalText.text = ""
            binaryText.text = ""
            hexText.text = ""
            octalText.text = ""
            inputNumber.setText("")
        }

    }

    private fun convertNumber() {
        try {
            val num = value!!.toLong()
            decimalText.setText(num.toString())
            binaryText.setText(num.toString(2))
            octalText.setText(num.toString(8))
            hexText.setText(num.toString(16))
        } catch (e: NumberFormatException) {
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}
