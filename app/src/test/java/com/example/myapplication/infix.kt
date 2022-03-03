package com.example.myapplication


infix fun String.beginsWith(prefix: String) = startsWith(prefix)
infix fun <T> Collection<T>.has(element : T) = contains(element)    //给 Collection 接口添加了一个扩展函数
infix fun <A,B> A.with(that:B): Pair<A,B> = Pair(this, that)
inline fun <reified T> getGenericType() = T::class.java