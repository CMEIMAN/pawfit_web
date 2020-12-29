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
    private static WebElement pawfit_Collar;
    private static WebElement collar_attachment;
    private static WebElement collar_strap;
    private static WebElement charging_dock;
    private static WebElement pawfit2_add;
    private static WebElement collar_attachment_add;
    private static WebElement collar_strap_add;
    private static WebElement charging_dock_add;
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
        pawfit_Collar=driver.findElementByXPath("/html/body/section[2]/div/div/div[1]/div/div/div[1]/div[3]/a/button");
        collar_attachment=driver.findElementByXPath("/html/body/section[2]/div/div/div[2]/div/div/div/div[1]/div[3]/a[1]/button");
        collar_strap=driver.findElementByXPath("/html/body/section[2]/div/div/div[3]/div/div/div[1]/div[3]/a[1]/button");
        charging_dock=driver.findElementByXPath("/html/body/section[2]/div/div/div[4]/div/div/div/div[1]/div[3]/a[1]/button");
        pawfit2_add=driver.findElementByXPath("/html/body/section[1]/div/div/div[1]/div/div/div[3]/div[3]/a[2]");
    }

    //   点击pawfit 2模块
    @Test
    public void testApawfit2() throws IOException {
        javaTools.click(pawfit2_add);
        javaTools.scrFile(driver);
        javaTools.click(pawfit2);
        javaTools.scrFile(driver);
        javaTools.back(driver);
    }

    //   点击pawfit Colla模块
    @Test
    public void testBpawfit_Collar() throws IOException {
        pawfit_Collar=driver.findElementByXPath("/html/body/section[2]/div/div/div[1]/div/div/div[1]/div[3]/a/button");
        javaTools.click(pawfit_Collar);
        javaTools.scrFile(driver);
        javaTools.back(driver);
    }

    //   点击collar attachment模块
    @Test
    public void testCcollar_attachment() throws IOException {
        collar_attachment_add=driver.findElementByXPath("/html/body/section[2]/div/div/div[2]/div/div/div/div[1]/div[3]/a[2]/button");
        javaTools.click(collar_attachment_add);
        javaTools.scrFile(driver);
        collar_attachment=driver.findElementByXPath("/html/body/section[2]/div/div/div[2]/div/div/div/div[1]/div[3]/a[1]/button");
        javaTools.click(collar_attachment);
        javaTools.scrFile(driver);
        javaTools.back(driver);
    }

    //   点击collar strap模块
    @Test
    public void testDcollar_strap() throws IOException {
        collar_strap_add=driver.findElementByXPath("/html/body/section[2]/div/div/div[3]/div/div/div[1]/div[3]/a[2]/button");
        javaTools.click(collar_strap_add);
        javaTools.scrFile(driver);
        collar_strap=driver.findElementByXPath("/html/body/section[2]/div/div/div[3]/div/div/div[1]/div[3]/a[1]/button");
        javaTools.click(collar_strap);
        javaTools.scrFile(driver);
        javaTools.back(driver);
    }

    //   点击Charging Dock and Cable 模块
    @Test
    public void testEcharging_dock() throws IOException {
        charging_dock_add=driver.findElementByXPath("/html/body/section[2]/div/div/div[4]/div/div/div/div[1]/div[3]/a[2]/button");
        javaTools.click(charging_dock_add);
        javaTools.scrFile(driver);
        charging_dock=driver.findElementByXPath("/html/body/section[2]/div/div/div[4]/div/div/div/div[1]/div[3]/a[1]/button");
        javaTools.click(charging_dock);
        javaTools.scrFile(driver);
        javaTools.back(driver);
    }

    //  点击下方read按钮
    @Test
    public void testFread() throws IOException {
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
