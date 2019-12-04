package com.latsen.pawfit.testCase;

import com.latsen.pawfit.common.Driver;
import junit.framework.TestCase;
import org.junit.FixMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HomePageTestCase extends TestCase {
    private static  WebElement pawfit;
    private static WebElement collar;
    private static WebElement strap;
    private static WebElement docks;
    private static WebElement attachment;
    private static WebDriver driver;
    private static Actions actions;
    private static Demo demo;

    public void Init() throws InterruptedException {
        demo=new Demo();
        driver=demo.connect();
        Thread.sleep(10000);
        actions=new Actions(driver);
    }

    public void testBAddPawfitToBasket() throws InterruptedException {
        Init();
        System.out.println("添加pawfit2到购物车");
        pawfit=driver.findElement(By.name("450"));
        pawfit.click();

    }
    public void testCAddCollarToBasket() throws InterruptedException {
        System.out.println("添加项圈到购物车");
        driver.wait(5);
        collar=driver.findElement(By.name("451"));
        collar.click();
    }
    public void testDAddStrapToBasket() throws InterruptedException {
        System.out.println("添加橡胶扣到购物车");
        driver.wait(5);

        strap=driver.findElement(By.name("454"));
        strap.click();
    }
    public void testEAddDocksToBasket() throws InterruptedException {
        System.out.println("添加充电底座到购物车");
        driver.wait(5);
        docks=driver.findElement(By.name("455"));
        docks.click();

    }
    public void testFAddAttachmentToBasket ()throws InterruptedException {
        System.out.println("添加卡扣到购物车");
        driver.wait(5);
        attachment=driver.findElement(By.name("500"));
        attachment.click();

    }


}
