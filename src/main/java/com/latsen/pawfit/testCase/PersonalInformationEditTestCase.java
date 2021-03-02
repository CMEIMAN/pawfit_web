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
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.latsen.pawfit.utils.JavaTools;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersonalInformationEditTestCase {
    private static WebElement firstName;
    private static WebElement lastName;
    private static WebElement customer_country;
    private static WebElement province;
    private static WebElement street_address;
    private static WebElement phone;
    private static WebElement city;
    private static WebElement submit;
    private static MyChromeDriverSingleton myChromeDriver;
    private static NewDriver driver;
    private static HashMap<WebElement, String> elementStringHashMap;
    private static Select select;
    private static WebElement warningMessage;
    private static Map<String,String> warningMessageMap;
    private static WebElement postcode;
    private static WebElement email;
    private static WebElement password;
    private static WebElement login;
    private static WebElement imformation;
    private static WebElement edit;
    private static JavaTools javaTools;

    @BeforeClass
    public static void beforeClass() throws IOException {
        driver = new NewDriver(Const.LOGiN_URL);
        elementStringHashMap = new HashMap<WebElement, String>();
        warningMessageMap=new HashMap<String, String>();
        myChromeDriver = driver.connect();
        javaTools = new JavaTools();

        email= myChromeDriver.findElementById("signin_userName");
        password= myChromeDriver.findElementById("signin_password");
        login= myChromeDriver.findElementById("genericLogin-button");
        //登录账号
        javaTools.inputText(myChromeDriver,"1790039849@qq.com",email);
        javaTools.inputText(myChromeDriver,"12345678",password);
        javaTools.click(login);
        imformation=myChromeDriver.findElementByXPath("/html/body/div[3]/div/div[2]/div[1]/ul/li[1]/a");
        javaTools.click(imformation);
        edit =myChromeDriver.findElementByXPath("/html/body/div[3]/div[2]/div[2]/div/span/p/span[2]/a/button");
        javaTools.click(edit);

        //定位元素

        firstName = myChromeDriver.findElement(By.id("firstName"));
        lastName = myChromeDriver.findElement(By.id("lastName"));
        customer_country = myChromeDriver.findElement(By.id("customer_country"));
        province = myChromeDriver.findElement(By.id("stateProvince"));
        street_address = myChromeDriver.findElement(By.id("address"));
        phone = myChromeDriver.findElement(By.id("phone"));
        city = myChromeDriver.findElement(By.id("city"));
        postcode=myChromeDriver.findElementById("billingPostalCode");
        elementStringHashMap.put(firstName, "Pawfit");
        elementStringHashMap.put(lastName, "latsen");
        select = new Select(customer_country);
//        select.selectByVisibleText("United Kingdom");
        select.selectByVisibleText("United States");
        elementStringHashMap.put(province, "广东省");
//        elementStringHashMap.put(postcode,"IV17 0YT");
        elementStringHashMap.put(postcode,"12345");
        elementStringHashMap.put(street_address, "test");
        elementStringHashMap.put(phone, "12346625");
        elementStringHashMap.put(city, "佛山");

        //清除原有数据
        javaTools.clear(firstName);
        javaTools.clear(lastName);
        javaTools.clear(province);
        javaTools.clear(street_address);
        javaTools.clear(phone);
        javaTools.clear(city);
    }

    @Test
    public void testAFirstName() {
        submit = myChromeDriver.findElement(By.id("submitAddress"));
        //空判断
        javaTools.click(submit);
        warningMessage=myChromeDriver.findElement(By.id("formError"));
        warningMessageMap.put("首名空判断",warningMessage.getText());
        //长度判断
        setTextAndClickBtn(firstName, Tools.getUUIDText(),submit);
        warningMessageMap.put("首名长度判断",warningMessage.getText());
        //输入特殊字符
        javaTools.inputText(myChromeDriver,"#￥%……&*？",firstName);
        javaTools.click(submit);
        warningMessageMap.put("首名特殊字符判断判断",warningMessage.getText());
        javaTools.clear(firstName);
        firstName.sendKeys(elementStringHashMap.get(firstName));
    }

    @Test
    public void testBLastName() {
        //空判断
        javaTools.click(submit);
        warningMessage=myChromeDriver.findElement(By.id("formError"));
        warningMessageMap.put("次名空判断",warningMessage.getText());
        //长度判断
        setTextAndClickBtn(lastName,Tools.getUUIDText(),submit);
        warningMessageMap.put("次名长度判断",warningMessage.getText());
        //输入特殊字符
        javaTools.inputText(myChromeDriver,"#￥%……&*？",lastName);
        javaTools.click(submit);
        warningMessageMap.put("次名特殊字符判断判断",warningMessage.getText());
        javaTools.clear(lastName);
        lastName.sendKeys(elementStringHashMap.get(lastName));
    }

    @Test
    public void testCCountry() {
//        select.selectByVisibleText("United Kingdom");
        select.selectByVisibleText("United States");
    }

    @Test
    public void testDProvince() {
        //长度判断
        setTextAndClickBtn(province,Tools.getUUIDText(),submit);
        warningMessage=myChromeDriver.findElement(By.id("formError"));
        warningMessageMap.put("province长度判断",warningMessage.getText());
        //特殊字符
        javaTools.inputText(myChromeDriver,"#￥%……&*？=-,.",province);
        warningMessageMap.put("province特殊字符判断",warningMessage.getText());
        javaTools.clear(province);
        province.sendKeys(elementStringHashMap.get(province));
    }

    @Test
    public void testEstreet_address() {
        //长度判断
        setTextAndClickBtn(street_address,Tools.getUUIDText(),submit);
        warningMessage=myChromeDriver.findElement(By.id("formError"));
        warningMessageMap.put("street address长度判断",warningMessage.getText());
        //特殊字符
        javaTools.inputText(myChromeDriver,"#￥%……&*？=-,.[|*",street_address);
        warningMessageMap.put("street address特殊字符判断",warningMessage.getText());
        javaTools.clear(street_address);
        street_address.sendKeys(elementStringHashMap.get(street_address));
    }

    @Test
    public void testFphone() {
        //长度判断
        setTextAndClickBtn(phone,Tools.getUUIDText(),submit);
        warningMessage=myChromeDriver.findElement(By.id("formError"));
        warningMessageMap.put("电话号码长度判断",warningMessage.getText());
        //特殊字符
        javaTools.inputText(myChromeDriver,"#￥%……&*？=-,.[|*",phone);
        warningMessageMap.put("phone特殊字符判断",warningMessage.getText());
        javaTools.clear(phone);
        phone.sendKeys(elementStringHashMap.get(phone));
    }

    @Test
    public void testJcity() {
        //长度判断
        setTextAndClickBtn(city,Tools.getUUIDText(),street_address);
        warningMessage=myChromeDriver.findElement(By.id("formError"));
        warningMessageMap.put("city长度判断",warningMessage.getText());
        //特殊字符
        city = myChromeDriver.findElement(By.id("city"));
        javaTools.inputText(myChromeDriver,"#￥%……&*？=-,.[|*",city);
        warningMessageMap.put("city特殊字符判断",warningMessage.getText());
        javaTools.clear(city);
        street_address = myChromeDriver.findElement(By.id("address"));
        javaTools.click(street_address);
    }

    @Test
    public void testKpostcode() {
        postcode=myChromeDriver.findElementById("billingPostalCode");
        javaTools.clear(postcode);
        warningMessage=myChromeDriver.findElement(By.id("formError"));
        warningMessageMap.put("postcode空判断",warningMessage.getText());
        submit = myChromeDriver.findElement(By.id("submitAddress"));
        setTextAndClickBtn(postcode,Tools.getUUIDText(),submit);
        warningMessageMap.put("postcode长度判断",warningMessage.getText());
        //特殊字符
        javaTools.inputText(myChromeDriver,"#￥%……&*？=-,.[|*",postcode);
        warningMessageMap.put("postcode特殊字符判断",warningMessage.getText());
        javaTools.clear(postcode);
    }

    @AfterClass
    public static void alterClass() {
        //输出全部错误提示
        for (Map.Entry<String,String> entry:warningMessageMap.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
//        select = new Select(customer_country);
//        select.selectByVisibleText("United Kingdom");
        select.selectByVisibleText("United States");
        setText(elementStringHashMap);
        //提交
        submit.click();
        try {
            Thread.sleep(10000l);
        }
        catch (Exception e){
            System.out.println("出现异常");
        }
//        driver.disconnect();
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
