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
import org.openqa.selenium.WebElement;
import org.testng.internal.Utils;

import java.io.IOException;
import com.latsen.pawfit.utils.JavaTools;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductTestCase {
    private static WebElement pawfit2;
    private static WebElement pawfit2_add;
    private static WebElement p2GD;
    private static WebElement p2GD_add;
    private static WebElement accessory1;
    private static WebElement accessory2;
    private static MyChromeDriverSingleton driver;
    private static NewDriver webdriver;
    private Utils FileUtils;
    private static WebElement read;
    private static JavaTools javaTools;

    @BeforeClass
    public static void beforeClass() throws IOException {
        System.out.println("已经执行");
        webdriver = new NewDriver(Const.PRODUCT_URL);
        driver = webdriver.connect();
        javaTools = new JavaTools();
        pawfit2=driver.findElementByXPath("/html/body/section[1]/div/div/div[1]/div/div/div[3]/div[3]/a[1]");
        pawfit2_add=driver.findElementByXPath("/html/body/section[1]/div/div/div[1]/div/div/div[3]/div[3]/a[2]");
        p2GD=driver.findElementByXPath("/html/body/section[1]/div/div[2]/div[1]/div/div/div[3]/div[3]/a[1]");
        p2GD_add=driver.findElementByXPath("/html/body/section[1]/div/div[2]/div[1]/div/div/div[3]/div[3]/a[2]");
        accessory1=driver.findElementByXPath("/html/body/section[2]/div/div/div/div/div/div[2]/div[3]/a/button");
        accessory2=driver.findElementByXPath("/html/body/section[3]/div/div/div/div/div/div[2]/div[3]/a/button");
    }

    //   点击pawfit 2模块
    @Test
    public void testApawfit2() throws IOException {
        javaTools.click(pawfit2_add);
        javaTools.click(pawfit2);
        javaTools.scrFile(driver);
        javaTools.back(driver);
    }

    //   点击pawfit2 bundle deal模块
    @Test
    public void testBpawfit2_Bundle_Deal() throws IOException {
        javaTools.click(p2GD_add);
        javaTools.click(p2GD);
        javaTools.scrFile(driver);
        javaTools.back(driver);
    }

    //   点击HARNESSES, LEASHES & COLLARS模块
    @Test
    public void testCaccessory1() throws IOException {
        javaTools.click(accessory1);
        javaTools.scrFile(driver);
        javaTools.back(driver);
    }

    //   点击collar strap模块
    @Test
    public void testDaccessory2() throws IOException {
        javaTools.click(accessory2);
        javaTools.scrFile(driver);
        javaTools.back(driver);
    }

    //  点击下方read按钮
    @Test
    public void testEread() throws IOException {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        read=driver.findElementByXPath("/html/body/section[3]/div/div[3]/div/a/button");
        javaTools.click(read);
        javaTools.scrFile(driver);
        javaTools.back(driver);
    }

    @AfterClass
    public static void alterClass(){
        webdriver.disconnect();
    }
}
