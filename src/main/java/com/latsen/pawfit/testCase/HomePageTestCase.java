package com.latsen.pawfit.testCase;

import com.latsen.pawfit.Const.Const;
import com.latsen.pawfit.common.Driver;
import com.latsen.pawfit.common.NewDriver;
import com.latsen.pawfit.driver.MyChromeDriver;
import com.latsen.pawfit.driver.MyChromeDriverSingleton;

import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.junit.runners.MethodSorters;
import java.io.IOException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HomePageTestCase {
    private static NewDriver driver;
    private static MyChromeDriverSingleton myChromeDriver;
    private static WebElement walk_learn_more;
    private static WebElement shop_now;
    private static WebElement about_pawfit;
    private static WebElement register;
    private static WebElement google_play;
    private static WebElement app_store;
    private static WebElement watch;
    private static WebElement wear;
    private static WebElement p2_learn_more;
    private static WebElement p2_add;
    private static WebElement pawfit_collar;
    private static WebElement story_learn_more;
    private static WebElement latsen_articles;
    private static WebElement read_all_articel1;
    private static WebElement read_all_articel2;
    private static WebElement read_all_articel3;
    private static WebElement read_all_articel;

   @BeforeClass
    public static void beforeClass() throws IOException {
        driver=new NewDriver(Const.HOME_URL);
        myChromeDriver=driver.connect();
//        walk_learn_more=myChromeDriver.findElementByXPath("/html/body/section[1]/div[1]/div/div/a/button");
    }
    @Test
    public void testAClick1() {
//        System.out.println("点击learn more到遛狗界面");
//        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",walk_learn_more);
//        myChromeDriver.navigate().back();

        System.out.println("点击SHOP NOW");
        shop_now=myChromeDriver.findElementByXPath("/html/body/section[1]/div/div[2]/div/div/a/button");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",shop_now);
        myChromeDriver.navigate().back();

        System.out.println("点击about pawfit");
        about_pawfit=myChromeDriver.findElementByXPath("/html/body/section[2]/div/div/div[2]/div[2]/a");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",about_pawfit);
        myChromeDriver.navigate().back();

        System.out.println("点击注册");
        register=myChromeDriver.findElementByXPath("/html/body/section[3]/div[1]/div[2]/div/div/div/a");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",register);
        myChromeDriver.navigate().back();
    }

    @Test
    public void testBClick2() {
        System.out.println("点击跳转到谷歌");
        google_play=myChromeDriver.findElementByXPath("/html/body/section[4]/div/div/div[2]/div[1]/a/img");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",google_play);
        myChromeDriver.navigate().back();
        System.out.println("点击跳转到app store");
        app_store=myChromeDriver.findElementByXPath("/html/body/section[4]/div/div/div[2]/div[2]/a/img");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",app_store);
        myChromeDriver.navigate().back();

        System.out.println("点击跳转watch");
        watch=myChromeDriver.findElementByXPath("/html/body/section[5]/div/div[3]/div/div/div[1]/a[1]");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",watch);
        myChromeDriver.navigate().back();
        System.out.println("点击跳转到wear");
        wear=myChromeDriver.findElementByXPath("/html/body/section[5]/div/div[3]/div/div/div[1]/a[2]");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",wear);
        myChromeDriver.navigate().back();
    }

    @Test
    public void testCClick3() {
        System.out.println("点击pawfit 2模块");
        p2_learn_more=myChromeDriver.findElementByXPath("/html/body/section[6]/div/div/div[1]/div/div/div[3]/div[2]/a[1]/button");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",p2_learn_more);
        myChromeDriver.navigate().back();
        p2_add=myChromeDriver.findElementByXPath("/html/body/section[6]/div/div/div[1]/div/div/div[3]/div[2]/a[2]/button");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",p2_add);
        pawfit_collar=myChromeDriver.findElementByXPath("/html/body/section[7]/div/div/div/div/div[2]/div/div[3]/a/button");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",pawfit_collar);
        myChromeDriver.navigate().back();

        System.out.println("点击learn more跳转到story");
        story_learn_more=myChromeDriver.findElementByXPath("/html/body/section[10]/div/div/div[1]/p[1]/a");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",story_learn_more);
        myChromeDriver.navigate().back();
    }

    @Test
    public void testDClick4() {
        System.out.println("点击跳转到articles");
        latsen_articles=myChromeDriver.findElementByXPath("/html/body/section[11]/div/div[1]/h3/a");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",latsen_articles);
        myChromeDriver.navigate().back();

        read_all_articel=myChromeDriver.findElementByXPath("/html/body/section[11]/div/div[3]/div/a");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",read_all_articel);
        myChromeDriver.navigate().back();

        read_all_articel1=myChromeDriver.findElementByXPath("/html/body/section[11]/div/div[2]/div[1]/div[2]/a");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",read_all_articel1);
        myChromeDriver.navigate().back();

        read_all_articel2=myChromeDriver.findElementByXPath("/html/body/section[11]/div/div[2]/div[2]/div[2]/a");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",read_all_articel2);
        myChromeDriver.navigate().back();

        read_all_articel3=myChromeDriver.findElementByXPath("/html/body/section[11]/div/div[2]/div[3]/div[2]/a");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",read_all_articel3);
        myChromeDriver.navigate().back();
    }

    @AfterClass
    public static void alterClass(){
       driver.disconnect();
    }

}
