package com.latsen.pawfit.testCase;

import com.latsen.pawfit.Const.Const;
import com.latsen.pawfit.common.NewDriver;
import com.latsen.pawfit.driver.MyChromeDriverSingleton;
import com.latsen.pawfit.utils.JavaTools;
import com.latsen.pawfit.utils.Tools;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.internal.Utils;

import java.io.IOException;
import java.util.HashMap;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Shopping_Process_guestTestcase {
    private static MyChromeDriverSingleton myChromeDriver;
    private static NewDriver driver;
    private static JavaTools javaTools;
    private static WebElement pawfit2_add;
    private static WebElement checkout;
    private static WebElement guest;
    private static WebElement guest_email;
    private static WebElement guest_submit;
    private Utils FileUtils;
    private static WebElement firstName;
    private static WebElement lastName;
    private static WebElement company;
    private static WebElement address;
    private static WebElement city;
    private static WebElement country;
    private static WebElement province;
    private static WebElement postalCode;
    private static WebElement phoneNumber;
    private static WebElement submitOrder;
    private static WebElement checkboxOfOrderNote;
    private static HashMap<WebElement,String> webElements;
    private static Select countrySelect;
    private static WebElement change_address1;
    private static WebElement change_address2;
    private static WebElement edit1;
    private static WebElement edit2;
    private static WebElement giftCode;
    private static WebElement apply;
    private static WebElement submitOrder1;
    private static WebElement confirm;



    @BeforeClass
    public static void beforeClass() throws IOException {
        System.out.println("已经执行");
        driver = new NewDriver(Const.PRODUCT_URL);
        myChromeDriver = driver.connect();
        javaTools = new JavaTools();
        webElements=new HashMap<WebElement, String>();
        pawfit2_add=myChromeDriver.findElementByXPath("/html/body/section[1]/div/div[1]/div[1]/div/div/div[3]/div[3]/a[2]/button");

    }

    @Test
    public void testAClick() throws IOException {
//        添加pawfit2加入购物车
        pawfit2_add.click();
        //        点击购物车跳转购物车页面
        Actions action=new Actions(myChromeDriver);
        action.moveToElement(myChromeDriver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div/div[1]/button"))).perform();
        myChromeDriver.findElementByClassName("checkout-bg").click();
        //        点击跳转checkout页面
        checkout=myChromeDriver.findElementByClassName("check-btn-div");
        javaTools.click(checkout);
    }

    @Test
    public void testBGUEST (){
        guest=myChromeDriver.findElementByCssSelector("body > div.login-area.ptb-80 > div > div > div > div.container.login-bottom-container > div.login-button-father > a");
        javaTools.click(guest);

        for(int i=0;i<Const.getCommomText().length;i++){
//            注入SQL
            guest_email=myChromeDriver.findElementById("email");
            guest_email.sendKeys(""+Const.getSQlText()[i]);
            javaTools.clear(guest_email);
            guest_submit=myChromeDriver.findElementById("emailSubmit");
            javaTools.click(guest_submit);

//            注入其他文本
            guest_email=myChromeDriver.findElementById("email");
            guest_email.sendKeys(""+Const.getCommomText()[i]);
            javaTools.clear(guest_email);
            guest_submit=myChromeDriver.findElementById("emailSubmit");
            javaTools.click(guest_submit);
        }
    }
@Test
    public void testCGUEST_null (){
//        输入空
        guest_email=myChromeDriver.findElementById("email");
        guest_email.sendKeys(" ");
        guest_submit=myChromeDriver.findElementById("emailSubmit");
        javaTools.click(guest_submit);

//        输入已存在邮箱
        guest_email=myChromeDriver.findElementById("email");
        guest_email.sendKeys("1790039849@qq.com");
        guest_submit=myChromeDriver.findElementById("emailSubmit");
        javaTools.jsclick(myChromeDriver,guest_submit);
    }

    @Test
    public void testDGUEST_right(){
//        输入正确游客邮箱
        guest_email=myChromeDriver.findElementById("email");
        javaTools.clear(guest_email);
        guest_email.sendKeys("110@qq.com");
        guest_submit=myChromeDriver.findElementById("emailSubmit");
        javaTools.jsclick(myChromeDriver,guest_submit);
    }

    @Test//      定位元素

    public void testEcheckFitstName() throws IOException {
        /*长度判断*/
        firstName=myChromeDriver.findElement(By.id("firstName"));
        submitOrder=myChromeDriver.findElementById("submit");
        Tools.setAllText(firstName,submitOrder, Tools.getUUIDText());
//        scrFile();
        /*SQL注入*/
        injectSQLs(firstName);
        webElements.put(firstName,"pawfit");
    }

    @Test
    public void testFcheckLastName() throws IOException {
        lastName=myChromeDriver.findElement(By.id("lastName"));
        submitOrder=myChromeDriver.findElementById("submit");
        Tools.setAllText(lastName,submitOrder,Tools.getUUIDText());
//        scrFile();
        injectSQLs(lastName);
        webElements.put(lastName,"latsen");
    }

    @Test
    public void testGcheckCountry() {
        country=myChromeDriver.findElement(By.id("country"));
        countrySelect=new Select(country);
        countrySelect.selectByVisibleText("United Kingdom");
//        countrySelect.selectByVisibleText("United States");
        submitOrder=myChromeDriver.findElementById("submit");
        javaTools.click(submitOrder);
    }


    @Test
    public void testHcheckProvince() throws IOException {
        province=myChromeDriver.findElement(By.id("state"));
        submitOrder=myChromeDriver.findElementById("submit");
        Tools.setAllText(province,submitOrder,Tools.getUUIDText());
        injectSQLs(province);
        webElements.put(province,"广东省");
    }


    @Test
    public void testIcheakCity() throws IOException {
        city=myChromeDriver.findElement(By.id("city"));
        submitOrder=myChromeDriver.findElementById("submit");
        Tools.setAllText(city,submitOrder,Tools.getUUIDText());
        injectSQLs(city);
        webElements.put(city,"佛山");
    }

    @Test
    public void testJcheckPostalCode() throws IOException {
        postalCode=myChromeDriver.findElement(By.id("postcode"));
        submitOrder=myChromeDriver.findElementById("submit");
        Tools.setAllText(postalCode,submitOrder,Tools.getUUIDText());
        injectSQLs(postalCode);webElements.put(postalCode,"M2 5BQ");
//        injectSQLs(postalCode);webElements.put(postalCode,"12345");
    }

    @Test
    public void testKcheakAddress() throws IOException {
        address=myChromeDriver.findElement(By.id("address"));
        submitOrder=myChromeDriver.findElementById("submit");
        Tools.setAllText(address,submitOrder,Tools.getUUIDText());
        injectSQLs(address);
        webElements.put(address,"中国广东顺德大良");
    }

    @Test
    public void testLcompany() throws IOException {
        company=myChromeDriver.findElement(By.id("company"));
        submitOrder=myChromeDriver.findElementById("submit");
        Tools.setAllText(company,submitOrder,Tools.getUUIDText());
//        scrFile();
        injectSQLs(company);
        webElements.put(company,"广东顺德雷舜信息科技有限公司");
    }

    @Test
    public void testMcheckPhoneNumber() throws IOException {
        phoneNumber=myChromeDriver.findElement(By.id("phone"));
        submitOrder=myChromeDriver.findElementById("submit");
        Tools.setAllText(phoneNumber,submitOrder,Tools.getUUIDText());
        injectSQLs(phoneNumber);
        webElements.put(phoneNumber,"19197032890");
    }

    @Test
    public void testNcheckCheckboxOfOrderNote() throws IOException {
        checkboxOfOrderNote=myChromeDriver.findElementById("comments");
        submitOrder=myChromeDriver.findElementById("submit");
        Tools.setAllText(checkboxOfOrderNote,submitOrder,Tools.getUUIDText());
        injectSQLs(checkboxOfOrderNote);
        webElements.put(checkboxOfOrderNote,"12345678");
    }

    @Test
    public void testOcheackSubmitOrder() {
        Tools.clearText(webElements);
        Tools.setText(webElements);
        submitOrder=myChromeDriver.findElementById("submit");
        javaTools.click(submitOrder);
//        javaTools.back(driver);
    }

    @Test
    public void testPChang_address(){
//        点击change address按钮并返回
        change_address1=myChromeDriver.findElementByXPath("/html/body/form/div/div/div[1]/div[3]/a");
        javaTools.click(change_address1);
        submitOrder=myChromeDriver.findElementById("submit");
        javaTools.click(submitOrder);

//        点击编辑购物车
        edit2=myChromeDriver.findElementById("editCart");
        javaTools.click(edit2);
        checkout=myChromeDriver.findElementByClassName("check-btn-div");
        javaTools.click(checkout);
        submitOrder=myChromeDriver.findElementById("submit");
        javaTools.click(submitOrder);
    }

    @Test
    public void testQReferral_Code(){
        javaTools.sleep(2000);
        for(int i=0;i<Const.getCommomText().length;i++) {
//            注入SQL
            giftCode=myChromeDriver.findElementById("giftCode");
            giftCode.sendKeys("" + Const.getSQlText()[i]);
            javaTools.clear(giftCode);
            apply=myChromeDriver.findElementByXPath("/html/body/form/div/div/div[1]/div[4]/div/div[1]/span");
            javaTools.click(apply);
        }
        giftCode=myChromeDriver.findElementById("giftCode");
        giftCode.sendKeys("R6AWZR");
        apply=myChromeDriver.findElementByXPath("/html/body/form/div/div/div[1]/div[4]/div/div[1]/span");
        javaTools.click(apply);

        javaTools.sleep(2000);
        submitOrder1=myChromeDriver.findElementById("submit");
        javaTools.click(submitOrder1);
    }

    @Test
    public void testRSubmitOrder(){
        javaTools.sleep(2000);
        change_address2=myChromeDriver.findElementByCssSelector("body > div.shopping > div.orderBtn > div.row.hidden-xs > div:nth-child(2) > div");
        javaTools.click(change_address2);

        submitOrder=myChromeDriver.findElementById("submit");
        javaTools.click(submitOrder);
        submitOrder1=myChromeDriver.findElementById("submit");
        javaTools.click(submitOrder1);

        confirm=myChromeDriver.findElementByCssSelector("body > div.shopping > div.orderBtn > div.row.hidden-xs > div:nth-child(3) > div");
        javaTools.click(confirm);

    }

    public void injectSQLs(WebElement element) throws IOException {
        String[] strings={
                "and ascii(substr((select database()),1,1))>64",
                "id=1 union select if(SUBSTRING(user(),1,4)='root',sleep(4),1),null,null",
                "id =-1 union select 1,2,3","id=1' substr(database(),1,1)='t'--+",
                "union select count(*),2,concat(':',(select database()),':',floor(rand()*2))as a from information_schema.tables group by a",
                "id=1 and (extractvalue(1,concat(0x7e,(select user()),0x7e)))"};
        for (int i=0;i< strings.length;i++){
            if (i>strings.length-2){
                element.sendKeys(strings[i]);
//                javaTools.scrFile(driver);
                submitOrder=myChromeDriver.findElementById("submit");
                javaTools.click(submitOrder);
            }
            else {
                element.sendKeys(strings[i]);
                submitOrder=myChromeDriver.findElementById("submit");
                javaTools.click(submitOrder);
                element.clear();
            }

        }

    }

    @AfterClass
    public static void alterClass() {
        driver.disconnect();
    }

}

