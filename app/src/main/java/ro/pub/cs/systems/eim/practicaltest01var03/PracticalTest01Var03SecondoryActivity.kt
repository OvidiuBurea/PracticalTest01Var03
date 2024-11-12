package ro.pub.cs.systems.eim.practicaltest01var03

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PracticalTest01Var03SecondoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practical_test01_var03_secondary)

        val operationResult = intent.getStringExtra("operation_result")
        val resultTextView = findViewById<TextView>(R.id.result_text_view)
        resultTextView.text = operationResult

        val buttonCorrect = findViewById<Button>(R.id.button_correct)
        val buttonIncorrect = findViewById<Button>(R.id.button_incorrect)

        buttonCorrect.setOnClickListener {
            Toast.makeText(this, "Correct: $operationResult", Toast.LENGTH_SHORT).show()
            finish()
        }

        buttonIncorrect.setOnClickListener {
            Toast.makeText(this, "Incorrect: $operationResult", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}