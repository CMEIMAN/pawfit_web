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
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

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
    private static WebElement formErrorMessage;

    @BeforeClass
    public static void beforeClass() throws IOException {
        System.out.println("已经执行");
        webdriver = new NewDriver(Const.PRODUCT_URL);
        driver = webdriver.connect();

//        添加商品到购物车
        add= driver.findElementByXPath("/html/body/section[1]/div/div/div[1]/div/div/div[3]/div[3]/a[2]/button");
        add.click();

//        点击购物车跳转购物车页面
        Actions action=new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div/div[1]/button"))).perform();
        driver.findElementByClassName("checkout-bg").click();

//        点击跳转checkout页面
        checkout=driver.findElementByXPath("/html/body/div[5]/div/div/div/div/div/div[2]/div[2]/div/a");
        checkout.click();

        webElements=new HashMap<WebElement, String>();
//      定位元素
        submitOrder=driver.findElement(By.id("submitOrder"));
        checkboxOfCreateAnAccount=driver.findElementById("cbox");
        password=driver.findElementById("customer.clearPassword");
        checkboxOfOrderNote=driver.findElementById("comments");
    }
//  截图
    public void scrFile(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");  //转换时间格式
        String time = dateFormat.format(Calendar.getInstance().getTime());  //获取当前时间
        String Name = Thread.currentThread().getStackTrace()[2].getMethodName();//获取当前类名
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  //执行屏幕截取
        FileUtils.copyFile(srcFile, new File("C:\\Users\\Admin\\web_test\\src\\img\\PalpalInfo", Name+"_"+time + ".png"));
    }

    @Test
    public void testAcheckFitstName_data() {
        /*长度判断*/
        firstName=driver.findElement(By.id("customer.firstName"));
        setAllText(firstName, Tools.getUUIDText());
//        scrFile();
        /*SQL注入*/
        injectSQLs(firstName);
        webElements.put(firstName,"pawfit");
    }

    @Test
    public void testBcheckLastName_null() {
        formErrorMessage=driver.findElementById("formErrorMessage");
        System.out.print("lastname输入为空："+formErrorMessage.getText());
    }

    @Test
    public void testCcheckLastName_data() {
        lastName=driver.findElement(By.id("customer.lastName"));
        setAllText(lastName,Tools.getUUIDText());
//        scrFile();
        injectSQLs(lastName);
        webElements.put(lastName,"latsen");
    }

    @Test
    public void testDcompany() {
        company=driver.findElement(By.id("customer.billing.company"));
        setAllText(company,Tools.getUUIDText());
//        scrFile();
        injectSQLs(company);
        webElements.put(company,"广东顺德雷舜信息科技有限公司");
    }

    @Test
    public void testEcheakAddress_null() {
        formErrorMessage=driver.findElementById("formErrorMessage");
        System.out.print("Address输入为空："+formErrorMessage.getText());
    }

    @Test
    public void testFcheakAddress_data() {
        address=driver.findElement(By.id("customer.billing.address"));
        setAllText(address,Tools.getUUIDText());
        injectSQLs(address);
        webElements.put(address,"中国广东顺德大良");
    }

    @Test
    public void testGcheakCity_null() {
        formErrorMessage=driver.findElementById("formErrorMessage");
        System.out.print("City输入为空："+formErrorMessage.getText());
    }

    @Test
    public void testHcheakCity_data() {
        city=driver.findElement(By.id("customer.billing.city"));
        setAllText(city,Tools.getUUIDText());
        injectSQLs(city);
        webElements.put(city,"佛山");
    }

    @Test
    public void testIcheckCountry() {
        country=driver.findElement(By.id("customer.billing.country"));
        countrySelect=new Select(country);
        countrySelect.selectByVisibleText("United Kingdom");
        submitOrder.click();
    }

    @Test
    public void testJcheckProvince() {
        province=driver.findElement(By.name("customer.billing.stateProvince"));
        setAllText(province,Tools.getUUIDText());
        injectSQLs(province);
        webElements.put(province,"广东省");
    }

    @Test
    public void testKcheckPostalCode_null() {
        formErrorMessage=driver.findElementById("formErrorMessage");
        System.out.print("PostalCode输入为空："+formErrorMessage.getText());
    }

    @Test
    public void testLcheckPostalCode_data() {
        postalCode=driver.findElement(By.name("customer.billing.postalCode"));
        setAllText(postalCode,Tools.getUUIDText());
        injectSQLs(postalCode);
        postalCode.clear();
        postalCode.sendKeys("IV17 0YT");
        webElements.put(postalCode,"M2 5BQ");
    }

    @Test
    public void testMcheckEmail_null() {
        formErrorMessage=driver.findElementById("formErrorMessage");
        System.out.print("Email输入为空："+formErrorMessage.getText());
    }

    @Test
    public void testNcheckEmail_data() {
        email=driver.findElement(By.id("customer.emailAddress"));
        setAllText(email,Tools.getUUIDText());
        injectSQLs(email);
        webElements.put(email,"1401734643@qq.com");
    }

    @Test
    public void testOcheckPhoneNumber() {
        phoneNumber=driver.findElement(By.name("customer.billing.phone"));
        setAllText(phoneNumber,Tools.getUUIDText());
        injectSQLs(phoneNumber);
        webElements.put(phoneNumber,"19197032890");
    }

    @Test
    public void testPcheckCheckboxOfCreateAnAccount() {
        checkboxOfCreateAnAccount.click();
    }

    @Test
    public void testQcheckPassword_null() {
        formErrorMessage=driver.findElementById("formErrorMessage");
        System.out.print("Password输入为空："+formErrorMessage.getText());
    }

    @Test
    public void testRcheckPassword_data() {
        setAllText(password,Tools.getUUIDText());
        injectSQLs(password);
        webElements.put(password,"12345678");
    }
    @Test
    public void testScheckCheckboxOfOrderNote() {
        setAllText(checkboxOfOrderNote,Tools.getUUIDText());
        injectSQLs(checkboxOfOrderNote);
        webElements.put(checkboxOfOrderNote,"12345678");
    }

    @Test
    public void testTcheackSubmitOrder()throws InterruptedException{
        clearText(webElements);
        setText(webElements);
        scrFile();
        submitOrder.click();
        Thread.sleep(3000);
        scrFile();
        driver.navigate().back();
    }

    @AfterClass
    public static void alterClass() {
        webdriver.disconnect();
    }

    public void injectSQLs(WebElement element){
        String[] strings={
                "and ascii(substr((select database()),1,1))>64",
                "id=1 union select if(SUBSTRING(user(),1,4)='root',sleep(4),1),null,null",
                "id =-1 union select 1,2,3","id=1' substr(database(),1,1)='t'--+",
                "union select count(*),2,concat(':',(select database()),':',floor(rand()*2))as a from information_schema.tables group by a",
                "id=1 and (extractvalue(1,concat(0x7e,(select user()),0x7e)))"};
        for (int i=0;i< strings.length;i++){
            if (i>strings.length-2){
                element.sendKeys(strings[i]);
                submitOrder.click();
            }
            else {
                element.sendKeys(strings[i]);
                submitOrder.click();
                element.clear();
            }

        }

    }
    public void setAllText(WebElement element,String str){
        element.sendKeys(str,Tools.getUUIDText());
        submitOrder.click();
        element.clear();
    }

    public void clearText(HashMap<WebElement,String> maps){
        for (Map.Entry<WebElement,String> hashMap:maps.entrySet()) {
            hashMap.getKey().clear();
        }
    }
    public void setText(HashMap<WebElement,String> maps){
        for (Map.Entry<WebElement,String> hashMap:maps.entrySet()) {
            hashMap.getKey().sendKeys(hashMap.getValue());
        }
    }

}
