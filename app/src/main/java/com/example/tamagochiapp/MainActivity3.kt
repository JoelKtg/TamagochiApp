package com.example.tamagochiapp

import android.animation.ObjectAnimator
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var title=findViewById<TextView>(R.id.title)
        val petName = intent.getStringExtra("petName")
        title.text="Take Care of ${petName}"



        val eatBtn=findViewById<Button>(R.id.eatBtn)
        val playBtn=findViewById<Button>(R.id.playBtn)
        val bathBtn=findViewById<Button>(R.id.bathBtn)
        val smokeBtn=findViewById<Button>(R.id.smokeBtn)
        val eatProgress=findViewById<ProgressBar>(R.id.eatPb)
        val playProgress=findViewById<ProgressBar>(R.id.playPb)
        val bathProgress=findViewById<ProgressBar>(R.id.bathPb)
        val smokeProgress=findViewById<ProgressBar>(R.id.smokePb)
        var actionImage=findViewById<ImageView>(R.id.statusIv)

        eatProgress.max=1000
        var currentProgress=0




    eatBtn.setOnClickListener {

    fun updateProgress(){
        currentProgress+=100
        ObjectAnimator.ofInt(eatProgress,"progress",currentProgress)
            .start()

    }
        fun changeImageDelay(){


            Handler().postDelayed({
                actionImage.setImageResource(R.drawable.neutral)
            }, 2000)

        }

        fun checkProgress(){
            if (currentProgress>=eatProgress.max){

                actionImage.setImageResource(R.drawable.sakamoto_full)
            }

        }

        fun start(){
            actionImage.setImageResource(R.drawable.sakamoto_eating)
            updateProgress()
            changeImageDelay()
            checkProgress()



        }

        start()





    }



    }
}