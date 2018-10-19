package com.tocel.kotlintest

fun main(args: Array<String>) {
    testArray1()
}

fun testArray1() {
    val letters = Array(26){ i -> ('a'+i).toString() }
    println(letters.joinToString(""))

    val strings = listOf("a","b","c")
    println("%s/%s/%s".format(*strings.toTypedArray()))
}
