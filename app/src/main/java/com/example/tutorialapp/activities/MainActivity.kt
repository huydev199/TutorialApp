package com.example.tutorialapp.activities

import android.content.ContentResolver
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.Telephony
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.tutorialapp.MyReceiver
import com.example.tutorialapp.R
import android.Manifest
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {
    private lateinit var btnHome: Button
    private lateinit var btnBottom: Button
    private val MY_PERMISSIONS_REQUEST_READ_SMS = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addBroadcast()
        addContentProvider()
        askNotificationPermission()
//        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
//            if (!task.isSuccessful) {
////                Log.w(TAG, "Fetching FCM registration token failed", task.exception)
//                return@OnCompleteListener
//            }
//
//            // Get new FCM registration token
//            val token = task.result
//
//            // Log and toast
////            val msg = getString(R.string.msg_token_fmt, token)
//            Log.d("mytoken", "token "+token)
//
////            Toast.makeText(baseContext, msg, Toast.LENGTH_SHORT).show()
//        })

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

    private fun addContentProvider(){
        val contentResolver = contentResolver

        // Kiểm tra xem ứng dụng đã được cấp quyền đọc SMS chưa
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED) {
            // Nếu chưa được cấp quyền, yêu cầu quyền từ người dùng
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.READ_SMS),
                MY_PERMISSIONS_REQUEST_READ_SMS)
        } else {
            // Nếu đã được cấp quyền, truy xuất dữ liệu tin nhắn
            val contentResolver = contentResolver
            fetchSmsData(contentResolver)
        }
        fetchSmsData(contentResolver)
    }

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission(),
    ) { isGranted: Boolean ->
        if (isGranted) {
            // FCM SDK (and your app) can post notifications.

        } else {
            // TODO: Inform user that that your app will not show notifications.
        }
    }

    private fun askNotificationPermission() {
        // This is only necessary for API level >= 33 (TIRAMISU)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) ==
                PackageManager.PERMISSION_GRANTED
            ) {
                // FCM SDK (and your app) can post notifications.
            } else if (shouldShowRequestPermissionRationale(Manifest.permission.POST_NOTIFICATIONS)) {
                // TODO: display an educational UI explaining to the user the features that will be enabled
                //                //       by them granting the POST_NOTIFICATION permission. This UI should provide the user
                //                //       "OK" and "No thanks" buttons. If the user selects "OK," directly request the permission.
                //                //       If the user selects "No thanks," allow the user to continue without notifications.
            } else {
                // Directly ask for the permission
                requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
            }
        }
    }

    fun fetchSmsData(contentResolver: ContentResolver) {
        val uri: Uri = Uri.parse("content://sms/inbox")
        val projection = arrayOf(
            Telephony.Sms._ID,
            Telephony.Sms.ADDRESS,
            Telephony.Sms.BODY,
            Telephony.Sms.DATE,
        )

        val sortOrder = "${Telephony.Sms.DATE} DESC"
        val cursor = contentResolver.query(uri, projection, null, null, sortOrder)
        if (cursor != null && cursor.moveToFirst()) {
            do {
                val messageId = cursor.getLong(0)
                val address = cursor.getString(1)
                val body = cursor.getString(2)
                val date = cursor.getLong(3)
//                Log.d("MESSAGE", "My message"+address)

            } while (cursor.moveToNext())
            cursor.close()
        }
    }

    private fun addBroadcast(){
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