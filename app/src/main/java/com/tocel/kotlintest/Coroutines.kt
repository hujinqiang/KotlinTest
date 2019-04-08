package com.tocel.kotlintest

import kotlinx.coroutines.*

fun main(args: Array<String>) {
//    launchTest()

//    main1()
//    blockCoroutine()
    repeatTest()

//    printHeat()

}


fun printHeat() = runBlocking{
    for(i in 0 until 10){
        launch {
            delay(10000L - i * 1000)
            print("❤$i ")
        }
    }
}

fun repeatTest() = runBlocking {
    repeat(1000000){
        launch {
            delay(1000)
            println(".")
        }
    }

//    GlobalScope.launch {
//        repeat(1000){
//            println("I'm sleeping $it ...")
//            delay(500)
//        }
//    }
    delay(1300)
}

fun blockCoroutine() = runBlocking {
    launch {
        delay(200L)
        println("Task from runBlocking")
    }

    coroutineScope {
        launch {
            delay(500)
            println("Task from nested launch")
        }

        delay(100)
        println("Task from coroutine scope")
    }

    println("Coroutine scope is over")
}

private fun launchTest() {
    GlobalScope.launch {
        delay(1000L)
        println("World!")
    }
    println("Hello,")
//    Thread.sleep(2000)

    runBlocking {
        delay(2000L)
    }
}

fun main1() = runBlocking {
    launch {
        doWorld()
    }
    println("Hello,")
}


fun main() = runBlocking {
    val job = GlobalScope.launch {
        doWorld()
    }

    println("hello")

    job.join()
//    delay(2000L)
}

private suspend fun doWorld() {
    delay(1000L)
    println("world!")
}
