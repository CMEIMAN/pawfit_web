package com.latsen.pawfit.testCase;

import com.latsen.pawfit.Const.Const;
import com.latsen.pawfit.common.Driver;
import junit.framework.TestCase;
import org.junit.FixMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.junit.runners.MethodSorters;
import org.openqa.selenium.support.ui.Select;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HomePageTestCase extends TestCase {
    private static WebElement pawfit;
    private static WebElement collar;
    private static WebElement strap;
    private static WebElement docks;
    private static WebElement attachment;
    private static WebElement collarSizeSelect;
    private static WebDriver driver;
    private static Actions actions;
    private static Driver demo;
    private Select select;

    public void Init() throws InterruptedException {
        demo=new Driver(Const.HOME_URL);
        driver=demo.connect();
        actions=new Actions(driver);
    }

    public void testBAddPawfitToBasket() throws InterruptedException {
        Init();
        System.out.println(" 添加pawfit2到购物车 ");
        Thread.sleep(3000);
        pawfit=driver.findElement(By.name("450"));
        pawfit.click();
    }
    public void testCAddCollarToBasket() throws InterruptedException {
//        修改，选择尺寸
        driver.get(Const.PAWFIT_COLLAR_URL);
        collarSizeSelect=driver.findElement(By.name("0"));
        select=new Select(collarSizeSelect);
        System.out.println("选择项圈尺寸");
        select.getOptions().get(1);
        System.out.println("添加项圈到购物车");
        Thread.sleep(3000);
        collar=driver.findElement(By.linkText("ADD TO BASKET"));
        collar.click();
        driver.navigate().back();
    }
    public void testDAddStrapToBasket() throws InterruptedException {
        System.out.println("添加橡胶扣到购物车");
        Thread.sleep(3000);
        strap=driver.findElement(By.name("454"));
        strap.click();
    }
    public void testEAddDocksToBasket() throws InterruptedException {
        System.out.println("添加充电底座到购物车");
        Thread.sleep(3000);
        docks=driver.findElement(By.name("455"));
        docks.click();

    }
    public void testFAddAttachmentToBasket ()throws InterruptedException {
        System.out.println("添加卡扣到购物车");
        Thread.sleep(3000);
        attachment=driver.findElement(By.name("500"));
        attachment.click();
        Thread.sleep(10000);
        demo.disconnect();

    }


}
