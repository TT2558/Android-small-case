package com.example.myapplication

import java.lang.StringBuilder
import java.util.concurrent.ArrayBlockingQueue

fun main(){
    println("hello kotlin")

    var a = method("🆘")
    println(a)

    val list = listOf<String>("apple","orange","banana","watermelon")ld

    if (list has "banana"){
        println(list.last())
    }

    val map = mapOf("apple" with 1,"banana" with 2)

    val result = StringBuilder().builder {                 //with(StringBuilder())
        append("Start eat fruits.\n")
        for (fruit in list) {
            append(fruit).append("\n")
        }
        append("Ate All fruits.")
        toString()
    }
    println(result)

    val count = "asdhajkschaih@!s2131221".lettersCount()
    println(count)
    val str :String = "abc"*3
    println(str)
    var str1 : String = "alex"
    str1 = str1.times(4)
    println(str1)

    val num1=10
    val num2=20
    val result1= num1andnum2(num1,num2){ n1 , n2 ->
        n1*n2
    }
    println("result:$result1")

    println("mian 开始🉑️")
    val str2 =""
    printString(str2){s ->
        println("lambda 开始⬆️")
        if (s.isEmpty()) return     //@printString     //局部返回，并且不再执行剩余代码
        println(s)
        println("lanmbda 结束⬇️")
    }
}

   inline fun printString(str : String ,block : (String) -> Unit){
        println("printString 开始🔓")
        block(str)
        println("printString 结束🔚")
    }

    fun StringBuilder.builder(block: StringBuilder.() ->Unit):StringBuilder{
        block()
        return this
    }

    fun String.lettersCount():Int{
        var count = 0
        for(char in this){
            if (char.isLetter()){
                count++
            }
        }
        return count
    }

    operator fun String.times(n: Int) : String{
        val builder = StringBuilder()
        repeat(n){
            builder.append(this)
        }
        return builder.toString()
    }

    fun num1andnum2 (num1 : Int, num2 : Int,operation :(Int, Int) ->Int):Int{
        val result = operation(num1,num2)
        return result
    }

    fun plus(num1 : Int, num2 :Int) : Int{
        return num1+num2
    }

    fun minus(num1 :Int, num2 :Int) : Int{
        return num1-num2

    }
    fun < T > method(param : T) :T{
        return param
    }