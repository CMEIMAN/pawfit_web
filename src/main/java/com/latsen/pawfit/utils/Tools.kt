package com.latsen.pawfit.utils

import com.latsen.pawfit.kt.LoginTestCase.Companion.driver
import org.openqa.selenium.*
import java.io.File
import java.util.*
import org.testng.internal.Utils
import ru.yandex.qatools.ashot.AShot
import ru.yandex.qatools.ashot.shooting.ShootingStrategies
import ru.yandex.qatools.ashot.shooting.ShootingStrategy
import java.lang.Exception
import java.sql.Time
import javax.imageio.ImageIO


class Tools {
    companion object {
        /**
         * 截取浏览器界面
         */
        @JvmStatic
        fun scrFile() {
            val date = System.currentTimeMillis()
            var path = date.toString()
            val curPath = System.getProperty("user.dir")
            path = "$path.png"
            val screenPath = "$curPath/$path"
            val screen = (driver as TakesScreenshot).getScreenshotAs(OutputType.FILE)
            Utils.copyFile(screen, File(screenPath))
        }

        /**
         *填充测试数据，获取UUID并设置
         * element：需要设置的文本框
         * btn：设置后点击提交按钮
         *
         */
        @JvmStatic
        fun setAllText(element: WebElement, btn: WebElement, str: String) {
            element.sendKeys(str, Tools.getUUIDText())
            btn.click()
            element.clear()
        }

        /**
         * 清空输入框文本
         * map；用于装载控件元素及数据
         */
        @JvmStatic
        fun clearText(maps: HashMap<WebElement, String>) {
            for ((key) in maps) {
                key.clear()
            }
        }

        /**
         * 填充文本框
         * map；用于装载控件元素及数据
         */
        @JvmStatic
        fun setText(maps: HashMap<WebElement, String>) {
            for ((key, value) in maps) {
                key.sendKeys(value)
            }
        }

        /**
         * 生成随机uuid文本
         */
        @JvmStatic
        fun getUUIDText(): String {
            var str = ""
            for (i in 0..99) {
                str = UUID.randomUUID().toString()
            }
            return str
        }

        /**
         * SQL文本注入
         * element：输入文本框
         * element_btn，提交按钮
         * times：等待时间，加入延時，避免執行太快，出現控件查找異常
         * clear：是否清空文本框
         * list_data：SQL数据
         */
        @JvmStatic
        fun injectSQLs(element: WebElement, element_btn: WebElement? = null, times: Long = 0, clear: Boolean = true, list_data: Array<String>) {
            val strings = list_data;
            for (i in strings.indices) {
                if (i > strings.size - 3) {
                    println(strings[i])
                    element.sendKeys(strings[i])
                    try {
                        element_btn?.click()
                    } catch (e: WebDriverException) {
                        print(e)
                    }

                    Thread.sleep(times)
                } else {
                    element.sendKeys(strings[i])
                    if (clear) {
                        element.clear()
                    }
                    Thread.sleep(times)
                    try {
                        element_btn?.click()
                    } catch (e: WebDriverException) {
                        print(e)
                    }
                }

            }
            element.clear()

        }

        @JvmStatic
        fun takeEntirePage(driver: WebDriver, imgName: String, path: String) {
            val img = AShot()
                    .shootingStrategy(ShootingStrategies.viewportPasting(100))
                    .takeScreenshot(driver).image
            ImageIO.write(img, "png", File(path + imgName + ".png"))

        }

        @JvmStatic
        fun takeOneWebElement(driver: WebDriver, webElement: WebElement, eleName: String, path: String) {
            var img = AShot().takeScreenshot(driver, webElement).image
            ImageIO.write(img, "png", File(path + eleName + ".png"))
        }

        @JvmStatic
        fun main(args: Array<String>) {
            var s = Tools.getUUIDText()
            print(s)
        }

        /**
         * webDriver:驱动类
         * webElementName：元素名称
         * timeout：超时，用于控制元素查找时间，如果时间结束都没找到，返回false
         */
        @JvmStatic
        fun checkElementExistsById(webDriver: WebDriver, webElementName: String, timeout: Int = 1): Boolean {
            var exists = false;
            var i = 1;
            while (timeout > i) {
                try {
                    exists = webDriver.findElement(By.id(webElementName)) != null
                } catch (exception: Exception) {
                    println(exception.message)
                    Thread.sleep(1000)
                    i++;
                    continue;
                }

            }
            return exists;
        }
        /**
         * webDriver:驱动类
         * webElementName：元素名称
         * timeout：超时，用于控制元素查找时间，如果时间结束都没找到，返回false
         * whatmethod：根据那种类型查找元素
         */
        @JvmStatic
        fun checkElementExists(webDriver: WebDriver, webElementName: String, timeout: Int = 1, whatMethod: String = "id"): Boolean {
            var flag=false
            var i=1
            while (timeout>i){
                try {

                    if (whatMethod.equals("id")) {
                        webDriver.findElement(By.id(webElementName))
                    } else if (whatMethod.equals("xpath")) {
                        webDriver.findElement(By.xpath(webElementName))
                    } else if (whatMethod.equals("class")) {
                        webDriver.findElement(By.className(webElementName))
                    } else if (whatMethod.equals("css")) {
                        webDriver.findElement(By.ByCssSelector(webElementName))
                    } else if (whatMethod.equals("text")) {
                        webDriver.findElement(By.linkText(webElementName))
                    } else if (whatMethod.equals("tag")) {
                        webDriver.findElement(By.tagName(webElementName))
                    }
                    flag = true
                    Thread.sleep(1000)
                    return flag;
                }
                catch (exception:Exception){
                    print(exception.message)
                    i+=1
                    Thread.sleep(1)
                    continue
                }
                }
            return false
            }
        }

}