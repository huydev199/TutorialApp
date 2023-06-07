package com.example.tutorialapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var btnHome:  Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnHome = findViewById(R.id.btnHome)
        btnHome.setOnClickListener(){
            val i = Intent(this , HomeActivity::class.java)
            startActivity(i)
        }
//        Log.i("Main", "MainActivity")
//        val serviceIntent = Intent(this, MyService::class.java)
//        startService(serviceIntent)
    }

//    override fun startService(service: Intent?): ComponentName? {
//        return super.startService(Intent(this, MyService::class.java))
//    }
}