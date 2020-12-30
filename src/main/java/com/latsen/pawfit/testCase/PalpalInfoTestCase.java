package com.latsen.pawfit.testCase;

import com.latsen.pawfit.Const.Const;
import com.latsen.pawfit.common.NewDriver;
import com.latsen.pawfit.driver.MyChromeDriverSingleton;
import com.latsen.pawfit.utils.Tools;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.internal.Utils;
import java.io.IOException;
import java.util.HashMap;
import com.latsen.pawfit.utils.JavaTools;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PalpalInfoTestCase {
    private static WebElement firstName;
    private static WebElement lastName;
    private static WebElement company;
    private static WebElement address;
    private static WebElement city;
    private static WebElement country;
    private static WebElement province;
    private static WebElement postalCode;
    private static WebElement email;
    private static WebElement phoneNumber;
    private static WebElement checkboxOfCreateAnAccount;
    private static WebElement password;
    private static WebElement checkboxOfOrderNote;
    private static HashMap<WebElement,String> webElements;
    private static WebElement submitOrder;
    private static Select countrySelect;
    private static MyChromeDriverSingleton driver;
    private static NewDriver webdriver;
    private static WebElement add;
    private static WebElement checkout;
    private Utils FileUtils;
    private static JavaTools javaTools;

    @BeforeClass
    public static void beforeClass() throws IOException {
        System.out.println("已经执行");
        webdriver = new NewDriver(Const.PRODUCT_URL);
        driver = webdriver.connect();
        javaTools = new JavaTools();

//        添加商品到购物车
        add= driver.findElementByXPath("/html/body/section[1]/div/div/div[1]/div/div/div[3]/div[3]/a[2]/button");
        javaTools.click(add);

//        点击购物车跳转购物车页面
        Actions action=new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div/div[1]/button"))).perform();
        driver.findElementByClassName("checkout-bg").click();

//        点击跳转checkout页面
        checkout=driver.findElementByXPath("/html/body/div[5]/div/div/div/div/div/div[2]/div[2]/div/a");
        javaTools.click(checkout);

        webElements=new HashMap<WebElement, String>();
        submitOrder=driver.findElement(By.id("submitOrder"));
        checkboxOfCreateAnAccount=driver.findElementById("cbox");
        password=driver.findElementById("customer.clearPassword");
        checkboxOfOrderNote=driver.findElementById("comments");
    }


    @Test//      定位元素

    public void testAcheckFitstName() throws IOException {
        /*长度判断*/
        firstName=driver.findElement(By.id("customer.firstName"));
        Tools.setAllText(firstName,submitOrder, Tools.getUUIDText());
//        scrFile();
        /*SQL注入*/
        injectSQLs(firstName);
        webElements.put(firstName,"pawfit");
    }

    @Test
    public void testBcheckLastName() throws IOException {
        lastName=driver.findElement(By.id("customer.lastName"));
        Tools.setAllText(lastName,submitOrder,Tools.getUUIDText());
//        scrFile();
        injectSQLs(lastName);
        webElements.put(lastName,"latsen");
    }

    @Test
    public void testCcompany() throws IOException {
        company=driver.findElement(By.id("customer.billing.company"));
        Tools.setAllText(company,submitOrder,Tools.getUUIDText());
//        scrFile();
        injectSQLs(company);
        webElements.put(company,"广东顺德雷舜信息科技有限公司");
    }

    @Test
    public void testDcheakAddress() throws IOException {
        address=driver.findElement(By.id("customer.billing.address"));
        Tools.setAllText(address,submitOrder,Tools.getUUIDText());
        injectSQLs(address);
        webElements.put(address,"中国广东顺德大良");
    }

    @Test
    public void testEcheakCity() throws IOException {
        city=driver.findElement(By.id("customer.billing.city"));
        Tools.setAllText(city,submitOrder,Tools.getUUIDText());
        injectSQLs(city);
        webElements.put(city,"佛山");
    }

    @Test
    public void testFcheckCountry() {
        country=driver.findElement(By.id("customer.billing.country"));
        countrySelect=new Select(country);
        countrySelect.selectByVisibleText("United Kingdom");
        javaTools.click(submitOrder);
    }

    @Test
    public void testGcheckProvince() throws IOException {
        province=driver.findElement(By.name("customer.billing.stateProvince"));
        Tools.setAllText(province,submitOrder,Tools.getUUIDText());
        injectSQLs(province);
        webElements.put(province,"广东省");
    }

    @Test
    public void testHcheckPostalCode() throws IOException {
        postalCode=driver.findElement(By.name("customer.billing.postalCode"));
        Tools.setAllText(postalCode,submitOrder,Tools.getUUIDText());
        injectSQLs(postalCode);webElements.put(postalCode,"M2 5BQ");
    }

    @Test
    public void testIcheckEmail() throws IOException {
        email=driver.findElement(By.id("customer.emailAddress"));
        Tools.setAllText(email,submitOrder,Tools.getUUIDText());
        injectSQLs(email);
        webElements.put(email,"1401734643@qq.com");
    }

    @Test
    public void testJcheckPhoneNumber() throws IOException {
        phoneNumber=driver.findElement(By.name("customer.billing.phone"));
        Tools.setAllText(phoneNumber,submitOrder,Tools.getUUIDText());
        injectSQLs(phoneNumber);
        webElements.put(phoneNumber,"19197032890");
    }

    @Test
    public void testKcheckCheckboxOfCreateAnAccount() {
        checkboxOfCreateAnAccount.click();
    }

    @Test
    public void testLcheckPassword() throws IOException {
        Tools.setAllText(password,submitOrder,Tools.getUUIDText());
        injectSQLs(password);
        webElements.put(password,"12345678");
    }
    @Test
    public void testMcheckCheckboxOfOrderNote() throws IOException {
        Tools.setAllText(checkboxOfOrderNote,submitOrder,Tools.getUUIDText());
        injectSQLs(checkboxOfOrderNote);
        webElements.put(checkboxOfOrderNote,"12345678");
    }

    @Test
    public void testVcheackSubmitOrder() throws IOException {
        Tools.clearText(webElements);
        javaTools.scrFile(driver);
        Tools.setText(webElements);
        javaTools.scrFile(driver);
        javaTools.click(submitOrder);
        javaTools.scrFile(driver);
        javaTools.back(driver);
    }

    @AfterClass
    public static void alterClass() {
        webdriver.disconnect();
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
                javaTools.scrFile(driver);
                javaTools.click(submitOrder);
            }
            else {
                element.sendKeys(strings[i]);
                javaTools.click(submitOrder);
                element.clear();
            }

        }

    }


}
