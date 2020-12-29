package com.latsen.pawfit.testCase;

import com.latsen.pawfit.Const.Const;
import com.latsen.pawfit.common.NewDriver;
import com.latsen.pawfit.driver.MyChromeDriverSingleton;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;
import org.testng.internal.Utils;

import java.io.IOException;
import java.net.MalformedURLException;
import com.latsen.pawfit.utils.JavaTools;

@org.testng.annotations.Test(groups = "Group")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmailSubscriptionTestCase {
    private static NewDriver driver;
    private static MyChromeDriverSingleton webDriver;
    private static WebElement firstName;
    private static WebElement lastName;
    private static WebElement emial;
    private static WebElement subscribeBtn;
    private static WebElement backToHomePage;
    private static JavaTools javaTools;

    @BeforeClass
    public static void beforeClass() throws IOException {
        driver=new NewDriver(Const.PRODUCT_URL);
        try {
            webDriver=driver.connect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        javaTools = new JavaTools();
        firstName=webDriver.findElement(By.id("exampleInputName2"));
        lastName=webDriver.findElement(By.id("exampleInputName3"));
        emial=webDriver.findElement(By.id("exampleInputEmail2"));
        subscribeBtn=webDriver.findElementByXPath("/html/body/div[5]/div/div/div/form/div[8]/button");
    }

    @Test
    public void testAput_error(){
//        循环注入数据验证
        firstName=webDriver.findElementById("exampleInputName2");
        for(int i=0;i<Const.getCommomText().length;i++){
            firstName.sendKeys(""+Const.getCommomText()[i]);
            lastName.sendKeys(""+Const.getCommomText()[i]);
            emial.sendKeys(""+Const.getEmail()[i]);
        }
    }

//    输入空格
    @Test
    public void testBput_null() throws IOException {
        //        清除数据
        javaTools.clear(firstName);
        javaTools.clear(lastName);
        javaTools.clear(emial);

        javaTools.inputText(webDriver,"    ",firstName);
        javaTools.inputText(webDriver,"    ",lastName);
        javaTools.inputText(webDriver,"    ",emial);
        javaTools.jsclick(webDriver,subscribeBtn);
        javaTools.scrFile(webDriver);
    }

    @Test
    public void testCput() throws IOException {
        firstName=webDriver.findElement(By.id("exampleInputName2"));
        lastName=webDriver.findElement(By.id("exampleInputName3"));
        emial=webDriver.findElement(By.id("exampleInputEmail2"));
        subscribeBtn=webDriver.findElementByXPath("/html/body/div[5]/div/div/div/form/div[8]/button");
//        清除数据
        javaTools.clear(firstName);
        javaTools.clear(lastName);
        javaTools.clear(emial);
//        输入数据
        javaTools.inputText(webDriver,"chen",firstName);
        javaTools.inputText(webDriver,"test",lastName);
        javaTools.inputText(webDriver,"1790039849@qq.com",emial);
//        点击提交
        javaTools.jsclick(webDriver,subscribeBtn);
        javaTools.sleep(3000);
        javaTools.scrFile(webDriver);
//        点击Go back to Homepage按钮
        backToHomePage=webDriver.findElement(By.xpath("/html/body/div[4]/a"));
        javaTools.click(backToHomePage);
        javaTools.scrFile(webDriver);
    }

    @AfterClass
    public static void afterClass(){
        driver.disconnect();
    }
}
