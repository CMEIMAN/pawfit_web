package com.latsen.pawfit.testCase;

import com.latsen.pawfit.Const.Const;
import com.latsen.pawfit.common.Driver;
import com.latsen.pawfit.driver.MyChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.io.IOException;
import com.latsen.pawfit.utils.JavaTools;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Pawfit_collarEditTestCase{
    private static Driver driver;
    private static MyChromeDriver myChromeDriver;
    private static WebElement add;
    private static WebElement size;
    private static WebElement img1;
    private static WebElement img2;
    private static Select select;
    private static JavaTools javaTools;

    @BeforeClass
    public static void beforeClass() throws IOException {
        System.out.println("已经执行");
        driver = new Driver(Const.PAWFIT_COLLAR_URL);
        myChromeDriver = driver.connect();
        javaTools = new JavaTools();

        add=myChromeDriver.findElementByXPath("/html/body/section/div[2]/div/div/div/div[1]/div/div/div[2]/div/div[2]/div/div[1]/button");
        size=myChromeDriver.findElementByXPath("/html/body/section/div[2]/div/div/div/div[1]/div/div/div[2]/div/div[2]/div/div[1]/div/form/div/div/select");
        img1=myChromeDriver.findElementByXPath("/html/body/section/div[2]/div/div/div/div[1]/div/div/div[1]/ul/li[1]/a");
        img2=myChromeDriver.findElementByXPath("/html/body/section/div[2]/div/div/div/div[1]/div/div/div[1]/ul/li[2]/a");
    }

    @Test
    public void testAAdd() throws InterruptedException {
        select = new Select(size);
        System.out.println("选择项圈小尺寸");
        select.selectByVisibleText("Small 26-42 cm/10.2-16.5 in");
        System.out.println("添加小项圈到购物车");
        javaTools.sleep(3000);
        javaTools.click(add);

        System.out.println("选择项圈中尺寸");
        select.selectByVisibleText("Medium 35-55 cm/13.8-21.7 in");
        System.out.println("添加中项圈到购物车");
        javaTools.sleep(3000);
        javaTools.click(add);

        System.out.println("选择项圈大尺寸");
        select.selectByVisibleText("Large 42-65 cm/16.5-25.6 in");
        System.out.println("添加大项圈到购物车");
        javaTools.sleep(3000);
        javaTools.click(add);
    }

    @Test
    public void testBImg() {
        javaTools.click(img1);
        javaTools.click(img2);
    }
    @AfterClass
    public static void alterClass(){
        driver.disconnect();
    }

}
