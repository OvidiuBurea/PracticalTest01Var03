package ro.pub.cs.systems.eim.practicaltest01var03

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PracticalTest01Var03MainActivity : AppCompatActivity() {

    private lateinit var number1: EditText
    private lateinit var number2: EditText
    private lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practical_test01_var03_main)

        number1 = findViewById(R.id.number1)
        number2 = findViewById(R.id.number2)
        result = findViewById(R.id.result)
        val buttonAdd = findViewById<Button>(R.id.button_add)
        val buttonSubtract = findViewById<Button>(R.id.button_subtract)
        val buttonNextActivity = findViewById<Button>(R.id.button_next_activity)
        val buttonStartService = findViewById<Button>(R.id.button_start_service)

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

        buttonNextActivity.setOnClickListener {
            val intent = Intent(this, PracticalTest01Var03SecondoryActivity::class.java)
            intent.putExtra("operation_result", result.text.toString())
            startActivity(intent)
        }

        buttonStartService.setOnClickListener {
            val num1 = number1.text.toString().toIntOrNull()
            val num2 = number2.text.toString().toIntOrNull()
            if (num1 != null && num2 != null) {
                val serviceIntent = Intent(this, PracticalTest01Var03Service::class.java)
                serviceIntent.putExtra("number1", num1)
                serviceIntent.putExtra("number2", num2)
                startService(serviceIntent)
            } else {
                Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show()
            }
        }

        if (savedInstanceState != null) {
            number1.setText(savedInstanceState.getString("number1"))
            number2.setText(savedInstanceState.getString("number2"))
            result.text = savedInstanceState.getString("result")
            Toast.makeText(this, "Values restored", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("number1", number1.text.toString())
        outState.putString("number2", number2.text.toString())
        outState.putString("result", result.text.toString())
    }
}