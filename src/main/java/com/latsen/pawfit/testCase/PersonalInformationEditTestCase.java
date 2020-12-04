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
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersonalInformationEditTestCase {
    private static WebDriverWait webDriverWait;
    private static WebElement firstName;
    private static WebElement lastName;
    private static WebElement customer_country;
    private static WebElement province;
    private static WebElement street_address;
    private static WebElement phone;
    private static WebElement city;
    private static WebElement submit;
    private static MyChromeDriver myChromeDriver;
    private static Driver driver;
    private static HashMap<WebElement, String> elementStringHashMap;
    private static Select select;
    private static WebElement warningMessage;
    private static Map<String,String> warningMessageMap;
    private static WebElement postcode;
    private static WebElement emil;
    private static WebElement password;
    private static WebElement login;
    private static WebElement imformation;
    private static WebElement edit;

    @BeforeClass
    public static void beforeClass() throws IOException {
        System.out.println("已经执行");
        driver = new Driver(Const.LOGiN_URL);
        elementStringHashMap = new HashMap<WebElement, String>();
        warningMessageMap=new HashMap<String, String>();
        myChromeDriver = driver.connect();
        webDriverWait=new WebDriverWait(myChromeDriver,10l,1l);

        emil= myChromeDriver.findElementById("signin_userName");
        password= myChromeDriver.findElementById("signin_password");
        login= myChromeDriver.findElementById("genericLogin-button");
        //登录账号
        emil.sendKeys("1790039849@qq.com");
        password.sendKeys("123456");
        login.click();
        imformation=myChromeDriver.findElementByXPath("/html/body/div[3]/div/div[2]/div[1]/ul/li[1]/a");
        imformation.click();
        edit =myChromeDriver.findElementByXPath("/html/body/div[3]/div[2]/div[2]/div/span/p/span[2]/a/button");
        edit.click();

        //定位元素
        warningMessage=myChromeDriver.findElement(By.id("formError"));
        firstName = myChromeDriver.findElement(By.id("firstName"));
        lastName = myChromeDriver.findElement(By.id("lastName"));
        submit = myChromeDriver.findElement(By.id("submitAddress"));
        customer_country = myChromeDriver.findElement(By.id("customer_country"));
        province = myChromeDriver.findElement(By.id("stateProvince"));
        street_address = myChromeDriver.findElement(By.id("address"));
        phone = myChromeDriver.findElement(By.id("phone"));
        city = myChromeDriver.findElement(By.id("city"));
        postcode=myChromeDriver.findElementById("billingPostalCode");
        elementStringHashMap.put(firstName, "Pawfit");
        elementStringHashMap.put(lastName, "latsen");
        select = new Select(customer_country);
        select.selectByVisibleText("United Kingdom");
        elementStringHashMap.put(province, "广东省");
        elementStringHashMap.put(street_address, "test");
        elementStringHashMap.put(phone, "12346625");
        elementStringHashMap.put(city, "佛山");

//        清除原有数据
        firstName.clear();
        lastName.clear();
        province.clear();
        street_address.clear();
        phone .clear();
        city .clear();
        postcode.clear();
    }

    @Test
    public void testAFirstName() {
        //空判断
        submit.click();
        warningMessageMap.put("首名空判断",warningMessage.getText());
        //长度判断
        setTextAndClickBtn(firstName, Tools.getUUIDText(),submit);
        firstName.sendKeys(elementStringHashMap.get(firstName));
    }

    @Test
    public void testBLastName() {
        //空判断
        submit.click();
        warningMessageMap.put("次名空判断",warningMessage.getText());
        //长度判断
        setTextAndClickBtn(lastName,Tools.getUUIDText(),submit);
        lastName.sendKeys(elementStringHashMap.get(lastName));
    }

    @Test
    public void testCCountry() {
        select.selectByVisibleText("Romania");
    }

    @Test
    public void testDProvince() {
        //长度判断
        setTextAndClickBtn(province,Tools.getUUIDText(),submit);
        warningMessageMap.put("省份长度判断",warningMessage.getText());
        province.sendKeys(elementStringHashMap.get(province));
    }

    @Test
    public void testEstreet_address() {
        //长度判断
        setTextAndClickBtn(street_address,Tools.getUUIDText(),submit);
        warningMessageMap.put("street address度判断",warningMessage.getText());
        street_address.sendKeys(elementStringHashMap.get(street_address));
    }

    @Test
    public void testFphone() {
        //长度判断
        setTextAndClickBtn(phone,Tools.getUUIDText(),submit);
        warningMessageMap.put("电话号码长度判断",warningMessage.getText());
        phone.sendKeys(elementStringHashMap.get(phone));
    }

    @Test
    public void testJcity() {
        //长度判断
        setTextAndClickBtn(city,Tools.getUUIDText(),submit);
        warningMessageMap.put("city长度判断",warningMessage.getText());
    }

    @Test
    public void testKpostcode() {
        setTextAndClickBtn(postcode,Tools.getUUIDText(),submit);
        warningMessageMap.put("postcode长度判断",warningMessage.getText());
    }

    @AfterClass
    public static void alterClass() {
        //输出全部错误提示
        for (Map.Entry<String,String> entry:warningMessageMap.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        setText(elementStringHashMap);
        //提交
        submit.click();
        try {
            Thread.sleep(10000l);
        }
        catch (Exception e){
            System.out.println("出现异常");
        }
        driver.disconnect();
    }

    public static void setText(HashMap<WebElement, String> elementStringHashMap) {
        for (HashMap.Entry<WebElement, String> map : elementStringHashMap.entrySet()) {
            map.getKey().clear();
            map.getKey().sendKeys(map.getValue());
        }

    }

    public void clearText(HashMap<WebElement, String> hashMap) {
        for (HashMap.Entry<WebElement, String> map : elementStringHashMap.entrySet()) {
            map.getKey().clear();
        }
    }

    public void setTextAndClickBtn(WebElement webElement,String content,WebElement btn){
        webElement.sendKeys(content);
        btn.click();

    }

}
