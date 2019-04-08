package com.tocel.kotlintest

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking

fun CoroutineScope.produceSquares():ReceiveChannel<Int> = produce {
    for (x in 1..5)send(x * x)
}

fun main(args: Array<String>) {

    runBlocking {
        val channel = produceSquares()
        channel.consumeEach { println(it) }

//        repeat(5){
//            println("try receive data from channel")
//            println(channel.receive())
//        }
        println("Done!")
    }
}