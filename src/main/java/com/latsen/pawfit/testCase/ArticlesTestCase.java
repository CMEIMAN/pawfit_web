package com.latsen.pawfit.testCase;

import com.latsen.pawfit.Const.Const;
import com.latsen.pawfit.common.NewDriver;
import com.latsen.pawfit.driver.MyChromeDriverSingleton;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebElement;
import java.io.IOException;
import com.latsen.pawfit.utils.JavaTools;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ArticlesTestCase {
    private static MyChromeDriverSingleton myChromeDriver;
    private static NewDriver driver;
    private static WebElement dog_cat_btn;
    private static WebElement fitness_btn;
    private static WebElement health_btn;
    private static WebElement new_Tech_btn;
    private static WebElement pawfit_new_btn;
    private static WebElement tips_tricks_btn;
    private static WebElement all_btn;
    private static WebElement read1;
    private static WebElement read2;
    private static WebElement next;
    private static JavaTools javaTools;

    @BeforeClass
    public static void beforeClass() throws IOException {
        javaTools = new JavaTools();
        System.out.println("已经执行");
        driver = new NewDriver(Const.BLOG_URL);
        myChromeDriver = driver.connect();
    }

    @Test
    public void testAClick() {
        try {
//            定位元素，逐个点击articles左边标签
            dog_cat_btn=myChromeDriver.findElementByXPath("/html/body/section/div[1]/div[1]/div/div/dl/dd[2]/a");
            javaTools.click(dog_cat_btn);
            fitness_btn=myChromeDriver.findElementByXPath("/html/body/section/div[1]/div[1]/div/div/dl/dd[3]/a");
            javaTools.click(fitness_btn);
            health_btn=myChromeDriver.findElementByXPath("/html/body/section/div[1]/div[1]/div/div/dl/dd[4]/a");
            javaTools.click(health_btn);
            new_Tech_btn=myChromeDriver.findElementByXPath("/html/body/section/div[1]/div[1]/div/div/dl/dd[5]/a");
            javaTools.click(new_Tech_btn);
            pawfit_new_btn=myChromeDriver.findElementByXPath("/html/body/section/div[1]/div[1]/div/div/dl/dd[6]/a");
            javaTools.click(pawfit_new_btn);
            tips_tricks_btn=myChromeDriver.findElementByXPath("/html/body/section/div[1]/div[1]/div/div/dl/dd[7]/a");
            javaTools.click(tips_tricks_btn);
            all_btn=myChromeDriver.findElementByXPath("/html/body/section/div[1]/div[1]/div/div/dl/dd[1]/a/button");
            javaTools.click(all_btn);
//            点击read the article
            read1=myChromeDriver.findElementByXPath("/html/body/section/div[1]/div[2]/div[1]/div[2]/a");
            javaTools.click(read1);
            javaTools.back(myChromeDriver);
            read2=myChromeDriver.findElementByXPath("/html/body/section/div[1]/div[2]/div[5]/div[2]/a");
            javaTools.click(read2);
            javaTools.back(myChromeDriver);
//            点击下一页
            next=myChromeDriver.findElementByXPath("/html/body/section/div[2]/nav/ul/li[5]/a");
            javaTools.click(next);
            System.out.println("测试完成！");
        }catch (Exception e){
            System.out.println("测试失败！");
        }

    }

    @AfterClass
    public static void alterClass(){
        driver.disconnect();
    }
}
