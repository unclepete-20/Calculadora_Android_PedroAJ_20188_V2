package com.example.calculadoraPedroArriola20188

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class Calculadora : AppCompatActivity() {
    lateinit var tvOne : TextView
    lateinit var tvTwo : TextView
    lateinit var tvThree : TextView
    lateinit var tvFour : TextView
    lateinit var tvFive : TextView
    lateinit var tvSix : TextView
    lateinit var tvSeven : TextView
    lateinit var tvEight : TextView
    lateinit var tvNine : TextView
    lateinit var tvZero : TextView
    lateinit var tvClear : TextView
    lateinit var tvResult : TextView
    lateinit var tvExpression : TextView
    lateinit var tvMul : TextView
    lateinit var tvDivide : TextView
    lateinit var tvBack : ImageView
    lateinit var tvClose : TextView
    lateinit var tvOpen : TextView
    lateinit var tvPlus : TextView
    lateinit var tvMinus : TextView
    lateinit var tvEquals : TextView
    lateinit var tvDot : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        tvOne = findViewById(R.id.tvOne)
        tvTwo = findViewById(R.id.tvTwo)
        tvThree = findViewById(R.id.tvThree)
        tvFour = findViewById(R.id.tvFour)
        tvFive = findViewById(R.id.tvFive)
        tvSix = findViewById(R.id.tvSix)
        tvSeven = findViewById(R.id.tvSeven)
        tvEight = findViewById(R.id.tvEight)
        tvNine = findViewById(R.id.tvNine)
        tvZero = findViewById(R.id.tvZero)
        tvClear = findViewById(R.id.tvClear)
        tvResult = findViewById(R.id.tvResult)
        tvExpression = findViewById(R.id.tvExpression)
        tvMul = findViewById(R.id.tvMul)
        tvDivide = findViewById(R.id.tvDivide)
        tvBack = findViewById(R.id.tvBack)
        tvClose = findViewById(R.id.tvClose)
        tvOpen = findViewById(R.id.tvOpen)
        tvPlus = findViewById(R.id.tvPlus)
        tvMinus = findViewById(R.id.tvMinus)
        tvEquals = findViewById(R.id.tvEquals)
        tvDot = findViewById(R.id.tvDot)

        //Numeros
        tvOne.setOnClickListener{ appendOnExpression("1", true) }
        tvTwo.setOnClickListener{ appendOnExpression("2", true) }
        tvThree.setOnClickListener{ appendOnExpression("3", true) }
        tvFour.setOnClickListener{ appendOnExpression("4", true) }
        tvFive.setOnClickListener{ appendOnExpression("5", true) }
        tvSix.setOnClickListener{ appendOnExpression("6", true) }
        tvSeven.setOnClickListener{ appendOnExpression("7", true) }
        tvEight.setOnClickListener{ appendOnExpression("8", true) }
        tvNine.setOnClickListener{ appendOnExpression("9", true) }
        tvZero.setOnClickListener{ appendOnExpression("0", true) }
        tvDot.setOnClickListener{ appendOnExpression(".", true) }

        //Operadores
        tvPlus.setOnClickListener{ appendOnExpression("+", false) }
        tvMinus.setOnClickListener{ appendOnExpression("-", false) }
        tvMul.setOnClickListener{ appendOnExpression("*", false) }
        tvDivide.setOnClickListener{ appendOnExpression("/", false) }
        tvOpen.setOnClickListener{ appendOnExpression("(", false) }
        tvClose.setOnClickListener{ appendOnExpression(")", false) }

        tvClear.setOnClickListener{
            tvExpression.text = ""
            tvResult.text = ""
        }

        tvBack.setOnClickListener{
            val string = tvExpression.text.toString()
            if(string.isNotEmpty()){
                tvExpression.text = string.substring(0, string.length - 1)
            }
            tvResult.text = ""
        }

        tvEquals.setOnClickListener{
            try {
                val expression = ExpressionBuilder(tvExpression.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble()){
                    tvResult.text = longResult.toString()
                } else {
                    tvResult.text = result.toString()
                }
            } catch (e: Exception){
                Log.d("Exception", " message : " + e.message)
            }
        }
    }

    fun appendOnExpression(string: String, canClear : Boolean){
        if(tvResult.text.isNotEmpty()){
            tvExpression.text = ""
        }

        if(canClear){
            tvResult.text = ""
            tvExpression.append(string)
        } else {
            tvExpression.append(tvResult.text)
            tvExpression.append(string)
        }
    }
}