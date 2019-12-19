package com.latsen.pawfit.kt

fun main(args: Array<String>) {
    println("hello world")
    var num = Num(100, 10000L);
    println(sum(num.a, num.b))
    println(sum())
    println("a+b的和是${sum()}")
    var listUnm= listOf<Int>(1,3,5,7)
    for (num:Int in listUnm){
        println(num)
    }
}

fun sum(a: Int = 100, b: Long = 200) = a + b;
fun maxOF(a: Int, b: Int) = if (a > b) a else b;
fun stirngOfLength(s: Any): Int? {
    if (s is String) return s.length else return null
}

data class Num(val a: Int, val b: Long) {
    companion object {
        @JvmStatic
        fun sum(n: Num) = n.a + n.b
    }
}
