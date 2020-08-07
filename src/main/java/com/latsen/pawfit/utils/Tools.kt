package com.latsen.pawfit.utils

import org.openqa.selenium.WebDriverException
import org.openqa.selenium.WebElement
import java.util.*

class Tools{
    companion object {
        @JvmStatic
        fun getUUIDText(): String {
            var str = ""
            for (i in 0..99) {
                str = UUID.randomUUID().toString()
            }
            return str
        }
        @JvmStatic
        fun injectSQLs(element: WebElement,element_btn: WebElement?=null,times:Long=0,clear:Boolean=true,list_data:Array<String>) {
            val strings =list_data;
            for (i in strings.indices) {
                if (i > strings.size - 3) {
                    println(strings[i])
                    element.sendKeys(strings[i])
                    try {
                        element_btn?.click()
                    }
                    catch(e: WebDriverException){
                        print(e)
                    }

                    Thread.sleep(times)
                } else {
                    element.sendKeys(strings[i])
                    if (clear){
                        element.clear()
                    }
                    Thread.sleep(times)
                    try {
                        element_btn?.click()
                    }
                    catch(e: WebDriverException){
                        print(e)
                    }
                }

            }
            element.clear()

        }

    }
}