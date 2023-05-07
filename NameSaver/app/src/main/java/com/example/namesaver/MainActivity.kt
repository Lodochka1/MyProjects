package com.example.namesaver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

/*import kotlinx.android.synthetic.main.activity_main*/

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonSave = findViewById<View>(R.id.buttonSave)
        val editTextName = findViewById<EditText>(R.id.editTextName)
        val textViewName = findViewById<TextView>(R.id.textViewName)
        buttonSave.setOnClickListener {
            val name= editTextName.text.toString().trim()
            textViewName.text = "Привет, $name"
        }
    }
}