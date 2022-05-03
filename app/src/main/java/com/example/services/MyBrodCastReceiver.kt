package com.example.services

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build

class MyBrodCastReceiver: BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        if (p1?.action == Intent.ACTION_BOOT_COMPLETED){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                p0?.startForegroundService(Intent(p0, ForegroundService::class.java))
            }
        }
    }
}