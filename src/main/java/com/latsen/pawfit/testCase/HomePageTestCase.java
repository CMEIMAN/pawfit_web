package com.latsen.pawfit.testCase;

import com.latsen.pawfit.Const.Const;
import com.latsen.pawfit.common.NewDriver;
import com.latsen.pawfit.driver.MyChromeDriverSingleton;
import org.junit.*;
import org.openqa.selenium.WebElement;
import org.junit.runners.MethodSorters;
import java.io.IOException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.latsen.pawfit.utils.JavaTools;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HomePageTestCase {
    private static NewDriver driver;
    private static MyChromeDriverSingleton myChromeDriver;
    private static JavaTools javaTools;
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
    private static WebElement accessory;
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
        javaTools=new JavaTools();
//        walk_learn_more=myChromeDriver.findElementByXPath("/html/body/section[1]/div[1]/div/div/a/button");
    }
    @Test
    public void testAClick1() {
//        System.out.println("点击learn more到遛狗界面");
//        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",walk_learn_more);
//        myChromeDriver.navigate().back();

        System.out.println("点击SHOP NOW");
        shop_now=myChromeDriver.findElementByXPath("/html/body/section[1]/div/div[2]/div/div/a/button");
        javaTools.jsclick(myChromeDriver,shop_now);
        javaTools.back(myChromeDriver);

        System.out.println("点击about pawfit");
        about_pawfit=myChromeDriver.findElementByXPath("/html/body/section[2]/div/div/div[2]/div[2]/a");
        javaTools.jsclick(myChromeDriver,about_pawfit);
        javaTools.back(myChromeDriver);

        System.out.println("点击注册");
        register=myChromeDriver.findElementByXPath("/html/body/section[3]/div[1]/div[2]/div/div/div/a");
        javaTools.jsclick(myChromeDriver,register);
        javaTools.back(myChromeDriver);
    }

    @Test
    public void testBClick2() {
        System.out.println("点击跳转到谷歌");
        google_play=myChromeDriver.findElementByXPath("/html/body/section[4]/div/div/div[2]/div[1]/a/img");
        javaTools.jsclick(myChromeDriver,google_play);
        javaTools.back(myChromeDriver);
        System.out.println("点击跳转到app store");
        app_store=myChromeDriver.findElementByXPath("/html/body/section[4]/div/div/div[2]/div[2]/a/img");
        javaTools.jsclick(myChromeDriver,app_store);
        javaTools.back(myChromeDriver);

        System.out.println("点击跳转watch");
        watch=myChromeDriver.findElementByXPath("/html/body/section[5]/div/div[3]/div/div/div[1]/a[1]");
        javaTools.jsclick(myChromeDriver,watch);
        javaTools.back(myChromeDriver);
        System.out.println("点击跳转到wear");
        wear=myChromeDriver.findElementByXPath("/html/body/section[5]/div/div[3]/div/div/div[1]/a[2]");
        javaTools.jsclick(myChromeDriver,wear);
        javaTools.back(myChromeDriver);
    }

    @Test
    public void testCClick3() {
        System.out.println("点击pawfit 2模块");
        p2_learn_more=myChromeDriver.findElementByXPath("/html/body/section[6]/div/div/div[1]/div/div/div[3]/div[2]/a[1]/button");
        javaTools.jsclick(myChromeDriver,p2_learn_more);
        javaTools.back(myChromeDriver);
        p2_add=myChromeDriver.findElementByXPath("/html/body/section[6]/div/div/div[1]/div/div/div[3]/div[2]/a[2]/button");
        javaTools.jsclick(myChromeDriver,p2_add);
        accessory=myChromeDriver.findElementByXPath("/html/body/section[7]/div/div/div/div/div/div[2]/div[3]/a/button");
        javaTools.jsclick(myChromeDriver,accessory);
        javaTools.back(myChromeDriver);

        System.out.println("点击learn more跳转到story");
//        story_learn_more=myChromeDriver.findElementByXPath("/html/body/section[11]/div/div/div[1]/p[1]/a");
        story_learn_more=myChromeDriver.findElementByCssSelector("body > section.home_stores > div > div > div.col-lg-6.col-md-6.col-xs-12.col-sm-12.stores_content > p:nth-child(3) > a");
        javaTools.click(story_learn_more);
        javaTools.back(myChromeDriver);
    }

    @Test
    public void testDClick4() {
        javaTools.scrollTobottom(myChromeDriver);
        System.out.println("点击跳转到articles");
        latsen_articles=myChromeDriver.findElementByXPath("/html/body/section[12]/div/div[1]/h3/a");
        javaTools.jsclick(myChromeDriver,latsen_articles);
        javaTools.back(myChromeDriver);

        javaTools.scrollTobottom(myChromeDriver);
        read_all_articel=myChromeDriver.findElementByXPath("/html/body/section[12]/div/div[3]/div/a/button");
        javaTools.jsclick(myChromeDriver,read_all_articel);
        javaTools.back(myChromeDriver);

        read_all_articel1=myChromeDriver.findElementByXPath("/html/body/section[12]/div/div[2]/div[1]/div[2]/a");
        javaTools.jsclick(myChromeDriver,read_all_articel1);
        javaTools.back(myChromeDriver);

        read_all_articel2=myChromeDriver.findElementByXPath("/html/body/section[12]/div/div[2]/div[2]/div[2]/a");
        javaTools.jsclick(myChromeDriver,read_all_articel2);
        javaTools.back(myChromeDriver);

        read_all_articel3=myChromeDriver.findElementByXPath("/html/body/section[12]/div/div[2]/div[3]/div[2]/a");
        javaTools.jsclick(myChromeDriver,read_all_articel3);
        javaTools.back(myChromeDriver);
    }

    @AfterClass
    public static void alterClass(){
       driver.disconnect();
    }

}
