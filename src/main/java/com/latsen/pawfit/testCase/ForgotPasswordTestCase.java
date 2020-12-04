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

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ForgotPasswordTestCase{
    private static Driver driver;
    private static MyChromeDriver myChromeDriver;
    private static WebElement forgot_btn;
    private static WebElement email;
    private static WebElement emailCode;
    private static WebElement send;
    private static WebElement nextStep;
    private Utils FileUtils;

    @BeforeClass
    public static void beforeClass() throws IOException {
        driver = new Driver(Const.LOGiN_URL);
        myChromeDriver = driver.connect();
        System.out.println("已经执行");

        forgot_btn=myChromeDriver.findElementByXPath("/html/body/div[3]/div/div/div[1]/div[2]/form/p[1]/a");
        forgot_btn.click();
        email= myChromeDriver.findElementByXPath("/html/body/div[3]/div/form/div/p[1]/input");
        emailCode=myChromeDriver.findElementById("emailCode");
        send=myChromeDriver.findElementById("getting");
        nextStep=myChromeDriver.findElementById("NextStep");
    }

    //截图
    public void scrFile(){
        long date=System.currentTimeMillis();
        String path = String.valueOf(date);
        String curPath =System.getProperty("C:\\Users\\Admin\\web_test\\src\\img\\forgotpassword");
        path =path+".png";
        String screenPath = curPath+"/"+path;
        File screen = ((TakesScreenshot) myChromeDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screen,new File(screenPath));
    }



    @Test
    public void testAput() {
        nextStep.click();
        scrFile();
        for(int i=0;i<Const.getCommomText().length;i++) {
            email.sendKeys("" + Const.getCommomText()[i]);
            emailCode.sendKeys("" + Const.getCommomText()[i]);
        }
        email.clear();
        emailCode.clear();
    }

    @Test
    public void testBemail() {
//        输入错误email
        email.sendKeys("11111111111");
        send.click();
        scrFile();
        email.clear();
//        输入正确email
        email.sendKeys("1790039849@qq.com");
        send.click();
        scrFile();
//        输入错误验证码
        emailCode.sendKeys("111111111");
        nextStep.click();
        scrFile();
    }

    @AfterClass
    public static void afterClass(){
        driver.disconnect();
    }
}
