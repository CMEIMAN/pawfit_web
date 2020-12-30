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
import com.latsen.pawfit.utils.JavaTools;
import java.io.IOException;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Referral_CodeTestCase {
    private static NewDriver driver;
    private static MyChromeDriverSingleton myChromeDriver;
    private static JavaTools javaTools;
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
    private static WebElement formError;

    @BeforeClass
    public static void beforeClass() throws IOException, InterruptedException {
        System.out.println("已经执行");
        driver = new NewDriver(Const.LOGiN_URL);
        myChromeDriver = driver.connect();
        javaTools = new JavaTools();
//       登录账号
        email=myChromeDriver.findElementById("signin_userName");
        password=myChromeDriver.findElementById("signin_password");
        login =myChromeDriver.findElementById("genericLogin-button");
        javaTools.inputText(myChromeDriver,"1790039849@qq.com",email);
        javaTools.inputText(myChromeDriver,"12345678",password);
        javaTools.click(login);
        javaTools.sleep(3000);

//       点击进入product页面
        product=myChromeDriver.findElementByXPath("/html/body/div[1]/div[2]/div/div/div/nav/ul/li[1]/a");
        javaTools.jsclick(myChromeDriver,product);


        //        添加商品到购物车
        add= myChromeDriver.findElementByXPath("/html/body/section[1]/div/div/div[1]/div/div/div[3]/div[3]/a[2]/button");
        javaTools.jsclick(myChromeDriver,add);
        javaTools.sleep(3000);
//        添加配件
        add1=myChromeDriver.findElementByXPath("/html/body/section[2]/div/div/div[2]/div/div/div/div[1]/div[3]/a[2]/button");
        javaTools.jsclick(myChromeDriver,add1);

        //        点击购物车跳转购物车页面
        Actions action=new Actions(myChromeDriver);
        action.moveToElement(myChromeDriver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div/div[1]/button"))).perform();
        myChromeDriver.findElementByClassName("checkout-bg").click();

        //        点击跳转checkout页面
        checkout=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/div/div/div/div[2]/div[2]/div/a");
        javaTools.click(checkout);
    }


    @Test
    public void testAReferral_Code(){
        javaTools.sleep(3000);
        code=myChromeDriver.findElementById("discount");
        apply=myChromeDriver.findElementByCssSelector("#summaryRows > tr:nth-child(4) > td > div > button");
        /*注入数据*/
        for(int i=0;i<Const.getCommomText().length;i++) {
            code.sendKeys("" + Const.getCommomText()[i]);
            javaTools.jsclick(myChromeDriver,apply);
        }
    }

    @Test
    public void testBReferral_Code1_p2_null(){
//       设备使用优惠码
//        输入空
        javaTools.sleep(3000);
        code=myChromeDriver.findElementById("discount");
        javaTools.clear(code);
        javaTools.inputText(myChromeDriver,"   ",code);
        apply=myChromeDriver.findElementByCssSelector("#summaryRows > tr:nth-child(4) > td > div > button");
        javaTools.jsclick(myChromeDriver,apply);
        javaTools.sleep(3000);
        formError=myChromeDriver.findElementByClassName("cart-error");
        System.out.print("优惠码为空："+formError.getText());
    }

    @Test
    public void testCReferral_Code1_p2_error(){
        //        输入错误优惠码
        code=myChromeDriver.findElementById("discount");
        apply=myChromeDriver.findElementByCssSelector("#summaryRows > tr:nth-child(4) > td > div > button");
        javaTools.inputText(myChromeDriver,"11111111",code);
        javaTools.jsclick(myChromeDriver,apply);
        javaTools.sleep(3000);
        formError=myChromeDriver.findElementByClassName("cart-error");
        System.out.print("输入错误优惠码："+formError.getText());
    }

    @Test
    public void testDReferral_Code1_p2_sp(){
        //        输入特殊字符优惠码
        code=myChromeDriver.findElementById("discount");
        apply=myChromeDriver.findElementByCssSelector("#summaryRows > tr:nth-child(4) > td > div > button");
        javaTools.clear(code);
        javaTools.inputText(myChromeDriver,"@#$%^&*~>",code);
        javaTools.jsclick(myChromeDriver,apply);
        javaTools.sleep(3000);
        formError=myChromeDriver.findElementByClassName("cart-error");
        System.out.print("输入特殊字符优惠码："+formError.getText());
    }

    @Test
    public void testEReferral_Code1_p2_reduce(){
        //        输入减扣优惠码
        code=myChromeDriver.findElementById("discount");
        apply=myChromeDriver.findElementByCssSelector("#summaryRows > tr:nth-child(4) > td > div > button");
        javaTools.clear(code);
        javaTools.inputText(myChromeDriver,"LWFHCJ",code);
        javaTools.jsclick(myChromeDriver,apply);
        javaTools.sleep(3000);
        formError=myChromeDriver.findElementByClassName("cart-error");
        System.out.print("输入减扣优惠码："+formError.getText());
////        提交订单
//        submit=myChromeDriver.findElementById("submitOrder");
//        javaTools.click(submit);
//        javaTools.sleep(3000);
//        javaTools.scrFile(myChromeDriver);
//        javaTools.back(myChromeDriver);
    }

    @Test
    public void testFReferral_Code1_p2_discount_min(){
        //        输入折扣优惠码,最低消费低于160
        code=myChromeDriver.findElementById("discount");
        apply=myChromeDriver.findElementByCssSelector("#summaryRows > tr:nth-child(4) > td > div > button");
        javaTools.clear(code);
        javaTools.inputText(myChromeDriver,"BI9FRQ",code);
        javaTools.jsclick(myChromeDriver,apply);
        javaTools.sleep(3000);
        formError=myChromeDriver.findElementByClassName("cart-error");
        System.out.print("达不到折扣价格："+formError.getText());
    }

    @Test
    public void testGReferral_Code1_p2_discount_max() throws IOException {
        //添加商品
        javaTools.back(myChromeDriver);
        increase=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/div/div/div/div[1]/table/tbody/tr/td[2]/img[1]");
        int i;
        for (i=0;i<5;i++){
            javaTools.click(increase);
        }
        javaTools.sleep(3000);
        checkout=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/div/div/div/div[2]/div[2]/div/a");
        javaTools.click(checkout);

        //        输入折扣优惠码,最低消费高于160
        code=myChromeDriver.findElementById("discount");
        apply=myChromeDriver.findElementByCssSelector("#summaryRows > tr:nth-child(4) > td > div > button");
        javaTools.clear(code);
        javaTools.inputText(myChromeDriver,"BI9FRQ",code);
        javaTools.click(apply);
        javaTools.sleep(3000);
        formError=myChromeDriver.findElementByClassName("cart-error");
        System.out.print("达到折扣价格："+formError.getText());
        //        提交订单
        submit=myChromeDriver.findElementById("submitOrder");
        javaTools.click(submit);
        javaTools.sleep(5000);
        javaTools.scrFile(myChromeDriver);
        javaTools.back(myChromeDriver);
    }


//    @Test
//    public void testBReferral_Code1_p2_free(){
//        //        输入免费优惠码
//        code=myChromeDriver.findElementById("discount");
//        apply=myChromeDriver.findElementByCssSelector("#summaryRows > tr:nth-child(4) > td > div > button");
//        javaTools.clear(code);
//        javaTools.inputText(myChromeDriver,"3XXXXX",code);
//        javaTools.click(apply);
//        javaTools.sleep(3000);
//        javaTools.scrFile(myChromeDriver);
//////        提交订单
////        submit=myChromeDriver.findElementById("submitOrder");
////        javaTools.click(submit);
////        javaTools.sleep(3000);
////        javaTools.scrFile(myChromeDriver);
////        javaTools.back(myChromeDriver);
//    }

    @Test
    public void testHReferral_Code1_p2_accessory(){
        //        输入配件优惠码
        code=myChromeDriver.findElementById("discount");
        apply=myChromeDriver.findElementByCssSelector("#summaryRows > tr:nth-child(4) > td > div > button");
        javaTools.clear(code);
        javaTools.inputText(myChromeDriver,"4XXXXXX",code);
        javaTools.jsclick(myChromeDriver,apply);
        javaTools.sleep(3000);
        formError=myChromeDriver.findElementByClassName("cart-error");
        System.out.print("P2商品，输入配件优惠码："+formError.getText());
    }


//    配件单个不足50元
    @Test
    public void testIReferral_Code2_accessory_p2(){
        javaTools.back(myChromeDriver);
        cancel=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/div/div/div/div[1]/table/tbody/tr[1]/td[4]/div/a");
        javaTools.click(cancel);
        checkout=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/div/div/div/div[2]/div[2]/div/a");
        javaTools.click(checkout);

//      输入p2优惠码
        code=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/form/div[2]/div/div[1]/table/tbody/tr[3]/td/div/input");
        apply=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/form/div[2]/div/div[1]/table/tbody/tr[3]/td/div/button");
        javaTools.clear(code);
        javaTools.inputText(myChromeDriver,"BI9FRQ",code);
        javaTools.jsclick(myChromeDriver,apply);
        javaTools.sleep(3000);
        formError=myChromeDriver.findElementByClassName("cart-error");
        System.out.print("配件商品，输入P2优惠码："+formError.getText());
    }

    @Test
    public void testJReferral_Code2_accessory_reduce_max(){
//        输入价格总价必须>50的优惠码，未满50
        code=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/form/div[2]/div/div[1]/table/tbody/tr[3]/td/div/input");
        apply=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/form/div[2]/div/div[1]/table/tbody/tr[3]/td/div/button");
        javaTools.clear(code);
        javaTools.inputText(myChromeDriver,"XXXXXX2",code);
        javaTools.click(apply);
        javaTools.sleep(3000);
        formError=myChromeDriver.findElementByClassName("cart-error");
        System.out.print("配件商品，输入减扣价格总价必须>50的优惠码："+formError.getText());
    }

    @Test
    public void testKReferral_Code2_accessory_reduce(){
        //        输入减扣优惠码，满50
        code=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/form/div[2]/div/div[1]/table/tbody/tr[3]/td/div/input");
        apply=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/form/div[2]/div/div[1]/table/tbody/tr[3]/td/div/button");
        javaTools.clear(code);
        javaTools.inputText(myChromeDriver,"LWFHCJ",code);
        javaTools.click(apply);
        javaTools.sleep(3000);
        formError=myChromeDriver.findElementByClassName("cart-error");
        System.out.print("配件商品，输入减扣优惠码："+formError.getText());
//        //        提交订单
//        submit=myChromeDriver.findElementById("submitOrder");
//        javaTools.click(submit);
//        javaTools.sleep(3000);
//        javaTools.scrFile(myChromeDriver);
//        javaTools.back(myChromeDriver);
    }

    @Test
    public void testLReferral_Code2_accessory_discount() throws IOException {
        //        输入折扣优惠码，无限制消费额度
        code=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/form/div[2]/div/div[1]/table/tbody/tr[3]/td/div/input");
        apply=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/form/div[2]/div/div[1]/table/tbody/tr[3]/td/div/button");
        javaTools.clear(code);
        javaTools.inputText(myChromeDriver,"BZVJ6M",code);
        javaTools.click(apply);
        javaTools.sleep(3000);
        formError=myChromeDriver.findElementByClassName("cart-error");
        System.out.print("配件商品，输入折扣优惠码："+formError.getText());
        //        提交订单
        submit=myChromeDriver.findElementById("submitOrder");
        javaTools.click(submit);
        javaTools.sleep(3000);
        javaTools.scrFile(myChromeDriver);
        javaTools.back(myChromeDriver);
    }

//    @Test
//    public void testMReferral_Code2_accessory_free(){
//        //        输入免费优惠码
//        code=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/form/div[2]/div/div[1]/table/tbody/tr[3]/td/div/input");
//        apply=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/form/div[2]/div/div[1]/table/tbody/tr[3]/td/div/button");
//        javaTools.clear(code);
//        javaTools.inputText(myChromeDriver,"XXXXX",code);
//        javaTools.jsclick(myChromeDriver,apply);
//        javaTools.sleep(3000);
//        formError=myChromeDriver.findElementByClassName("cart-error");
//        System.out.print("配件商品，输入免费优惠码："+formError.getText());
//        //        提交订单
//        submit=myChromeDriver.findElementById("submitOrder");
//        javaTools.click(submit);
//        javaTools.sleep(3000);
//        javaTools.scrFile(myChromeDriver);
//        javaTools.back(myChromeDriver);
//    }

//    配件满足50元
    @Test
    public void testNReferral_Code3_accessory() throws IOException {
        javaTools.sleep(3000);
        javaTools.back(myChromeDriver);
        increase=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/div/div/div/div[1]/table/tbody/tr/td[2]/img[1]");
        int i;
        for (i=0;i<12;i++){
            javaTools.click(increase);
        }
        javaTools.sleep(3000);
        checkout=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/div/div/div/div[2]/div[2]/div/a");
        javaTools.click(checkout);

//      输入价格总价必须>50的优惠码，有限制消费额度
        code=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/form/div[2]/div/div[1]/table/tbody/tr[3]/td/div/input");
        apply=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/form/div[2]/div/div[1]/table/tbody/tr[3]/td/div/button");
        javaTools.clear(code);
        javaTools.inputText(myChromeDriver,"LWFHCJ",code);
        javaTools.jsclick(myChromeDriver,apply);
        javaTools.sleep(3000);
        formError=myChromeDriver.findElementByClassName("cart-error");
        System.out.print("配件商品，输入折扣价格总价必须>50的优惠码："+formError.getText());
        //        提交订单
        submit=myChromeDriver.findElementById("submitOrder");
        javaTools.click(submit);
        javaTools.sleep(3000);
        javaTools.scrFile(myChromeDriver);
        javaTools.back(myChromeDriver);
    }

//    邀请码
    @Test
    public void testOInvitation_code_old() throws IOException {
//        老用户
        javaTools.sleep(3000);
        code=myChromeDriver.findElementById("discount");
        apply=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/form/div[2]/div/div[1]/table/tbody/tr[3]/td/div/button");
        code.clear();
        code.sendKeys("VE0JZI");
        javaTools.jsclick(myChromeDriver,apply);
        submit=myChromeDriver.findElementById("submitOrder");
        javaTools.jsclick(myChromeDriver,submit);
        javaTools.sleep(3000);
        javaTools.scrFile(myChromeDriver);
        myChromeDriver.navigate().back();
    }

    @Test
    public void testPInvitation_code_new() throws IOException {
        //        新用户
        email1=myChromeDriver.findElementById("customer.emailAddress");
        javaTools.clear(email);
        javaTools.inputText(myChromeDriver,"22222222@qq.com",email);
        code=myChromeDriver.findElementById("discount");
        javaTools.clear(code);
        javaTools.inputText(myChromeDriver,"VE0JZI",code);
        apply=myChromeDriver.findElementByXPath("/html/body/div[5]/div/div/form/div[2]/div/div[1]/table/tbody/tr[3]/td/div/button");
        javaTools.jsclick(myChromeDriver,apply);
        submit=myChromeDriver.findElementById("submitOrder");
        javaTools.jsclick(myChromeDriver,submit);
        javaTools.sleep(3000);
        javaTools.scrFile(myChromeDriver);
        javaTools.back(myChromeDriver);
    }

    @AfterClass
    public static void alterClass() {
        driver.disconnect();
    }

}
