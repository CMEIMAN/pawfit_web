package com.latsen.pawfit.testCase;

import com.latsen.pawfit.Const.Const;
import com.latsen.pawfit.common.NewDriver;
import com.latsen.pawfit.driver.MyChromeDriverSingleton;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.io.IOException;
import com.latsen.pawfit.utils.JavaTools;

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
    private static Select select;
    private static WebElement formError;
    private static JavaTools javaTools;

    @BeforeClass
    public static void beforeClass() throws IOException {
        System.out.println("已经执行");
        driver = new NewDriver(Const.LOGiN_URL);
        myChromeDriver = driver.connect();
        javaTools = new JavaTools();
//        登录账号
        emil= myChromeDriver.findElementById("signin_userName");
        password= myChromeDriver.findElementById("signin_password");
        login= myChromeDriver.findElementById("genericLogin-button");
        javaTools.inputText(myChromeDriver,"1790039849@qq.com",emil);
        javaTools.inputText(myChromeDriver,"12345678",password);
        javaTools.click(login);
    }

    @Test
    public void testAPut() {
//        清除原有数据
        firstname=myChromeDriver.findElementById("firstname");
        javaTools.clear(firstname);
        lastname=myChromeDriver.findElementById("lastName");
        javaTools.clear(lastname);
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
        javaTools.clear(firstname);
        javaTools.clear(lastname);
        javaTools.inputText(myChromeDriver,"  ",firstname);
        javaTools.inputText(myChromeDriver,"Latsen",lastname);
    }

//    Firstname输入特殊字符
    @Test
    public void testDFirstname_sp() {
        javaTools.clear(firstname);
        javaTools.inputText(myChromeDriver,"@#$%^&*&☀♣%￥……？`△",firstname);
    }

//    Firstname输入长字符
    @Test
    public void testEFirstname_max() {
        javaTools.clear(firstname);
        javaTools.inputText(myChromeDriver,"pawfitdsf259dsh238dhak28dh84hs83hs83hs83hs3hs",firstname);
    }

//    Lastname输入空
    @Test
    public void testFLastname_null() {
        javaTools.clear(firstname);
        javaTools.clear(lastname);
        javaTools.inputText(myChromeDriver,"Pawfit",firstname);
        javaTools.inputText(myChromeDriver," ",lastname);
        formError=myChromeDriver.findElementById("formError");
        System.out.println("Lastname为空："+formError.getText());
    }

    //    Lastname输入特殊字符
    @Test
    public void testGLastname_sp() throws IOException {
        javaTools.inputText(myChromeDriver,"@#$%^&*&☀♣%￥……？`△",lastname);
        save=myChromeDriver.findElementById("submitInformation");
        javaTools.jsclick(myChromeDriver,save);
        formError=myChromeDriver.findElementById("formError");
        System.out.println("Lastname为特殊字符："+formError.getText());
        javaTools.scrFile(myChromeDriver);
    }

    //    Lastname输入长字符
    @Test
    public void testHFirstname_max() throws IOException {
        lastname=myChromeDriver.findElementById("lastName");
        javaTools.clear(lastname);
        javaTools.inputText(myChromeDriver,"pawfitdsf259dsh238dhak28dh84hs83hs83hs83hs3hs",lastname);
        save=myChromeDriver.findElementById("submitInformation");
        javaTools.jsclick(myChromeDriver,save);
        formError=myChromeDriver.findElementById("formError");
        System.out.println("Lastname为特殊字符："+formError.getText());
        javaTools.scrFile(myChromeDriver);
    }

    //    Lastname和firstname输入正确字符
    @Test
    public void testIFirstname_right() throws IOException {
        lastname=myChromeDriver.findElementById("lastName");
        javaTools.clear(lastname);
        javaTools.inputText(myChromeDriver,"Latsen",lastname);
        save=myChromeDriver.findElementById("submitInformation");
        javaTools.jsclick(myChromeDriver,save);
        javaTools.scrFile(myChromeDriver);
    }


    @AfterClass
    public static void alterClass() {
        driver.disconnect();
    }

}
