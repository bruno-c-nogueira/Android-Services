package com.example.services
import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ForeGround Service will run even if the app is closed
        if (!foregroundServiceRunning()){
            val intent = Intent(this, ForegroundService::class.java)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                startForegroundService(intent)
            }
        }

        //BackGround Service will work only when the application still alive
        //startService(Intent(this, MyBackGroundService::class.java))



    }

    fun foregroundServiceRunning(): Boolean{
        val activityManager: ActivityManager =  getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        activityManager.getRunningServices(Int.MAX_VALUE).forEach {
            return ForegroundService::class.java.name == it.service.className

        }
        return false
    }
}