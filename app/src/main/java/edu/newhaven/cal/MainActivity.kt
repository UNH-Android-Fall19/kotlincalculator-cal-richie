package edu.newhaven.cal
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*Arithmetic functions calls, also passing boolean as true for value */
        tvOne.setOnClickListener {Append_Arthematic_Experssion(string = "1", clear_Expression = true)}
        tvTwo.setOnClickListener {Append_Arthematic_Experssion(string = "2", clear_Expression = true)}
        tvThree.setOnClickListener {Append_Arthematic_Experssion(string = "3", clear_Expression = true)}
        tvFour.setOnClickListener {Append_Arthematic_Experssion(string = "4", clear_Expression = true)}
        tvFive.setOnClickListener {Append_Arthematic_Experssion(string = "5", clear_Expression = true)}
        tvSix.setOnClickListener {Append_Arthematic_Experssion(string = "6", clear_Expression = true)}
        tvSeven.setOnClickListener {Append_Arthematic_Experssion(string = "7", clear_Expression = true)}
        tvEight.setOnClickListener {Append_Arthematic_Experssion(string = "8", clear_Expression = true)}
        tvNine.setOnClickListener {Append_Arthematic_Experssion(string = "9", clear_Expression = true)}
        tvZero.setOnClickListener{Append_Arthematic_Experssion(string = "0", clear_Expression = true)}
        tvDot.setOnClickListener{Append_Arthematic_Experssion(string = ".", clear_Expression = true)}


        /*Operation Function calls, also passing boolean as false for operators */
        tvEquals.setOnClickListener{Append_Arthematic_Experssion(string = "0", clear_Expression = true)}
        tvOpen.setOnClickListener{Append_Arthematic_Experssion(string = "(", clear_Expression = false)}
        tvClose.setOnClickListener{Append_Arthematic_Experssion(string = ")", clear_Expression = false)}
        tvDivide.setOnClickListener{Append_Arthematic_Experssion(string = "/", clear_Expression = false)}
        tvMul.setOnClickListener{Append_Arthematic_Experssion(string = "*", clear_Expression = false)}
        tvPlus.setOnClickListener{Append_Arthematic_Experssion(string = "+", clear_Expression = false)}
        tvMinus.setOnClickListener{Append_Arthematic_Experssion(string = "-", clear_Expression = false)}



       tvClear.setOnClickListener{
           val resultString = tvResult.text.toString()
           val expressionString = tvExpression.text.toString()
           if(resultString.isNotEmpty() or expressionString.isNotEmpty()){
               tvExpression.text = ""
               tvResult.text = ""
           }

       }




        tvBack.setOnClickListener{
            val string = tvExpression.text.toString()
            if(string.isNotEmpty()){
                tvExpression.text = string.substring(0,string.length-1)
            }
            tvResult.text= ""
        }


        tvEquals.setOnClickListener{
            try {
                val expression = ExpressionBuilder(tvExpression.text.toString()).build()
                val result = expression.evaluate()
                val longresult = result.toLong()
                if(result == longresult.toDouble())
                    tvResult.text = longresult.toString()
                else
                    tvResult.text = result.toString()

            }catch (e:Exception){
                Log.d("Execption", "message: "+e.message)
            }
        }



    }
    /*The below function is used to append new calculations and boolean is used to clear them once
     '=' to is entered to show the result in its place */
    fun Append_Arthematic_Experssion(string: String, clear_Expression : Boolean){

        if(tvResult.text.isNotEmpty()){
            tvExpression.text =""
        }
        if(clear_Expression){
            tvResult.text = ""
            tvExpression.append(string)
        }
        else{
            tvExpression.append(tvResult.text)
            tvExpression.append(string)
            tvResult.text = ""
        }


    }
}


