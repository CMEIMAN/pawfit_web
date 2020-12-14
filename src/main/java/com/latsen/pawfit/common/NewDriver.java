package com.latsen.pawfit.common;

import com.latsen.pawfit.Const.Const;
import com.latsen.pawfit.driver.MyChromeDriver;
import com.latsen.pawfit.driver.MyChromeDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class NewDriver {
    private DesiredCapabilities desiredCapabilities;
    private String sessionId;
    private String urlStr;
    private MyChromeDriverSingleton myChromeDriver;
    private String newSessionId;
    private String testUrl;
    private TestConfig config;
    public NewDriver(String url){
        this.testUrl=url;
    }

    public MyChromeDriverSingleton getMyChromeDriver() {
        myChromeDriver=MyChromeDriverSingleton.getInstance();
        newSessionId=myChromeDriver.getSessionId().toString();
        return myChromeDriver;
    }


//    public String getSessionId() throws IOException {
//        config=new TestConfig();
//        if(!config.readSessionId("sessionId").equals("test")){
//            sessionId=config.readSessionId("sessionId");
//            return sessionId;
//        }
//        else {
//            sessionId="";
//            try {
//                config.writeSessionId(sessionId);
//                config.close();
//
//            }
//            catch (MalformedURLException e){
//                System.out.println(e);
//            }
//            return sessionId;
//        }
//
//    }

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
        urlStr= Const.HUB_URL;
        return urlStr;
    }
    public MyChromeDriverSingleton connect() throws IOException {
        myChromeDriver=this.getMyChromeDriver();
//        String sessoin=this.getSessionId();
//        myChromeDriver.setSessionId(sessoin);
        try {
            myChromeDriver.get(this.testUrl);

        }
        catch (Exception e){
            System.out.println("出现异常");
        }
        myChromeDriver.manage().window().setSize(new Dimension(1920,1080));
        myChromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return myChromeDriver;
    }


    public void disconnect(){
        myChromeDriver.setSessionId(newSessionId);
        myChromeDriver.quit();
    }

//    public static void main(String[] args) throws MalformedURLException {
//        String sessinId = Const.SESSION_ID;
//        MyChromeDriverSingleton driver =MyChromeDriverSingleton.getInstance();
//        MyChromeDriverSingleton driver1 =MyChromeDriverSingleton.getInstance();
//        String newSessionId = driver.getSessionId().toString();
//        String newSessionId1 = driver1.getSessionId().toString();
//        try {
//            driver.setSessionId(newSessionId1);
//            driver.get("http://www.baidu.com");
//            driver.findElement(By.cssSelector("#kw")).sendKeys("good");
//            driver.findElement(By.cssSelector("#su")).click();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            driver.setSessionId(newSessionId);
//            driver.quit();
//        }
//    }
}
