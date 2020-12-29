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
    private static NewDriver newDriver;
    private static JavaTools javaTools;

    @BeforeClass
    public static void beforeClass() throws IOException {
        System.out.println("已经执行");
        newDriver = new NewDriver(Const.PAWFIT2_URL);
        driver = newDriver.connect();
        javaTools = new JavaTools();

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

//   点击页面所有添加pawfit 2到购物车的按钮
    @Test
    public void testAAdd() throws InterruptedException {
        banner_btn=driver.findElementByXPath("/html/body/section/section[3]/div/div/div/div/p[3]/button");
        javaTools.click(banner_btn);
        javaTools.sleep(3000);
        javaTools.click(pawfit2_btn);
        javaTools.sleep(3000);
        javaTools.click(center_btn);
        javaTools.sleep(3000);
        footer_btn=driver.findElementByXPath(("/html/body/section/div[4]/div/p[3]/button"));
        javaTools.click(footer_btn);
    }

    @Test
    public void testBImg() {
//        点击商品图片和视频
        javaTools.scrollToTop(driver);
        javaTools.click(img1);
        javaTools.click(img2);
        javaTools.click(img3);
        javaTools.click(video);
        javaTools.click(close1);
//        点击Compare our subscription plans here
        javaTools.click(subscription);
        javaTools.click(close2);
        System.out.println("测试完成！");
    }

//    Pawfit 2 and the Pawfit App
    @Test
    public void testCexplain() {
        javaTools.click(explain1);
        javaTools.click(explain2);
        javaTools.click(explain3);
        javaTools.click(explain4);
        javaTools.click(explain5);
        javaTools.click(explain6);
        javaTools.click(explain7);
        javaTools.click(explain8);

        javaTools.click(specifications);
        javaTools.click(box);
        javaTools.click(manuals);
        System.out.println("测试完成！");
    }

    @Test
    public void testDdetail() {
        javaTools.click(live);
        javaTools.click(live_close);
        javaTools.click(light_sound);
        javaTools.click(light_sound_close);
        javaTools.click(active);
        javaTools.click(active_close);
        javaTools.click(rest);
        javaTools.click(rest_close);
        javaTools.click(calories);
        javaTools.click(calories_close);
        javaTools.click(distance);
        javaTools.click(distance_close);
        javaTools.click(temperature);
        javaTools.click(temperature_close);
        javaTools.click(removal);
        javaTools.click(removal_close);
        javaTools.click(virtual_fence);
        javaTools.click(virtual_fence_close);
        System.out.println("测试完成！");
    }

    @AfterClass
    public static void afterClass(){
        newDriver.disconnect();
    }
}

