package com.example.currencycalculator

import android.icu.util.CurrencyAmount


class CurrencyCalculator {
    /*
    <item>Mex Peso</item>
    <item>US Dollar</item>
    <item>Can Dollar</item>
    <item>Jap Yen</item>*/

    var fromCurrencyAmount: Double = 0.0
     var fromCurrencyType : String = ""
     var toCurrencyType: String = ""

    fun calculateToCurrency() : String{
        if( fromCurrencyType!= "" && toCurrencyType != ""){
            when(fromCurrencyType){
                "Mex Peso" -> return fromMexCalc().toString().plus(" ").plus(toCurrencyType)
                "Can Dollar" -> return fromCanCalc().toString().plus(" ").plus(toCurrencyType)
                "Jap Yen" -> return fromJapCalc().toString().plus(" ").plus(toCurrencyType)
                "US Dollar" -> return fromUsCalc().toString().plus(" ").plus(toCurrencyType)
            }
        }
        return ""
    }
    private fun fromUsCalc(): Double{
            when(toCurrencyType){
            "Mex Peso" -> return fromCurrencyAmount * 18.56
            "Can Dollar" -> return fromCurrencyAmount * 1.33
            "Jap Yen" -> return fromCurrencyAmount * 109.74
        }
        return fromCurrencyAmount
    }
    private fun fromMexCalc(): Double{
        when(toCurrencyType){
            "US Dollar" -> return fromCurrencyAmount * 0.054
            "Can Dollar" -> return fromCurrencyAmount * 0.071
            "Jap Yen" -> return fromCurrencyAmount * 5.92
        }
        return fromCurrencyAmount
    }
    private fun fromCanCalc(): Double{
        when(toCurrencyType){
            "Mex Peso" -> return fromCurrencyAmount * 13.99
            "US Dollar" -> return fromCurrencyAmount * 0.75
            "Jap Yen" -> return fromCurrencyAmount * 82.80
        }
        return fromCurrencyAmount
    }
    private fun fromJapCalc(): Double{
        when(toCurrencyType) {
            "Mex Peso" -> return fromCurrencyAmount * 0.17
            "US Dollar" -> return fromCurrencyAmount * 0.0091
            "Can Dollar" -> return fromCurrencyAmount * 0.012
        }
        return fromCurrencyAmount
    }

}
