package com.latsen.pawfit.testCase;

import com.latsen.pawfit.Const.Const;
import com.latsen.pawfit.common.NewDriver;
import com.latsen.pawfit.driver.MyChromeDriverSingleton;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import java.io.IOException;
import com.latsen.pawfit.utils.JavaTools;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StoryTestCase {
        private static MyChromeDriverSingleton myChromeDriver;
        private static NewDriver driver;
        private static WebElement read1;
        private static WebElement read2;
        private static WebElement read3;
        private static WebElement see_all_story1;
        private static WebElement see_all_story2;
        private static JavaTools javaTools;

    @BeforeClass
    public static void beforeClass() throws IOException {
        System.out.println("已经执行");
        driver = new NewDriver(Const.STORY_URL);
        myChromeDriver = driver.connect();
        javaTools = new JavaTools();
    }
    @Test
    public void testAClick() {
//        点击read the story
            read1=myChromeDriver.findElementByXPath("/html/body/section/div/div/div[1]/div[1]/div[2]/a");
            javaTools.click(read1);
            javaTools.back(myChromeDriver);
            read2=myChromeDriver.findElementByXPath("/html/body/section/div/div/div[1]/div[3]/div[2]/a");
            javaTools.click(read2);
            javaTools.back(myChromeDriver);
            read3=myChromeDriver.findElementByXPath("/html/body/section/div/div/div[2]/div[2]/div[2]/a");
            javaTools.click(read3);
//            点击See all stories
            see_all_story1=myChromeDriver.findElementByLinkText("See all stories");
            javaTools.click(see_all_story1);
            javaTools.back(myChromeDriver);
            see_all_story2=myChromeDriver.findElementByXPath("/html/body/div[4]/div[2]/p[6]/a");
            javaTools.jsclick(myChromeDriver,see_all_story2);
            System.out.println("测试成功！");
    }

    @AfterClass
    public static void alterClass(){
        driver.disconnect();
    }

}
