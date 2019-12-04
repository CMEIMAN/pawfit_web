package com.latsen.pawfit.common;

import com.latsen.pawfit.Const.Const;
import com.latsen.pawfit.driver.MyChromeDriver;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.net.Urls;
import org.openqa.selenium.remote.DesiredCapabilities;
import  org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

    public static ChromeDriver driver=new ChromeDriver();
    public static void connect(){
        driver.get(Const.BASE_URL);
    }
    public static void disconnect(){
        driver.close();
    }
    public static  WebDriver getDriver(){
        return driver;
    }
}
