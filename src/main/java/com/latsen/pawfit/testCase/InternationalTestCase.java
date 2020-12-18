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
import org.testng.internal.Utils;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InternationalTestCase {
    private static MyChromeDriverSingleton myChromeDriver;
    private static NewDriver driver;
    private static WebElement langage;
    private static WebElement English;
    private static WebElement french;
    private static WebElement german;
    private Utils FileUtils;
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
    public void International() throws InterruptedException {
        langage=myChromeDriver.findElementById("dropdownMenu2");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",langage);
        french=myChromeDriver.findElementByLinkText("French (Français)");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",french);
        url();
        Thread.sleep(3000);
        scrFile();
        langage=myChromeDriver.findElementById("dropdownMenu2");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",langage);
        german=myChromeDriver.findElementByLinkText("German (Deutsch)");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",german);
        url();
        Thread.sleep(3000);
        scrFile();
        langage=myChromeDriver.findElementById("dropdownMenu2");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",langage);
        English=myChromeDriver.findElementByLinkText("English (English)");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",English);
        url();
        Thread.sleep(3000);
        scrFile();
    }
    
    //截图
    public void scrFile(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");  //转换时间格式
        String time = dateFormat.format(Calendar.getInstance().getTime());  //获取当前时间
        String Name = Thread.currentThread().getStackTrace()[2].getMethodName();//获取当前类名
        File srcFile = ((TakesScreenshot)myChromeDriver).getScreenshotAs(OutputType.FILE);  //执行屏幕截取
        FileUtils.copyFile(srcFile, new File("C:\\Users\\Admin\\web_test\\src\\img\\International", Name+"_"+time + ".png"));
    }

    //下滑到底部
    public void scroll(){
        ((JavascriptExecutor) myChromeDriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

//    首页国际化
    @Test
    public void testAHome() throws InterruptedException {
        International();
    }

//    订阅页面国际化
    @Test
    public void testBsubscribe() throws InterruptedException {
        scroll();
        email=myChromeDriver.findElementById("exampleInputEmail2");
        email.sendKeys("1790039849@qq.com");
        subscribe_btn=myChromeDriver.findElementByXPath("/html/body/div[6]/div/div/div/form/div[8]/button");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",subscribe_btn);
        Thread.sleep(3000);
        International();
    }

//    服务协议和contant us国际化
    @Test
    public void testCagreement() throws InterruptedException {
        scroll();
        legal=myChromeDriver.findElementByXPath("/html/body/div[7]/div/div[1]/ul[2]/li[1]/a");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",legal);
//        Terms of Use
        term=myChromeDriver.findElementByLinkText("Terms of Use");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",term);
        International();

//      Referrals Programme
        term=myChromeDriver.findElementByLinkText("Referrals Programme");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",referral);
        International();

        //      FCC Compliance Statement
        term=myChromeDriver.findElementByLinkText("FCC Compliance Statement");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",fcc);
        International();

//        Service Agreement
        service=myChromeDriver.findElementByLinkText("Service Agreement");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",service);
        International();

//        Privacy Policy
        privary_policy=myChromeDriver.findElementByLinkText("Privacy Policy");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",privary_policy);
        International();

//        Contact Us
        scroll();
        contact_us=myChromeDriver.findElementByLinkText("Contact Us");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",contact_us);
        International();
    }

    @Test
    public void testDproduct() throws InterruptedException {
//        点击跳转到product页面
        product=myChromeDriver.findElementByXPath("/html/body/div[1]/div/div/div/div/nav/ul/li[1]/a");
        product.click();
        International();

//        点击跳转到Pawfit 2页面
        Actions action=new Actions(myChromeDriver);
        action.moveToElement(myChromeDriver.findElementByLinkText("Products")).perform();
        pawfit2=myChromeDriver.findElementByXPath("/html/body/div[1]/div[2]/div/div/div/nav/ul/li[1]/section/div/div[2]/div[1]/a");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",pawfit2);
        Thread.sleep(3000);
        International();

//        点击跳转到配件页
        accessory=myChromeDriver.findElementByXPath("/html/body/div[1]/div[2]/div/div/div/nav/ul/li[1]/section/div/div[2]/div[2]/a");
        Actions action1=new Actions(myChromeDriver);
        action1.moveToElement(myChromeDriver.findElementByLinkText("Products")).perform();
        accessory.click();
        International();
    }
    @Test
    public void testEhow() throws InterruptedException {
//        点击跳转到how it works页面
        how=myChromeDriver.findElementByXPath("/html/body/div[1]/div/div/div/div/nav/ul/li[2]/a");
        how.click();
        International();
    }
    @Test
    public void testFblog() throws InterruptedException {
//        点击跳转到blog页面
        blog=myChromeDriver.findElementByXPath("/html/body/div[1]/div/div/div/div/nav/ul/li[3]/a");
        blog.click();
        International();

//        点击跳转到story页面
        story=myChromeDriver.findElementByXPath("/html/body/div[1]/div[2]/div/div/div/nav/ul/li[3]/section/div/div[2]/div[2]/a");
        Actions action=new Actions(myChromeDriver);
        action.moveToElement(myChromeDriver.findElementByLinkText("Blog")).perform();
        story.click();
        International();
    }

    @Test
    public void testGsupport() throws InterruptedException {
//        点击跳转到support页面
        support=myChromeDriver.findElementByXPath("/html/body/div[1]/div/div/div/div/nav/ul/li[4]/a");
        support.click();
        International();

//        点击跳转到delicery页面
        delivery=myChromeDriver.findElementByXPath("/html/body/div[1]/div[2]/div/div/div/nav/ul/li[4]/section/div/div[2]/div[2]/a");
        Actions action=new Actions(myChromeDriver);
        action.moveToElement(myChromeDriver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/nav/ul/li[4]/a"))).perform();
        delivery.click();
        International();
    }

    @Test
    public void testHcompany() throws InterruptedException {
//        点击跳转到company页面
        company=myChromeDriver.findElementByXPath("/html/body/div[1]/div/div/div/div/nav/ul/li[5]/a");
        company.click();
        International();
    }

    @Test
    public void testIcustomer() throws InterruptedException {
//        点击跳转到customer页面
        customer=myChromeDriver.findElementByXPath("/html/body/div[1]/div/div/div/div/nav/ul/li[6]/a");
        customer.click();
        International();

//        注册
        register=myChromeDriver.findElementByXPath("/html/body/div[3]/div/div/div[2]/a");
        register.click();
        International();
        customer=myChromeDriver.findElementByXPath("/html/body/div[1]/div/div/div/div/nav/ul/li[6]/a");
        customer.click();

//        忘记密码
        forget_password=myChromeDriver.findElementByXPath("/html/body/div[3]/div/div/div[1]/div[2]/form/p[1]/a");
        forget_password.click();
        International();
        customer=myChromeDriver.findElementByXPath("/html/body/div[1]/div/div/div/div/nav/ul/li[6]/a");
        customer.click();

//        登录账号
        login_email_address=myChromeDriver.findElementById("signin_userName");
        login_password=myChromeDriver.findElementById("signin_password");
        login=myChromeDriver.findElementById("genericLogin-button");
        login_email_address.sendKeys("1790039849@qq.com");
        login_password.sendKeys("123456");
        login.click();
        Thread.sleep(3000);
        International();

//        用户个人信息页面
        shopping_information=myChromeDriver.findElementByXPath("/html/body/div[3]/div/div[2]/div[1]/ul/li[1]/a");
        shopping_information.click();
        International();

//        用户个人信息编辑
        shopping_information_edit=myChromeDriver.findElementByXPath("/html/body/div[3]/div[2]/div[2]/div/span/p/span[2]/a/button");
        shopping_information_edit.click();
        International();

//        订单页面
        //        点击订单列表
        recent_order=myChromeDriver.findElementByXPath("/html/body/div[3]/div/div[2]/ul/li[2]/a");
        recent_order.click();
        International();

//        点击跳转订单详情页面
        details=myChromeDriver.findElementByXPath("/html/body/div[4]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[6]/a");
        details.click();
        International();

//        返回订单列表
        list_of_orders=myChromeDriver.findElementByXPath("/html/body/div[3]/div[3]/div[4]/div[2]/form[1]/button");
        list_of_orders.click();
        International();

//        修改密码页面
        changepassword=myChromeDriver.findElementByXPath("/html/body/div[4]/div/div[1]/ul/li[3]/a");
        changepassword.click();
        International();
    }

    //添加商品到购物车并跳转购物车页面
    @Test
    public void testJshopping_cart() throws InterruptedException {
        product=myChromeDriver.findElementByXPath("/html/body/div[1]/div/div/div/div/nav/ul/li[1]/a");
        product.click();
        Thread.sleep(3000);
        p2add=myChromeDriver.findElementByXPath("/html/body/section[1]/div/div/div[1]/div/div/div[3]/div[3]/a[2]");
        p2add.click();
        checkout=myChromeDriver.findElementByLinkText("Checkout");
        Actions action=new Actions(myChromeDriver);
        action.moveToElement(myChromeDriver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div/div[1]/button"))).perform();
        checkout.click();
        International();

//        跳转下订单页面
        proceed_to_checkout=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/div/div/div/div[2]/div[2]/div/a");
        proceed_to_checkout.click();
        International();
    }

    @AfterClass
    public static void alterClass(){
        driver.disconnect();
    }
}
