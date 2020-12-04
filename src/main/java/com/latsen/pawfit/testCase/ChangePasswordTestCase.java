package com.latsen.pawfit.testCase;

import com.latsen.pawfit.Const.Const;
import com.latsen.pawfit.common.Driver;
import com.latsen.pawfit.driver.MyChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.internal.Utils;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ChangePasswordTestCase {
    private static Driver driver;
    private static MyChromeDriver myChromeDriver;
    private static WebElement emil;
    private static WebElement login_password;
    private static WebElement login;
    private static WebElement change;
    private static WebElement current_password;
    private static WebElement new_password;
    private static WebElement confirm_password;
    private static WebElement change_password_btn;
    private static WebElement eye1;
    private static WebElement eye2;
    private static WebElement eye3;
    private Utils FileUtils;

    @BeforeClass
    public static void beforeClass() throws IOException {
        System.out.println("已经执行");
        driver = new Driver(Const.LOGiN_URL);
        myChromeDriver = driver.connect();

        emil= myChromeDriver.findElementById("signin_userName");
        login_password= myChromeDriver.findElementById("signin_password");
        login= myChromeDriver.findElementById("genericLogin-button");
        emil.sendKeys("1790039849@qq.com");
        login_password.sendKeys("12345678");
        login.click();
        change=myChromeDriver.findElementByXPath("/html/body/div[3]/div/div[2]/div[1]/ul/li[3]");
        change.click();
        current_password=myChromeDriver.findElementById("currentPassword");
        new_password=myChromeDriver.findElementById("password");
        confirm_password=myChromeDriver.findElementById("checkPassword");
        change_password_btn=myChromeDriver.findElementById("submitChangePassword");
        eye1=myChromeDriver.findElementById("togglePassword_customer");
        eye2=myChromeDriver.findElementById("togglePassword_customer_new");
        eye3=myChromeDriver.findElementById("togglePassword_customer_repeat");
    }

    //截图
    public void scrFile(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");  //转换时间格式
        String time = dateFormat.format(Calendar.getInstance().getTime());  //获取当前时间
        String Name = Thread.currentThread().getStackTrace()[2].getMethodName();//获取当前类名
        File srcFile = ((TakesScreenshot)myChromeDriver).getScreenshotAs(OutputType.FILE);  //执行屏幕截取
        FileUtils.copyFile(srcFile, new File("C:\\Users\\Admin\\web_test\\src\\img\\ChangePassword", Name+"_"+time + ".png"));
    }

    @Test
    public void testApassword_error() {
        for(int i=0;i<Const.getCommomText().length;i++) {
            current_password.sendKeys("" + Const.getCommomText()[i]);
            new_password.sendKeys("" + Const.getCommomText()[i]);
            confirm_password.sendKeys("" + Const.getEmail()[i]);
        }
        change_password_btn.click();
    }

    @Test
    public void testBpassword_right() {
       current_password.clear();
       new_password.clear();
       confirm_password.clear();
       current_password.sendKeys("12345678");
       eye1.click();
       new_password.sendKeys("12345678");
       eye2.click();
       confirm_password.sendKeys("12345678");
       eye3.click();
       change_password_btn.click();
       scrFile();
    }

    @AfterClass
    public static void afterClass(){
        driver.disconnect();
    }

}
