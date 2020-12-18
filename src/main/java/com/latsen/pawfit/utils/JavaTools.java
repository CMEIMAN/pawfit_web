package com.latsen.pawfit.utils;
import com.latsen.pawfit.common.NewDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.latsen.pawfit.driver.MyChromeDriverSingleton;
import com.latsen.pawfit.Const.Const;


public class JavaTools {
    static boolean flog = true;
    public static boolean currentFlog() {
        return flog;
    }
    private static NewDriver driver;
    private static MyChromeDriverSingleton myChromeDriver;

    /*
     * 封装断言
     */
    public static void setFlag(boolean flog) {
        JavaTools.flog = flog;
    }
    public void verifyassert(Object actual, Object expected) {
        try {
            Assert.assertEquals(actual, expected);
        } catch (Error e) {
            // TODO: handle exception
            e.printStackTrace();
            //抛出异常时记录flog=false;
            setFlag(false);
        }
    }

    public void verifyassert(Object actual, Object expected, String message) {
        try {
            Assert.assertEquals(actual, expected, message);
        } catch (Error e) {
            // TODO: handle exception
            //仅仅代表异常消息的输出
            e.printStackTrace();
            //抛出异常时记录flog=false
            setFlag(false);
        }
    }


//通过js点击
     public void clickByJs(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
        //第二种点击方法
         //        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", question);
            }





}
