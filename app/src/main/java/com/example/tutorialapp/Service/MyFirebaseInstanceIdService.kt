package com.example.tutorialapp.Service

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseInstanceIdService :FirebaseMessagingService() {
    override fun onNewToken(token: String) {
        Log.d("mytoken", "Refreshed token: $token")

//        sendRegistrationToServer(token)
    }

}