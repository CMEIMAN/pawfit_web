package com.latsen.pawfit.common.utils

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
        fun injectSQLs(element: WebElement,element_btn: WebElement?=null,times:Long=0,clear:Boolean=true) {
            val strings = arrayOf("and ascii(substr((select database()),1,1))>64", "id=1 union select if(SUBSTRING(user(),1,4)='root',sleep(4),1),null,null", "id =-1 union select 1,2,3", "id=1' substr(database(),1,1)='t'--+", "union select count(*),2,concat(':',(select database()),':',floor(rand()*2))as a from information_schema.tables group by a", "id=1 and (extractvalue(1,concat(0x7e,(select user()),0x7e)))")
            for (i in strings.indices) {
                if (i > strings.size - 2) {
                    element.sendKeys(strings[i])
                    element_btn?.click()
                    Thread.sleep(times)
                } else {
                    element.sendKeys(strings[i])
                    if (clear){
                        element.clear()
                    }
                    Thread.sleep(times)
                    element_btn?.click()
                }

            }
            element.clear()

        }

    }
}