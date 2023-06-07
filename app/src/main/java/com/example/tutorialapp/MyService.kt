package com.example.tutorialapp

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import java.util.Timer
import java.util.TimerTask

class MyService : Service() {
    private var mTimer: Timer? = null

    override fun onBind(intent: Intent?): IBinder? {

        Log.i("HUYTEST", "onBind")
        Toast.makeText(this, "Service onBind!", Toast.LENGTH_LONG).show();
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i("HUYTEST", "onStartCommand")

        return super.onStartCommand(intent, flags, startId)
    }
    override fun onCreate() {
        super.onCreate()
//        this.bindService()
//        Log.i("HUYTEST", "onCreate")
//        mTimer = Timer()
//        mTimer?.scheduleAtFixedRate(object : TimerTask() {
//            override fun run() {
////                Toast.makeText(this@MyService, "Service created!", Toast.LENGTH_LONG).show();
//
//                Log.i("HUYTEST", "onCreate")
//                // Do something here
//            }
//        }, 0, 1000)
    }

    override fun onDestroy() {
        Toast.makeText(this, "onDestroy", Toast.LENGTH_LONG).show();
        Log.i("HUYTEST", "onDestroy")
        super.onDestroy()
        mTimer?.cancel()
    }
}