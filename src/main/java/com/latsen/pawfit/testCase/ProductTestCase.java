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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.internal.Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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

    @BeforeClass
    public static void beforeClass() throws IOException {
        System.out.println("已经执行");
        webdriver = new NewDriver(Const.PRODUCT_URL);
        driver = webdriver.connect();
        pawfit2=driver.findElementByXPath("/html/body/section[1]/div/div/div[1]/div/div/div[3]/div[3]/a[1]");
        pawfit_Collar=driver.findElementByXPath("/html/body/section[2]/div/div/div[1]/div/div/div[1]/div[3]/a/button");
        collar_attachment=driver.findElementByXPath("/html/body/section[2]/div/div/div[2]/div/div/div/div[1]/div[3]/a[1]/button");
        collar_strap=driver.findElementByXPath("/html/body/section[2]/div/div/div[3]/div/div/div[1]/div[3]/a[1]/button");
        charging_dock=driver.findElementByXPath("/html/body/section[2]/div/div/div[4]/div/div/div/div[1]/div[3]/a[1]/button");
        pawfit2_add=driver.findElementByXPath("/html/body/section[1]/div/div/div[1]/div/div/div[3]/div[3]/a[2]");
    }

    //截图
    public void scrFile(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");  //转换时间格式
        String time = dateFormat.format(Calendar.getInstance().getTime());  //获取当前时间
        String Name = Thread.currentThread().getStackTrace()[2].getMethodName();//获取当前类名
        File srcFile = ((TakesScreenshot)webdriver).getScreenshotAs(OutputType.FILE);  //执行屏幕截取
        FileUtils.copyFile(srcFile, new File("C:\\Users\\Admin\\web_test\\src\\img\\Product", Name+"_"+time + ".png"));
    }

    //   点击pawfit 2模块
    @Test
    public void testApawfit2() {
        pawfit2_add.click();
        scrFile();
        pawfit2.click();
        scrFile();
        driver.navigate().back();
    }

    //   点击pawfit Colla模块
    @Test
    public void testBpawfit_Collar() {
        pawfit_Collar=driver.findElementByXPath("/html/body/section[2]/div/div/div[1]/div/div/div[1]/div[3]/a/button");
        pawfit_Collar.click();
        scrFile();
        driver.navigate().back();
    }

    //   点击collar attachment模块
    @Test
    public void testCcollar_attachment() {
        collar_attachment_add=driver.findElementByXPath("/html/body/section[2]/div/div/div[2]/div/div/div/div[1]/div[3]/a[2]/button");
        collar_attachment_add.click();
        scrFile();
        collar_attachment=driver.findElementByXPath("/html/body/section[2]/div/div/div[2]/div/div/div/div[1]/div[3]/a[1]/button");
        collar_attachment.click();
        scrFile();
        driver.navigate().back();
    }

    //   点击collar strap模块
    @Test
    public void testDcollar_strap() {
        collar_strap_add=driver.findElementByXPath("/html/body/section[2]/div/div/div[3]/div/div/div[1]/div[3]/a[2]/button");
        collar_strap_add.click();
        scrFile();
        collar_strap=driver.findElementByXPath("/html/body/section[2]/div/div/div[3]/div/div/div[1]/div[3]/a[1]/button");
        collar_strap.click();
        scrFile();
        driver.navigate().back();
    }

    //   点击Charging Dock and Cable 模块
    @Test
    public void testEcharging_dock() {
        charging_dock_add=driver.findElementByXPath("/html/body/section[2]/div/div/div[4]/div/div/div/div[1]/div[3]/a[2]/button");
        charging_dock_add.click();
        scrFile();
        charging_dock=driver.findElementByXPath("/html/body/section[2]/div/div/div[4]/div/div/div/div[1]/div[3]/a[1]/button");
        charging_dock.click();
        scrFile();
        driver.navigate().back();
    }

    //  点击下方read按钮
    @Test
    public void testFread() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        read=driver.findElementByXPath("/html/body/section[3]/div/div[3]/div/a/button");
        read.click();
        scrFile();
        driver.navigate().back();
    }

    @AfterClass
    public static void alterClass(){
        webdriver.disconnect();
    }
}
