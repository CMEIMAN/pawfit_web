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
import com.latsen.pawfit.utils.JavaTools;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ForgotPasswordTestCase{
    private static NewDriver driver;
    private static MyChromeDriverSingleton myChromeDriver;
    private static WebElement forgot_btn;
    private static WebElement email;
    private static WebElement emailCode;
    private static WebElement send;
    private static WebElement nextStep;
    private static WebElement newepassword;
    private static WebElement confirmpassword;
    private static WebElement confirm;
    private static WebElement formError;
    private static WebElement formError1;
    private static WebElement eye1;
    private static WebElement eye2;
    private static JavaTools javaTools;


    @BeforeClass
    public static void beforeClass() throws IOException {
        driver = new NewDriver(Const.LOGiN_URL);
        myChromeDriver = driver.connect();
        System.out.println("已经执行");
        javaTools=new JavaTools();

        forgot_btn=myChromeDriver.findElementByXPath("/html/body/div[3]/div/div/div[1]/div[2]/form/p[1]/a");
        forgot_btn.click();
        email= myChromeDriver.findElementByXPath("/html/body/div[3]/div/form/div/p[1]/input");
        emailCode=myChromeDriver.findElementById("emailCode");
        send=myChromeDriver.findElementById("getting");
        nextStep=myChromeDriver.findElementById("NextStep");
    }


    @Test
    public void testAput() {
        for(int i=0;i<Const.getCommomText().length;i++) {
            email.sendKeys("" + Const.getCommomText()[i]);
            emailCode.sendKeys("" + Const.getCommomText()[i]);
        }
        javaTools.clear(email);
        javaTools.clear(emailCode);
    }

    @Test
    public void testBemail_null() throws InterruptedException{
//        email输入空字符
        javaTools.inputText(myChromeDriver,"",email);
        javaTools.click(send);
        javaTools.sleep(2000);
        formError1=myChromeDriver.findElementById("formError");
        System.out.println("email输入空,点击发送验证码："+formError1.getText());
        javaTools.click(nextStep);
        formError1=myChromeDriver.findElementById("formError");
        System.out.print("email输入空，点击下一步："+formError1.getText());
        javaTools.clear(email);
    }

    @Test
    public void testCemail_sp() throws InterruptedException, IOException {
        //        输入特殊字符的email
        javaTools.inputText(myChromeDriver,"$@#^&*?/+_{}|",email);
        javaTools.click(send);
        javaTools.sleep(2000);
        formError1=myChromeDriver.findElementById("formError");
        System.out.print("email输入特殊字符："+formError1.getText());
        javaTools.scrFile(myChromeDriver);
        javaTools.clear(email);
    }

    @Test
    public void testDemail_error() throws InterruptedException{
        //        输入错误email
        javaTools.inputText(myChromeDriver,"11111111111",email);
        javaTools.click(send);
        javaTools.sleep(2000);
        formError1=myChromeDriver.findElementById("formError");
        System.out.print("email输入错误："+formError1.getText());
        javaTools.clear(email);
    }

    @Test
    public void testEemail_right() {
        //        输入正确email
        javaTools.inputText(myChromeDriver,"1790039849@qq.com",email);
        javaTools.clear(email);
    }

    @Test
    public void testFcode_error() throws InterruptedException{
        //        输入错误验证码
        javaTools.inputText(myChromeDriver,"111111111",emailCode);
        javaTools.click(nextStep);
        javaTools.sleep(2000);
        formError1=myChromeDriver.findElementById("formError");
        System.out.print("验证码输入错误："+formError1.getText());
        javaTools.clear(emailCode);
    }

    //输入特殊字符验证码
    @Test
    public void testGcode_error()throws InterruptedException {
        javaTools.inputText(myChromeDriver,"$@#^&*?/+_{}|",emailCode);
        javaTools.click(nextStep);
        formError1=myChromeDriver.findElementById("formError");
        System.out.println("验证码输入特殊字符："+formError1.getText());
        javaTools.clear(emailCode);

        //输入正确验证码，手动输入
        javaTools.click(send);
        System.out.println("等待25s,手动输入验证码！");
        javaTools.sleep(25000);
    }

    @Test
    public void testHput2() {
        newepassword=myChromeDriver.findElementById("password");
        confirmpassword=myChromeDriver.findElementById("checkPassword");
        for(int i=0;i<Const.getCommomText().length;i++) {
            newepassword.sendKeys("" + Const.getCommomText()[i]);
            confirmpassword.sendKeys("" + Const.getCommomText()[i]);
        }
        javaTools.clear(newepassword);
        javaTools.clear(confirmpassword);
    }

    //输入新密码为空
    @Test
    public void testInewpassword_null() {
        newepassword=myChromeDriver.findElementById("password");
        confirm=myChromeDriver.findElementById("NextStep");
        formError=myChromeDriver.findElementById("formError");
        javaTools.inputText(myChromeDriver,"",newepassword);
        javaTools.click(confirm);
        System.out.println("新密码为空："+formError.getText());
    }

    //输入新密码为特殊字符
    @Test
    public void testJnewpassword_sp() {
        newepassword=myChromeDriver.findElementById("password");
        confirm=myChromeDriver.findElementById("NextStep");
        formError=myChromeDriver.findElementById("formError");
        javaTools.inputText(myChromeDriver,"$@#^&*?/+_{}|",newepassword);
        javaTools.click(confirm);
        System.out.println("新密码为特殊字符："+formError.getText());
        javaTools.clear(newepassword);
    }

    //输入正确新密码，确认密码为空
    @Test
    public void testKconfirmpassword_null() {
        newepassword=myChromeDriver.findElementById("password");
        confirmpassword=myChromeDriver.findElementById("checkPassword");
        confirm=myChromeDriver.findElementById("NextStep");
        formError=myChromeDriver.findElementById("formError");
        javaTools.inputText(myChromeDriver,"12345678",newepassword);
        javaTools.inputText(myChromeDriver,"",confirmpassword);
        javaTools.click(confirm);
        System.out.println("确认密码为空："+formError.getText());
    }

    //输入确认密码为特殊字符
    @Test
    public void testLconfirmpassword_sp() {
        newepassword=myChromeDriver.findElementById("password");
        confirmpassword=myChromeDriver.findElementById("checkPassword");
        confirm=myChromeDriver.findElementById("NextStep");
        formError=myChromeDriver.findElementById("formError");
        javaTools.inputText(myChromeDriver,"12345678",newepassword);
        javaTools.inputText(myChromeDriver,"$@#^&*?/+_{}|",confirmpassword);
        javaTools.click(confirm);
        System.out.println("确认密码为特殊字符："+formError.getText());
        javaTools.clear(confirmpassword);
    }

    //输入的确认密码和新密码不一致
    @Test
    public void testMconfirmpassword_error() {
        newepassword=myChromeDriver.findElementById("password");
        confirmpassword=myChromeDriver.findElementById("checkPassword");
        confirm=myChromeDriver.findElementById("NextStep");
        formError=myChromeDriver.findElementById("formError");
        javaTools.inputText(myChromeDriver,"12345678",newepassword);
        javaTools.inputText(myChromeDriver,"123456",confirmpassword);
        javaTools.click(confirm);
        System.out.println("新密码和确认密码不一致："+formError.getText());
        javaTools.clear(confirmpassword);
        javaTools.clear(newepassword);
    }

    //输入小于6字符长度的新密码
    @Test
    public void testNconfirmpassword_min() {
        newepassword=myChromeDriver.findElementById("password");
        confirmpassword=myChromeDriver.findElementById("checkPassword");
        confirm=myChromeDriver.findElementById("NextStep");
        formError=myChromeDriver.findElementById("formError");
        javaTools.inputText(myChromeDriver,"123",newepassword);
        javaTools.inputText(myChromeDriver,"123",confirmpassword);
        javaTools.click(confirm);
        System.out.println("密码长度小于6字符："+formError.getText());
        javaTools.clear(confirmpassword);
        javaTools.clear(newepassword);
    }


    //输入正确的新密码和确认密码
    @Test
    public void testOconfirmpassword_right() throws IOException {
        newepassword=myChromeDriver.findElementById("password");
        confirmpassword=myChromeDriver.findElementById("checkPassword");
        confirm=myChromeDriver.findElementById("NextStep");
        formError=myChromeDriver.findElementById("formError");
        javaTools.inputText(myChromeDriver,"12345678",newepassword);
        javaTools.inputText(myChromeDriver,"12345678",confirmpassword);
        //显示密码
        eye1=myChromeDriver.findElementById("togglePassword_customer_new");
        eye2=myChromeDriver.findElementById("togglePassword_customer_repeat");
        javaTools.click(eye1);
        javaTools.click(eye2);
        javaTools.click(confirm);
        javaTools.scrFile(myChromeDriver);
    }


    @AfterClass
    public static void afterClass(){
        driver.disconnect();
    }
}
