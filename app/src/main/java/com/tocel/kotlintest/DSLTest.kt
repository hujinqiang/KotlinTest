package com.tocel.kotlintest

fun main(args: Array<String>) {
    val appendExcl:StringBuilder.() -> Unit = {append("!")}


    val stringBuilder = StringBuilder("Hi")
    stringBuilder.appendExcl()
    println(stringBuilder)

    println(buildString { append("abcdefg") })


}

fun buildString(builderAction: StringBuilder.() -> Unit):String = StringBuilder().apply(builderAction).toString()