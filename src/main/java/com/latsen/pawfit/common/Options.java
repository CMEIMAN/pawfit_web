package com.latsen.pawfit.common;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;

public class Options {
    ChromeOptions options;

    public ChromeOptions getOptions(){
        options=new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        options.addArguments("disable-popup-blocking");
        options.addArguments("disable-notifications");
        options.addArguments("disable-infobars");
        options.addArguments("disable-extensions");
        options.addArguments("start-maximized");
        options.addArguments("detach=True");
        return options;
    }
}
