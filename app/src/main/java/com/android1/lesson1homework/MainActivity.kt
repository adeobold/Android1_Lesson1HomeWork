package com.android1.lesson1homework

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editName: TextView = findViewById(R.id.editName);
        val editEmail: TextView = findViewById(R.id.editEmail);
        val editDateOfBirth: TextView = findViewById(R.id.editDateOfBirth);
        //editDateOfBirth.text = SimpleDateFormat("dd.MM.yyyy").format(System.currentTimeMillis())
        val editPhone: TextView = findViewById(R.id.editPhone);
        val txtResult: TextView = findViewById(R.id.txtResult);
        val swMarried: Switch = findViewById(R.id.swMarried);

        val btnResult: Button = findViewById(R.id.btnResult);

        fun View.hideKeyboard() {
            val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(windowToken, 0)
        }

        btnResult.setOnClickListener(){

            editName.hideKeyboard();
            editEmail.hideKeyboard();
            editDateOfBirth.hideKeyboard();
            editPhone.hideKeyboard();

            txtResult.text = "Name: " + editName.text + "\n" +
                    "Email: " + editEmail.text + "\n" +
                    "Date of Birth: " + editDateOfBirth.text + "\n" +
                    "Phone number: " + editPhone.text + "\n";

            if (swMarried.isChecked) {
                txtResult.append("Status: Married");
            } else {
                txtResult.append("Status: Not married");
            }


        }

        var cal = Calendar.getInstance()

        val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, monthOfYear)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val myFormat = "dd.MM.yyyy"
            val sdf = SimpleDateFormat(myFormat, Locale.US)
            editDateOfBirth.text = sdf.format(cal.time)
        }

        editDateOfBirth.setOnClickListener {
            DatePickerDialog(this@MainActivity, dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)).show()
        }



    }


}