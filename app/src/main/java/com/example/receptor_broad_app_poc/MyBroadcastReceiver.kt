package com.example.receptor_broad_app_poc

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import java.lang.StringBuilder

class MyBroadcastReceiver : BroadcastReceiver(){

    override fun onReceive(context: Context?, intent: Intent?) {
        if(intent?.action.equals("com.example.broadcast.MY_ACTION_TO_BROADCAST")){
            val prefs = context?.getSharedPreferences("receptor_broadcast_app", Context.MODE_PRIVATE)
            val editor = prefs?.edit()
            editor?.apply {
                putString(Math.random().toString(), intent?.getStringExtra("data"))
                apply()
            }
        }
    }
}