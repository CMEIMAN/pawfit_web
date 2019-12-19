package com.latsen.pawfit.demo;

import com.latsen.pawfit.kt.StaticDemo;

public class Demo {
    private static int  s=StaticDemo.Companion.staticMethod(100,200);
    private static StaticDemo demo=new StaticDemo();

    public static void main(String[] args) {
        System.out.println(demo.replaceString("100","200"));
        System.out.println(s);
        System.out.println(StaticDemo.STATICSTR);
    }
}
