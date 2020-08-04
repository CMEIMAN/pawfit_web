package com.latsen.pawfit.common;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDrivesInst {
    public static void main(String[] args) {
        Options options=new Options();
        ChromeDriver driver=new ChromeDriver(options.getOptions());
        driver.get("https://www.pawfit.com/");
    }
}
