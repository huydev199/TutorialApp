package com.example.tutorialapp.Service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseInstanceIdService2 : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {

        Log.d("TAG", "From: ${remoteMessage.from}")
        Log.d("TAG", "Notification Message Body: ${remoteMessage.notification?.body}")

    }

    override fun onNewToken(token: String) {
        Log.d("test", "my token: " + token)
    }
}