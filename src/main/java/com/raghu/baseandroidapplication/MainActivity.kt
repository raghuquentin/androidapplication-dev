package com.raghu.baseandroidapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var weightText = findViewById<EditText>(R.id.wckgtext)
        var heightText = findViewById<EditText>(R.id.hgInputNumber)
        var calcButton = findViewById<Button>(R.id.btnCalc)

        calcButton.setOnClickListener {
            var weight = weightText.text.toString()
            var height = heightText.text.toString()
            println(weight+".."+height)
            if(validateInput(weight,height)) {
                var bmi = (weight.toFloat()) / ((height.toFloat() / 100) * (height.toFloat() / 100))
                var bmi2Digits = String.format("%.2f", bmi).toFloat()
                displayResult(bmi2Digits)
            }
        }
    }

    private fun displayResult(bmi2Digits: Float) {
        var bmiValue = findViewById<TextView>(R.id.tvValueHolder)
        var healthCondtn = findViewById<TextView>(R.id.tvhealthCondHolder)
        var healthRange = findViewById<TextView>(R.id.tvHealthRangeHolder)
        bmiValue.text = bmi2Digits.toString()
        when{
            bmi2Digits < 16 ->{
                healthCondtn.text = "Severe Thinness"
            }
            bmi2Digits in 16.toFloat()..18.5F ->{
                healthCondtn.text = "Healthy"
        }
            bmi2Digits > 19 ->{
                healthCondtn.text = "Unhealthy"
            }
        }
    }
    private fun validateInput(weight:String?,height:String?):Boolean{
        when{
            weight.isNullOrEmpty()->{
                Toast.makeText(this,"Weight should not be empty",Toast.LENGTH_LONG).show()
                return false
            }
            height.isNullOrEmpty()->{
                Toast.makeText(this,"Heightght should not be empty",Toast.LENGTH_LONG).show()
                return false
            }else ->{
                return true
            }
        }
    }
}