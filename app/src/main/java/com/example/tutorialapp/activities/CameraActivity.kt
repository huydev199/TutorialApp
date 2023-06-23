package com.example.tutorialapp.activities

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.camera.core.ImageCapture
import androidx.camera.video.Recorder
import androidx.camera.video.Recording
import androidx.camera.video.VideoCapture
import androidx.core.content.ContextCompat

import com.example.tutorialapp.R
import java.util.concurrent.ExecutorService

class CameraActivity : AppCompatActivity() {
//    private lateinit var viewBinding: ActivityMainBinding

//    private var imageCapture: ImageCapture? = null
//
//    private var videoCapture: VideoCapture<Recorder>? = null
//    private var recording: Recording? = null
//
//    private lateinit var cameraExecutor: ExecutorService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)
    }


//    private fun takePhoto() {}
//
//    private fun captureVideo() {}
//
//    private fun startCamera() {}
//
//    private fun requestPermissions() {}

//    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
//        ContextCompat.checkSelfPermission(
//            baseContext, it) == PackageManager.PERMISSION_GRANTED
//    }

//    override fun onDestroy() {
//        super.onDestroy()
//        cameraExecutor.shutdown()
//    }

//    companion object {
//        private const val TAG = "CameraXApp"
//        private const val FILENAME_FORMAT = "yyyy-MM-dd-HH-mm-ss-SSS"
//        private val REQUIRED_PERMISSIONS =
//            mutableListOf (
//                android.Manifest.permission.CAMERA,
//                android.Manifest.permission.RECORD_AUDIO
//            ).apply {
//                if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.P) {
//                    add(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
//                }
//            }.toTypedArray()
//    }
}