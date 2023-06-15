package com.example.tutorialapp.activies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.tutorialapp.R

class MainActivity : AppCompatActivity() {
    private lateinit var btnHome: Button
    private lateinit var btnBottom: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnHome = findViewById(R.id.btnHome)
        btnBottom = findViewById(R.id.btnBottomNav)
        btnBottom.setOnClickListener {
            val i = Intent(this, BottomNavigationActivity::class.java)
            startActivity(i)
        }
        btnHome.setOnClickListener() { view ->
            val i = Intent(this, HomeActivity::class.java)
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