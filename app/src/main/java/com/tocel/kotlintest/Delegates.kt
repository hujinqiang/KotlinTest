package com.tocel.kotlintest

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.properties.Delegates

val lazyString:String by lazy(LazyThreadSafetyMode.NONE) {
    Thread.sleep(200)
    println("set value")
    "Hello"
}
fun main(args: Array<String>) {

    println(lazyString)
    GlobalScope.launch {
        println(lazyString)
    }
    println(lazyString)
    println(lazyString)

    val user = User()
    user.name = "first"
    user.name = "second"
}

class User{
    var name :String by Delegates.observable("normalName"){
        prop,old,new -> println("$old -> $new")
    }
}