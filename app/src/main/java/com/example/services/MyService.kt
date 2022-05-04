package com.example.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlin.math.log

class MyService: Service() {
    val TAG = this::class.simpleName

    init {
        Log.d(TAG, "Service starting now")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val dataString = intent?.getStringExtra("EXTRA_DATA")
        dataString?.let {
            Log.d(TAG, it)
        }
        Thread{

        }.start()

        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "Service been destroyed")

    }


    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
}