package com.latsen.pawfit.testCase;

import com.latsen.pawfit.Const.Const;
import com.latsen.pawfit.common.Driver;
import com.latsen.pawfit.driver.MyChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebElement;
import java.io.IOException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AccessoryTestCase {
    private static WebElement pawfit_collar;
    private static WebElement collar_attachment;
    private static WebElement collar_attachment_add;
    private static WebElement collar_strap;
    private static WebElement collar_strap_add;
    private static WebElement charging;
    private static WebElement charging_add;
    private static Driver driver;
    private static MyChromeDriver myChromeDriver;

    @BeforeClass
    public static void beforeClass() throws IOException {
        System.out.println("已经执行");
        driver = new Driver(Const.ACCESSORY_URL);
        myChromeDriver = driver.connect();
        pawfit_collar=myChromeDriver.findElementByXPath("/html/body/div[4]/div/div/div/div/div[2]/div/div[3]/a/button");
    }

    @Test
    public void testAClick() {
        System.out.println("点击pawfit collar的learn more");
        pawfit_collar.click();
        myChromeDriver.navigate().back();

        //定位元素并点击
        collar_attachment=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/div/div/div[1]/div/div/div[3]/a/button");
        collar_attachment_add=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/div/div/div[1]/div/div/div[3]/button");
        System.out.println("点击collar attachment加入购物车");
        collar_attachment_add.click();
        System.out.println("点击collar attachment的learn more");
        collar_attachment.click();
        myChromeDriver.navigate().back();

        //定位元素并点击
        collar_strap=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/div/div/div[2]/div/div/div[3]/a/button");
        collar_strap_add=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/div/div/div[2]/div/div/div[3]/button");
        System.out.println("点击collar strap加入购物车");
        collar_strap_add.click();
        System.out.println("点击collar strap的learn more");
        collar_strap.click();
        myChromeDriver.navigate().back();

        //定位元素并点击
        charging=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/div/div/div[3]/div/div/div[3]/a/button");
        charging_add=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/div/div/div[3]/div/div/div[3]/button");
        System.out.println("点击Charging Dock and Cable加入购物车");
        charging_add.click();
        System.out.println("点击Charging Dock and Cable 的learn more");
        charging.click();
        myChromeDriver.navigate().back();
    }
    @AfterClass
    public static void alterClass(){
        driver.disconnect();
    }

}
