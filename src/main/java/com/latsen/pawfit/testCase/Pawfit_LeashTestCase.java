package com.latsen.pawfit.testCase;

import com.latsen.pawfit.Const.Const;
import com.latsen.pawfit.common.NewDriver;
import com.latsen.pawfit.driver.MyChromeDriverSingleton;
import com.latsen.pawfit.utils.JavaTools;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class Pawfit_LeashTestCase {
    private static MyChromeDriverSingleton myChromeDriver;
    private static NewDriver driver;
    private static JavaTools javaTools;
    private static WebElement btn1;
    private static WebElement btn2;
    private static WebElement btn3;
    private static WebElement img1;
    private static WebElement img2;
    private static WebElement img3;
    private static WebElement img4;

    @BeforeClass
    public static void beforeClass() throws IOException {
        System.out.println("已经执行");
        driver = new NewDriver(Const.PAWFIT_LEASH);
        myChromeDriver = driver.connect();
        javaTools=new JavaTools();

        btn1= myChromeDriver.findElementByXPath("/html/body/section/div[2]/div/div/div/div[1]/div/div/div[2]/div/div[2]/div/div[1]/button");
        btn2= myChromeDriver.findElementById("circle2FF7C12");
        btn3= myChromeDriver.findElementById("circle2414040");
        img1= myChromeDriver.findElementByXPath("/html/body/section/div[2]/div/div/div/div[1]/div/div/div[1]/ul/li[1]/a/img");
        img2= myChromeDriver.findElementByXPath("/html/body/section/div[2]/div/div/div/div[1]/div/div/div[1]/ul/li[2]/a/img");
        img3= myChromeDriver.findElementByXPath("/html/body/section/div[2]/div/div/div/div[1]/div/div/div[1]/ul/li[3]/a/img");
        img4= myChromeDriver.findElementByXPath("/html/body/section/div[2]/div/div/div/div[1]/div/div/div[1]/ul/li[4]/a/img");
    }

    @Test
    public void testAClick(){
        javaTools.click(btn2);
        javaTools.click(btn3);
        javaTools.sleep(2000);
        javaTools.click(btn1);
        javaTools.click(btn3);
        javaTools.sleep(2000);
    }

    @Test
    public void testBClick(){
        javaTools.jsclick(myChromeDriver,img2);
        javaTools.jsclick(myChromeDriver,img3);
        javaTools.jsclick(myChromeDriver,img4);
        javaTools.jsclick(myChromeDriver,img1);
    }

    @AfterClass
    public static void alterClass(){
        driver.disconnect();
    }
}
