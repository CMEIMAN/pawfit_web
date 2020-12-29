package com.latsen.pawfit.testCase;

import com.latsen.pawfit.Const.Const;
import com.latsen.pawfit.common.NewDriver;
import com.latsen.pawfit.driver.MyChromeDriverSingleton;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import java.io.IOException;
import com.latsen.pawfit.utils.JavaTools;

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
    private static MyChromeDriverSingleton driver;
    private static NewDriver webdriver;
    private static WebElement p2add;
    private static WebElement checkout;

    private static WebElement abuot_pawfit;
    private static WebElement company1;
    private static WebElement join;
    private static WebElement join_close;
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

    private static JavaTools javaTools;

    @BeforeClass
    public static void beforeClass() throws IOException {
        javaTools = new JavaTools();
        System.out.println("已经执行");
        webdriver = new NewDriver(Const.BASEURL);
        driver = webdriver.connect();
        home= driver.findElementByXPath("/html/body/div[1]/div/div/div/div/div[1]/a/img");
        product=driver.findElementByXPath("/html/body/div[1]/div/div/div/div/nav/ul/li[1]/a");
        customer=driver.findElementByXPath("/html/body/div[1]/div/div/div/div/nav/ul/li[6]/a");
    }

//    顶部导航栏
    @Test
    public void testAhome() throws IOException {
//        点击跳转到home页面
        home= driver.findElementByXPath("/html/body/div[1]/div/div/div/div/div[1]/a/img");
        javaTools.click(home);
        javaTools.scrFile(driver);
    }

    @Test
    public void testBproduct() throws IOException {
//        点击跳转到product页面
        product=driver.findElementByXPath("/html/body/div[1]/div/div/div/div/nav/ul/li[1]/a");
        javaTools.click(product);
        javaTools.scrFile(driver);
    }
    @Test
    public void testCpawfit2() throws IOException {
//        点击跳转到Pawfit 2页面
        pawfit2=driver.findElementByXPath("/html/body/div[1]/div[2]/div/div/div/nav/ul/li[1]/section/div/div[2]/div[1]/a");
        Actions action=new Actions(driver);
        action.moveToElement(driver.findElementByLinkText("Products")).perform();
        javaTools.click(pawfit2);
        javaTools.scrFile(driver);
    }
    @Test
    public void testDaccessory() throws IOException {
//        点击跳转到配件页
        accessory=driver.findElementByXPath("/html/body/div[1]/div/div/div/div/nav/ul/li[1]/section/div/div[2]/div[2]");
        Actions action=new Actions(driver);
        action.moveToElement(driver.findElementByLinkText("Products")).perform();
        javaTools.click(accessory);
        javaTools.scrFile(driver);
    }
    @Test
    public void testEhow() throws IOException {
//        点击跳转到how it works页面
        how=driver.findElementByXPath("/html/body/div[1]/div/div/div/div/nav/ul/li[2]/a");
        javaTools.click(how);
        javaTools.scrFile(driver);
    }
    @Test
    public void testFblog() throws IOException {
//        点击跳转到blog页面
        blog=driver.findElementByXPath("/html/body/div[1]/div/div/div/div/nav/ul/li[3]/a");
        javaTools.click(blog);
        javaTools.scrFile(driver);
    }
    @Test
    public void testGstory() throws IOException {
//        点击跳转到story页面
        story=driver.findElementByXPath("/html/body/div[1]/div/div/div/div/nav/ul/li[3]/section/div/div[2]/div[2]");
        Actions action=new Actions(driver);
        action.moveToElement(driver.findElementByLinkText("Blog")).perform();
        javaTools.click(story);
        javaTools.scrFile(driver);
    }

    @Test
    public void testHsupport() throws IOException {
//        点击跳转到support页面
        support=driver.findElementByXPath("/html/body/div[1]/div/div/div/div/nav/ul/li[4]/a");
        javaTools.click(support);
        javaTools.scrFile(driver);
    }

    @Test
    public void testIdelivery() throws IOException {
//        点击跳转到delicery页面
        delivery=driver.findElementByXPath("/html/body/div[1]/div/div/div/div/nav/ul/li[4]/section/div/div[2]/div[2]");
        Actions action=new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/nav/ul/li[4]/a"))).perform();
        javaTools.click(delivery);
        javaTools.scrFile(driver);
    }

    @Test
    public void testJcompany() throws IOException {
//        点击跳转到company页面
        company=driver.findElementByXPath("/html/body/div[1]/div/div/div/div/nav/ul/li[5]/a");
        javaTools.click(company);
        javaTools.scrFile(driver);
    }

    @Test
    public void testKcustomer() throws IOException {
//        点击跳转到customer页面
        customer=driver.findElementByXPath("/html/body/div[1]/div/div/div/div/nav/ul/li[6]/a");
        javaTools.click(customer);
        javaTools.scrFile(driver);
    }

