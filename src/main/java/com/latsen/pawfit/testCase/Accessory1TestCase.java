package com.latsen.pawfit.testCase;

import com.latsen.pawfit.Const.Const;
import com.latsen.pawfit.common.NewDriver;
import com.latsen.pawfit.driver.MyChromeDriverSingleton;
import com.latsen.pawfit.utils.JavaTools;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Accessory1TestCase {
    private static NewDriver driver;
    private static MyChromeDriverSingleton myChromeDriver;
    private static JavaTools javaTools;
    private static WebElement pawfit_collar;
    private static WebElement pawfit_leash;
    private static WebElement pawfit_harness_for_dogs;

    @BeforeClass
    public static void beforeClass() throws IOException {
        javaTools = new JavaTools();
        System.out.println("已经执行");
        driver = new NewDriver(Const.ACCESSORY1_URL);
        myChromeDriver = driver.connect();
        pawfit_collar=myChromeDriver.findElementByXPath("/html/body/div[4]/div/div/div/div/div[1]/div/div/div[3]/a/button");
        pawfit_leash=myChromeDriver.findElementByXPath("/html/body/div[4]/div/div/div/div/div[2]/div/div/div[3]/a/button");
        pawfit_harness_for_dogs=myChromeDriver.findElementByXPath("/html/body/div[4]/div/div/div/div/div[3]/div/div/div[3]/a/button");
    }

    @Test
    public void testAClick() {
        javaTools.click(pawfit_collar);
        javaTools.back(myChromeDriver);
        javaTools.click(pawfit_leash);
        javaTools.back(myChromeDriver);
        javaTools.click(pawfit_harness_for_dogs);
        javaTools.back(myChromeDriver);
    }

    @AfterClass
    public static void alterClass(){
        driver.disconnect();
    }

}
