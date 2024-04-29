package com.example.tamagochiapp

import android.animation.ObjectAnimator
import android.content.Intent
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
//       assigning the title textview to the pet name passed from the previous Intent
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
        val healthProgress=findViewById<ProgressBar>(R.id.health)


//Assigning the maximum values of the progress Bars
        eatProgress.max=1000
        playProgress.max=1000
        bathProgress.max=1000
        smokeProgress.max=3500
        healthProgress.max=1000
//assigning and initializing the current progress
        var eatCurrentProgress=0
        var playCurrentProgress=0
        var bathCurrentProgress=0
        var smokeCurrentProgress=0
        var healthCurrentProgress=100

//update the current progress function with int progress and progress bar name as a parameter
        fun updateProgress(progress:Int,pbName:ProgressBar){
            ObjectAnimator.ofInt(pbName,"progress",progress)
                .start()

        }

//        display the default image after 2 second
        fun changeImageDelay(){


            Handler().postDelayed({
                actionImage.setImageResource(R.drawable.neutral)
            }, 2000)

        }

//        max progress function condition to what happens when the  max is reached with three parameters a corresponding image is loaded
        fun maxProgress(progress:Int,pbName:ProgressBar,maxImg:Int){
            if (progress>=pbName.max){

                actionImage.setImageResource(maxImg)
            }
        }
//change the image to the corresponding action
        fun start(action:Int) {
            actionImage.setImageResource(action)
        }

//        overall health of the pet

        fun overallHealth(){
        ObjectAnimator.ofInt(healthProgress,"progress",healthCurrentProgress).start()}



//triggers when the overall health reaches <=0 it creates a new intent
        fun dead(){
            if (healthCurrentProgress<=0){
                val deadScreen=Intent(this,dead::class.java).also {
                    it.putExtra("EXTRA PET NAME",petName)
                }
                startActivity(deadScreen)
            }
        }

        overallHealth()

    eatBtn.setOnClickListener {

        if(eatCurrentProgress>500){
            healthCurrentProgress-=300
            overallHealth()
            dead()

        }
        else{

        eatCurrentProgress+=100
            healthCurrentProgress+=200
            overallHealth()

        }


        start(R.drawable.sakamoto_eating)
        changeImageDelay()
        updateProgress(eatCurrentProgress,eatProgress)
        maxProgress(eatCurrentProgress,eatProgress,R.drawable.sakamoto_full)


    }
        playBtn.setOnClickListener {

            if (playCurrentProgress>600){
                healthCurrentProgress-=500
                overallHealth()
                dead()
            }
            else{
                playCurrentProgress+=100
                healthCurrentProgress+=300
            overallHealth()
            }


            start(R.drawable.playing)
            changeImageDelay()
            updateProgress(playCurrentProgress,playProgress)
            maxProgress(playCurrentProgress,playProgress,R.drawable.sakamoto_sleep)
        }


        bathBtn.setOnClickListener {
        if (bathCurrentProgress>500){
            healthCurrentProgress-=300
            overallHealth()
            dead()
        }
            else{

        bathCurrentProgress+=150
            healthCurrentProgress+=200
            overallHealth()
            }
        start(R.drawable.sakamoto_bath)
        changeImageDelay()
        updateProgress(bathCurrentProgress,bathProgress)
        maxProgress(bathCurrentProgress,bathProgress,R.drawable.sakamoto_sparkling)
    }
        smokeBtn.setOnClickListener {
            if (smokeCurrentProgress>=1000){
                healthCurrentProgress-=500
                overallHealth()
                dead()
            }
            else{
                smokeCurrentProgress+=1000
                healthCurrentProgress+=500
                overallHealth()
            }

            start(R.drawable.sakamoto_smoking)
            changeImageDelay()
            updateProgress(smokeCurrentProgress,smokeProgress)
            maxProgress(smokeCurrentProgress,smokeProgress,R.drawable.sakamoto_red_eye)
        }

    }
    }
