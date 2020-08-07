package com.latsen.pawfit.testCase;

import com.latsen.pawfit.Const.Const;
import com.latsen.pawfit.common.Driver;
import junit.framework.TestCase;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.junit.runners.MethodSorters;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.net.MalformedURLException;

//@org.testng.annotations.Test(groups = "Group")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HomePageTestCase {
    private static WebElement pawfit;
    private static WebElement collar;
    private static WebElement strap;
    private static WebElement docks;
    private static WebElement attachment;
    private static WebElement collarSizeSelect;
    private static WebDriver driver;
    private static Actions actions;
    private static Driver demo;
    private static Select select;
    @BeforeClass
    public static void beforeClass() throws InterruptedException, IOException {
        demo=new Driver(Const.HOME_URL);
        try {
            driver=demo.connect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        actions=new Actions(driver);
    }
    @Test
    public void testBAddPawfitToBasket() throws InterruptedException {
        System.out.println(" 添加pawfit2到购物车 ");
        pawfit=driver.findElement(By.name("450"));
        pawfit.click();
    }
    @Test
    public void testCAddCollarToBasket() throws InterruptedException {
        //修改，选择尺寸
        driver.get(Const.PAWFIT_COLLAR_URL);
        collarSizeSelect=driver.findElement(By.name("0"));
        select=new Select(collarSizeSelect);
        System.out.println("选择项圈尺寸");
        select.selectByVisibleText("Small 26-42 cm/10.2-16.5 in");
        System.out.println("添加项圈到购物车");
        collar=driver.findElement(By.name("451"));
        Thread.sleep(3000);
        collar.click();
    }
    @Test
    public void testDAddStrapToBasket() throws InterruptedException {
        System.out.println("添加橡胶扣到购物车");
        strap=driver.findElement(By.name("454"));
        strap.click();
    }
    @Test
    public void testEAddDocksToBasket() throws InterruptedException {
        System.out.println("添加充电底座到购物车");
        docks=driver.findElement(By.name("455"));
        docks.click();

    }
    @Test
    public void testFAddAttachmentToBasket ()throws InterruptedException {
        System.out.println("添加卡扣到购物车");
        attachment=driver.findElement(By.name("500"));
        attachment.click();

    }
    @AfterClass
    public static void alterClass(){
        demo.disconnect();
    }


}
