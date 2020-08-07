package com.latsen.pawfit.testCase;

import com.latsen.pawfit.Const.Const;
import com.latsen.pawfit.common.Driver;
import com.latsen.pawfit.driver.MyChromeDriver;
import junit.framework.TestCase;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.MalformedURLException;

@org.testng.annotations.Test(groups = "Group")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmailSubscriptionTestCase {
    private static Driver driver;
    private static MyChromeDriver webDriver;
    private static WebElement firstName;
    private static WebElement lastName;
    private static WebElement emial;
    private static WebElement subscribeBtn;
    private static WebElement errorContent;
    private static WebElement backToHomePage;
    private static WebElement subscriptionResult;
    private static String[] strings;

    @BeforeClass
    public static void beforeClass() throws IOException {
        driver=new Driver(Const.BASEURL);
        try {
            webDriver=driver.connect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        firstName=webDriver.findElementById("exampleInputName2");
        lastName=webDriver.findElementById("exampleInputName3");
        emial=webDriver.findElementById("exampleInputEmail2");
        subscribeBtn=webDriver.findElementByXPath("//*[@id=\"mailchimp_subscribe\"]/div/div/div/form/div[8]/button");
        backToHomePage=webDriver.findElementByXPath("/html/body/div[4]/a/button");
        subscriptionResult=webDriver.findElementByXPath("/html/body/div[3]/div/div/p");
    }
    @Test
    public void testACheackFirstName(){
        firstName=webDriver.findElementById("exampleInputName2");
        for(int i=0;i<Const.getCommomText().length;i++){
            firstName.sendKeys(""+Const.getCommomText()[i]);
            lastName.sendKeys(""+Const.getCommomText()[i]);
            emial.sendKeys(""+Const.getEmail()[i]);
            subscribeBtn.click();
            backToHomePage.click();
        }
    }
    @Test
    public void testBCheckLastName(){}
    @Test
    public void testCCheckEmail(){}
    @AfterClass
    public static void afterClass(){
        driver.disconnect();
    }
}
