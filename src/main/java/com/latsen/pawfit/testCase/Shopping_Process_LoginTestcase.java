package com.latsen.pawfit.testCase;

import com.latsen.pawfit.Const.Const;
import com.latsen.pawfit.common.NewDriver;
import com.latsen.pawfit.driver.MyChromeDriverSingleton;
import com.latsen.pawfit.utils.JavaTools;
import com.latsen.pawfit.utils.Tools;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.internal.Utils;

import java.io.IOException;
import java.util.HashMap;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Shopping_Process_LoginTestcase {
    private static MyChromeDriverSingleton myChromeDriver;
    private static NewDriver driver;
    private static JavaTools javaTools;
    private static WebElement pawfit2_add;
    private static WebElement checkout;
    private static WebElement product;
    private static WebElement password;
    private static WebElement email;
    private static WebElement submit;
    private Utils FileUtils;
    private static WebElement firstName;
    private static WebElement lastName;
    private static WebElement company;
    private static WebElement address;
    private static WebElement address2;
    private static WebElement city;
    private static WebElement country;
    private static WebElement countrySelect2;
    private static WebElement province;
    private static WebElement postalCode;
    private static WebElement phoneNumber;
    private static WebElement submitOrder;
    private static WebElement checkboxOfOrderNote;
    private static HashMap<WebElement,String> webElements;
    private static Select countrySelect;
    private static WebElement login;
    private static WebElement logout;
    private static WebElement giftCode;
    private static WebElement apply;
    private static WebElement submitOrder1;
    private static WebElement confirm;



    @BeforeClass
    public static void beforeClass() throws IOException {
        System.out.println("已经执行");
        driver = new NewDriver(Const.LOGiN_URL);
        myChromeDriver = driver.connect();
        javaTools = new JavaTools();
        webElements=new HashMap<WebElement, String>();

        email=myChromeDriver.findElementById("signin_userName");
        email.sendKeys("1790039849@qq.com");
        password=myChromeDriver.findElementById("signin_password");
        password.sendKeys("12345678");
        javaTools.sleep(2000);
        submit=myChromeDriver.findElementById("genericLogin-button");
        javaTools.click(submit);

    }

    @Test
    public void testAClick(){
        javaTools.sleep(2000);
        product=myChromeDriver.findElementByClassName("Product-html");
        javaTools.click(product);
//        添加pawfit2加入购物车
        pawfit2_add=myChromeDriver.findElementByXPath("/html/body/section[1]/div/div[1]/div[1]/div/div/div[3]/div[3]/a[2]/button");
        pawfit2_add.click();
        //        点击购物车跳转购物车页面
        Actions action=new Actions(myChromeDriver);
        action.moveToElement(myChromeDriver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div/div[1]/button"))).perform();
        myChromeDriver.findElementByClassName("checkout-bg").click();
        //        点击跳转checkout页面
        javaTools.sleep(2000);
        checkout=myChromeDriver.findElementByClassName("check-btn-div");
        javaTools.click(checkout);
    }

    @Test
    //      定位元素
    public void testBcheckFitstName() throws IOException {
        /*长度判断*/
        firstName=myChromeDriver.findElement(By.id("firstName"));
        submitOrder=myChromeDriver.findElementById("submit");
        Tools.setAllText(firstName,submitOrder, Tools.getUUIDText());
//        scrFile();
        /*SQL注入*/
        injectSQLs(firstName);
        webElements.put(firstName,"pawfit");
    }

    @Test
    public void testCcheckLastName() throws IOException {
        lastName=myChromeDriver.findElement(By.id("lastName"));
        submitOrder=myChromeDriver.findElementById("submit");
        Tools.setAllText(lastName,submitOrder,Tools.getUUIDText());
//        scrFile();
        injectSQLs(lastName);
        webElements.put(lastName,"latsen");
    }

    @Test
    public void testDcheckCountry() {
        country=myChromeDriver.findElement(By.id("country"));
        javaTools.click(country);
//        countrySelect1=myChromeDriver.findElementById("countryList");
        countrySelect2=myChromeDriver.findElement(By.cssSelector("#countryList > li:nth-child(41)"));
        javaTools.jsclick(myChromeDriver,countrySelect2);
//        countrySelect.selectByVisibleText("United States");
        submitOrder=myChromeDriver.findElementById("submit");
        javaTools.click(submitOrder);
    }


    @Test
    public void testEcheckProvince() throws IOException {
        province=myChromeDriver.findElement(By.id("state"));
        submitOrder=myChromeDriver.findElementById("submit");
        Tools.setAllText(province,submitOrder,Tools.getUUIDText());
        injectSQLs(province);
        webElements.put(province,"广东省");
    }


    @Test
    public void testFcheakCity() throws IOException {
        city=myChromeDriver.findElement(By.id("city"));
        submitOrder=myChromeDriver.findElementById("submit");
        Tools.setAllText(city,submitOrder,Tools.getUUIDText());
        injectSQLs(city);
        webElements.put(city,"佛山");
    }

    @Test
    public void testGcheckPostalCode() throws IOException {
        postalCode=myChromeDriver.findElement(By.id("postcode"));
        submitOrder=myChromeDriver.findElementById("submit");
        Tools.setAllText(postalCode,submitOrder,Tools.getUUIDText());
        injectSQLs(postalCode);webElements.put(postalCode,"M2 5BQ");
//        injectSQLs(postalCode);webElements.put(postalCode,"12345");
    }

    @Test
    public void testHcheakAddress() throws IOException {
        address=myChromeDriver.findElement(By.id("address1"));
        submitOrder=myChromeDriver.findElementById("submit");
        Tools.setAllText(address,submitOrder,Tools.getUUIDText());
        injectSQLs(address);

        address2=myChromeDriver.findElement(By.id("address2"));
        submitOrder=myChromeDriver.findElementById("submit");
        Tools.setAllText(address2,submitOrder,Tools.getUUIDText());
        injectSQLs(address2);

        webElements.put(address,"中国广东顺德大良");
        webElements.put(address2,"中国广东顺德大良2");
    }

    @Test
    public void testIcompany() throws IOException {
        company=myChromeDriver.findElement(By.id("company"));
        submitOrder=myChromeDriver.findElementById("submit");
        Tools.setAllText(company,submitOrder,Tools.getUUIDText());
//        scrFile();
        injectSQLs(company);
        webElements.put(company,"广东顺德雷舜信息科技有限公司");
    }

    @Test
    public void testJcheckPhoneNumber() throws IOException {
        phoneNumber=myChromeDriver.findElement(By.id("phone"));
        submitOrder=myChromeDriver.findElementById("submit");
        Tools.setAllText(phoneNumber,submitOrder,Tools.getUUIDText());
        injectSQLs(phoneNumber);
        webElements.put(phoneNumber,"19197032890");
    }

    @Test
    public void testKcheckCheckboxOfOrderNote() throws IOException {
        checkboxOfOrderNote=myChromeDriver.findElementById("comments");
        submitOrder=myChromeDriver.findElementById("submit");
        Tools.setAllText(checkboxOfOrderNote,submitOrder,Tools.getUUIDText());
        injectSQLs(checkboxOfOrderNote);
        webElements.put(checkboxOfOrderNote,"12345678");
    }

    @Test
    public void testLcheackSubmitOrder() {
        Tools.clearText(webElements);
        Tools.setText(webElements);
        submitOrder=myChromeDriver.findElementById("submit");
        javaTools.click(submitOrder);
//        javaTools.back(driver);
    }

    @Test
    public void testMReferral_Code(){
        javaTools.sleep(2000);
        for(int i=0;i<Const.getCommomText().length;i++) {
//            注入SQL
            giftCode=myChromeDriver.findElementById("giftCode");
            giftCode.sendKeys("" + Const.getSQlText()[i]);
            javaTools.clear(giftCode);
            apply=myChromeDriver.findElementByXPath("/html/body/form/div/div/div[1]/div[4]/div/div[1]/span");
            javaTools.click(apply);
        }
        giftCode=myChromeDriver.findElementById("giftCode");
        giftCode.sendKeys("DF8JTX");
        apply=myChromeDriver.findElementByXPath("/html/body/form/div/div/div[1]/div[4]/div/div[1]/span");
        javaTools.click(apply);

        javaTools.sleep(2000);
        submitOrder1=myChromeDriver.findElementById("submit");
        javaTools.click(submitOrder1);
    }

    @Test
    public void testNSubmitOrder(){
        confirm=myChromeDriver.findElementByCssSelector("body > div.shopping > div.orderBtn > div.row.hidden-xs > div:nth-child(3) > div");
        javaTools.click(confirm);

        javaTools.sleep(2000);
        javaTools.back(myChromeDriver);
    }

    @Test
    public void testO(){
        login=myChromeDriver.findElementByXPath("/html/body/div[2]/div[2]/div/div/div/nav/ul/li[6]/a");
        javaTools.click(login);

//        退出登录
        logout=myChromeDriver.findElementByXPath("/html/body/div[4]/div/div[2]/div[1]/ul/li[4]/a");
        javaTools.click(logout);

        javaTools.sleep(2000);
        //        点击购物车跳转购物车页面
        Actions action=new Actions(myChromeDriver);
        action.moveToElement(myChromeDriver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div/div[1]/button"))).perform();
        myChromeDriver.findElementByClassName("checkout-bg").click();
        //        点击跳转checkout页面
        checkout=myChromeDriver.findElementByClassName("check-btn-div");
        javaTools.click(checkout);
    }

    @Test
    public void testP(){
        email=myChromeDriver.findElementById("signin_userName");
        email.sendKeys("1790039849@qq.com");
        password=myChromeDriver.findElementById("signin_password");
        password.sendKeys("12345678");
        javaTools.sleep(2000);
        submit=myChromeDriver.findElementById("genericLogin-button");
        javaTools.click(submit);
    }

    public void injectSQLs(WebElement element) throws IOException {
        String[] strings={
                "and ascii(substr((select database()),1,1))>64",
                "id=1 union select if(SUBSTRING(user(),1,4)='root',sleep(4),1),null,null",
                "id =-1 union select 1,2,3","id=1' substr(database(),1,1)='t'--+",
                "union select count(*),2,concat(':',(select database()),':',floor(rand()*2))as a from information_schema.tables group by a",
                "id=1 and (extractvalue(1,concat(0x7e,(select user()),0x7e)))"};
        for (int i=0;i< strings.length;i++){
            if (i>strings.length-2){
                element.sendKeys(strings[i]);
//                javaTools.scrFile(driver);
                submitOrder=myChromeDriver.findElementById("submit");
                javaTools.click(submitOrder);
            }
            else {
                element.sendKeys(strings[i]);
                submitOrder=myChromeDriver.findElementById("submit");
                javaTools.click(submitOrder);
                element.clear();
            }

        }

    }


//    @AfterClass
//    public static void alterClass() {
//        driver.disconnect();
//    }
}
