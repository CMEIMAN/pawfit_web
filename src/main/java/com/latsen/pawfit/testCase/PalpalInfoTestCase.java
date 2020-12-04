package com.latsen.pawfit.testCase;

import com.latsen.pawfit.Const.Const;
import com.latsen.pawfit.common.Driver;
import com.latsen.pawfit.driver.MyChromeDriver;
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
    private static MyChromeDriver driver;
    private static Driver webdriver;
    private static WebElement add;
    private static WebElement checkout;
    private Utils FileUtils;

    @BeforeClass
    public static void beforeClass() throws IOException {
        System.out.println("已经执行");
        webdriver = new Driver(Const.PRODUCT_URL);
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
        File srcFile = ((TakesScreenshot)webdriver).getScreenshotAs(OutputType.FILE);  //执行屏幕截取
        FileUtils.copyFile(srcFile, new File("C:\\Users\\Admin\\web_test\\src\\img\\PalpalInfo", Name+"_"+time + ".png"));
    }

    @Test
    public void testAcheckFitstName() {
        /*长度判断*/
        firstName=driver.findElement(By.id("customer.firstName"));
        setAllText(firstName, Tools.getUUIDText());
//        scrFile();
        /*SQL注入*/
        injectSQLs(firstName);
        webElements.put(firstName,"pawfit");
    }

    @Test
    public void testBcheckLastName() {
        lastName=driver.findElement(By.id("customer.lastName"));
        setAllText(lastName,Tools.getUUIDText());
//        scrFile();
        injectSQLs(lastName);
        webElements.put(lastName,"latsen");
    }

    @Test
    public void testCcompany() {
        company=driver.findElement(By.id("customer.billing.company"));
        setAllText(company,Tools.getUUIDText());
//        scrFile();
        injectSQLs(company);
        webElements.put(company,"广东顺德雷舜信息科技有限公司");
    }

    @Test
    public void testDcheakAddress() {
        address=driver.findElement(By.id("customer.billing.address"));
        setAllText(address,Tools.getUUIDText());
        injectSQLs(address);
        webElements.put(address,"中国广东顺德大良");
    }

    @Test
    public void testEcheakCity() {
        city=driver.findElement(By.id("customer.billing.city"));
        setAllText(city,Tools.getUUIDText());
        injectSQLs(city);
        webElements.put(city,"佛山");
    }

    @Test
    public void testFcheckCountry() {
        country=driver.findElement(By.id("customer.billing.country"));
        countrySelect=new Select(country);
        countrySelect.selectByVisibleText("United Kingdom");
        submitOrder.click();
    }

    @Test
    public void testGcheckProvince() {
        province=driver.findElement(By.name("customer.billing.stateProvince"));
        setAllText(province,Tools.getUUIDText());
        injectSQLs(province);
        webElements.put(province,"广东省");
    }

    @Test
    public void testHcheckPostalCode() {
        postalCode=driver.findElement(By.name("customer.billing.postalCode"));
        setAllText(postalCode,Tools.getUUIDText());
        injectSQLs(postalCode);webElements.put(postalCode,"M2 5BQ");
    }

    @Test
    public void testIcheckEmail() {
        email=driver.findElement(By.id("customer.emailAddress"));
        setAllText(email,Tools.getUUIDText());
        injectSQLs(email);
        webElements.put(email,"1401734643@qq.com");
    }

    @Test
    public void testJcheckPhoneNumber() {
        phoneNumber=driver.findElement(By.name("customer.billing.phone"));
        setAllText(phoneNumber,Tools.getUUIDText());
        injectSQLs(phoneNumber);
        webElements.put(phoneNumber,"19197032890");
    }

    @Test
    public void testKcheckCheckboxOfCreateAnAccount() {
        checkboxOfCreateAnAccount.click();
    }

    @Test
    public void testLcheckPassword() {
        setAllText(password,Tools.getUUIDText());
        injectSQLs(password);
        webElements.put(password,"12345678");
    }
    @Test
    public void testMcheckCheckboxOfOrderNote() {
        setAllText(checkboxOfOrderNote,Tools.getUUIDText());
        injectSQLs(checkboxOfOrderNote);
        webElements.put(checkboxOfOrderNote,"12345678");
    }

    @Test
    public void testVcheackSubmitOrder() {
        clearText(webElements);
        scrFile();
        setText(webElements);
        scrFile();
        submitOrder.click();
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
                scrFile();
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
