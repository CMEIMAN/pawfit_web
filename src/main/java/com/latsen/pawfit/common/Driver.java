package com.latsen.pawfit.common;

import com.latsen.pawfit.Const.Const;
import com.latsen.pawfit.driver.MyChromeDriver;
import com.latsen.pawfit.utils.Tools;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.print.DocFlavor;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {
    private DesiredCapabilities desiredCapabilities;
    private String sessionId;
    private String urlStr;
    private MyChromeDriver myChromeDriver;
    private String newSessionId;
    private String testUrl;
    private TestConfig config;
    public Driver(String url){
        this.testUrl=url;
    }

    public MyChromeDriver getMyChromeDriver() {
        try {
            myChromeDriver=new MyChromeDriver(new URL(getUrlStr()),getDesiredCapabilities());
            newSessionId=myChromeDriver.getSessionId().toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return myChromeDriver;
    }

    public DesiredCapabilities getDesiredCapabilities() {
        desiredCapabilities=DesiredCapabilities.chrome();
        desiredCapabilities.setPlatform(Platform.ANY);
        return desiredCapabilities;
    }

    public String getSessionId() throws IOException {
        config=new TestConfig();
        if(!config.readSessionId("sessionId").equals("test")){
            sessionId=config.readSessionId("sessionId");
            return sessionId;
        }
        else {
            DesiredCapabilities cap = DesiredCapabilities.chrome();
            String urlStr = "http://localhost:4444/wd/hub";
            sessionId="";
            try {
                MyChromeDriver driver = new MyChromeDriver(new URL(urlStr), cap);
                sessionId = driver.getSessionId().toString();
                config.writeSessionId(sessionId);
                config.close();

            }
            catch (MalformedURLException e){
                System.out.println(e);
            }
            return sessionId;
        }

    }

    public String getUrlStr() {
        urlStr=Const.HUB_URL;
        return urlStr;
    }
    public MyChromeDriver connect() throws IOException {
        myChromeDriver=getMyChromeDriver();
        myChromeDriver.setSessionId(getSessionId());
        try {
            myChromeDriver.get(this.testUrl);

        }
        catch (Exception e){
            System.out.println(e.getCause());
        }
        myChromeDriver.manage().window().setSize(new Dimension(1920,1080));
        myChromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return myChromeDriver;
    }


    public void disconnect(){
        myChromeDriver.setSessionId(newSessionId);
        myChromeDriver.quit();
    }

    public static void main(String[] args) throws MalformedURLException {
        String sessinId = Const.SESSION_ID;
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setPlatform(Platform.ANY);
        String urlStr = "http://localhost:4444/wd/hub";
        MyChromeDriver driver =new MyChromeDriver(new URL(urlStr), cap);
        MyChromeDriver driver1 =new MyChromeDriver(new URL(urlStr), cap);
        String newSessionId = driver.getSessionId().toString();
        String newSessionId1 = driver1.getSessionId().toString();
        try {
            driver.setSessionId(newSessionId1);
            driver.get("https://www.baidu.com/");
            Boolean exists=Tools.checkElementExistsById(driver,"kdkdkdkdkdkekd",30);
            System.out.println(exists);

//            driver.findElement(By.cssSelector("#kw")).sendKeys("good");
//            driver.findElement(By.cssSelector("#su")).click();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.setSessionId(newSessionId);
            driver.quit();
        }
    }
}
