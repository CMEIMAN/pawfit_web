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
public class Referral_CodeTestCase {
    private static NewDriver driver;
    private static MyChromeDriverSingleton myChromeDriver;
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
    private static WebElement formError;

    @BeforeClass
    public static void beforeClass() throws IOException, InterruptedException {
        System.out.println("已经执行");
        driver = new NewDriver(Const.LOGiN_URL);
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
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");  //转换时间格式
        String time = dateFormat.format(Calendar.getInstance().getTime());  //获取当前时间
        String Name = Thread.currentThread().getStackTrace()[2].getMethodName();//获取当前类名
        File srcFile = ((TakesScreenshot)myChromeDriver).getScreenshotAs(OutputType.FILE);  //执行屏幕截取
        FileUtils.copyFile(srcFile, new File("C:\\Users\\Admin\\web_test\\src\\img\\Referral_code", Name+"_"+time + ".png"));
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
    public void testBReferral_Code1_p2_null() throws InterruptedException {
//       设备使用优惠码
//        输入空
        Thread.sleep(3000);
        code=myChromeDriver.findElementById("discount");
        code.clear();
        code.sendKeys("  ");
        apply=myChromeDriver.findElementByCssSelector("#summaryRows > tr:nth-child(4) > td > div > button");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",apply);
        Thread.sleep(3000);
        formError=myChromeDriver.findElementByClassName("cart-error");
        System.out.print("优惠码为空："+formError.getText());
    }

    @Test
    public void testCReferral_Code1_p2_error() throws InterruptedException {
        //        输入错误优惠码
        code=myChromeDriver.findElementById("discount");
        apply=myChromeDriver.findElementByCssSelector("#summaryRows > tr:nth-child(4) > td > div > button");
        code.sendKeys("11111111");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",apply);
        Thread.sleep(3000);
        formError=myChromeDriver.findElementByClassName("cart-error");
        System.out.print("输入错误优惠码："+formError.getText());
    }

    @Test
    public void testDReferral_Code1_p2_sp() throws InterruptedException {
        //        输入特殊字符优惠码
        code=myChromeDriver.findElementById("discount");
        apply=myChromeDriver.findElementByCssSelector("#summaryRows > tr:nth-child(4) > td > div > button");
        code.clear();
        code.sendKeys("@#$%^&*~>");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",apply);
        Thread.sleep(3000);
        formError=myChromeDriver.findElementByClassName("cart-error");
        System.out.print("输入特殊字符优惠码："+formError.getText());
    }

    @Test
    public void testEReferral_Code1_p2_reduce() throws InterruptedException {
        //        输入减扣优惠码
        code=myChromeDriver.findElementById("discount");
        apply=myChromeDriver.findElementByCssSelector("#summaryRows > tr:nth-child(4) > td > div > button");
        code.clear();
        code.sendKeys("LWFHCJ");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",apply);
        Thread.sleep(3000);
        formError=myChromeDriver.findElementByClassName("cart-error");
        System.out.print("输入减扣优惠码："+formError.getText());
////        提交订单
//        submit=myChromeDriver.findElementById("submitOrder");
//        submit.click();
//        Thread.sleep(3000);
//        scrFile();
//        myChromeDriver.navigate().back();
    }

    @Test
    public void testFReferral_Code1_p2_discount_min() throws InterruptedException {
        //        输入折扣优惠码,最低消费低于160
        code=myChromeDriver.findElementById("discount");
        apply=myChromeDriver.findElementByCssSelector("#summaryRows > tr:nth-child(4) > td > div > button");
        code.clear();
        code.sendKeys("BI9FRQ");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",apply);
        Thread.sleep(3000);
        formError=myChromeDriver.findElementByClassName("cart-error");
        System.out.print("达不到折扣价格："+formError.getText());
    }

    @Test
    public void testGReferral_Code1_p2_discount_max() throws InterruptedException {
        //添加商品
        myChromeDriver.navigate().back();
        increase=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/div/div/div/div[1]/table/tbody/tr/td[2]/img[1]");
        int i;
        for (i=0;i<5;i++){
            increase.click();
        }
        Thread.sleep(3000);
        checkout=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/div/div/div/div[2]/div[2]/div/a");
        checkout.click();

        //        输入折扣优惠码,最低消费高于160
        code=myChromeDriver.findElementById("discount");
        apply=myChromeDriver.findElementByCssSelector("#summaryRows > tr:nth-child(4) > td > div > button");
        code.clear();
        code.sendKeys("BI9FRQ");
        apply.click();
        Thread.sleep(3000);
        formError=myChromeDriver.findElementByClassName("cart-error");
        System.out.print("达到折扣价格："+formError.getText());
        //        提交订单
        submit=myChromeDriver.findElementById("submitOrder");
        submit.click();
        Thread.sleep(5000);
        scrFile();
        myChromeDriver.navigate().back();
    }


//    @Test
//    public void testBReferral_Code1_p2_free() throws InterruptedException {
//        //        输入免费优惠码
//        code=myChromeDriver.findElementById("discount");
//        apply=myChromeDriver.findElementByCssSelector("#summaryRows > tr:nth-child(4) > td > div > button");
//        code.clear();
//        code.sendKeys("3XXXXXX");
//        apply.click();
//        Thread.sleep(3000);
//        scrFile();
//////        提交订单
////        submit=myChromeDriver.findElementById("submitOrder");
////        submit.click();
////        Thread.sleep(3000);
////        scrFile();
////        myChromeDriver.navigate().back();
//    }

    @Test
    public void testHReferral_Code1_p2_accessory() throws InterruptedException {
        //        输入配件优惠码
        code=myChromeDriver.findElementById("discount");
        apply=myChromeDriver.findElementByCssSelector("#summaryRows > tr:nth-child(4) > td > div > button");
        code.clear();
        code.sendKeys("4XXXXXX");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",apply);
        Thread.sleep(3000);
        formError=myChromeDriver.findElementByClassName("cart-error");
        System.out.print("P2商品，输入配件优惠码："+formError.getText());
    }


//    配件单个不足50元
    @Test
    public void testIReferral_Code2_accessory_p2() throws InterruptedException {
        myChromeDriver.navigate().back();
        cancel=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/div/div/div/div[1]/table/tbody/tr[1]/td[4]/div/a");
        cancel.click();
        checkout=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/div/div/div/div[2]/div[2]/div/a");
        checkout.click();

//      输入p2优惠码
        code=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/form/div[2]/div/div[1]/table/tbody/tr[3]/td/div/input");
        apply=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/form/div[2]/div/div[1]/table/tbody/tr[3]/td/div/button");
        code.clear();
        code.sendKeys("BI9FRQ");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",apply);
        Thread.sleep(3000);
        formError=myChromeDriver.findElementByClassName("cart-error");
        System.out.print("配件商品，输入P2优惠码："+formError.getText());
    }

    @Test
    public void testJReferral_Code2_accessory_reduce_max() throws InterruptedException {
//        输入价格总价必须>50的优惠码，未满50
        code=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/form/div[2]/div/div[1]/table/tbody/tr[3]/td/div/input");
        apply=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/form/div[2]/div/div[1]/table/tbody/tr[3]/td/div/button");
        code.clear();
        code.sendKeys("XXXXXX2");
        apply.click();
        Thread.sleep(3000);
        formError=myChromeDriver.findElementByClassName("cart-error");
        System.out.print("配件商品，输入减扣价格总价必须>50的优惠码："+formError.getText());
    }

    @Test
    public void testKReferral_Code2_accessory_reduce() throws InterruptedException {
        //        输入减扣优惠码，满50
        code=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/form/div[2]/div/div[1]/table/tbody/tr[3]/td/div/input");
        apply=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/form/div[2]/div/div[1]/table/tbody/tr[3]/td/div/button");
        code.clear();
        code.sendKeys("LWFHCJ");
        apply.click();
        Thread.sleep(3000);
        formError=myChromeDriver.findElementByClassName("cart-error");
        System.out.print("配件商品，输入减扣优惠码："+formError.getText());
//        //        提交订单
//        submit=myChromeDriver.findElementById("submitOrder");
//        submit.click();
//        Thread.sleep(3000);
//        scrFile();
//        myChromeDriver.navigate().back();
    }

    @Test
    public void testLReferral_Code2_accessory_discount() throws InterruptedException {
        //        输入折扣优惠码，无限制消费额度
        code=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/form/div[2]/div/div[1]/table/tbody/tr[3]/td/div/input");
        apply=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/form/div[2]/div/div[1]/table/tbody/tr[3]/td/div/button");
        code.clear();
        code.sendKeys("BZVJ6M");
        apply.click();
        Thread.sleep(3000);
        formError=myChromeDriver.findElementByClassName("cart-error");
        System.out.print("配件商品，输入折扣优惠码："+formError.getText());
        //        提交订单
        submit=myChromeDriver.findElementById("submitOrder");
        submit.click();
        Thread.sleep(3000);
        scrFile();
        myChromeDriver.navigate().back();
    }

//    @Test
//    public void testMReferral_Code2_accessory_free() throws InterruptedException {
//        //        输入免费优惠码
//        code=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/form/div[2]/div/div[1]/table/tbody/tr[3]/td/div/input");
//        apply=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/form/div[2]/div/div[1]/table/tbody/tr[3]/td/div/button");
//        code.clear();
//        code.sendKeys("XXXXXX5");
//        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",apply);
//        Thread.sleep(3000);
//        formError=myChromeDriver.findElementByClassName("cart-error");
//        System.out.print("配件商品，输入免费优惠码："+formError.getText());
//        //        提交订单
//        submit=myChromeDriver.findElementById("submitOrder");
//        submit.click();
//        Thread.sleep(3000);
//        scrFile();
//        myChromeDriver.navigate().back();
//    }

//    配件满足50元
    @Test
    public void testNReferral_Code3_accessory() throws InterruptedException {
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

//      输入价格总价必须>50的优惠码，有限制消费额度
        code=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/form/div[2]/div/div[1]/table/tbody/tr[3]/td/div/input");
        apply=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/form/div[2]/div/div[1]/table/tbody/tr[3]/td/div/button");
        code.clear();
        code.sendKeys("LWFHCJ");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",apply);
        Thread.sleep(3000);
        formError=myChromeDriver.findElementByClassName("cart-error");
        System.out.print("配件商品，输入折扣价格总价必须>50的优惠码："+formError.getText());
        //        提交订单
        submit=myChromeDriver.findElementById("submitOrder");
        submit.click();
        Thread.sleep(3000);
        scrFile();
        myChromeDriver.navigate().back();
    }

//    邀请码
    @Test
    public void testOInvitation_code_old() throws InterruptedException {
//        老用户
        Thread.sleep(3000);
        code=myChromeDriver.findElementById("discount");
        apply=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/form/div[2]/div/div[1]/table/tbody/tr[3]/td/div/button");
        code.clear();
        code.sendKeys("VE0JZI");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",apply);
        submit=myChromeDriver.findElementById("submitOrder");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",submit);
        Thread.sleep(3000);
        scrFile();
        myChromeDriver.navigate().back();
    }

    @Test
    public void testPInvitation_code_new() throws InterruptedException {
        //        新用户
        email1=myChromeDriver.findElementById("customer.emailAddress");
        email1.clear();
        email1.sendKeys("22222222@qq.com");
        code=myChromeDriver.findElementById("discount");
        code.clear();
        code.sendKeys("VE0JZI");
        apply=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/form/div[2]/div/div[1]/table/tbody/tr[3]/td/div/button");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",apply);
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
