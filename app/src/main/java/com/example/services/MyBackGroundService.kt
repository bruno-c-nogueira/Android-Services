package com.example.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log


class MyBackGroundService: Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Thread { while(true){
            Log.e("Service", "Service is Running")
            try {
                Thread.sleep(1000)
            }catch (e: InterruptedException){
                e.printStackTrace()
            }
        }
        }.run()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }
}