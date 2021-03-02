package com.latsen.pawfit.testCase;

import com.latsen.pawfit.Const.Const;
import com.latsen.pawfit.common.NewDriver;
import com.latsen.pawfit.utils.Tools;
import com.latsen.pawfit.driver.MyChromeDriverSingleton;
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
import com.latsen.pawfit.utils.JavaTools;

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
    private static MyChromeDriverSingleton myChromeDriver;
    private static NewDriver driver;
    private static HashMap<WebElement, String> elementStringHashMap;
    private static Select select;
    private static WebElement warningMessage;
    private static Map<String,String> warningMessageMap;
    private static WebElement agree_email;
    private static WebElement check;
    private static JavaTools javaTools;

    @BeforeClass
    public static void beforeClass() throws IOException {
        System.out.println("已经执行");
        driver = new NewDriver(Const.REGISTER_RUL);
        elementStringHashMap = new HashMap<WebElement, String>();
        warningMessageMap=new HashMap<String, String>();
        myChromeDriver = driver.connect();
        webDriverWait=new WebDriverWait(myChromeDriver,10l,1l);
        javaTools=new JavaTools();

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
        select.selectByVisibleText("United States");
        elementStringHashMap.put(province, "广东省");
        elementStringHashMap.put(email, "email@test" + new Random().nextInt() + ".com");
        elementStringHashMap.put(password, "fk_liekkas04040");
        elementStringHashMap.put(rePassword, "fk_liekkas04040");
    }

    @Test
    public void testAFirstName_null() {
        //空判断
        submit.click();
        warningMessageMap.put("首名空判断",warningMessage.getText());
        javaTools.verifyassert(warningMessage.getText(),"Last name is required","测试首名空提示错误：");
    }

    @Test
    public void testBFirstName_long() {
        //长度判断
        setTextAndClickBtn(firstName,Tools.getUUIDText(),submit);
        firstName.sendKeys(elementStringHashMap.get(firstName));
    }

    @Test
    public void testCFirstName_sp() {
        firstName.clear();
        firstName.sendKeys("@#$%^^&*△?");
        javaTools.verifyassert(warningMessage.getText(),"Last name is required","测试首名特殊字符提示错误：");
    }

    @Test
    public void testDLastName_null() {
        //空判断
        submit.click();
        warningMessageMap.put("次名空判断",warningMessage.getText());
        javaTools.verifyassert(warningMessage.getText(),"Last name is required","测试次名空提示错误：");
    }

    @Test
    public void testELastName_long() {
        //长度判断
        setTextAndClickBtn(lastName,Tools.getUUIDText(),submit);
        lastName.sendKeys(elementStringHashMap.get(lastName));
    }

    @Test
    public void testFLastName_sp() {
        lastName.clear();
        lastName.sendKeys("@#$%^^&*△?");
        warningMessageMap.put("次名特殊字符判断",warningMessage.getText());
        javaTools.verifyassert(warningMessage.getText(),"Fields cannot be blank strings or too long.","测试次名特殊字符提示错误：");
    }

    @Test
    public void testGCountry() {
        select.selectByVisibleText("Romania");
    }

    @Test
    public void testHProvince_long() {
        //长度判断
        setTextAndClickBtn(province,Tools.getUUIDText(),submit);
        warningMessageMap.put("省份长度判断",warningMessage.getText());
        province.sendKeys(elementStringHashMap.get(province));
    }

    @Test
    public void testIProvince_sp() {
        province.clear();
        province.sendKeys("@#$%^^&*△?");
        javaTools.verifyassert(warningMessage.getText(),"Email address is required","测试Province特殊字符提示错误：");
    }

    @Test
    public void testJEmail_null() {
        email.click();
        warningMessageMap.put("邮箱空判断",warningMessage.getText());
        javaTools.verifyassert(warningMessage.getText(),"Email address is required","测试邮箱空提示错误：");
    }

    @Test
    public void testKEmail_long() {
        //长度判断
        email.clear();
        email.sendKeys("112111111111111111112322323235454565654343434");
        password.click();
        warningMessageMap.put("邮箱长度判断",warningMessage.getText());
        javaTools.verifyassert(warningMessage.getText(),"Fields cannot be blank strings or too long.","测试邮箱长度判断提示错误：");
    }

    @Test
    public void testLEmail_sp() {
        email.clear();
        email.sendKeys("@#$%^^&*△?");
        password.click();
        warningMessageMap.put("邮箱特殊字符判断",warningMessage.getText());
        javaTools.verifyassert(warningMessage.getText(),"Please provide a valid email address.","测试邮箱特殊字符提示错误：");

    }

    @Test
    public void testMEmail_error() {
        email.clear();
        //格式判断
        setTextAndClickBtn(email,"fk_liekkas",submit);
        warningMessageMap.put("邮箱格式判断",warningMessage.getText());
        email.sendKeys(elementStringHashMap.get(email));
    }

    @Test
    public void testNPassword_null() {
        password.click();
        warningMessageMap.put("密码空判断",warningMessage.getText());
        javaTools.verifyassert(warningMessage.getText(),"Fields cannot be blank strings or too long.","测试密码空提示错误：");
    }

    @Test
    public void testOPassword_long() {
//        //长度判断
//        setTextAndClickBtn(password,Tools.getUUIDText(),submit);
//        rePassword.click();
//        warningMessageMap.put("密码长度判断",warningMessage.getText());
//        password.sendKeys(elementStringHashMap.get(password));

        password.clear();
        password.sendKeys("123");
        rePassword.click();
        warningMessageMap.put("密码长度判断",warningMessage.getText());
        javaTools.verifyassert(warningMessage.getText(),"Your password should be between 6 and 30 characters in length.","测试密码长度提示错误：");
    }
    @Test
    public void testPPassword_sp(){
        password.clear();
        password.sendKeys("@#$%^^&*△?");
        warningMessageMap.put("密码长度特殊字符判断",warningMessage.getText());
        javaTools.verifyassert(warningMessage.getText(),"Please enter a password","测试密码特殊字符提示错误：");
    }

    @Test
    public void testQRePassword_null() {
        //SQL注入尝试
//        Tools.injectSQLs(rePassword, submit, 1000, true);
        //密码匹配判断
        setTextAndClickBtn(rePassword,"fk_liekkas",submit);
        warningMessageMap.put("密码匹配判断",warningMessage.getText());
        rePassword.sendKeys(elementStringHashMap.get(rePassword));
    }

    @Test
    public void testRRePassword_long() {
        //长度判断
        setTextAndClickBtn(rePassword,Tools.getUUIDText(),submit);
        warningMessageMap.put("二次密码长度判断",warningMessage.getText());
        javaTools.verifyassert(warningMessage.getText(),"Please repeat the password","测试确认密码长度提示错误：");
    }

    @Test
    public void testSRePassword_sp() {
        rePassword.clear();
        rePassword.sendKeys("@#$%^^&*△?");
        warningMessageMap.put("二次密码特殊字符判断",warningMessage.getText());
        javaTools.verifyassert(warningMessage.getText(),"Please repeat the password","测试确认密码特殊字符提示错误：");
    }

    @Test
    public void testTRePassword_error() {
        //密码匹配判断
        setTextAndClickBtn(rePassword,"fk_liekkas",submit);
        warningMessageMap.put("密码匹配判断",warningMessage.getText());
        rePassword.sendKeys(elementStringHashMap.get(rePassword));

        rePassword.clear();
        rePassword.sendKeys("444444444");
        password.click();
        javaTools.verifyassert(warningMessage.getText(),"Both password must match","测试确认密码错误提示错误：");
    }

    //邮箱已经注册过
    @Test
    public void testUEmail_exit() {

    }
    @Test
    public void testVagree_email() {
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
