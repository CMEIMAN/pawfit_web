package com.latsen.pawfit.testCase;

import com.latsen.pawfit.Const.Const;
import com.latsen.pawfit.common.Driver;
import junit.framework.TestCase;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PalpalInfoTestCase extends TestCase {
    private static WebDriver driver;
    private static Driver demo;
    private static Actions actions;
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
    private static WebElement warningMessahe;
    private static Select countrySelect;

    public void Init() {
        demo=new Driver(Const.PAYPAL_URL);
        driver=demo.connect();
        actions=new Actions(driver);
        webElements=new HashMap<WebElement, String>();
    }

    @Test
    public void testAcheckFitstName() {
        Init();
        /*
        * 判空
        * */
        submitOrder=driver.findElement(By.id("submitOrder"));
        submitOrder.click();
        warningMessahe=driver.findElement(By.xpath("//*[@id=\"formErrorMessage\"]/strong/font"));
        assertEquals("First name is required",warningMessahe.getText());
        /*长度判断*/
        firstName=driver.findElement(By.id("customer.firstName"));
        setAllText(firstName,getUUIDText());
        /*SQL注入*/
        injectSQLs(firstName);
        webElements.put(firstName,"pawfit");


    }
    @Test
    public void testBcheckLastName() {
        lastName=driver.findElement(By.id("customer.lastName"));
        setAllText(lastName,getUUIDText());
        injectSQLs(lastName);
        webElements.put(lastName,"latsen");

    }

    @Test
    public void testCcompany() {
        company=driver.findElement(By.id("customer.billing.company"));
        setAllText(company,getUUIDText());
        injectSQLs(company);
        webElements.put(company,"广东顺德雷舜信息科技有限公司");

    }

    @Test
    public void testDcheakAddress() {
        address=driver.findElement(By.id("customer.billing.address"));
        setAllText(address,getUUIDText());
        injectSQLs(address);
        webElements.put(address,"中国广东顺德大良");
    }

    @Test
    public void testEcheakCity() {
        city=driver.findElement(By.id("customer.billing.city"));
        setAllText(city,getUUIDText());
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
        setAllText(province,getUUIDText());
        injectSQLs(province);
        webElements.put(province,"广东省");

    }

    @Test
    public void testHcheckPostalCode() {
        postalCode=driver.findElement(By.name("customer.billing.postalCode"));
        setAllText(postalCode,getUUIDText());
        injectSQLs(postalCode);
        webElements.put(postalCode,"M2 5BQ");

    }

    @Test
    public void testIcheckEmail() {
        email=driver.findElement(By.id("customer.emailAddress"));
        setAllText(email,getUUIDText());
        injectSQLs(email);
        webElements.put(email,"1401734643@qq.com");
    }

    @Test
    public void testJcheckPhoneNumber() {
        phoneNumber=driver.findElement(By.name("customer.billing.phone"));
        setAllText(phoneNumber,getUUIDText());
        injectSQLs(phoneNumber);
        webElements.put(phoneNumber,"19197032890");
    }

    @Test
    public void testKcheckCheckboxOfCreateAnAccount() {

    }

    @Test
    public void testLcheckPassword() {
    }

    @Test
    public void testMcheckCheckboxOfOrderNote() {
    }


    @Test
    public void testVcheackSubmitOrder() {
        clearText(webElements);
        setText(webElements);
        submitOrder.click();
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
    public String getUUIDText(){
        String str="";
        for (int i=0;i<100;i++){
            str= UUID.randomUUID().toString();
        }
        return str;
    }
    public void setAllText(WebElement element,String str){
        element.sendKeys(str,getUUIDText());
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
