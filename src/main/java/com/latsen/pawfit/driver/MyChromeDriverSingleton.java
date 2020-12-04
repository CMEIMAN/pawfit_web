package com.latsen.pawfit.driver;

import com.latsen.pawfit.Const.Const;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class MyChromeDriverSingleton extends RemoteWebDriver {
    private static DesiredCapabilities desiredCapabilities=DesiredCapabilities.chrome();
    private static MyChromeDriverSingleton ourInstance ;
    private static URL url;
    static {
        desiredCapabilities.setPlatform(Platform.ANY);
        try {
            url = new URL(Const.HUB_URL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static MyChromeDriverSingleton getInstance()  {
        if(ourInstance==null){
            ourInstance= new MyChromeDriverSingleton();
            return ourInstance;
        }
        else {
            return ourInstance;
        }
    }

    private MyChromeDriverSingleton() {
        super(url,desiredCapabilities);
    }
    @Override
    public void setSessionId(String opaqueKey) {
        super.setSessionId(opaqueKey);
    }
}
