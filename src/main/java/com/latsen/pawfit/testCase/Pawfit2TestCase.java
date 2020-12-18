package com.latsen.pawfit.testCase;

import com.latsen.pawfit.Const.Const;
import com.latsen.pawfit.common.NewDriver;
import com.latsen.pawfit.driver.MyChromeDriverSingleton;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.IOException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Pawfit2TestCase {
    private static WebElement banner_btn;
    private static WebElement pawfit2_btn;
    private static WebElement img1;
    private static WebElement img2;
    private static WebElement img3;
    private static WebElement video;
    private static WebElement close1;
    private static WebElement subscription;
    private static WebElement close2;
    private static WebElement explain1;
    private static WebElement explain2;
    private static WebElement explain3;
    private static WebElement explain4;
    private static WebElement explain5;
    private static WebElement explain6;
    private static WebElement explain7;
    private static WebElement explain8;
    private static WebElement specifications;
    private static WebElement box;
    private static WebElement manuals;
    private static WebElement center_btn;
    private static WebElement footer_btn;
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
    private static MyChromeDriverSingleton driver;
    private static NewDriver webdriver;

    @BeforeClass
    public static void beforeClass() throws IOException {
        System.out.println("已经执行");
        webdriver = new NewDriver(Const.PAWFIT2_URL);
        driver = webdriver.connect();

        banner_btn=driver.findElementByXPath("/html/body/section/section[3]/div/div/div/div/p[3]/button");
        pawfit2_btn=driver.findElementByXPath("/html/body/section/div[2]/div/div/div/div[1]/div[1]/div/div[2]/div/div[2]/div/h4/button");
        img1=driver.findElementByXPath("/html/body/section/div[2]/div/div/div/div[1]/div[1]/div/div[1]/ul/li[1]/a");
        img2=driver.findElementByXPath("/html/body/section/div[2]/div/div/div/div[1]/div[1]/div/div[1]/ul/li[2]/a");
        img3=driver.findElementByXPath("/html/body/section/div[2]/div/div/div/div[1]/div[1]/div/div[1]/ul/li[3]/a");
        video=driver.findElementByXPath("/html/body/section/div[2]/div/div/div/div[1]/div[1]/div/div[1]/ul/li[4]/div/div/div/div");
        close1=driver.findElementByXPath("/html/body/div[3]/div/div/div[1]");
        subscription=driver.findElementByXPath("/html/body/section/div[2]/div/div/div/div[1]/div[1]/div/div[2]/div/div[2]/div/div[2]/a");
        close2=driver.findElementByXPath("/html/body/section/div[7]/div/div/div[1]/button/span");
        explain1=driver.findElementByXPath("/html/body/section/div[2]/div/div/div/div[1]/div[2]/div[1]/div[2]/ul/li[2]/h2");
        explain2=driver.findElementByXPath("/html/body/section/div[2]/div/div/div/div[1]/div[2]/div[1]/div[2]/ul/li[3]/h2");
        explain3=driver.findElementByXPath("/html/body/section/div[2]/div/div/div/div[1]/div[2]/div[1]/div[2]/ul/li[4]/h2");
        explain4=driver.findElementByXPath("/html/body/section/div[2]/div/div/div/div[1]/div[2]/div[1]/div[2]/ul/li[5]/h2");
        explain5=driver.findElementByXPath("/html/body/section/div[2]/div/div/div/div[1]/div[2]/div[1]/div[2]/ul/li[6]/h2");
        explain6=driver.findElementByXPath("/html/body/section/div[2]/div/div/div/div[1]/div[2]/div[1]/div[2]/ul/li[7]/h2");
        explain7=driver.findElementByXPath("/html/body/section/div[2]/div/div/div/div[1]/div[2]/div[1]/div[2]/ul/li[8]/h2");
        explain8=driver.findElementByXPath("/html/body/section/div[2]/div/div/div/div[1]/div[2]/div[1]/div[2]/ul/li[9]/h2");
        specifications=driver.findElementByXPath("/html/body/section/div[3]/div/div/div/ul/li[1]/a");
        box=driver.findElementByXPath("/html/body/section/div[3]/div/div/div/ul/li[2]/a");
        manuals=driver.findElementByXPath("/html/body/section/div[3]/div/div/div/ul/li[3]/a");
        center_btn=driver.findElementByXPath("/html/body/section/div[4]/div/p[3]/button");
        live=driver.findElementByXPath("/html/body/section/div[5]/div[1]/div[1]/div/div/button[1]");
        live_close=driver.findElementByXPath("/html/body/section/div[9]/div/div/div[1]/button/span");
        light_sound=driver.findElementByXPath("/html/body/section/div[5]/div[1]/div[1]/div/div/button[2]");
        light_sound_close=driver.findElementByXPath("/html/body/section/div[9]/div/div/div[1]/button/span");
        active=driver.findElementByXPath("/html/body/section/div[5]/div[2]/div[2]/div/div/button[1]");
        active_close=driver.findElementByXPath("/html/body/section/div[9]/div/div/div[1]/button/span");
        rest=driver.findElementByXPath("/html/body/section/div[5]/div[2]/div[2]/div/div/button[2]");
        rest_close=driver.findElementByXPath("/html/body/section/div[9]/div/div/div[1]/button/span");
        calories=driver.findElementByXPath("/html/body/section/div[5]/div[2]/div[2]/div/div/button[3]");
        calories_close=driver.findElementByXPath("/html/body/section/div[9]/div/div/div[1]/button/span");
        distance=driver.findElementByXPath("/html/body/section/div[5]/div[2]/div[2]/div/div/button[4]");
        distance_close=driver.findElementByXPath("/html/body/section/div[9]/div/div/div[1]/button/span");
        temperature=driver.findElementByXPath("/html/body/section/div[5]/div[3]/div[1]/div/button[1]");
        temperature_close=driver.findElementByXPath("/html/body/section/div[9]/div/div/div[1]/button/span");
        removal=driver.findElementByXPath("/html/body/section/div[5]/div[3]/div[1]/div/button[2]");
        removal_close=driver.findElementByXPath("/html/body/section/div[9]/div/div/div[1]/button/span");
        virtual_fence=driver.findElementByXPath("/html/body/section/div[5]/div[3]/div[1]/div/button[3]");
        virtual_fence_close=driver.findElementByXPath("/html/body/section/div[9]/div/div/div[1]/button/span");
    }
    /**
     * 控制滚动条向上拉到顶
     * @param driver 浏览器驱动
     */
    public static void scrolltoTop(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //向上拉到顶
        js.executeScript("window.scrollTo(0,1)");
    }

//   点击页面所有添加pawfit 2到购物车的按钮
    @Test
    public void testAAdd() throws InterruptedException {
        banner_btn=driver.findElementByXPath("/html/body/section/section[3]/div/div/div/div/p[3]/button");
        banner_btn.click();
        Thread.sleep(3000);
        pawfit2_btn.click();
        Thread.sleep(3000);
        center_btn.click();
        Thread.sleep(3000);
        footer_btn=driver.findElementByXPath(("/html/body/section/div[4]/div/p[3]/button"));
        footer_btn.click();
    }

    @Test
    public void testBImg() {
//        点击商品图片和视频
        scrolltoTop(driver);
        img1.click();
        img2.click();
        img3.click();
        video.click();
        close1.click();
//        点击Compare our subscription plans here
        subscription.click();
        close2.click();
        System.out.println("测试完成！");
    }

//    Pawfit 2 and the Pawfit App
    @Test
    public void testCexplain() {
        explain1.click();
        explain2.click();
        explain3.click();
        explain4.click();
        explain5.click();
        explain6.click();
        explain7.click();
        explain8.click();

        specifications.click();
        box.click();
        manuals.click();
        System.out.println("测试完成！");
    }

    @Test
    public void testDdetail() {
        live.click();
        live_close.click();
        light_sound.click();
        light_sound_close.click();
        active.click();
        active_close.click();
        rest.click();
        rest_close.click();
        calories.click();
        calories_close.click();
        distance.click();
        distance_close.click();
        temperature.click();
        temperature_close.click();
        removal.click();
        removal_close.click();
        virtual_fence.click();
        virtual_fence_close.click();
        System.out.println("测试完成！");
    }

    @AfterClass
    public static void afterClass(){
        webdriver.disconnect();
    }
}

