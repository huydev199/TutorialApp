package com.example.tutorialapp.activities

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.tutorialapp.MyReceiver
import com.example.tutorialapp.R


class MainActivity : AppCompatActivity() {
    private lateinit var btnHome: Button
    private lateinit var btnBottom: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addBroadcast()

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

    fun addBroadcast(){
        val broadcast = MyReceiver()
        val filter = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        registerReceiver(broadcast, filter)
    }


    fun broadcastIntent(view: View?) {
        val intent = Intent()
        intent.action = "com"
        sendBroadcast(intent)
    }

//    override fun startService(service: Intent?): ComponentName? {
//        return super.startService(Intent(this, MyService::class.java))
//    }
}