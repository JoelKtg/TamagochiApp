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
        playProgress.max=1000
        bathProgress.max=1000
        smokeProgress.max=2000

        var eatCurrentProgress=0
        var playCurrentProgress=0
        var bathCurrentProgress=0
        var smokeCurrentProgress=0

        fun updateProgress(progress:Int,pbName:ProgressBar){
            ObjectAnimator.ofInt(pbName,"progress",progress)
                .start()

        }
        fun changeImageDelay(){


            Handler().postDelayed({
                actionImage.setImageResource(R.drawable.neutral)
            }, 2000)

        }

        fun maxProgress(progress:Int,pbName:ProgressBar,maxImg:Int){
            if (progress>=pbName.max){

                actionImage.setImageResource(maxImg)
            }

        }

        fun start(action:Int) {
            actionImage.setImageResource(action)


        }


    eatBtn.setOnClickListener {
        eatCurrentProgress+=100
        start(R.drawable.sakamoto_eating)
        changeImageDelay()
        updateProgress(eatCurrentProgress,eatProgress)
        maxProgress(eatCurrentProgress,eatProgress,R.drawable.sakamoto_full)



        }
        playBtn.setOnClickListener {
            playCurrentProgress+=100
            start(R.drawable.playing)
            changeImageDelay()
            updateProgress(playCurrentProgress,playProgress)
            maxProgress(playCurrentProgress,playProgress,R.drawable.sakamoto_sleep)

        }

    bathBtn.setOnClickListener {
        bathCurrentProgress+=150
        start(R.drawable.sakamoto_bath)
        changeImageDelay()
        updateProgress(bathCurrentProgress,bathProgress)
        maxProgress(bathCurrentProgress,bathProgress,R.drawable.sakamoto_sparkling)
    }

        smokeBtn.setOnClickListener {
            smokeCurrentProgress+=1000
            start(R.drawable.sakamoto_smoking)
            changeImageDelay()
            updateProgress(smokeCurrentProgress,smokeProgress)
            maxProgress(smokeCurrentProgress,smokeProgress,R.drawable.sakamoto_red_eye)
        }








    }





    }
