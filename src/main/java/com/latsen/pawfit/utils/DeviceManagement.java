package com.latsen.pawfit.utils;

import net.bytebuddy.implementation.bytecode.Throw;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.util.ArrayList;

public class DeviceManagement {
    CloseableHttpClient httpclient;
    HttpGet httpGet;
    CloseableHttpResponse closeableHttpResponse;
    FileInputStream fileInputStream;
    InputStreamReader inputStreamReader;
    BufferedReader bufferedReader;
    ArrayList<String> arrayList;
    HttpEntity entity;

    public DeviceManagement() {
        httpclient = HttpClients.custom()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setCookieSpec(CookieSpecs.STANDARD).build())
                .build();
    }
    /*
    * 获取设别Device ID列表
    * */

    public ArrayList<String> getDeviceIdFromTXT(String path) throws IOException {
        fileInputStream = new FileInputStream(path);
        inputStreamReader = new InputStreamReader(fileInputStream);
        FileReader fileReader = new FileReader(path);
        bufferedReader = new BufferedReader(fileReader);
        arrayList = new ArrayList<String>();
        String s;
        while ((s = bufferedReader.readLine()) != null) {
            arrayList.add(s);
        }
        bufferedReader.close();
        inputStreamReader.close();
        fileInputStream.close();
        return arrayList;

    }
    /*
    * 网络请求库
    * */
    public String sendRequest(String url) throws IOException {
        httpGet = new HttpGet(url);
        String result = "";
        try {

            closeableHttpResponse = httpclient.execute(httpGet);
            if (closeableHttpResponse.getStatusLine().getStatusCode() == 200) {
                entity = closeableHttpResponse.getEntity();
                result = EntityUtils.toString(entity);
                return result;

            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("请求失败:" + url);
        } finally {
            return result;
        }
    }

    public void closeRequest() throws IOException {
        this.closeableHttpResponse.close();
    }

    public static void main(String[] args) throws IOException {
        DeviceManagement management = new DeviceManagement();
        ArrayList<String> list = management.getDeviceIdFromTXT("src/main/resources/txt/deviceIds.txt");

        for(String s:list){
            System.out.println(s+"---"+management.sendRequest("https://api.pawfit.cn:9000/api/v1/gettrackertype/1/1/1/6060?identity="+s));
        }
        management.closeRequest();
    }


}
