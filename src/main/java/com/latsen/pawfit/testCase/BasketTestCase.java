package com.latsen.pawfit.testCase;

import com.latsen.pawfit.Const.Const;
import com.latsen.pawfit.common.Driver;
import com.latsen.pawfit.driver.MyChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.internal.Utils;
import java.io.File;
import java.io.IOException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BasketTestCase {
    private static WebElement home;
    private static WebElement product;
    private static WebElement pawfit2;
    private static WebElement accessory;
    private static WebElement how;
    private static WebElement blog;
    private static WebElement story;
    private static WebElement support;
    private static WebElement delivery;
    private static WebElement company;
    private static WebElement customer;
    private static MyChromeDriver driver;
    private static Driver webdriver;
    private Utils FileUtils;
    private static WebElement p2add;
    private static WebElement checkout;

    private static WebElement abuot_pawfit;
    private static WebElement company1;
    private static WebElement join;
    private static WebElement what;
    private static WebElement delivery_info;
    private static WebElement faq;
    private static WebElement term;
    private static WebElement service_agreement;
    private static WebElement privary_policy;
    private static WebElement contact_us;
    private static WebElement user_manuals;
    private static WebElement support1;
    private static WebElement close;
    private static WebElement legal;
    private static WebElement referral;
    private static WebElement fcc;

    @BeforeClass
    public static void beforeClass() throws IOException {
        System.out.println("已经执行");
        webdriver = new Driver(Const.BASEURL);
        driver = webdriver.connect();
        home= driver.findElementByXPath("/html/body/div[1]/div/div/div/div/div[1]/a/img");
        product=driver.findElementByXPath("/html/body/div[1]/div/div/div/div/nav/ul/li[1]/a");
        customer=driver.findElementByXPath("/html/body/div[1]/div/div/div/div/nav/ul/li[6]/a");

        abuot_pawfit=driver.findElementByXPath("/html/body/div[8]/div/div[1]/ul[1]/li[1]/a");
        company1=driver.findElementByXPath("/html/body/div[8]/div/div[1]/ul[1]/li[2]/a");
        join=driver.findElementByXPath("/html/body/div[8]/div/div[1]/ul[1]/li[3]/a");
        what=driver.findElementByXPath("/html/body/div[8]/div/div[1]/ul[1]/li[4]/a");
        delivery_info=driver.findElementByXPath("/html/body/div[8]/div/div[1]/ul[1]/li[5]/a");
        faq=driver.findElementByXPath("/html/body/div[8]/div/div[1]/ul[1]/li[6]");
        term=driver.findElementByXPath("/html/body/div[3]/div[2]/div/div[2]/div/ul/li[2]/a");
        service_agreement=driver.findElementByXPath("/html/body/div[3]/div[2]/div/div[2]/div/ul/li[5]/a");
        privary_policy=driver.findElementByXPath("/html/body/div[3]/div[2]/div/div[2]/div/ul/li[1]/b/a");
        contact_us=driver.findElementByXPath("/html/body/div[8]/div/div[1]/ul[2]/li[4]/a");
        user_manuals=driver.findElementByXPath("/html/body/div[8]/div/div[1]/ul[2]/li[5]");
        support1=driver.findElementByXPath("/html/body/div[8]/div/div[1]/ul[2]/li[6]/a");
        legal= driver.findElementByXPath("/html/body/div[8]/div/div[1]/ul[2]/li[1]/a");
        referral= driver.findElementByXPath("/html/body/div[3]/div[2]/div/div[2]/div/ul/li[3]/a");
        fcc=driver.findElementByXPath("/html/body/div[3]/div[2]/div/div[2]/div/ul/li[4]/a");
    }

    //截图
    public void scrFile(){
        long date=System.currentTimeMillis();
        String path = String.valueOf(date);
        String curPath =System.getProperty("user.dir");
        path =path+".png";
        String screenPath = curPath+"/"+path;
        File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screen,new File(screenPath));
    }

    //下滑到底部
    public void scroll(){
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

//    顶部导航栏
    @Test
    public void testAhome() {
//        点击跳转到home页面
        home.click();
        scrFile();
    }

    @Test
    public void testBproduct() {
//        点击跳转到product页面
        product=driver.findElementByXPath("/html/body/div[1]/div/div/div/div/nav/ul/li[1]/a");
        product.click();
        scrFile();
    }
    @Test
    public void testCpawfit2() {
//        点击跳转到Pawfit 2页面
        pawfit2=driver.findElementByXPath("/html/body/div[1]/div[2]/div/div/div/nav/ul/li[1]/section/div/div[2]/div[1]/a");
        Actions action=new Actions(driver);
        action.moveToElement(driver.findElementByLinkText("Products")).perform();
        pawfit2.click();
        scrFile();
    }
    @Test
    public void testDaccessory() {
//        点击跳转到配件页
        accessory=driver.findElementByXPath("/html/body/div[1]/div/div/div/div/nav/ul/li[1]/section/div/div[2]/div[2]");
        Actions action=new Actions(driver);
        action.moveToElement(driver.findElementByLinkText("Products")).perform();
        accessory.click();
        scrFile();
    }
    @Test
    public void testEhow() {
//        点击跳转到how it works页面
        how=driver.findElementByXPath("/html/body/div[1]/div/div/div/div/nav/ul/li[2]/a");
        how.click();
        scrFile();
    }
    @Test
    public void testFblog() {
//        点击跳转到blog页面
        blog=driver.findElementByXPath("/html/body/div[1]/div/div/div/div/nav/ul/li[3]/a");
        blog.click();
        scrFile();
    }
    @Test
    public void testGstory() {
//        点击跳转到story页面
        story=driver.findElementByXPath("/html/body/div[1]/div/div/div/div/nav/ul/li[3]/section/div/div[2]/div[2]");
        Actions action=new Actions(driver);
        action.moveToElement(driver.findElementByLinkText("Blog")).perform();
        story.click();
        scrFile();
    }

    @Test
    public void testHsupport() {
//        点击跳转到support页面
        support=driver.findElementByXPath("/html/body/div[1]/div/div/div/div/nav/ul/li[4]/a");
        support.click();
        scrFile();
    }

    @Test
    public void testIdelivery() {
//        点击跳转到delicery页面
        delivery=driver.findElementByXPath("/html/body/div[1]/div/div/div/div/nav/ul/li[4]/section/div/div[2]/div[2]");
        Actions action=new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/nav/ul/li[4]/a"))).perform();
        delivery.click();
        scrFile();
    }

    @Test
    public void testJcompany() {
//        点击跳转到company页面
        company=driver.findElementByXPath("/html/body/div[1]/div/div/div/div/nav/ul/li[5]/a");
        company.click();
        scrFile();
    }

    @Test
    public void testKcustomer() {
//        点击跳转到customer页面
        customer=driver.findElementByXPath("/html/body/div[1]/div/div/div/div/nav/ul/li[6]/a");
        customer.click();
        scrFile();
    }

//添加商品到购物车并跳转购物车页面
    @Test
    public void testLshopping_cart() throws InterruptedException {
        product=driver.findElementByXPath("/html/body/div[1]/div/div/div/div/nav/ul/li[1]/a");
        product.click();
        Thread.sleep(3000);
        p2add=driver.findElementByXPath("/html/body/section[1]/div/div/div[1]/div/div/div[3]/div[3]/a[2]");
        p2add.click();
        checkout=driver.findElementByLinkText("Checkout");
        Actions action=new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div/div[1]/button"))).perform();
        checkout.click();
        scrFile();
    }

//    footer
    @Test
    public void testMabuot_pawfit() {
//        滑动到底部
        scroll();
//        点击about pawfit
        abuot_pawfit=driver.findElementByLinkText("About Pawfit");
        abuot_pawfit.click();
        scrFile();
    }

    @Test
    public void testNcompany1() {
        scroll();
//        点击Company
        company1=driver.findElementByLinkText("Company");
        company1.click();
        scrFile();
    }

    @Test
    public void testOjoin() {
        scroll();
//        点击Join Our Affiliate Programme
        join=driver.findElementByLinkText("Join Our Affiliate Programme");
        join.click();
        scrFile();
    }

    @Test
    public void testPwhat() {
        scroll();
//        点击What Our Customers Say
        what=driver.findElementByLinkText("What Our Customers Say");
        what.click();
        scrFile();
        driver.navigate().back();
    }

    @Test
    public void testQdelivery_info() {
        scroll();
        //        点击Delivery Info
        delivery_info=driver.findElementByLinkText("Delivery Info");
        delivery_info.click();
        scrFile();
    }

    @Test
    public void testRfaq() {
        scroll();
//        点击FAQ's
        faq=driver.findElementByLinkText("FAQ's");
        faq.click();
        scrFile();
    }

//    @Test
//    public void testSterm() {
//        scroll();
////        点击Terms of Use
//        term=driver.findElementByLinkText("Terms of Use");
//        term.click();
//        scrFile();
//    }
//
//    @Test
//    public void testTservice_agreement() {
//        scroll();
////        点击Service Agreement
//        service_agreement=driver.findElementByLinkText("Service Agreement");
//        service_agreement.click();
//        scrFile();
//    }
//
//    @Test
//    public void testUprivary_policy() {
//        scroll();
////        点击Privacy Policy
//        privary_policy=driver.findElementByLinkText("Privacy Policy");
//        privary_policy.click();
//        scrFile();
//    }

    @Test
    public void testSlegal() {
        scroll();
//        点击Legal
        legal=driver.findElementByLinkText("Legal");
        legal.click();
        scrFile();

        term.click();
        scrFile();

        referral.click();
        scrFile();

        fcc.click();
        scrFile();

        service_agreement.click();
        scrFile();

        privary_policy.click();
        scrFile();
    }

    @Test
    public void testVcontact_us() {
        scroll();
//        点击Contact Us
        contact_us=driver.findElementByLinkText("Contact Us");
        contact_us.click();
        scrFile();
    }

    @Test
    public void testWuser_manuals() {
        scroll();
//        点击User Manuals
        user_manuals=driver.findElementByLinkText("User Manuals");
        user_manuals.click();
        scrFile();
        close=driver.findElementByXPath("/html/body/div[5]/div/div/div[1]/img");
        close.click();
    }

    @Test
    public void testXsupport1() {
//        点击Support
        scroll();
        support1=driver.findElementByLinkText("Support");
        support1.click();
        scrFile();
    }

    @AfterClass
    public static void alterClass(){
       webdriver.disconnect();
    }
}




