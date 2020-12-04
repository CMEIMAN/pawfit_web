package com.latsen.pawfit.testCase;

import com.latsen.pawfit.Const.Const;
import com.latsen.pawfit.common.Driver;
import com.latsen.pawfit.driver.MyChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;
import org.testng.internal.Utils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

@org.testng.annotations.Test(groups = "Group")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmailSubscriptionTestCase {
    private static Driver driver;
    private static MyChromeDriver webDriver;
    private static WebElement firstName;
    private static WebElement lastName;
    private static WebElement emial;
    private static WebElement subscribeBtn;
    private static WebElement backToHomePage;
    private Utils FileUtils;

    @BeforeClass
    public static void beforeClass() throws IOException {
        driver=new Driver(Const.PRODUCT_URL);
        try {
            webDriver=driver.connect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        firstName=webDriver.findElement(By.id("exampleInputName2"));
        lastName=webDriver.findElement(By.id("exampleInputName3"));
        emial=webDriver.findElement(By.id("exampleInputEmail2"));
        subscribeBtn=webDriver.findElementByXPath("/html/body/div[5]/div/div/div/form/div[8]/button");
    }

    //截图
    public void scrFile() {
        long date = System.currentTimeMillis();
        String path = String.valueOf(date);
        String curPath = System.getProperty("user.dir");
        path = path + ".png";
        String screenPath = curPath + "/" + path;
        File screen = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screen, new File(screenPath));
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

    @Test
    public void testBput(){
        firstName=webDriver.findElement(By.id("exampleInputName2"));
        lastName=webDriver.findElement(By.id("exampleInputName3"));
        emial=webDriver.findElement(By.id("exampleInputEmail2"));
        subscribeBtn=webDriver.findElementByXPath("/html/body/div[5]/div/div/div/form/div[8]/button");
//        清除数据
        firstName.clear();
        lastName.clear();
        emial.clear();
//        输入数据
        firstName.sendKeys("chen");
        lastName.sendKeys("test");
        emial.sendKeys("1790039849@qq.com");
//        截图
        scrFile();
//        点击提交
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click()",subscribeBtn);
        scrFile();
//        点击Go back to Homepage按钮
        backToHomePage=webDriver.findElement(By.xpath("/html/body/div[4]/a"));
        backToHomePage.click();
        scrFile();
    }

    @AfterClass
    public static void afterClass(){
        driver.disconnect();
    }
}
