package com.latsen.pawfit.testCase;

import com.latsen.pawfit.Const.Const;
import com.latsen.pawfit.common.NewDriver;
import com.latsen.pawfit.driver.MyChromeDriverSingleton;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebElement;
import java.io.IOException;
import com.latsen.pawfit.utils.JavaTools;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Accessory2TestCase{
    private static WebElement collar_attachment;
    private static WebElement collar_attachment_add;
    private static WebElement collar_strap;
    private static WebElement collar_strap_add;
    private static WebElement charging;
    private static WebElement charging_add;
    private static NewDriver driver;
    private static MyChromeDriverSingleton myChromeDriver;
    private static JavaTools javaTools;

    @BeforeClass
    public static void beforeClass() throws IOException {
        javaTools = new JavaTools();
        System.out.println("已经执行");
        driver = new NewDriver(Const.ACCESSORY2_URL);
        myChromeDriver = driver.connect();
    }

    @Test
    public void testAClick() {
        //定位元素并点击
        collar_attachment=myChromeDriver.findElementByXPath("/html/body/div[4]/div/div/div/div/div[2]/div/div/div[3]/a/button");
        collar_attachment_add=myChromeDriver.findElementByXPath("/html/body/div[4]/div/div/div/div/div[2]/div/div/div[3]/button");
        System.out.println("点击collar attachment加入购物车");
        javaTools.click(collar_attachment_add);
        System.out.println("点击collar attachment的learn more");
        javaTools.click(collar_attachment);
        javaTools.back(myChromeDriver);
    }

    @Test
    public void testBClick() {
//定位元素并点击
        collar_strap=myChromeDriver.findElementByXPath("/html/body/div[4]/div/div/div/div/div[1]/div/div/div[3]/a/button");
        collar_strap_add=myChromeDriver.findElementByXPath("/html/body/div[4]/div/div/div/div/div[1]/div/div/div[3]/button");
        System.out.println("点击collar strap加入购物车");
        javaTools.click(collar_strap_add);
        System.out.println("点击collar strap的learn more");
        javaTools.click(collar_strap);
        javaTools.back(myChromeDriver);
    }

    @Test
    public void testCClick() {
//定位元素并点击
        charging=myChromeDriver.findElementByXPath("/html/body/div[4]/div/div/div/div/div[3]/div/div/div[3]/a/button");
        charging_add=myChromeDriver.findElementByXPath("/html/body/div[4]/div/div/div/div/div[3]/div/div/div[3]/button");
        System.out.println("点击Charging Dock and Cable加入购物车");
        javaTools.click(charging_add);
        System.out.println("点击Charging Dock and Cable 的learn more");
        javaTools.click(charging);
        javaTools.back(myChromeDriver);
    }

    @AfterClass
    public static void alterClass(){
        driver.disconnect();
    }

}
