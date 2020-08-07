package com.latsen.pawfit.common;

import junit.framework.TestCase;

import java.io.*;
import java.util.Iterator;
import java.util.Properties;

public class TestConfig {
    private String sessionId;
    private Properties properties;
    FileInputStream fileInputStream;
    FileOutputStream  fileOutputStream;
    public TestConfig() throws IOException {
        properties=new Properties();
        fileInputStream=new FileInputStream("src/config.properties");
        fileOutputStream=new FileOutputStream(new File("src/config.properties"),true);
        properties.load(fileInputStream);
    }
    public  String readSessionId(String key) throws IOException {
       sessionId=properties.getProperty(key);
        fileInputStream.close();
       return sessionId;
    }
    public  void writeSessionId(String sessionId) throws IOException {
        properties.setProperty("sessionId",sessionId);
        properties.store(fileOutputStream,"");

    }
    public void close() throws IOException {
        fileInputStream.close();
    }

    public static void main(String[] args) throws IOException {
       TestConfig confit=new TestConfig();
       confit.writeSessionId("sessionId");
    }
}
