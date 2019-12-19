package com.latsen.pawfit.common;

import com.latsen.pawfit.Const.Const;
import com.latsen.pawfit.driver.MyChromeDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.print.DocFlavor;
import java.net.MalformedURLException;
import java.net.URL;

public class Driver {
    private DesiredCapabilities desiredCapabilities;
    private String sessionId;
    private String urlStr;
    private MyChromeDriver myChromeDriver;
    private String newSessionId;
    private String testUrl;
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

    public String getSessionId() {
        sessionId= Const.SESSION_ID;
        return sessionId;
    }

    public String getUrlStr() {
        urlStr=Const.HUB_URL;
        return urlStr;
    }
    public MyChromeDriver connect(){
        myChromeDriver=getMyChromeDriver();
        myChromeDriver.setSessionId(getSessionId());
        myChromeDriver.get(this.testUrl);
        return myChromeDriver;
    }


    public void disconnect(){
        myChromeDriver.setSessionId(newSessionId);
        myChromeDriver.quit();
    }
//    @Test
//    public void test(){
//        Demo demo=new Demo();
//        demo.connect();
//        demo.disconnect();
//    }
    @Test
    public void demo() throws MalformedURLException {
        String sessinId = Const.SESSION_ID;
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setPlatform(Platform.ANY);
        String urlStr = "http://localhost:4444/wd/hub";
        MyChromeDriver driver = new MyChromeDriver(new URL(urlStr), cap);
        String newSessionId = driver.getSessionId().toString();
        try {
            driver.setSessionId(sessinId);
            driver.get("http://www.baidu.com");
            driver.findElement(By.cssSelector("#kw")).sendKeys("good");
            driver.findElement(By.cssSelector("#su")).click();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.setSessionId(newSessionId);
            driver.quit();
        }

    }
}
