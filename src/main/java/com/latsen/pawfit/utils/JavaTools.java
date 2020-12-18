package com.latsen.pawfit.utils;
import org.testng.Assert;


public class JavaTools {
    static boolean flog = true;
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

}
