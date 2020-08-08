package com.mipa.learnandroidfundamentals.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.widget.Toast

const val TAG = "MyService"

class MyService : Service() {

    init {
        Log.d(TAG, "Service is running")
    }

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val dataString = intent?.getStringExtra("EXTRA_DATA")
        dataString?.let {
            Log.d(TAG, "DataString is $dataString")
        }
//        return START_NOT_STICKY
//        while (true){
//
//        }
        Thread {
            while (true) {

            }
        }.start()
        return START_STICKY
//        return START_REDELIVER_INTENT
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "Service is being killed...")
        Toast.makeText(this, " Service is being killed...", Toast.LENGTH_SHORT).show()
    }
}