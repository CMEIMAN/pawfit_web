package com.latsen.pawfit.testCase;

import com.latsen.pawfit.Const.Const;
import com.latsen.pawfit.common.NewDriver;
import com.latsen.pawfit.driver.MyChromeDriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebElement;
import java.io.IOException;
import com.latsen.pawfit.utils.JavaTools;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SupportTestCase {
    private static MyChromeDriverSingleton myChromeDriver;
    private static NewDriver driver;
    private static WebElement item;
    private static WebElement item_next;
    private static WebElement prev;
    private static WebElement delivery;
    private static JavaTools javaTools;

    @BeforeClass
    public static void beforeClass() throws IOException {
        System.out.println("已经执行");
        driver = new NewDriver(Const.SUPPORT_URL);
        myChromeDriver = driver.connect();
        javaTools = new JavaTools();
    }

//    进入support页面
    @Test
    public void testASupport() {
////        点击第一个问题
//        item=myChromeDriver.findElementByXPath("/html/body/div[4]/div/ul[1]/div[1]/a");
//        javaTools.click(item);
////        点击下一个
//        item_next=myChromeDriver.findElementByXPath("/html/body/div[4]/div[2]/div[3]/a");
//        javaTools.click(item_next);
////        点击上一个
//        prev=myChromeDriver.findElementByXPath("/html/body/div[4]/div[2]/div[1]/a");
////        prev.click();
//        javaTools.jsclick(myChromeDriver,prev);
//        javaTools.back(myChromeDriver);
//        System.out.println("Support测试成功！");
        javaTools.sleep(5000);
        javaTools.back(myChromeDriver);
 }

// 点击进入Delivery
    @Test
    public void testBDelivery() {
        delivery=myChromeDriver.findElementByXPath("/html/body/div[1]/div[2]/div/div/div/nav/ul/li[4]/section/div/div[2]/div[2]/a");
        javaTools.jsclick(myChromeDriver,delivery);
    }

    @AfterClass
    public static void alterClass(){
        driver.disconnect();
    }
}
