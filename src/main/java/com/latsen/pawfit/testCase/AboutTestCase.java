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
import java.text.SimpleDateFormat;
import java.util.Calendar;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AboutTestCase {
    private static MyChromeDriver myChromeDriver;
    private static Driver driver;
    private Utils FileUtils;
    private static WebElement support;
    private static WebElement contact_us;
    private static WebElement technology;

    @BeforeClass
    public static void beforeClass() throws IOException {
        System.out.println("已经执行");
        driver = new Driver(Const.ABOUT_URL);
        myChromeDriver = driver.connect();
    }

    //截图
    public void scrFile(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");  //转换时间格式
        String time = dateFormat.format(Calendar.getInstance().getTime());  //获取当前时间
        String Name = Thread.currentThread().getStackTrace()[2].getMethodName();//获取当前类名
        File srcFile = ((TakesScreenshot)myChromeDriver).getScreenshotAs(OutputType.FILE);  //执行屏幕截取
        FileUtils.copyFile(srcFile, new File("C:\\Users\\Admin\\web_test\\src\\img\\About", Name+"_"+time + ".png"));
    }

    @Test
    public void testAAbout() {
        support=myChromeDriver.findElementByXPath("/html/body/div[3]/div/div/p[2]/a[1]/button");
        System.out.println("点击Suppot按钮");
        support.click();
        scrFile();
        myChromeDriver.navigate().back();
        contact_us=myChromeDriver.findElementByXPath("/html/body/div[3]/div/div/p[2]/a[2]/button");
        System.out.println("点击Contact us按钮");
        contact_us.click();
        scrFile();
        myChromeDriver.navigate().back();
        technology=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/a/button");
        System.out.println("点击Visit Latsen Technology按钮");
        technology.click();
        scrFile();
        myChromeDriver.navigate().back();
        System.out.println("测试成功！");
    }

    @AfterClass
    public static void alterClass(){
        driver.disconnect();
    }
}
