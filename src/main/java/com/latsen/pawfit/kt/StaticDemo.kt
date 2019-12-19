package com.latsen.pawfit.kt

class StaticDemo{
    companion object {
        const val STATICSTR:String="我是静态变量"
        fun staticMethod(a:Int,b:Int) :Int=a+b;
    }
    fun replaceString(a:String,b:String):String{
        return a+b
    }
}