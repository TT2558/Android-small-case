package com.example.myapplication.Broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyBroadcastReceiver :  BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context,"标准广播🤔",Toast.LENGTH_LONG).show()
        //abortBroadcast() //abort流产
    }
}