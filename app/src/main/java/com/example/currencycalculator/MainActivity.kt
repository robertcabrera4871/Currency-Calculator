package com.example.currencycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var currencyCalc : CurrencyCalculator = CurrencyCalculator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        populateSpinner(fromCurrencySpinner)
        populateSpinner(toCurrencySpinner)
        fromCurrencySpinner.onItemSelectedListener = createSpinnerListener(fromCurrencySpinner)
        toCurrencySpinner.onItemSelectedListener = createSpinnerListener(toCurrencySpinner)
        currencyInTextView.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    currencyCalc.fromCurrencyAmount = currencyInTextView.text.toString().toDouble()
                    currencyOutTextView.text = currencyCalc.calculateToCurrency()

            }

        })
    }

    private fun createSpinnerListener(spinner: Spinner): AdapterView.OnItemSelectedListener{
            return object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    currencyCalc.fromCurrencyType = ""
                    currencyCalc.toCurrencyType = ""
                }

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    if(spinner.id == fromCurrencySpinner.id){
                        currencyCalc.fromCurrencyType = fromCurrencySpinner.getItemAtPosition(position).toString()
                    } else if(spinner.id == toCurrencySpinner.id){
                        currencyCalc.toCurrencyType = toCurrencySpinner.getItemAtPosition(position).toString()
                    }
                    currencyOutTextView.text = currencyCalc.calculateToCurrency()
                }

            }

    }

    private fun populateSpinner(spinner: Spinner) {
        spinner.adapter = ArrayAdapter.createFromResource(
            this@MainActivity,
            R.array.currency_names,
            R.layout.support_simple_spinner_dropdown_item
        )
    }
}
