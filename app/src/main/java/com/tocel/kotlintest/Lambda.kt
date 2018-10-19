package com.tocel.kotlintest

data class Person(val name:String,val age:Int)

fun main(args: Array<String>) {
    testConstractor()

    testFilter()

    testMap()

    testSequence()

}

fun testSequence() {
//    val naturalNumbers = generateSequence(0) { it + 1 }.takeWhile {  }
//    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }
    println(generateSequence(0) { it + 1 }.takeWhile {  it <= 100}.sum())
}

//元素的变换
fun testMap() {
    val list = listOf(1,2,3,4)
    println( list.asSequence().javaClass )
    println(list.map { it * it })
}

//filter 过滤
fun testFilter(){
    val list = listOf(1,2,3,4,5,6)
    println(list.filter { it %2 ==0 })

    val people = listOf(Person("Alice",29), Person("Bob",31))
    println(people.filter { it.age > 30 })
}

fun Person.isAdult() = age >= 21

fun testConstractor() {
    val createPerson = ::Person
    val p = createPerson("Alice",2)
    println(p)

    val predicate = Person::isAdult
    println(predicate(p))

    val adult = p.isAdult()
    println(adult)
}


