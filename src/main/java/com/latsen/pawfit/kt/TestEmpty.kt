package com.latsen.pawfit.kt

import java.sql.Time

class TestEmpty(val name: String, val age: Int) {
    var email:String ="140"
    var set_1= listOf<String>("1","2","3")
    var time :Time =Time(1000);
    companion object {
        const val email: String = " good"

        @JvmStatic
        fun helloWorld(a: Int, b: Int): Int = a + b;
    }

    constructor(name: String, age: Int, address: String, parent: TestEmpty) : this(name, age) {
    }
    constructor(name: String, age: Int ,parent: TestEmpty):this(name,age){}
}