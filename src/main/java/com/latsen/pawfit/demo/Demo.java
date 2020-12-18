package com.latsen.pawfit.demo;

import com.latsen.pawfit.Const.Const;
import com.latsen.pawfit.common.NewDriver;
import com.latsen.pawfit.driver.MyChromeDriverSingleton;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Demo {

    @Test
    public void contextLoads() throws InterruptedException, IOException, AWTException {
        NewDriver webdriver = new NewDriver("http://3.8.61.142:8080/product/pawfit2.html");
        MyChromeDriverSingleton driver = webdriver.connect();
//        Object width = driver.executeScript(
//                "return Math.max(document.body.scrollWidth, document.body.offsetWidth, document.documentElement.clientWidth, document.documentElement.scrollWidth, document.documentElement.offsetWidth);");
//        Object height = driver.executeScript(
//                "return Math.max(document.body.scrollHeight, document.body.offsetHeight, document.documentElement.clientHeight, document.documentElement.scrollHeight, document.documentElement.offsetHeight);");
//
//        driver.manage().window().maximize();
        Robot robot=new Robot();
        BufferedImage bi=robot.createScreenCapture(new Rectangle(1900,100));
        ImageIO.write(bi, "jpg", new File("C:/1.jpg"));
//        BufferedImage bi = new AShot()
//                .shootingStrategy(ShootingStrategies.viewportPasting(100))
//                .takeScreenshot(driver).getImage();
//        ImageIO.write(bi, "png", new File("C:/test.png"));
        driver.quit();
    }

}