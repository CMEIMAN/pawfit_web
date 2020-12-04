package com.latsen.pawfit.testCase;

import com.latsen.pawfit.Const.Const;
import com.latsen.pawfit.common.Driver;
import com.latsen.pawfit.driver.MyChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.internal.Utils;
import java.io.File;
import java.io.IOException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersonalInformationSaveTestCase {
    private static MyChromeDriver myChromeDriver;
    private static Driver driver;
    private static WebElement emil;
    private static WebElement password;
    private static WebElement login;
    private static WebElement lastname;
    private static WebElement firstname;
    private static WebElement title;
    private static WebElement save;
    private Utils FileUtils;
    private static Select select;

    @BeforeClass
    public static void beforeClass() throws IOException {
        System.out.println("已经执行");
        driver = new Driver(Const.LOGiN_URL);
        myChromeDriver = driver.connect();
//        登录账号
        emil= myChromeDriver.findElementById("signin_userName");
        password= myChromeDriver.findElementById("signin_password");
        login= myChromeDriver.findElementById("genericLogin-button");
        emil.sendKeys("1790039849@qq.com");
        password.sendKeys("123456");
        login.click();
    }

    //截图
    public void scrFile(){
        long date=System.currentTimeMillis();
        String path = String.valueOf(date);
        String curPath =System.getProperty("user.dir");
        path =path+".png";
        String screenPath = curPath+"/"+path;
        File screen = ((TakesScreenshot) myChromeDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screen,new File(screenPath));
    }

    @Test
    public void testAPut1() {
//        清除原有数据
        firstname=myChromeDriver.findElementById("firstname");
        firstname.clear();
        lastname=myChromeDriver.findElementById("lastName");
        lastname.clear();
//        循环注入数据
        for(int i=0;i<Const.getCommomText().length;i++) {
            firstname=myChromeDriver.findElementById("firstname");
            firstname.sendKeys("" + Const.getCommomText()[i]);
            lastname=myChromeDriver.findElementById("lastName");
            lastname.sendKeys("" + Const.getCommomText()[i]);
        }
    }

    @Test
    public void testBPut2() {
        title=myChromeDriver.findElementByXPath("/html/body/div[3]/div/div[2]/div[2]/div/form/div[1]/div/div/select");
        firstname=myChromeDriver.findElementById("firstname");
        lastname=myChromeDriver.findElementById("lastName");
        save=myChromeDriver.findElementById("submitInformation");

        select = new Select(title);
        select.selectByVisibleText("Miss");
        System.out.println("Title选择Miss.");

        firstname.clear();
        lastname.clear();
        firstname.sendKeys("Latsen");
        lastname.sendKeys("");
//       lastname输入空截图
        scrFile();

        lastname.sendKeys("*&☀♣%￥……？`△");
//       截取输入特殊字符图片
        scrFile();

        lastname.clear();
        lastname.sendKeys("testchen");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",save);
        scrFile();

        System.out.println("测试成功！");
    }

    @AfterClass
    public static void alterClass() {
        driver.disconnect();
    }

}
