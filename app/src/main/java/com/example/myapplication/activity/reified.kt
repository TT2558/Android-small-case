package com.example.myapplication.activity

import android.app.Activity
import android.content.Intent

inline fun <reified T> startActivity(activity: Activity, block : Intent.() -> Unit){
    val intent = Intent(activity, T::class.java)
    intent.block()
    activity.startActivity(intent)

}