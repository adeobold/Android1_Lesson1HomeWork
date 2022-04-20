package com.android1.lesson1homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        editDateOfBirth.text = SimpleDateFormat("dd.MM.yyyy").format(System.currentTimeMillis())
        val editPhone: TextView = findViewById(R.id.editPhone);
        val txtResult: TextView = findViewById(R.id.txtResult);
        val swMarried: Switch = findViewById(R.id.swMarried);

        val btnResult: Button = findViewById(R.id.btnResult);

        var cal = Calendar.getInstance()

        btnResult.setOnClickListener(){

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





    }
}