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
public class Referral_CodeTestCase {
    private static Driver driver;
    private static MyChromeDriver myChromeDriver;
    private static WebElement add;
    private static WebElement add1;
    private static WebElement checkout;
    private static WebElement code;
    private static WebElement apply;
    private static WebElement cancel;
    private static WebElement increase;
    private static WebElement email;
    private static WebElement password;
    private static WebElement login;
    private static WebElement product;
    private static WebElement submit;
    private static WebElement email1;
    private Utils FileUtils;

    @BeforeClass
    public static void beforeClass() throws IOException, InterruptedException {
        System.out.println("已经执行");
        driver = new Driver(Const.LOGiN_URL);
        myChromeDriver = driver.connect();
//       登录账号
        email=myChromeDriver.findElementById("signin_userName");
        password=myChromeDriver.findElementById("signin_password");
        login =myChromeDriver.findElementById("genericLogin-button");
        email.sendKeys("1790039849@qq.com");
        password.sendKeys("12345678");
        login.click();
        Thread.sleep(3000);

//       点击进入product页面
        product=myChromeDriver.findElementByXPath("/html/body/div[1]/div[2]/div/div/div/nav/ul/li[1]/a");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",product);


        //        添加商品到购物车
        add= myChromeDriver.findElementByXPath("/html/body/section[1]/div/div/div[1]/div/div/div[3]/div[3]/a[2]/button");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",add);
        Thread.sleep(2000);
//        添加配件
        add1=myChromeDriver.findElementByXPath("/html/body/section[2]/div/div/div[2]/div/div/div/div[1]/div[3]/a[2]/button");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",add1);

        //        点击购物车跳转购物车页面
        Actions action=new Actions(myChromeDriver);
        action.moveToElement(myChromeDriver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div/div[1]/button"))).perform();
        myChromeDriver.findElementByClassName("checkout-bg").click();

        //        点击跳转checkout页面
        checkout=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/div/div/div/div[2]/div[2]/div/a");
        checkout.click();
    }

    //截图
    public void scrFile(){
        long date=System.currentTimeMillis();
        String path = String.valueOf(date);
        String curPath =System.getProperty("user.dir");
        path =path+".png";
        String screenPath = curPath+"/"+path;
        File screen = ((TakesScreenshot) myChromeDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screen,new File(screenPath));
    }

    @Test
    public void testAReferral_Code() throws InterruptedException {
        Thread.sleep(3000);
        code=myChromeDriver.findElementById("discount");
        apply=myChromeDriver.findElementByCssSelector("#summaryRows > tr:nth-child(4) > td > div > button");
        /*注入数据*/
        for(int i=0;i<Const.getCommomText().length;i++) {
            code.sendKeys("" + Const.getCommomText()[i]);
            ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",apply);
        }
    }

    @Test
    public void testBReferral_Code1_p2() throws InterruptedException {
//       设备使用优惠码
//        输入空
        Thread.sleep(3000);
        code=myChromeDriver.findElementById("discount");
        code.clear();
        code.sendKeys("");
        apply=myChromeDriver.findElementByCssSelector("#summaryRows > tr:nth-child(4) > td > div > button");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",apply);
        Thread.sleep(3000);
        scrFile();

//        输入错误优惠码
        code=myChromeDriver.findElementById("discount");
        apply=myChromeDriver.findElementByCssSelector("#summaryRows > tr:nth-child(4) > td > div > button");
        code.sendKeys("11111111");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",apply);
        Thread.sleep(3000);
        scrFile();

//        输入特殊字符优惠码
        code=myChromeDriver.findElementById("discount");
        apply=myChromeDriver.findElementByCssSelector("#summaryRows > tr:nth-child(4) > td > div > button");
        code.clear();
        code.sendKeys("@#$%^&*~>");
        apply.click();
        Thread.sleep(3000);
        scrFile();

//        输入减扣优惠码
        code=myChromeDriver.findElementById("discount");
        apply=myChromeDriver.findElementByCssSelector("#summaryRows > tr:nth-child(4) > td > div > button");
        code.clear();
        code.sendKeys("1XXXXXX");
        apply.click();
        Thread.sleep(3000);
        scrFile();
////        提交订单
//        submit=myChromeDriver.findElementById("submitOrder");
//        submit.click();
//        Thread.sleep(3000);
//        scrFile();
//        myChromeDriver.navigate().back();

//        输入折扣优惠码
        code=myChromeDriver.findElementById("discount");
        apply=myChromeDriver.findElementByCssSelector("#summaryRows > tr:nth-child(4) > td > div > button");
        code.clear();
        code.sendKeys("58994V");
        apply.click();
        Thread.sleep(3000);
        scrFile();
//        提交订单
        submit=myChromeDriver.findElementById("submitOrder");
        submit.click();
        Thread.sleep(3000);
        scrFile();
        myChromeDriver.navigate().back();

//        输入免费优惠码
        code=myChromeDriver.findElementById("discount");
        apply=myChromeDriver.findElementByCssSelector("#summaryRows > tr:nth-child(4) > td > div > button");
        code.clear();
        code.sendKeys("3XXXXXX");
        apply.click();
        Thread.sleep(3000);
        scrFile();
////        提交订单
//        submit=myChromeDriver.findElementById("submitOrder");
//        submit.click();
//        Thread.sleep(3000);
//        scrFile();
//        myChromeDriver.navigate().back();

//        输入配件优惠码
        code=myChromeDriver.findElementById("discount");
        apply=myChromeDriver.findElementByCssSelector("#summaryRows > tr:nth-child(4) > td > div > button");
        code.clear();
        code.sendKeys("4XXXXXX");
        apply.click();
        Thread.sleep(3000);
        scrFile();
    }

//    配件单个不足50元
    @Test
    public void testCReferral_Code2_accessory_reduce() throws InterruptedException {
        myChromeDriver.navigate().back();
        cancel=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/div/div/div/div[1]/table/tbody/tr[1]/td[4]/div/a");
        cancel.click();
        checkout=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/div/div/div/div[2]/div[2]/div/a");
        checkout.click();

//      输入p2优惠码
        code=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/form/div[2]/div/div[1]/table/tbody/tr[3]/td/div/input");
        apply=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/form/div[2]/div/div[1]/table/tbody/tr[3]/td/div/button");
        code.clear();
        code.sendKeys("XXXXXX1");
        apply.click();
        Thread.sleep(3000);
        scrFile();

//        输入价格总价必须>50的优惠码
        code=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/form/div[2]/div/div[1]/table/tbody/tr[3]/td/div/input");
        apply=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/form/div[2]/div/div[1]/table/tbody/tr[3]/td/div/button");
        code.clear();
        code.sendKeys("XXXXXX2");
        apply.click();
        Thread.sleep(3000);
        scrFile();

//        输入减扣优惠码
        code=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/form/div[2]/div/div[1]/table/tbody/tr[3]/td/div/input");
        apply=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/form/div[2]/div/div[1]/table/tbody/tr[3]/td/div/button");
        code.clear();
        code.sendKeys("XXXXXX3");
        apply.click();
        Thread.sleep(3000);
        scrFile();
//        //        提交订单
//        submit=myChromeDriver.findElementById("submitOrder");
//        submit.click();
//        Thread.sleep(3000);
//        scrFile();
//        myChromeDriver.navigate().back();

//        输入折扣优惠码
        code=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/form/div[2]/div/div[1]/table/tbody/tr[3]/td/div/input");
        apply=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/form/div[2]/div/div[1]/table/tbody/tr[3]/td/div/button");
        code.clear();
        code.sendKeys("BZVJ6M");
        apply.click();
        Thread.sleep(3000);
        scrFile();
        //        提交订单
        submit=myChromeDriver.findElementById("submitOrder");
        submit.click();
        Thread.sleep(3000);
        scrFile();
        myChromeDriver.navigate().back();

//        输入免费优惠码
        code=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/form/div[2]/div/div[1]/table/tbody/tr[3]/td/div/input");
        apply=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/form/div[2]/div/div[1]/table/tbody/tr[3]/td/div/button");
        code.clear();
        code.sendKeys("XXXXXX5");
        apply.click();
        Thread.sleep(3000);
        scrFile();
//        //        提交订单
//        submit=myChromeDriver.findElementById("submitOrder");
//        submit.click();
//        Thread.sleep(3000);
//        scrFile();
//        myChromeDriver.navigate().back();

    }

//    配件满足50元
    @Test
    public void testDReferral_Code3_accessory() throws InterruptedException {
        Thread.sleep(3000);
        myChromeDriver.navigate().back();
        increase=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/div/div/div/div[1]/table/tbody/tr/td[2]/img[1]");
        int i;
        for (i=0;i<12;i++){
            increase.click();
        }
        Thread.sleep(3000);
        checkout=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/div/div/div/div[2]/div[2]/div/a");
        checkout.click();

//      输入价格总价必须>50的优惠码
        code=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/form/div[2]/div/div[1]/table/tbody/tr[3]/td/div/input");
        apply=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/form/div[2]/div/div[1]/table/tbody/tr[3]/td/div/button");
        code.clear();
        code.sendKeys("XXXXXX5");
        apply.click();
        Thread.sleep(3000);
        scrFile();
        //        提交订单
        submit=myChromeDriver.findElementById("submitOrder");
        submit.click();
        Thread.sleep(3000);
        scrFile();
        myChromeDriver.navigate().back();
    }

//    邀请码
    @Test
    public void testEInvitation_code4() throws InterruptedException {
//        老用户
        Thread.sleep(3000);
        code=myChromeDriver.findElementById("discount");
        apply=myChromeDriver.findElementByCssSelector("#summaryRows > tr:nth-child(4) > td > div > button");
        code.clear();
        code.sendKeys("VE0JZI");
        apply.click();
        submit=myChromeDriver.findElementById("submitOrder");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",submit);
        Thread.sleep(3000);
        scrFile();

//        新用户
        email1=myChromeDriver.findElementByXPath("customer.emailAddress");
        email1.clear();
        email1.sendKeys("22222222@qq.com");
        code=myChromeDriver.findElementById("discount");
        apply=myChromeDriver.findElementByCssSelector("#summaryRows > tr:nth-child(4) > td > div > button");
        code.clear();
        code.sendKeys("VE0JZI");
        apply.click();
        submit=myChromeDriver.findElementById("submitOrder");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",submit);
        Thread.sleep(3000);
        scrFile();
        myChromeDriver.navigate().back();
    }

    @AfterClass
    public static void alterClass() {
        driver.disconnect();
    }

}
