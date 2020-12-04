package com.latsen.pawfit.testCase;

import com.latsen.pawfit.Const.Const;
import com.latsen.pawfit.common.Driver;
import com.latsen.pawfit.driver.MyChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebElement;
import java.io.IOException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ArticlesTestCase {
    private static MyChromeDriver myChromeDriver;
    private static Driver driver;
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

    @BeforeClass
    public static void beforeClass() throws IOException {
        System.out.println("已经执行");
        driver = new Driver(Const.BLOG_URL);
        myChromeDriver = driver.connect();
    }

    @Test
    public void testAClick() {
        try {
//            定位元素，逐个点击articles左边标签
            dog_cat_btn=myChromeDriver.findElementByXPath("/html/body/section/div[1]/div[1]/div/div/dl/dd[2]/a");
            dog_cat_btn.click();
            fitness_btn=myChromeDriver.findElementByXPath("/html/body/section/div[1]/div[1]/div/div/dl/dd[3]/a");
            fitness_btn.click();
            health_btn=myChromeDriver.findElementByXPath("/html/body/section/div[1]/div[1]/div/div/dl/dd[4]/a");
            health_btn.click();
            new_Tech_btn=myChromeDriver.findElementByXPath("/html/body/section/div[1]/div[1]/div/div/dl/dd[5]/a");
            new_Tech_btn.click();
            pawfit_new_btn=myChromeDriver.findElementByXPath("/html/body/section/div[1]/div[1]/div/div/dl/dd[6]/a");
            pawfit_new_btn.click();
            tips_tricks_btn=myChromeDriver.findElementByXPath("/html/body/section/div[1]/div[1]/div/div/dl/dd[7]/a");
            tips_tricks_btn.click();
            all_btn=myChromeDriver.findElementByXPath("/html/body/section/div[1]/div[1]/div/div/dl/dd[1]/a/button");
            all_btn.click();
//            点击read the article
            read1=myChromeDriver.findElementByXPath("/html/body/section/div[1]/div[2]/div[1]/div[2]/a");
            read1.click();
            myChromeDriver.navigate().back();
            read2=myChromeDriver.findElementByXPath("/html/body/section/div[1]/div[2]/div[5]/div[2]/a");
            read2.click();
            myChromeDriver.navigate().back();
//            点击下一页
            next=myChromeDriver.findElementByXPath("/html/body/section/div[2]/nav/ul/li[5]/a");
            next.click();
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
