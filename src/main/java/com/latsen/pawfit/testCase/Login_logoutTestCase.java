package com.latsen.pawfit.testCase;

import com.latsen.pawfit.Const.Const;
import com.latsen.pawfit.common.NewDriver;
import com.latsen.pawfit.driver.MyChromeDriverSingleton;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebElement;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.latsen.pawfit.utils.JavaTools;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Login_logoutTestCase {
    private static MyChromeDriverSingleton myChromeDriver;
    private static NewDriver driver;
    private static WebElement email;
    private static WebElement password;
    private static WebElement eye;
    private static WebElement submit;
    private static WebElement warningMessage;
    private static WebElement logout;
    private static Map<String,String> warningMessageMap;
    private static HashMap<WebElement, String> elementStringHashMap;
    private static JavaTools javaTools;

    @BeforeClass
    public static void beforeClass() throws IOException {
        System.out.println("已经执行");
        driver = new NewDriver(Const.LOGiN_URL);
        myChromeDriver = driver.connect();
        warningMessageMap=new HashMap<String, String>();
        elementStringHashMap = new HashMap<WebElement, String>();
        javaTools =new JavaTools();

        email=myChromeDriver.findElementById("signin_userName");
        password=myChromeDriver.findElementById("signin_password");
        eye =myChromeDriver.findElementById("togglePassword_customer");
        submit =myChromeDriver.findElementById("genericLogin-button");
    }

    @Test
    public void testAPut1() {
//        循环注入数据
        for(int i=0;i<Const.getCommomText().length;i++) {
            email.sendKeys("" + Const.getCommomText()[i]);
            password.sendKeys("" + Const.getCommomText()[i]);
        }
        javaTools.jsclick(myChromeDriver,submit);
    }

    @Test
    public void testBboth_null() throws InterruptedException{
//        清除输入框数据
        javaTools.clear(email);
        javaTools.clear(password);
//        email和password输入为空
        javaTools.inputText(myChromeDriver,"",email);
        javaTools.inputText(myChromeDriver,"",password);
        javaTools.click(submit);
        javaTools.sleep(3000);
        warningMessage=myChromeDriver.findElementById("loginError");
        warningMessageMap.put("Email和Password输入空",warningMessage.getText());
        javaTools.verifyassert(warningMessage.getText(),"Login failed. Username or Password is incorrect.","测试登录提示是否相同：");
    }

    @Test
    public void testCboth_sp() throws IOException {
        //        email和password输入特殊字符
        javaTools.inputText(myChromeDriver,"&%……￥#@*？~",email);
        javaTools.inputText(myChromeDriver,"&%……￥#@*？~",password);
        javaTools.click(submit);

        warningMessage=myChromeDriver.findElementById("loginError");
        warningMessageMap.put("Email和Password输入特殊字符",warningMessage.getText());
        javaTools.verifyassert(warningMessage.getText(),"Login failed. Username or Password is incorrect.","测试登录提示是否相同：");
        javaTools.clear(email);
        javaTools.clear(password);
    }

    @Test
    public void testDpassword_null() {
//        email输入正确，password输入为空
        javaTools.inputText(myChromeDriver,"1790039849@qq.com",email);
        javaTools.inputText(myChromeDriver,"",password);
        javaTools.click(submit);
        warningMessage=myChromeDriver.findElementById("loginError");
        warningMessageMap.put("Email正确，Password输入空",warningMessage.getText());
        javaTools.verifyassert(warningMessage.getText(),"Login failed. Username or Password is incorrect.","测试登录提示是否相同：");
        javaTools.clear(email);
    }

    @Test
    public void testEemail_error() {
        //     email输入错误，password输入错误
        javaTools.inputText(myChromeDriver,"111111111111",email);
        javaTools.inputText(myChromeDriver,"12345688",password);
        javaTools.click(submit);
        warningMessage=myChromeDriver.findElementById("loginError");
        warningMessageMap.put("Email错误，Password输入正确",warningMessage.getText());
        javaTools.verifyassert(warningMessage.getText(),"Login failed. Username or Password is incorrect.","测试登录提示是否相同：");
        javaTools.clear(email);
        javaTools.clear(password);
    }

    @Test
    public void testFemail_sp() {
        //      email输入特殊字符，password输入正确
        javaTools.inputText(myChromeDriver,"&%……￥#@*？~/*",email);
        javaTools.inputText(myChromeDriver,"12345678",password);
        javaTools.click(submit);
        warningMessage=myChromeDriver.findElementById("loginError");
        warningMessageMap.put("Email输入特殊字符，Password输入正确误",warningMessage.getText());
        javaTools.verifyassert(warningMessage.getText(),"Login failed. Username or Password is incorrect.","测试登录提示是否相同：");
        javaTools.clear(email);
        javaTools.clear(password);
    }

    @Test
    public void testGpassword_sp() {
        //     email输入正确，password输入特殊字符
        javaTools.inputText(myChromeDriver,"1790039849@qq.com",email);
        javaTools.inputText(myChromeDriver,"&%……￥#@*？~/*",password);
        javaTools.click(submit);
        warningMessage=myChromeDriver.findElementById("loginError");
        warningMessageMap.put("Email正确，Password输入特殊字符",warningMessage.getText());
        javaTools.verifyassert(warningMessage.getText(),"Login failed. Username or Password is incorrect.","测试登录提示是否相同：");
        javaTools.clear(email);
        javaTools.clear(password);
    }

    @Test
    public void testHmin6() {
        //     email输入正确，password输入小于6字符长度
        javaTools.inputText(myChromeDriver,"1790039849@qq.com",email);
        javaTools.inputText(myChromeDriver,"12",password);
        javaTools.click(submit);
        warningMessage=myChromeDriver.findElementById("loginError");
        warningMessageMap.put("Email正确，Password输入小于6字符长度",warningMessage.getText());
        javaTools.verifyassert(warningMessage.getText(),"Login failed. Username or Password is incorrect.","测试登录提示是否相同：");
        javaTools.clear(email);
        javaTools.clear(password);
    }

    @Test
    public void testImax30() {
        //     email输入正确，password输入大于30字符长度
        javaTools.inputText(myChromeDriver,"1790039849@qq.com",email);
        javaTools.inputText(myChromeDriver,"1213233455565767878243435645657678782342323243434454565465234435223234123",password);
        javaTools.click(submit);
        warningMessage=myChromeDriver.findElementById("loginError");
        warningMessageMap.put("Email正确，Password输入大于30字符长度",warningMessage.getText());
        javaTools.verifyassert(warningMessage.getText(),"Login failed. Username or Password is incorrect.","测试登录提示是否相同：");
        javaTools.clear(email);
        javaTools.clear(password);
    }

    @Test
    public void testJright() {
        //      输入正确的email和password
        javaTools.inputText(myChromeDriver,"1790039849@qq.com",email);
        javaTools.inputText(myChromeDriver,"12345678",password);
        javaTools.click(eye);
        javaTools.jsclick(myChromeDriver,submit);
        System.out.println("登录成功！");
    }

//      注销登录
    @Test
    public void testKCancel2() {
        logout=myChromeDriver.findElementByXPath("/html/body/div[3]/div/div[2]/div[1]/ul/li[4]/a");
        javaTools.click(logout);
        System.out.println("注销成功！");
    }

    @AfterClass
    public static void alterClass() {
        //输出全部错误提示
        for (Map.Entry<String,String> entry:warningMessageMap.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        setText(elementStringHashMap);
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

}
