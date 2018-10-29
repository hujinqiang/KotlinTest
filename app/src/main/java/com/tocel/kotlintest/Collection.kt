package com.tocel.kotlintest

fun main(args: Array<String>) {

    for (i in args.indices){
        println("$i ${args[i]}")
    }

    args.forEachIndexed {
            index,element -> println("$index   $element")
    }

    testArray1()

    testAES()

    printSum(listOf(1,2,3))
    printSum(listOf("a","b","c"))
}

fun printSum(c :Collection<*>){
    val intList = c as? List<Int> ?: throw IllegalArgumentException("List is expected")
    println(intList.sum())
}

fun testAES() {

}

fun testArray1() {
    val letters = Array(26){ i -> ('a'+i).toString() }
    println(letters.joinToString(""))

    val strings = listOf("a","b","c")
    println("%s/%s/%s".format(*strings.toTypedArray()))
}
