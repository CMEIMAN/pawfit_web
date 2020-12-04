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
import org.openqa.selenium.interactions.Actions;
import org.testng.internal.Utils;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ShoppingCartTestCase {
    private static MyChromeDriver myChromeDriver;
    private static Driver driver;
    private static WebElement pawfit2_add;
    private static WebElement checkout;
    private static WebElement add;
    private static WebElement reduce;
    private static WebElement cancal;
    private static WebElement continue_shopping;
    private Utils FileUtils;

    @BeforeClass
    public static void beforeClass() throws IOException {
        System.out.println("已经执行");
        driver = new Driver(Const.PRODUCT_URL);
        myChromeDriver = driver.connect();

        pawfit2_add=myChromeDriver.findElementByXPath("/html/body/section[1]/div/div/div[1]/div/div/div[3]/div[3]/a[2]/button");
    }
    //截图
    public void scrFile(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");  //转换时间格式
        String time = dateFormat.format(Calendar.getInstance().getTime());  //获取当前时间
        String Name = Thread.currentThread().getStackTrace()[2].getMethodName();//获取当前类名
        File srcFile = ((TakesScreenshot)myChromeDriver).getScreenshotAs(OutputType.FILE);  //执行屏幕截取
        FileUtils.copyFile(srcFile, new File("C:\\Users\\Admin\\web_test\\src\\img\\ShoppingCart", Name+"_"+time + ".png"));
    }

    @Test
    public void testAClick() {
        //        添加pawfit2加入购物车
        pawfit2_add.click();
        //        点击购物车跳转购物车页面
        Actions action=new Actions(myChromeDriver);
        action.moveToElement(myChromeDriver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div/div[1]/button"))).perform();
        myChromeDriver.findElementByClassName("checkout-bg").click();
        //增加商品数量
        add=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/div/div/div/div[1]/table/tbody/tr[1]/td[2]/img[1]");
        add.click();
        add.click();
        //        减少商品数量
        reduce=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/div/div/div/div[1]/table/tbody/tr[1]/td[2]/img[2]");
        reduce.click();
        scrFile();
       //点击contine shopping按钮
        continue_shopping=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/div/div/div/div[2]/div[1]/div/a");
        continue_shopping.click();
        scrFile();
        myChromeDriver.navigate().back();
        //        点击跳转checkout页面
        checkout=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/div/div/div/div[2]/div[2]/div/a");
        checkout.click();
        scrFile();
        myChromeDriver.navigate().back();
        //        删除购物车商品
        cancal=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/div/div/div/div[1]/table/tbody/tr/td[4]/div/a");
        cancal.click();
        scrFile();

        System.out.println("测试成功！");
    }

    @AfterClass
    public static void alterClass() {
        driver.disconnect();
    }
}
