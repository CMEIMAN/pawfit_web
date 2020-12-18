package com.latsen.pawfit.testCase;

import com.latsen.pawfit.Const.Const;
import com.latsen.pawfit.common.Driver;
import com.latsen.pawfit.common.NewDriver;
import com.latsen.pawfit.driver.MyChromeDriverSingleton;
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
import java.text.SimpleDateFormat;
import java.util.Calendar;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersonalInformationSaveTestCase {
    private static MyChromeDriverSingleton myChromeDriver;
    private static NewDriver driver;
    private static WebElement emil;
    private static WebElement password;
    private static WebElement login;
    private static WebElement lastname;

    private static WebElement firstname;
    private static WebElement title;
    private static WebElement save;
    private Utils FileUtils;
    private static Select select;
    private static WebElement formError;

    @BeforeClass
    public static void beforeClass() throws IOException {
        System.out.println("已经执行");
        driver = new NewDriver(Const.LOGiN_URL);
        myChromeDriver = driver.connect();
//        登录账号
        emil= myChromeDriver.findElementById("signin_userName");
        password= myChromeDriver.findElementById("signin_password");
        login= myChromeDriver.findElementById("genericLogin-button");
        emil.sendKeys("1790039849@qq.com");
        password.sendKeys("12345678");
        login.click();
    }

    //截图
    public void scrFile(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");  //转换时间格式
        String time = dateFormat.format(Calendar.getInstance().getTime());  //获取当前时间
        String Name = Thread.currentThread().getStackTrace()[2].getMethodName();//获取当前类名
        File srcFile = ((TakesScreenshot)myChromeDriver).getScreenshotAs(OutputType.FILE);  //执行屏幕截取
        FileUtils.copyFile(srcFile, new File("C:\\Users\\Admin\\web_test\\src\\img\\PersonalInformation", Name+"_"+time + ".png"));
    }

    @Test
    public void testAPut() {
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

//    选择title
    @Test
    public void testBTitle() {
        title=myChromeDriver.findElementByXPath("/html/body/div[3]/div/div[2]/div[2]/div/form/div[1]/div/div/select");
        firstname=myChromeDriver.findElementById("firstname");
        lastname=myChromeDriver.findElementById("lastName");
        select = new Select(title);
        select.selectByVisibleText("Miss");
        System.out.println("Title选择Miss.");
    }

//   Firstname为空
    @Test
    public void testCFirstname_null() {
        firstname.clear();
        lastname.clear();
        firstname.sendKeys(" ");
        lastname.sendKeys("Latsen");
    }

//    Firstname输入特殊字符
    @Test
    public void testDFirstname_sp() {
        firstname.clear();
        firstname.sendKeys("@#$%^&*&☀♣%￥……？`△");
    }

//    Firstname输入长字符
    @Test
    public void testEFirstname_max() {
        firstname.clear();
        firstname.sendKeys("pawfitdsf259dsh238dhak28dh84hs83hs83hs83hs3hs");
    }

//    Lastname输入空
    @Test
    public void testFLastname_null() {
        firstname.clear();
        lastname.clear();
        firstname.sendKeys("Pawfit");
        lastname.sendKeys(" ");
        formError=myChromeDriver.findElementById("formError");
        System.out.println("Lastname为空："+formError.getText());
    }

    //    Lastname输入特殊字符
    @Test
    public void testGLastname_sp() {
        lastname.sendKeys("@#$%^&*&☀♣%￥……？`△");
        save=myChromeDriver.findElementById("submitInformation");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",save);
        formError=myChromeDriver.findElementById("formError");
        System.out.println("Lastname为特殊字符："+formError.getText());
        scrFile();
    }

    //    Lastname输入长字符
    @Test
    public void testHFirstname_max() {
        lastname=myChromeDriver.findElementById("lastName");
        lastname.clear();
        lastname.sendKeys("pawfitdsf259dsh238dhak28dh84hs83hs83hs83hs3hs");
        save=myChromeDriver.findElementById("submitInformation");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",save);
        formError=myChromeDriver.findElementById("formError");
        System.out.println("Lastname为特殊字符："+formError.getText());
        scrFile();
    }

    //    Lastname和firstname输入正确字符
    @Test
    public void testIFirstname_right() {
        lastname=myChromeDriver.findElementById("lastName");
        lastname.clear();
        lastname.sendKeys("Latsen");
        save=myChromeDriver.findElementById("submitInformation");
        ((JavascriptExecutor) myChromeDriver).executeScript("arguments[0].click()",save);
        scrFile();
    }


    @AfterClass
    public static void alterClass() {
        driver.disconnect();
    }

}
