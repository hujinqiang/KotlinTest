package com.tocel.kotlintest

fun main(args: Array<String>) {
    println(max(9,10))
    println("\$")
}

fun max(a :Int,b :Int):Int = if(a > b) a else b