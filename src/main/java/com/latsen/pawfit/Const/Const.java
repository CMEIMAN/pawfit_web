package com.latsen.pawfit.Const;

import java.util.ArrayList;

public class Const {
    public final static String BASEURL="https://www.pawfit.com/";
    public final static String HUB_URL="http://localhost:4444/wd/hub";
    public final static String SESSION_ID="a08858b1-00cc-492f-9d65-725a6f743842";
    public final static String LOGiN_URL=BASEURL+"customer-account/customer-logon.html";
    public final static String REGISTER_RUL="customer-account/registration.html";
    public final static String PRODUCT_URL="http://ec2-3-9-114-57.eu-west-2.compute.amazonaws.com/shop/product/product.html";
    public final static String HOME_URL="http://3.8.61.142:8080/";
    public final static String PAYPAL_URL="shopping-order/checkout.html";
    public final static String ABOUT_URL="http://ec2-3-9-114-57.eu-west-2.compute.amazonaws.com/shop/product/about.html";
    public final static String SUPPORT_URL="http://ec2-3-9-114-57.eu-west-2.compute.amazonaws.com/shop/product/suport.html";
    public final static String NEWANDEVENTS_URL="http://ec2-3-9-114-57.eu-west-2.compute.amazonaws.com/shop/product/news.html";
    public final static String SHOPPINGCART_URL="http://ec2-3-9-114-57.eu-west-2.compute.amazonaws.com/shop/cart/shoppingCart.html";
    public final static String PAWFIT_COLLAR_URL="http://ec2-3-9-114-57.eu-west-2.compute.amazonaws.com/shop/product/Pawfit%20Collar.html";
    public final static String[] getSQlText(){
        String[] strings={"and ascii(substr((select database()),1,1))>64", "id=1 union select if(SUBSTRING(user(),1,4)='root',sleep(4),1),null,null", "id =-1 union select 1,2,3", "id=1' substr(database(),1,1)='t'--+", "union select count(*),2,concat(':',(select database()),':',floor(rand()*2))as a from information_schema.tables group by a", "id=1 and (extractvalue(1,concat(0x7e,(select user()),0x7e)))"};
        return strings;

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
