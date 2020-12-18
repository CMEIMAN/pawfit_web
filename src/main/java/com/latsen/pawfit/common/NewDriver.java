package com.latsen.pawfit.common;

import com.latsen.pawfit.driver.MyChromeDriverSingleton;
import org.openqa.selenium.Dimension;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * 新的启动类，用于代替Driver，维持同一会话，优化多用例执行流程
 */
public class NewDriver {
    private MyChromeDriverSingleton myChromeDriver;
    private String newSessionId;
    private String testUrl;
    public NewDriver(String url){
        this.testUrl=url;
    }

    public MyChromeDriverSingleton getMyChromeDriver() {
        myChromeDriver=MyChromeDriverSingleton.getInstance();
        newSessionId=myChromeDriver.getSessionId().toString();
        return myChromeDriver;
    }

    /**
     * 创建会话，启动网页
     * @return 驱动类
     * @throws IOException
     */
    public MyChromeDriverSingleton connect() throws IOException {
        myChromeDriver=this.getMyChromeDriver();
        try {
            myChromeDriver.get(this.testUrl);

        }
        catch (Exception e){
            System.out.println("出现异常");
        }
        myChromeDriver.manage().window().setSize(new Dimension(1920,1080));
        myChromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return myChromeDriver;
    }

    /**
     * 中断会话
     */
    public void disconnect(){
        myChromeDriver.setSessionId(newSessionId);
        myChromeDriver.quit();
    }

}
