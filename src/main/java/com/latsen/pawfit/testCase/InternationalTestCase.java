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
public class InternationalTestCase {
    private static MyChromeDriverSingleton myChromeDriver;
    private static NewDriver driver;
    private static WebElement langage;
    private static WebElement English;
    private static WebElement french;
    private static WebElement german;
    private static JavaTools javaTools;
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
    private static WebElement p2add;
    private static WebElement checkout;
    private static WebElement login_email_address;
    private static WebElement login_password;
    private static WebElement login;
    private static WebElement register;
    private static WebElement forget_password;
    private static WebElement recent_order;
    private static WebElement details;
    private static WebElement list_of_orders;
    private static WebElement shopping_information;
    private static WebElement shopping_information_edit;
    private static WebElement changepassword;
    private static WebElement proceed_to_checkout;
    private static WebElement email;
    private static WebElement subscribe_btn;
    private static WebElement term;
    private static WebElement service;
    private static WebElement privary_policy;
    private static WebElement contact_us;
    private static WebElement legal;
    private static WebElement referral;
    private static WebElement fcc;


    @BeforeClass
    public static void beforeClass() throws IOException {
        System.out.println("已经执行");
        driver = new NewDriver(Const.HOME_URL);
        myChromeDriver = driver.connect();
        javaTools = new JavaTools();

        product=myChromeDriver.findElementByXPath("/html/body/div[1]/div/div/div/div/nav/ul/li[1]/a");
        customer=myChromeDriver.findElementByXPath("/html/body/div[1]/div/div/div/div/nav/ul/li[6]/a");
    }

//    获取页面的url
    public void url(){
        String currentURL = null;
        currentURL = myChromeDriver.getCurrentUrl();
        System.out.println(currentURL);
    }

//    切换英法德语言
    public void International() throws InterruptedException, IOException {
        langage=myChromeDriver.findElementById("dropdownMenu2");
        javaTools.jsclick(myChromeDriver,langage);
        french=myChromeDriver.findElementByLinkText("French (Français)");
        javaTools.jsclick(myChromeDriver,french);
        url();
        javaTools.sleep(3000);
        javaTools.scrFile(myChromeDriver);
        langage=myChromeDriver.findElementById("dropdownMenu2");
        javaTools.jsclick(myChromeDriver,langage);
        german=myChromeDriver.findElementByLinkText("German (Deutsch)");
        javaTools.jsclick(myChromeDriver,german);
        url();
        javaTools.sleep(3000);
        javaTools.scrFile(myChromeDriver);
        langage=myChromeDriver.findElementById("dropdownMenu2");
        javaTools.jsclick(myChromeDriver,langage);
        English=myChromeDriver.findElementByLinkText("English (English)");
        javaTools.jsclick(myChromeDriver,English);
        url();
        javaTools.sleep(3000);
        javaTools.scrFile(myChromeDriver);
    }

//    首页国际化
    @Test
    public void testAHome() throws InterruptedException, IOException {
        International();
    }

//    订阅页面国际化
    @Test
    public void testBsubscribe() throws InterruptedException, IOException {
        javaTools.scrollTobottom(myChromeDriver);
        email=myChromeDriver.findElementById("exampleInputEmail2");
        javaTools.inputText(myChromeDriver,"1790039849@qq.com",email);
        subscribe_btn=myChromeDriver.findElementByXPath("/html/body/div[6]/div/div/div/form/div[8]/button");
        javaTools.jsclick(myChromeDriver,subscribe_btn);
        javaTools.sleep(3000);
        International();
    }

//    服务协议和contant us国际化
    @Test
    public void testCagreement() throws InterruptedException, IOException {
        javaTools.scrollTobottom(myChromeDriver);
        legal=myChromeDriver.findElementByXPath("/html/body/div[7]/div/div[1]/ul[2]/li[1]/a");
        javaTools.jsclick(myChromeDriver,legal);
//        Terms of Use
        term=myChromeDriver.findElementByLinkText("Terms of Use");
        javaTools.jsclick(myChromeDriver,term);
        International();

//      Referrals Programme
        referral=myChromeDriver.findElementByLinkText("Referrals Programme");
        javaTools.jsclick(myChromeDriver,referral);
        International();

        //      FCC Compliance Statement
        fcc=myChromeDriver.findElementByLinkText("FCC Compliance Statement");
        javaTools.jsclick(myChromeDriver,fcc);
        International();

//        Service Agreement
        service=myChromeDriver.findElementByLinkText("Service Agreement");
        javaTools.jsclick(myChromeDriver,service);
        International();

//        Privacy Policy
        privary_policy=myChromeDriver.findElementByLinkText("Privacy Policy");
        javaTools.jsclick(myChromeDriver,privary_policy);
        International();

//        Contact Us
        javaTools.scrollTobottom(myChromeDriver);
        contact_us=myChromeDriver.findElementByLinkText("Contact Us");
        javaTools.jsclick(myChromeDriver,contact_us);
        International();
    }

