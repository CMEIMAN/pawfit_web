package com.latsen.pawfit.testCase;

import com.latsen.pawfit.Const.Const;
import com.latsen.pawfit.common.NewDriver;
import com.latsen.pawfit.driver.MyChromeDriverSingleton;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;
import org.testng.internal.Utils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@org.testng.annotations.Test(groups = "Group")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmailSubscriptionTestCase {
    private static NewDriver driver;
    private static MyChromeDriverSingleton webDriver;
    private static WebElement firstName;
    private static WebElement lastName;
    private static WebElement emial;
    private static WebElement subscribeBtn;
    private static WebElement backToHomePage;
    private Utils FileUtils;

    @BeforeClass
    public static void beforeClass() throws IOException {
        driver=new NewDriver(Const.PRODUCT_URL);
        try {
            webDriver=driver.connect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        firstName=webDriver.findElement(By.id("exampleInputName2"));
        lastName=webDriver.findElement(By.id("exampleInputName3"));
        emial=webDriver.findElement(By.id("exampleInputEmail2"));
        subscribeBtn=webDriver.findElementByXPath("/html/body/div[5]/div/div/div/form/div[8]/button");
    }

    //截图
    public void scrFile() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");  //转换时间格式
        String time = dateFormat.format(Calendar.getInstance().getTime());  //获取当前时间
        String Name = Thread.currentThread().getStackTrace()[2].getMethodName();//获取当前类名
        File srcFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);  //执行屏幕截取
        FileUtils.copyFile(srcFile, new File("C:\\Users\\Admin\\web_test\\src\\img\\EmailSubscription", Name+"_"+time + ".png"));
    }

    @Test
    public void testAput_error(){
//        循环注入数据验证
        firstName=webDriver.findElementById("exampleInputName2");
        for(int i=0;i<Const.getCommomText().length;i++){
            firstName.sendKeys(""+Const.getCommomText()[i]);
            lastName.sendKeys(""+Const.getCommomText()[i]);
            emial.sendKeys(""+Const.getEmail()[i]);
        }
    }

//    输入空格
    @Test
    public void testBput_null(){
        //        清除数据
        firstName.clear();
        lastName.clear();
        emial.clear();

        firstName.sendKeys("    ");
        lastName.sendKeys("    ");
        emial.sendKeys("    ");
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click()",subscribeBtn);
        scrFile();
    }

    @Test
    public void testCput()throws InterruptedException{
        firstName=webDriver.findElement(By.id("exampleInputName2"));
        lastName=webDriver.findElement(By.id("exampleInputName3"));
        emial=webDriver.findElement(By.id("exampleInputEmail2"));
        subscribeBtn=webDriver.findElementByXPath("/html/body/div[5]/div/div/div/form/div[8]/button");
//        清除数据
        firstName.clear();
        lastName.clear();
        emial.clear();
//        输入数据
        firstName.sendKeys("chen");
        lastName.sendKeys("test");
        emial.sendKeys("1790039849@qq.com");
//        点击提交
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click()",subscribeBtn);
        Thread.sleep(2000);
        scrFile();
//        点击Go back to Homepage按钮
        backToHomePage=webDriver.findElement(By.xpath("/html/body/div[4]/a"));
        backToHomePage.click();
        scrFile();
    }

    @AfterClass
    public static void afterClass(){
        driver.disconnect();
    }
}
