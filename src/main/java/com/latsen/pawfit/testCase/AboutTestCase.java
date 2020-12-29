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
public class AboutTestCase {
    private static MyChromeDriverSingleton myChromeDriver;
    private static NewDriver driver;
    private static WebElement support;
    private static WebElement contact_us;
    private static WebElement technology;
    private static JavaTools javaTools;

    @BeforeClass
    public static void beforeClass() throws IOException {
        System.out.println("已经执行");
        driver = new NewDriver(Const.ABOUT_URL);
        myChromeDriver = driver.connect();
        javaTools=new JavaTools();
    }


    @Test
    public void testAAbout() throws IOException {
        support=myChromeDriver.findElementByXPath("/html/body/div[3]/div/div/p[2]/a[1]/button");
        System.out.println("点击Suppot按钮");
        javaTools.click(support);
        javaTools.scrFile(myChromeDriver);
        javaTools.back(myChromeDriver);
        contact_us=myChromeDriver.findElementByXPath("/html/body/div[3]/div/div/p[2]/a[2]/button");
        System.out.println("点击Contact us按钮");
        javaTools.click(contact_us);
        javaTools.scrFile(myChromeDriver);
        javaTools.back(myChromeDriver);
        technology=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/a/button");
        System.out.println("点击Visit Latsen Technology按钮");
        javaTools.click(technology);
        javaTools.scrFile(myChromeDriver);
        javaTools.back(myChromeDriver);
    }

    @AfterClass
    public static void alterClass(){
        driver.disconnect();
    }
}
