package com.example.receptor_broad_app_poc

import android.content.BroadcastReceiver
import android.content.IntentFilter
import android.net.wifi.WifiManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private val myBroadcastReceiver: MyBroadcastReceiver = MyBroadcastReceiver();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val PERMISSION = "my.app.PERMISSION"
        val intentFilter = IntentFilter("com.example.broadcast.MY_ACTION_TO_BROADCAST")
        applicationContext.registerReceiver(myBroadcastReceiver, intentFilter, PERMISSION, null)
    }

    override fun onDestroy() {
        applicationContext.unregisterReceiver(myBroadcastReceiver)
        super.onDestroy()
    }
}