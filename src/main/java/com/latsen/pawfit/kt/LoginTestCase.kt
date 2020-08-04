package com.latsen.pawfit.kt

import com.latsen.pawfit.Const.Const
import com.latsen.pawfit.common.Driver
import com.latsen.pawfit.common.utils.Tools
import com.latsen.pawfit.driver.MyChromeDriver
import junit.framework.TestCase
import org.junit.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import java.util.*


class LoginTestCase(name: String?) : TestCase(name) {

    companion object {
        var webdriver: MyChromeDriver? = null
        var driver: Driver? = null
        var maps: HashMap<WebElement, String>? =null
        var genericLogin_button: WebElement?=null
    }

    fun init() {
        driver = Driver(Const.LOGiN_URL)
        webdriver = driver?.connect()
        genericLogin_button= webdriver?.findElement(By.id("genericLogin-button"))
        genericLogin_button?.click();

    }

    @Test
    fun testACheckUserName() {
        init()
        var signin_userName = webdriver?.findElement(By.id("signin_userName"))
        signin_userName?.let { maps?.put(it,"1@bccto.me") }
        signin_userName?.sendKeys(Tools.getUUIDText())
        genericLogin_button?.click()
        signin_userName?.let { Tools.injectSQLs(it, genericLogin_button) }
        signin_userName?.sendKeys("30@bccto.me")
        clearText(signin_userName!!)
        signin_userName.sendKeys("35@bccto.me")
    }
    @Test
    fun testBCheckPassword() {
        var signin_password= webdriver?.findElement(By.id("signin_password"))
        var button= webdriver?.findElement(By.id("genericLogin-button"))
        var a=mapOf<WebElement,String>((signin_password to "fk_liekkas0404") as Pair<WebElement, String>)
        signin_password?.let { maps?.put(it,"fk_liekkas0404") }
        signin_password?.sendKeys(Tools.getUUIDText())
        button?.click()
        Thread.sleep(1000)
        signin_password?.let { Tools.injectSQLs(it, button,3000,false) }
        Thread.sleep(1000)
        signin_password?.clear();
        signin_password?.sendKeys("fk_liekkas0404")
        button?.click()
    }
    fun clearText(element: WebElement){
        element.clear()
    }
}