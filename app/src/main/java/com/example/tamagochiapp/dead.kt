package com.example.tamagochiapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class dead : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dead)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val petName=intent.getStringExtra("EXTRA PET NAME")
        val tv1=findViewById<TextView>(R.id.tv1)
//        add the name of the EXTRA pet name to the textview
        tv1.text="$petName has Died"


//        play again button starts Main Activity 2
        val playAgainBtn=findViewById<Button>(R.id.playAgainBtn)

        playAgainBtn.setOnClickListener {
            val mainActivity2=Intent(this,MainActivity2::class.java)
            startActivity(mainActivity2)
        }
    }
}