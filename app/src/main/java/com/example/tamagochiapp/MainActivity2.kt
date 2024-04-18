package com.example.tamagochiapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nameField=findViewById<EditText>(R.id.nameField)
        val nextBtn=findViewById<Button>(R.id.nextBtn)
        val nextPage=Intent(this,MainActivity3::class.java)
        nextBtn.setOnClickListener {
            if (nameField.text.isBlank()){
                Toast.makeText(this, "Name cannot be empty", Toast.LENGTH_SHORT).show()
            }
            else{
                val pet = Pet(nameField.text.toString())
                nextPage.putExtra("petName", pet.name)
                startActivity(nextPage)
            }
        }










    }

}


data class Pet (val name:String){

}