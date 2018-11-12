package com.tocel.kotlintest

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {

    runBlocking {
        val channel = Channel<Int>()
        launch {
            for (x in 1..5) {
                delay(2000)
                channel.send(x * x)
            }
        }

        repeat(5){
            println("try receive data from channel")
            println(channel.receive())
        }
        println("Done!")
    }
}