package com.latsen.pawfit.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import com.latsen.pawfit.driver.MyChromeDriverSingleton;
import com.latsen.pawfit.common.NewDriver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;


public class JavaTools {
    static boolean flog = true;
    private static WebDriver driver;

    public static boolean currentFlog() {
        return flog;
    }

    /*
     * 封装断言
     */
    public static void setFlag(boolean flog) {
        JavaTools.flog = flog;
    }
    public void verifyassert(Object actual, Object expected) {
        try {
            Assert.assertEquals(actual, expected);
        } catch (Error e) {
            // TODO: handle exception
            e.printStackTrace();
            //抛出异常时记录flog=false;
            setFlag(false);
        }
    }

    public void verifyassert(Object actual, Object expected, String message) {
        try {
            Assert.assertEquals(actual, expected, message);
        } catch (Error e) {
            // TODO: handle exception
            //仅仅代表异常消息的输出
            e.printStackTrace();
            //抛出异常时记录flog=false
            setFlag(false);
        }
    }

    //截图
    public void scrFile(WebDriver driver) throws IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");  //转换时间格式
        String time = dateFormat.format(Calendar.getInstance().getTime());  //获取当前时间
        String Name1 = Thread.currentThread().getStackTrace()[2].getClassName();//获取当前class名
        String Name2 = Thread.currentThread().getStackTrace()[2].getMethodName();//获取当前方法名
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  //执行屏幕截取
        File file=new File("C:\\Users\\Admin\\web_test\\src\\img\\"+Name1);
        if(!file.exists()){//如果文件夹不存在
            file.mkdir();//创建文件夹
        }
        else
            System.out.print("已存在该文件夹！");

        FileUtils.copyFile(srcFile, new File(file, Name1+"_"+Name2+"_"+time + ".png"));
    }

    //通过js点击
    public void jsclick(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    //点击
    public void click(WebElement element) {
        element.click();
    }

    //js输入文本
    public void inputText(WebDriver driver,String text, WebElement element) {
        element.sendKeys(text);
    }

    //js清空文本
    public void clear(WebElement element) {
        element.clear();
    }

    //滚动到最上方
    public void scrollToTop() {
                ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,0);");
        //        JavascriptExecutor js = (JavascriptExecutor) driver;
        //        js.executeScript("window.scrollTo(0,0);");
            }


    //生成随机数字和字母
    public String getStringRandom(int length) {
        String val = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(10) % 2 == 0 ? "char" : "num";
            if ("char".equals(charOrNum)) {
                int temp = random.nextInt(10) % 2 == 0 ? 65 : 97;
                val += (char) (random.nextInt(26) + temp);
            } else if ("num".equals(charOrNum)) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

    //显示等待多少秒
    public void sleep(long seconds) {
        try {
            Thread.sleep(seconds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    }
