package com.latsen.pawfit.testCase;

import com.latsen.pawfit.Const.Const;
import com.latsen.pawfit.common.Driver;
import com.latsen.pawfit.utils.Tools;
import com.latsen.pawfit.driver.MyChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
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
import java.util.Random;

@FixMethodOrder(value = MethodSorters.JVM)
public class RegisterTestCase {
    private static WebDriverWait webDriverWait;
    private static WebElement firstName;
    private static WebElement lastName;
    private static WebElement country;
    private static WebElement province;
    private static WebElement email;
    private static WebElement password;
    private static WebElement rePassword;
    private static WebElement submit;
    private static MyChromeDriver myChromeDriver;
    private static Driver driver;
    private static HashMap<WebElement, String> elementStringHashMap;
    private static Select select;
    private static WebElement warningMessage;
    private static Map<String,String> warningMessageMap;
    private static WebElement agree_email;
    private static WebElement check;

    @BeforeClass
    public static void beforeClass() throws IOException {
        System.out.println("已经执行");
        driver = new Driver(Const.REGISTER_RUL);
        elementStringHashMap = new HashMap<WebElement, String>();
        warningMessageMap=new HashMap<String, String>();
        myChromeDriver = driver.connect();
        webDriverWait=new WebDriverWait(myChromeDriver,10l,1l);
        warningMessage=myChromeDriver.findElement(By.id("registrationError"));
        firstName = myChromeDriver.findElement(By.id("firstName"));
        lastName = myChromeDriver.findElement(By.id("lastName"));
        submit = myChromeDriver.findElement(By.id("submitRegistration"));
        country = myChromeDriver.findElement(By.id("registration_country"));
        province = myChromeDriver.findElement(By.id("zoners"));
        email = myChromeDriver.findElement(By.id("emailAddress"));
        password = myChromeDriver.findElement(By.id("password"));
        rePassword = myChromeDriver.findElement(By.id("passwordAgain"));
        agree_email=myChromeDriver.findElementById("agree_email");
        elementStringHashMap.put(firstName, "Pawfit");
        elementStringHashMap.put(lastName, "latsen");
        select = new Select(country);
        select.selectByVisibleText("United Kingdom");
        elementStringHashMap.put(province, "广东省");
        elementStringHashMap.put(email, "email@test" + new Random().nextInt() + ".com");
        elementStringHashMap.put(password, "fk_liekkas04040");
        elementStringHashMap.put(rePassword, "fk_liekkas04040");
    }

    @Test
    public void testAFirstName() {
        //空判断
        submit.click();
        warningMessageMap.put("首名空判断",warningMessage.getText());
        //长度判断
        setTextAndClickBtn(firstName,Tools.getUUIDText(),submit);
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
    public void testEEmail() {
        //长度判断
        setTextAndClickBtn(email,Tools.getUUIDText(),submit);
        warningMessageMap.put("邮箱长度判断",warningMessage.getText());
        //格式判断
        setTextAndClickBtn(email,"fk_liekkas",submit);
        warningMessageMap.put("邮箱格式判断",warningMessage.getText());
        email.sendKeys(elementStringHashMap.get(email));
    }

    @Test
    public void testFPassword() {
        //长度判断
        setTextAndClickBtn(password,Tools.getUUIDText(),submit);
        warningMessageMap.put("密码长度判断",warningMessage.getText());
        password.sendKeys(elementStringHashMap.get(password));
    }

    @Test
    public void testJRePassword() {
        //长度判断
        setTextAndClickBtn(rePassword,Tools.getUUIDText(),submit);
        warningMessageMap.put("二次密码长度判断",warningMessage.getText());
        //SQL注入尝试
//        Tools.injectSQLs(rePassword, submit, 1000, true);
        //密码匹配判断
        setTextAndClickBtn(rePassword,"fk_liekkas",submit);
        warningMessageMap.put("密码匹配判断",warningMessage.getText());
        rePassword.sendKeys(elementStringHashMap.get(rePassword));
    }

    @Test
    public void testKagree_email() {
        agree_email.click();
    }

    @AfterClass
    public static void alterClass() {
        //输出全部错误提示
        for (Map.Entry<String,String> entry:warningMessageMap.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        setText(elementStringHashMap);
        //提交
        check=myChromeDriver.findElementById("agree_email");
        check.click();
        submit = myChromeDriver.findElement(By.id("submitRegistration"));
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",submit);

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
        webElement.clear();
        webElement.sendKeys(content);
        btn.click();

    }

}
