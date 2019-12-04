package com.latsen.pawfit.driver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class MyChromeDriver extends RemoteWebDriver {
    public MyChromeDriver(URL url, DesiredCapabilities cap) {
        super(url, cap);
    }

    @Override
    public void setSessionId(String opaqueKey) {
        super.setSessionId(opaqueKey);
    }

}
