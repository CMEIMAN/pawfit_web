package com.latsen.pawfit.testCase;

import com.latsen.pawfit.Const.Const;
import com.latsen.pawfit.common.Driver;
import com.latsen.pawfit.driver.MyChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.internal.Utils;
import java.io.File;
import java.io.IOException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Recent_orderTestCase {
    private static MyChromeDriver myChromeDriver;
    private static Driver driver;
    private static WebElement emil;
    private static WebElement password;
    private static WebElement login;
    private static WebElement recent_order;
    private static WebElement details;
    private static WebElement list_of_orders;
    private Utils FileUtils;

    @BeforeClass
    public static void beforeClass() throws IOException {
        System.out.println("已经执行");
        driver = new Driver(Const.LOGiN_URL);
        myChromeDriver = driver.connect();
//        登录账号
        emil= myChromeDriver.findElementById("signin_userName");
        password= myChromeDriver.findElementById("signin_password");
        login= myChromeDriver.findElementById("genericLogin-button");
        emil.sendKeys("1790039849@qq.com");
        password.sendKeys("123456");
        login.click();
    }

    //截图
    public void scrFile(){
        long date=System.currentTimeMillis();
        String path = String.valueOf(date);
        String curPath =System.getProperty("user.dir");
        path =path+".png";
        String screenPath = curPath+"/"+path;
        File screen = ((TakesScreenshot) myChromeDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screen,new File(screenPath));
    }

    @Test
    public void testAClick1() {
//        点击订单列表
        recent_order=myChromeDriver.findElementByXPath("/html/body/div[3]/div/div[2]/div[1]/ul/li[2]/a");
        recent_order.click();
        scrFile();
//        点击跳转订单详情页面
        details=myChromeDriver.findElementByXPath("/html/body/div[4]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[6]/a");
        details.click();
        scrFile();
//        返回订单列表
        list_of_orders=myChromeDriver.findElementByXPath("/html/body/div[3]/div[3]/div[4]/div[2]/form[1]/button");
        list_of_orders.click();
        System.out.println("测试成功！");
    }

    @AfterClass
    public static void alterClass() {
        driver.disconnect();
    }

}