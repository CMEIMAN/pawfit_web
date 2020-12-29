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
public class Recent_orderTestCase {
    private static MyChromeDriverSingleton myChromeDriver;
    private static NewDriver driver;
    private static WebElement email;
    private static WebElement password;
    private static WebElement login;
    private static WebElement recent_order;
    private static WebElement details;
    private static WebElement list_of_orders;
    private static JavaTools javaTools;

    @BeforeClass
    public static void beforeClass() throws IOException {
        System.out.println("已经执行");
        driver = new NewDriver(Const.LOGiN_URL);
        myChromeDriver = driver.connect();
        javaTools = new JavaTools();
//        登录账号
        email= myChromeDriver.findElementById("signin_userName");
        password= myChromeDriver.findElementById("signin_password");
        login= myChromeDriver.findElementById("genericLogin-button");
        javaTools.inputText(myChromeDriver,"1790039849@qq.com",email);
        javaTools.inputText(myChromeDriver,"12345678",password);
        javaTools.click(login);
    }


    @Test
    public void testAClick1() throws IOException {
//        点击订单列表
        recent_order=myChromeDriver.findElementByXPath("/html/body/div[3]/div/div[2]/div[1]/ul/li[2]/a");
        javaTools.click(recent_order);
        javaTools.scrFile(myChromeDriver);
//        点击跳转订单详情页面
        details=myChromeDriver.findElementByXPath("/html/body/div[4]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[6]/a");
        javaTools.click(details);
        javaTools.scrFile(myChromeDriver);
//        返回订单列表
        list_of_orders=myChromeDriver.findElementByXPath("/html/body/div[3]/div[3]/div[4]/div[2]/form[1]/button");
        javaTools.click(list_of_orders);
        System.out.println("测试成功！");
    }

    @AfterClass
    public static void alterClass() {
        driver.disconnect();
    }

}