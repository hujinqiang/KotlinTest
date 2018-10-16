package com.tocel.kotlintest

class Greeter(val name:String){
    fun greet(){
        println("hello ,$name !")
    }
}

fun main(args: Array<String>) {
    Greeter("tom").greet()
    println(sum(5,12))
    printSum(9,10)
    vars(1,2,4,5,6,7,8,9,0)
    testlambda()

    val a:Int = 1
    val b = 2
    val c:Int
    c = 3

    testNull()

    println(getStringLength(2345))
    println(getStringLength("abcdefghijklmnopqrst"))

    testRange()

    testEquals()

    testArray()

    testString()

    testList()
}

fun testList() {
//    val set = hashSetOf(1,7,45)
//    val list = arrayListOf(1,7,56)
//    val map = hashMapOf(1 to "one",7 to "seven")

    val set = setOf(1,7,45)
    val list = listOf(1,7,56)
    val map = mapOf(1 to "one",7 to "seven")

    println(set.last())
    println(set.max())
    println(set.min())
    println(set.average())

    println(set.javaClass)
    println(list.javaClass)
    println(map.javaClass)

    println(joinToString(set,separator = "?",prefix = "{",postfix = "}"))
    println(joinToString(postfix = ")",prefix = "(",collection = list,separator = "a"))
    println(joinToString(list))
    println(map)
}

fun <T> joinToString(collection: Collection<T>,separator: String = ",", prefix:String = "",postfix:String = ""):String{
    val result = StringBuilder(prefix)

    for ((i,e) in collection.withIndex()){
        if(i > 0){
            result.append(separator)
        }
        result.append(e)
    }
    result.append(postfix)
    return result.toString()
}

fun testString() {
    val  text = """
                    多行字符串
                    多行字符串
                """
    println(text)

    val i = 10

    val s = "i = $i"

    println(s)

    val s1 = "runoob"

    val str = "$s1.length is ${s1.length}"

    println(str)

    val price = "${'$'}9.99"
    val price1 = "$9.99"
    println(price)
    println(price1)
}

fun testArray() {
    println()
    val a = arrayOf(1,2,3,4,5)
    val b = Array(7,{i ->(i)})
    println(a[0])
//    println(a[5])
}

fun testEquals() {
    val a = "abc"
    val b = "cde"
    print(b === a)
}

fun testRange() {
    for(i in 1..10) print(i)

    print("循环输出：")
    for (i in 1..4) print(i) // 输出“1234”
    println("\n----------------")
    print("设置步长：")
    for (i in 1..4 step 2) print(i) // 输出“13”
    println("\n----------------")
    print("使用 downTo：")
    for (i in 4 downTo 1 step 2) print(i) // 输出“42”
    println("\n----------------")
    print("使用 until：")
    // 使用 until 函数排除结束元素
    for (i in 1 until 4) {   // i in [1, 4) 排除了 4
        print(i)
    }
    println("\n----------------")

}

fun getStringLength(obj:Any):Int ?{
//    if(obj is String){
//        return obj.length
//    }
//
//    return null

    if(obj !is String){
        return null
    }
    return obj.length
}

fun testNull() {
    var a:Int?
}

fun testlambda(){
    val sumLambda:(Int,Int) -> Int = { x,y -> x * y}
    println(sumLambda(4,5))
}

//fun sum(a:Int ,b:Int) :Int{
//    return a + b
//}

fun sum(a:Int,b:Int) = a+b

fun printSum(a:Int,b:Int){
    println(a+b)
}

fun vars(vararg v:Int){
    for(vt in v){
        println(vt)
    }
}