//添加商品到购物车并跳转购物车页面
    @Test
    public void testLshopping_cart() throws IOException {
        product=driver.findElementByXPath("/html/body/div[1]/div/div/div/div/nav/ul/li[1]/a");
        javaTools.click(product);
        javaTools.sleep(3000);
        p2add=driver.findElementByXPath("/html/body/section[1]/div/div/div[1]/div/div/div[3]/div[3]/a[2]");
        javaTools.click(p2add);
        checkout=driver.findElementByLinkText("Checkout");
        Actions action=new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div/div[1]/button"))).perform();
        javaTools.click(checkout);
        javaTools.scrFile(driver);
    }

//    footer
    @Test
    public void testMabuot_pawfit() throws IOException {
//        滑动到底部
        javaTools.scrollTobottom(driver);
//        点击about pawfit
        abuot_pawfit=driver.findElementByLinkText("About Pawfit");
        javaTools.click(abuot_pawfit);
        javaTools.scrFile(driver);
    }

    @Test
    public void testNcompany1() throws IOException {
        javaTools.scrollTobottom(driver);
//        点击Company
        company1=driver.findElementByLinkText("Company");
        javaTools.click(company1);
        javaTools.scrFile(driver);
    }

    @Test
    public void testOjoin() throws IOException {
        javaTools.scrollTobottom(driver);
//        点击Join Our Affiliate Programme
        join=driver.findElementByLinkText("Join Our Affiliate Programme");
        javaTools.click(join);
        javaTools.scrFile(driver);
    }

    @Test
    public void testPwhat() throws IOException {
        javaTools.scrollTobottom(driver);
//        点击What Our Customers Say
        what=driver.findElementByLinkText("What Our Customers Say");
        javaTools.click(what);
        javaTools.scrFile(driver);
        javaTools.back(driver);
    }

    @Test
    public void testQdelivery_info() throws IOException {
        javaTools.scrollTobottom(driver);
        //        点击Delivery Info
        delivery_info=driver.findElementByLinkText("Delivery Info");
        javaTools.click(delivery_info);
        javaTools.scrFile(driver);
    }

    @Test
    public void testRfaq() throws IOException {
        javaTools.scrollTobottom(driver);
//        点击FAQ's
        faq=driver.findElementByLinkText("FAQ's");
        javaTools.click(faq);
        javaTools.sleep(3000);
        javaTools.scrFile(driver);
        join_close=driver.findElementByXPath("/html/body/div[6]/div/div[1]/div[2]/div/div/div[1]/button/span/svg");
    }

    @Test
    public void testSlegal() throws IOException {
        javaTools.scrollTobottom(driver);
//        点击Legal
        legal=driver.findElementByLinkText("Legal");
        javaTools.click(legal);
        javaTools.scrFile(driver);

        term=driver.findElementByXPath("/html/body/div[3]/div[2]/div/div[2]/div/ul/li[2]/a");
        javaTools.click(term);
        javaTools.scrFile(driver);

        referral=driver.findElementByXPath("/html/body/div[3]/div[2]/div/div[2]/div/ul/li[4]/a");
        javaTools.click(referral);
        javaTools.scrFile(driver);

        fcc=driver.findElementByXPath("/html/body/div[3]/div[2]/div/div[2]/div/ul/li[5]/a");
        javaTools.click(fcc);
        javaTools.scrFile(driver);

        service_agreement=driver.findElementByXPath("/html/body/div[3]/div[2]/div/div[2]/div/ul/li[3]/a");
        javaTools.click(service_agreement);
        javaTools.scrFile(driver);

        privary_policy=driver.findElementByXPath("/html/body/div[3]/div[2]/div/div[2]/div/ul/li[1]/a");
        javaTools.click(privary_policy);
        javaTools.scrFile(driver);
    }

    @Test
    public void testVcontact_us() throws IOException {
        javaTools.scrollTobottom(driver);
//        点击Contact Us
        contact_us=driver.findElementByLinkText("Contact Us");
        javaTools.click(contact_us);
        javaTools.scrFile(driver);
    }

    @Test
    public void testWuser_manuals() throws IOException {
        javaTools.scrollTobottom(driver);
//        点击User Manuals
        user_manuals=driver.findElementByLinkText("User Manuals");
        javaTools.click(user_manuals);
        javaTools.scrFile(driver);
        close=driver.findElementByXPath("/html/body/div[5]/div/div/div[1]/img");
        javaTools.click(close);
    }

    @Test
    public void testXsupport1() throws IOException {
//        点击Support
        javaTools.scrollTobottom(driver);
        support1=driver.findElementByLinkText("Support");
        javaTools.click(support1);
        javaTools.scrFile(driver);
    }

    @AfterClass
    public static void alterClass(){
       webdriver.disconnect();
    }
}




