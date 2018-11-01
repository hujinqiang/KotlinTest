package com.tocel.kotlintest

enum class Color{
    RED,ORANGE,YELLOW,GREEN,BLUE,INDIGO,VIOLET
}

fun main(args: Array<String>) {
    println(getMenemonic(Color.BLUE))
}

fun getMenemonic(color: Color) =
    when (color){
        Color.RED -> "Richard"
        Color.ORANGE -> "of"
        Color.YELLOW -> "York"
        Color.GREEN -> "Gave"
        Color.BLUE -> "Battle"
        Color.INDIGO -> "In"
        Color.VIOLET -> "Vain"
    }
