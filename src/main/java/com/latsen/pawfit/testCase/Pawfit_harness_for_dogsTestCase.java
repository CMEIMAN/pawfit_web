package com.latsen.pawfit.testCase;

import com.latsen.pawfit.Const.Const;
import com.latsen.pawfit.common.NewDriver;
import com.latsen.pawfit.driver.MyChromeDriverSingleton;
import com.latsen.pawfit.utils.JavaTools;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class Pawfit_harness_for_dogsTestCase {
    private static MyChromeDriverSingleton myChromeDriver;
    private static NewDriver driver;
    private static JavaTools javaTools;
    private static WebElement btn1;
    private static Select select;
    private static WebElement size;
    @BeforeClass
    public static void beforeClass() throws IOException {
        System.out.println("已经执行");
        driver = new NewDriver(Const.PAWFIT_HARNESS_FOR_DOGS);
        myChromeDriver = driver.connect();
        javaTools=new JavaTools();

        size=myChromeDriver.findElementByXPath("/html/body/section/div[2]/div/div/div/div[1]/div/div/div[2]/div/div[2]/div/div[1]/div/form/div/div/select");
        btn1= myChromeDriver.findElementByXPath("/html/body/section/div[2]/div/div/div/div[1]/div/div/div[2]/div/div[2]/div/div[1]/button");

    }

    @Test
    public void testAClick(){
        select = new Select(size);
        System.out.println("选择大尺寸");
        select.selectByVisibleText("Large  61-76.2 cm/24-30\"");
        System.out.println("添加到购物车");
        javaTools.sleep(3000);
        javaTools.click(btn1);
    }

    @Test
    public void testBClick(){
        select = new Select(size);
        System.out.println("选择中尺寸");
        select.selectByVisibleText("Medium 48.3-64.8 cm/19-25.5\"");
        System.out.println("添加到购物车");
        javaTools.sleep(3000);
        javaTools.click(btn1);
    }

    @Test
    public void testCClick(){
        select = new Select(size);
        System.out.println("选择最大尺寸");
        select.selectByVisibleText("Extra Large 71.1-87.6 cm/28-34.5\"");
        System.out.println("添加到购物车");
        javaTools.sleep(3000);
        javaTools.click(btn1);
    }

    @AfterClass
    public static void alterClass(){
        driver.disconnect();
    }
}
