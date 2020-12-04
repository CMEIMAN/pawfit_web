package com.latsen.pawfit.testCase;

import com.latsen.pawfit.Const.Const;
import com.latsen.pawfit.common.Driver;
import com.latsen.pawfit.driver.MyChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import java.io.IOException;

public class How_it_worksTestCase {
    private static WebElement live;
    private static WebElement live_close;
    private static WebElement light_sound;
    private static WebElement light_sound_close;
    private static WebElement active;
    private static WebElement active_close;
    private static WebElement rest;
    private static WebElement rest_close;
    private static WebElement calories;
    private static WebElement calories_close;
    private static WebElement distance;
    private static WebElement distance_close;
    private static WebElement temperature;
    private static WebElement temperature_close;
    private static WebElement removal;
    private static WebElement removal_close;
    private static WebElement virtual_fence;
    private static WebElement virtual_fence_close;
    private static WebElement walk_btn1;
    private static WebElement walk_btn2;
    private static WebElement app_store;
    private static WebElement google_play;
    private static MyChromeDriver myChromeDriver;
    private static Driver driver;

    @BeforeClass
    public static void beforeClass() throws IOException {
        System.out.println("已经执行");
        driver = new Driver(Const.HOW_URL);
        myChromeDriver = driver.connect();
        live=myChromeDriver.findElementByXPath("/html/body/div[3]/div[2]/div/div[2]/div/div/button[1]");
        live_close=myChromeDriver.findElementByXPath("/html/body/div[4]/div/div/div[1]/button/span");
        light_sound=myChromeDriver.findElementByXPath("/html/body/div[3]/div[2]/div/div[2]/div/div/button[2]");
        light_sound_close=myChromeDriver.findElementByXPath("/html/body/div[4]/div/div/div[1]/button/span");
        active=myChromeDriver.findElementByXPath("/html/body/div[3]/div[3]/div/div/div[2]/div/button[1]");
        active_close=myChromeDriver.findElementByXPath("/html/body/div[4]/div/div/div[1]/button/span");
        rest=myChromeDriver.findElementByXPath("/html/body/div[3]/div[3]/div/div/div[2]/div/button[2]");
        rest_close=myChromeDriver.findElementByXPath("/html/body/div[4]/div/div/div[1]/button/span");
        calories=myChromeDriver.findElementByXPath("/html/body/div[3]/div[3]/div/div/div[2]/div/button[3]");
        calories_close=myChromeDriver.findElementByXPath("/html/body/div[4]/div/div/div[1]/button/span");
        distance=myChromeDriver.findElementByXPath("/html/body/div[3]/div[3]/div/div/div[2]/div/button[4]");
        distance_close=myChromeDriver.findElementByXPath("/html/body/div[4]/div/div/div[1]/button/span");
        temperature=myChromeDriver.findElementByXPath("/html/body/div[3]/div[4]/div/div/div[2]/div/button[1]");
        temperature_close=myChromeDriver.findElementByXPath("/html/body/div[4]/div/div/div[1]/button/span");
        removal=myChromeDriver.findElementByXPath("/html/body/div[3]/div[4]/div/div/div[2]/div/button[2]");
        removal_close=myChromeDriver.findElementByXPath("/html/body/div[4]/div/div/div[1]/button/span");
        virtual_fence=myChromeDriver.findElementByXPath("/html/body/div[3]/div[4]/div/div/div[2]/div/button[3]");
        virtual_fence_close=myChromeDriver.findElementByXPath("/html/body/div[4]/div/div/div[1]/button/span");

        walk_btn1=myChromeDriver.findElementByXPath("/html/body/div[3]/div[6]/div/div/div[1]/div[1]/button[1]");
        walk_btn2=myChromeDriver.findElementByXPath("/html/body/div[3]/div[6]/div/div/div[1]/div[1]/button[2]");
        app_store=myChromeDriver.findElementByXPath("/html/body/div[3]/div[9]/div/div/div[2]/div/a[1]");
    }

    @Test
    public void testAClick() {
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",live);
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",live_close);
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",light_sound);
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",light_sound_close);
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",active);
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",active_close);
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",rest);
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",rest_close);
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",calories);
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",calories_close);
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",distance);
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",distance_close);
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",temperature);
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",temperature_close);
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",removal);
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",removal_close);
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",virtual_fence);
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",virtual_fence_close);
//        walk模块按钮切换
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",walk_btn1);
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",walk_btn2);
//        APP
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",app_store);
        myChromeDriver.navigate().back();
        google_play=myChromeDriver.findElementByXPath("/html/body/div[3]/div[9]/div/div/div[2]/div/a[2]/img");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",google_play);
        myChromeDriver.navigate().back();

        System.out.println("测试完成！");
    }
    @AfterClass
    public static void alterClass(){
        driver.disconnect();
    }

}
