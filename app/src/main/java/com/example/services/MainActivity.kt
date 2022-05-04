package com.example.services
import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.services.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //ForeGround Service will run even if the app is closed
//        if (!foregroundServiceRunning()){
//            val intent = Intent(this, ForegroundService::class.java)
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                startForegroundService(intent)
//            }
//        }

        //BackGround Service will work only when the application still alive
        //startService(Intent(this, MyBackGroundService::class.java))

        binding.run {

            start.setOnClickListener {
                Intent(this@MainActivity, MyService::class.java).also {
                    startService(it)
                    binding.textView.text = "Service running"
                }
            }

            stop.setOnClickListener {
                Intent(this@MainActivity, MyService::class.java).also {
                    binding.textView.text = "Service stop"
                    stopService(it)
                }
            }

            send.setOnClickListener {
                Intent(this@MainActivity, MyService::class.java).also {
                    it.putExtra("EXTRA_DATA",binding.textView.text.toString())
                    startService(it)
                }
            }


        }



    }

    fun foregroundServiceRunning(): Boolean{
        val activityManager: ActivityManager =  getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        activityManager.getRunningServices(Int.MAX_VALUE).forEach {
            return ForegroundService::class.java.name == it.service.className

        }
        return false
    }
}