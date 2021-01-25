package com.latsen.pawfit.testCase;
import com.latsen.pawfit.Const.Const;
import com.latsen.pawfit.common.NewDriver;
import com.latsen.pawfit.driver.MyChromeDriverSingleton;
import com.latsen.pawfit.utils.JavaTools;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Bundle_dealTestCase {
    private static MyChromeDriverSingleton myChromeDriver;
    private static NewDriver driver;
    private static JavaTools javaTools;
    private static WebElement btn1;
    private static WebElement btn2;
    private static WebElement btn3;
    private static WebElement img1;
    private static WebElement img2;
    private static WebElement img3;
    private static WebElement vedio;
    private static WebElement close;
    @BeforeClass
    public static void beforeClass() throws IOException {
        System.out.println("已经执行");
        driver = new NewDriver(Const.PAWFIT2_BUNDLE_DEAL);
        myChromeDriver = driver.connect();
        javaTools=new JavaTools();

        btn1=myChromeDriver.findElementByXPath("/html/body/section/section[3]/div/div/div/div/p[3]/button");
        btn2=myChromeDriver.findElementByXPath("/html/body/section/div[2]/div/div/div/div[1]/div[1]/div/div[2]/div/div[2]/div/h4/button");
        btn3=myChromeDriver.findElementByXPath("/html/body/section/div[4]/div/p[3]/button");
        img1=myChromeDriver.findElementByXPath("/html/body/section/div[2]/div/div/div/div[1]/div[1]/div/div[1]/ul/li[2]/a/img");
        img2=myChromeDriver.findElementByXPath("/html/body/section/div[2]/div/div/div/div[1]/div[1]/div/div[1]/ul/li[3]/a/img");
        img3=myChromeDriver.findElementByXPath("/html/body/section/div[2]/div/div/div/div[1]/div[1]/div/div[1]/ul/li[1]/a/img");
        vedio=myChromeDriver.findElementByXPath("/html/body/section/div[2]/div/div/div/div[1]/div[1]/div/div[1]/ul/li[4]/div/div/div/div/img[1]");
        close=myChromeDriver.findElementByXPath("/html/body/div[3]/div/div/div[1]/img");
    }

    @Test
    public void testAClick() throws IOException {
        javaTools.scrFile(myChromeDriver);
        javaTools.jsclick(myChromeDriver,btn1);
        javaTools.jsclick(myChromeDriver,btn2);
        javaTools.jsclick(myChromeDriver,btn3);
    }

    @Test
    public void testBClick(){
        javaTools.jsclick(myChromeDriver,img1);
        javaTools.jsclick(myChromeDriver,img2);
        javaTools.jsclick(myChromeDriver,img3);
        javaTools.click(close);
    }

    @AfterClass
    public static void alterClass(){
        driver.disconnect();
    }

}