    @Test
    public void testDproduct() throws InterruptedException, IOException {
//        点击跳转到product页面
        product=myChromeDriver.findElementByXPath("/html/body/div[1]/div/div/div/div/nav/ul/li[1]/a");
        javaTools.click(product);
        International();

//        点击跳转到Pawfit 2页面
        Actions action=new Actions(myChromeDriver);
        action.moveToElement(myChromeDriver.findElementByLinkText("Products")).perform();
        pawfit2=myChromeDriver.findElementByXPath("/html/body/div[1]/div[2]/div/div/div/nav/ul/li[1]/section/div/div[2]/div[1]/a");
        javaTools.jsclick(myChromeDriver,pawfit2);
        javaTools.sleep(3000);
        International();

//        点击跳转到配件页
        accessory=myChromeDriver.findElementByXPath("/html/body/div[1]/div[2]/div/div/div/nav/ul/li[1]/section/div/div[2]/div[2]/a");
        Actions action1=new Actions(myChromeDriver);
        action1.moveToElement(myChromeDriver.findElementByLinkText("Products")).perform();
        javaTools.click(accessory);
        International();
    }
    @Test
    public void testEhow() throws InterruptedException, IOException {
//        点击跳转到how it works页面
        how=myChromeDriver.findElementByXPath("/html/body/div[1]/div/div/div/div/nav/ul/li[2]/a");
        javaTools.click(how);
        International();
    }
    @Test
    public void testFblog() throws InterruptedException, IOException {
//        点击跳转到blog页面
        blog=myChromeDriver.findElementByXPath("/html/body/div[1]/div/div/div/div/nav/ul/li[3]/a");
        javaTools.click(blog);
        International();

//        点击跳转到story页面
        story=myChromeDriver.findElementByXPath("/html/body/div[1]/div[2]/div/div/div/nav/ul/li[3]/section/div/div[2]/div[2]/a");
        Actions action=new Actions(myChromeDriver);
        action.moveToElement(myChromeDriver.findElementByLinkText("Blog")).perform();
        javaTools.click(story);
        International();
    }

