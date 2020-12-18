package com.latsen.pawfit.testCase;

import com.latsen.pawfit.Const.Const;
import com.latsen.pawfit.common.NewDriver;
import com.latsen.pawfit.driver.MyChromeDriverSingleton;
import org.openqa.selenium.Keys;
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
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import com.latsen.pawfit.utils.JavaTools;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ChangePasswordTestCase {
    private static NewDriver driver;
    private static MyChromeDriverSingleton myChromeDriver;
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
    private static WebElement formError;
    private Utils FileUtils;
    private static JavaTools assertion;

    @BeforeClass
    public static void beforeClass() throws IOException {
        System.out.println("已经执行");
        driver = new NewDriver(Const.LOGiN_URL);
        myChromeDriver = driver.connect();
        assertion=new JavaTools();

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

    public void clear(){
        current_password.clear();
        new_password.clear();
        confirm_password.clear();
    }

    @Test
    public void testApassword_put() {
        for(int i=0;i<Const.getCommomText().length;i++) {
            current_password.sendKeys("" + Const.getCommomText()[i]);
            new_password.sendKeys("" + Const.getCommomText()[i]);
            confirm_password.sendKeys("" + Const.getEmail()[i]);
        }
        change_password_btn.click();
    }

//    当前密码输入为null
    @Test
    public void testBCurrentpassword_null() {
        clear();
        current_password.sendKeys("  ");
        new_password.sendKeys("  ");
        confirm_password.sendKeys("  ");
        formError=myChromeDriver.findElementById("formError");
        System.out.println("当前密码输入空："+formError.getText());
        assertion.verifyassert(formError.getText(),"Please provide your current password","当前密码输入空提示错误");
    }

//    当前密码输入小于6字符
    @Test
    public void testCCurrentpassword_min() {
        current_password.sendKeys("123");
        new_password.click();
        formError=myChromeDriver.findElementById("formError");
        System.out.println("当前密码输入小于6字符："+formError.getText());
        assertion.verifyassert(formError.getText(),"Your password should be between 6 and 30 characters in length.","当前密码输入小于6字符提示错误");
        clear();
    }

//    当前密码输入大于30字符
    @Test
    public void testDCurrentpassword_max() {
        current_password.sendKeys("1234658693472546462742734234374935478412132342412");
        new_password.click();
        formError=myChromeDriver.findElementById("formError");
        System.out.println("当前密码输入大于30字符："+formError.getText());
        assertion.verifyassert(formError.getText(),"Please provide a new password","当前密码大于30字符提示错误");
        clear();
    }

//    当前密码输入特殊字符
    @Test
    public void testECurrentpassword_sp() {
        current_password.sendKeys("^@#^$%#^*^&*^(^?>'");
        new_password.click();
        formError=myChromeDriver.findElementById("formError");
        System.out.println("当前密码输入特殊字符："+formError.getText());
        assertion.verifyassert(formError.getText(),"Please provide a new password","当前密码输入特殊字符提示错误");
        clear();
    }

//    当前密码输入错误，新密码和确认密码输入正确
    @Test
    public void testFCurrentpassword_error()throws InterruptedException {
        current_password.sendKeys("12dfjskskf");
        new_password.sendKeys("12345678");
        confirm_password.sendKeys("12345678");
        confirm_password.sendKeys(Keys.ENTER);
        formError=myChromeDriver.findElementById("formError");
        System.out.println("当前密码输入错误："+formError.getText());
        assertion.verifyassert(formError.getText(),"Invalid password","当前密码输入错误提示错误");
    }

//    当前密码输入正确，新密码输入为空
    @Test
    public void testGNewpassword_null() {
        current_password=myChromeDriver.findElementById("currentPassword");
        new_password=myChromeDriver.findElementById("password");
        confirm_password=myChromeDriver.findElementById("checkPassword");
        current_password.click();
        current_password.sendKeys("12345678");
        new_password.sendKeys(" ");
        new_password.sendKeys(Keys.ENTER);
        formError=myChromeDriver.findElementById("formError");
        System.out.println("新密码输入空："+formError.getText());
        assertion.verifyassert(formError.getText(),"Please provide a new password","新密码输入空提示错误" +
                "");
        clear();
    }

//    当前密码输入正确，新密码输入特殊字符
    @Test
    public void testHNewpassword_sp() {
        current_password.sendKeys("12345678");
        new_password.sendKeys("@#￥%……&*？》");
        new_password.sendKeys(Keys.ENTER);
        formError=myChromeDriver.findElementById("formError");
        System.out.println("新密码输入特殊字符："+formError.getText());
        assertion.verifyassert(formError.getText(),"Confirm new password","新密码输入特殊字符提示错误");
        clear();
    }

    //    当前密码输入正确，新密码输入小于6字符
    @Test
    public void testINewpassword_min() {
        current_password.sendKeys("12345678");
        new_password.sendKeys("12");
        new_password.sendKeys(Keys.ENTER);
        formError=myChromeDriver.findElementById("formError");
        System.out.println("新密码输入小于6字符："+formError.getText());
        clear();
    }

    //    当前密码输入正确，新密码输入大于30字符
    @Test
    public void testINewpassword_max() {
        current_password.sendKeys("12345678");
        new_password.sendKeys("1234658693472546462742734234374935478412132342412");
        new_password.sendKeys(Keys.ENTER);
        formError=myChromeDriver.findElementById("formError");
        System.out.println("新密码输入大于30字符："+formError.getText());
        clear();
    }

    //    当前密码输入正确，新密码输入正确，确认密码输入空
    @Test
    public void testIConfirmpassword_null() {
        current_password.sendKeys("12345678");
        new_password.sendKeys("12345678");
        confirm_password.sendKeys("  ");
        confirm_password.sendKeys(Keys.ENTER);
        formError=myChromeDriver.findElementById("formError");
        System.out.println("确认密码输入空："+formError.getText());
        clear();
    }

    //    当前密码输入正确，新密码输入特殊字符
    @Test
    public void testJNewpassword_sp() {
        current_password.sendKeys("12345678");
        new_password.sendKeys("12345678");
        confirm_password.sendKeys("@#￥%……&*？》");
        confirm_password.sendKeys(Keys.ENTER);
        formError=myChromeDriver.findElementById("formError");
        System.out.println("确认密码输入特殊字符："+formError.getText());
        clear();
    }

    //    当前密码输入正确，新密码输入小于6字符
    @Test
    public void testKNewpassword_min() {
        current_password.sendKeys("12345678");
        new_password.sendKeys("12345678");
        confirm_password.sendKeys("12");
        confirm_password.sendKeys(Keys.ENTER);
        formError=myChromeDriver.findElementById("formError");
        System.out.println("确认密码输入小于6字符："+formError.getText());
        clear();
    }

    //    当前密码输入正确，新密码输入大于30字符
    @Test
    public void testLNewpassword_max() {
        current_password.sendKeys("12345678");
        new_password.sendKeys("12345678");
        confirm_password.sendKeys("1234658693472546462742734234374935478412132342412");
        confirm_password.sendKeys(Keys.ENTER);
        formError=myChromeDriver.findElementById("formError");
        System.out.println("确认密码输入大于30字符："+formError.getText());
        clear();
    }

//    输入正确的密码
    @Test
    public void testMpassword_right() {
        eye1=myChromeDriver.findElementById("togglePassword_customer");
        eye2=myChromeDriver.findElementById("togglePassword_customer_new");
        eye3=myChromeDriver.findElementById("togglePassword_customer_repeat");
        current_password.sendKeys("12345678");
        eye1.click();
        new_password.sendKeys("12345678");
        eye2.click();
        confirm_password.sendKeys("12345678");
        eye3.click();
        change_password_btn=myChromeDriver.findElementById("submitChangePassword");
        change_password_btn.click();
       scrFile();
    }

    @AfterClass
    public static void afterClass(){
        driver.disconnect();
    }

}
