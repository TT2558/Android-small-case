package com.example.myapplication

import android.content.ContentValues

fun cvOf(vararg pairs: Pair<String, Any?>) = ContentValues().apply  {  //vararg 对应可变参数，Pair 是键值对类型的参数，其中必须加一个泛型来定义键值类型，any？相当于 object，加上？可传入空值
    val cv = ContentValues()
    for (pair in pairs){
        val key = pair.first
        val value = pair.second
        when (value){
            is Int -> cv.put(key, value)
            is Long -> cv.put(key, value)
            is Short -> cv.put(key, value)
            is Float -> cv.put(key, value)
            is Double -> cv.put(key, value)
            is Boolean -> cv.put(key, value)
            is String -> cv.put(key, value)
            is Byte -> cv.put(key, value)
            is ByteArray -> cv.put(key, value)
            null ->cv.putNull(key)
        }
    }
    return cv
}