    @Test
    public void testGsupport() throws InterruptedException, IOException {
//        点击跳转到support页面
        support=myChromeDriver.findElementByXPath("/html/body/div[1]/div/div/div/div/nav/ul/li[4]/a");
        javaTools.click(support);
        International();

//        点击跳转到delicery页面
        delivery=myChromeDriver.findElementByXPath("/html/body/div[1]/div[2]/div/div/div/nav/ul/li[4]/section/div/div[2]/div[2]/a");
        Actions action=new Actions(myChromeDriver);
        action.moveToElement(myChromeDriver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/nav/ul/li[4]/a"))).perform();
        javaTools.click(delivery);
        International();
    }

    @Test
    public void testHcompany() throws InterruptedException, IOException {
//        点击跳转到company页面
        company=myChromeDriver.findElementByXPath("/html/body/div[1]/div/div/div/div/nav/ul/li[5]/a");
        javaTools.click(company);
        International();
    }

    @Test
    public void testIcustomer() throws InterruptedException, IOException {
//        点击跳转到customer页面
        customer=myChromeDriver.findElementByXPath("/html/body/div[1]/div/div/div/div/nav/ul/li[6]/a");
        javaTools.click(customer);
        International();

//        注册
        register=myChromeDriver.findElementByXPath("/html/body/div[3]/div/div/div[2]/a");
        javaTools.click(register);
        International();
        customer=myChromeDriver.findElementByXPath("/html/body/div[1]/div/div/div/div/nav/ul/li[6]/a");
        javaTools.click(customer);

//        忘记密码
        forget_password=myChromeDriver.findElementByXPath("/html/body/div[3]/div/div/div[1]/div[2]/form/p[1]/a");
        javaTools.click(forget_password);
        International();
        customer=myChromeDriver.findElementByXPath("/html/body/div[1]/div/div/div/div/nav/ul/li[6]/a");
        javaTools.click(customer);

//        登录账号
        login_email_address=myChromeDriver.findElementById("signin_userName");
        login_password=myChromeDriver.findElementById("signin_password");
        login=myChromeDriver.findElementById("genericLogin-button");
        javaTools.inputText(myChromeDriver,"1790039849@qq.com",login_email_address);
        javaTools.inputText(myChromeDriver,"123456",login_password);
        javaTools.click(login);
        javaTools.sleep(3000);
        International();

//        用户个人信息页面
        shopping_information=myChromeDriver.findElementByXPath("/html/body/div[3]/div/div[2]/div[1]/ul/li[1]/a");
        javaTools.click(shopping_information);
        International();

//        用户个人信息编辑
        shopping_information_edit=myChromeDriver.findElementByXPath("/html/body/div[3]/div[2]/div[2]/div/span/p/span[2]/a/button");
        javaTools.click(shopping_information_edit);
        International();

//        订单页面
        //        点击订单列表
        recent_order=myChromeDriver.findElementByXPath("/html/body/div[3]/div/div[2]/ul/li[2]/a");
        javaTools.click(recent_order);
        International();

//        点击跳转订单详情页面
        details=myChromeDriver.findElementByXPath("/html/body/div[4]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[6]/a");
        javaTools.click(details);
        International();

//        返回订单列表
        list_of_orders=myChromeDriver.findElementByXPath("/html/body/div[3]/div[3]/div[4]/div[2]/form[1]/button");
        javaTools.click(list_of_orders);
        International();

//        修改密码页面
        changepassword=myChromeDriver.findElementByXPath("/html/body/div[4]/div/div[1]/ul/li[3]/a");
        javaTools.click(changepassword);
        International();
    }

    //添加商品到购物车并跳转购物车页面
    @Test
    public void testJshopping_cart() throws InterruptedException, IOException {
        product=myChromeDriver.findElementByXPath("/html/body/div[1]/div/div/div/div/nav/ul/li[1]/a");
        javaTools.click(product);
        javaTools.sleep(3000);
        p2add=myChromeDriver.findElementByXPath("/html/body/section[1]/div/div/div[1]/div/div/div[3]/div[3]/a[2]");
        javaTools.click(p2add);
        checkout=myChromeDriver.findElementByLinkText("Checkout");
        Actions action=new Actions(myChromeDriver);
        action.moveToElement(myChromeDriver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div/div[1]/button"))).perform();
        javaTools.click(checkout);
        International();

//        跳转下订单页面
        proceed_to_checkout=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/div/div/div/div[2]/div[2]/div/a");
        javaTools.click(proceed_to_checkout);
        International();
    }

    @AfterClass
    public static void alterClass(){
        driver.disconnect();
    }
}
