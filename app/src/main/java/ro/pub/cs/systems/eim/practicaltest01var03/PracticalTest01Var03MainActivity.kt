package ro.pub.cs.systems.eim.practicaltest01var03

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PracticalTest01Var03MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practical_test01_var03_main)

        val number1 = findViewById<EditText>(R.id.number1)
        val number2 = findViewById<EditText>(R.id.number2)
        val result = findViewById<TextView>(R.id.result)
        val buttonAdd = findViewById<Button>(R.id.button_add)
        val buttonSubtract = findViewById<Button>(R.id.button_subtract)
        val buttonNextActivity = findViewById<Button>(R.id.button_next_activity)

        buttonAdd.setOnClickListener {
            val num1 = number1.text.toString().toIntOrNull()
            val num2 = number2.text.toString().toIntOrNull()
            if (num1 != null && num2 != null) {
                result.text = "${num1} + ${num2} = ${num1 + num2}"
            } else {
                Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show()
            }
        }

        buttonSubtract.setOnClickListener {
            val num1 = number1.text.toString().toIntOrNull()
            val num2 = number2.text.toString().toIntOrNull()
            if (num1 != null && num2 != null) {
                result.text = "${num1} - ${num2} = ${num1 - num2}"
            } else {
                Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show()
            }
        }


    }
}