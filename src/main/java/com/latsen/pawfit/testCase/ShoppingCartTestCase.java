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
import org.openqa.selenium.interactions.Actions;
import org.testng.internal.Utils;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import com.latsen.pawfit.utils.JavaTools;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ShoppingCartTestCase {
    private static MyChromeDriverSingleton myChromeDriver;
    private static NewDriver driver;
    private static WebElement pawfit2_add;
    private static WebElement checkout;
    private static WebElement add;
    private static WebElement reduce;
    private static WebElement cancal;
    private static WebElement continue_shopping;
    private Utils FileUtils;
    private static JavaTools javaTools;

    @BeforeClass
    public static void beforeClass() throws IOException {
        System.out.println("已经执行");
        driver = new NewDriver(Const.PRODUCT_URL);
        myChromeDriver = driver.connect();
        javaTools = new JavaTools();

        pawfit2_add=myChromeDriver.findElementByXPath("/html/body/section[1]/div/div[1]/div[1]/div/div/div[3]/div[3]/a[2]/button");
    }

    @Test
    public void testAClick() throws IOException {
        //        添加pawfit2加入购物车
        pawfit2_add.click();
        //        点击购物车跳转购物车页面
        Actions action=new Actions(myChromeDriver);
        action.moveToElement(myChromeDriver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div/div[1]/button"))).perform();
        myChromeDriver.findElementByClassName("checkout-bg").click();
        //增加商品数量
        add=myChromeDriver.findElementByCssSelector("#mainCartTable > div.col-lg-7.col-md-7.col-sm-7.col-xs-12 > div:nth-child(1) > div.col-lg-7.col-md-7.col-sm-6.col-xs-6.flex-container > div.cart-bottom > input.cart-icon.jia_cart");
        javaTools.click(add);
        javaTools.click(add);
        //        减少商品数量
        reduce=myChromeDriver.findElementByXPath("#mainCartTable > div.col-lg-7.col-md-7.col-sm-7.col-xs-12 > div:nth-child(1) > div.col-lg-7.col-md-7.col-sm-6.col-xs-6.flex-container > div.cart-bottom > input.cart-icon.jian_cart");
        javaTools.click(reduce);
        javaTools.scrFile(myChromeDriver);
       //点击contine shopping按钮
        continue_shopping=myChromeDriver.findElementByXPath("/html/body/div[6]/div/div/div/div/div/div/div[1]/div[1]/a/strong");
        javaTools.click(continue_shopping);
        javaTools.scrFile(myChromeDriver);
        javaTools.back(myChromeDriver);
        //        点击跳转checkout页面
        checkout=myChromeDriver.findElementByClassName("check-btn-div");
        javaTools.click(checkout);
        javaTools.scrFile(myChromeDriver);
        javaTools.back(myChromeDriver);
        //        删除购物车商品
        cancal=myChromeDriver.findElementByCssSelector("#iDel");
        javaTools.click(cancal);
        javaTools.scrFile(myChromeDriver);

        System.out.println("测试成功！");
    }

    @AfterClass
    public static void alterClass() {
        driver.disconnect();
    }
}
