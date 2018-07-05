package org.naic.mfl.se.challenge;

import org.naic.mfl.se.org.naic.mfl.se.pageobject.AutomationPage;
import org.naic.mfl.se.org.naic.mfl.se.pageobject.WebDriverManager;
import org.naic.mfl.se.utils.Util;
import org.naic.mfl.se.utils.WebContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class WebTest {

    public WebDriver driver = WebDriverManager.getDriver();
    private AutomationPage automationPage = new AutomationPage(driver);

    @BeforeSuite
    @Parameters({"url"})
    public void setUp(String url){
        System.out.println("Inside 0");
        automationPage.fireUrl(url);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    }

    @Test(priority = 2)
    @Parameters({"emailId","firstName","lastName","password","day","month","year","company","address1","address2","city","state","postalCode","others","phone","mobile","alias","country"})
    public void signInTest(String emailId, String firstName,String lastName,String password,String day,String month,String year, String company,String address1,String address2,String city,String state,String postalCode,String others,String phone,String mobile, String alias,String country){
        if (automationPage == null){
            automationPage = new AutomationPage(WebDriverManager.getDriver());
        }
        automationPage.clickSignIn();
        String userMailid = emailId+ Util.getCurrentTime()+"@gmail.com";
        automationPage.enterEmail(userMailid);
        WebContext.setValue("userMailid",userMailid);
        automationPage.clickSignIn();
        Map<String,String> userDetails = new HashMap<String, String>();
        userDetails.put("firstName",firstName);
        userDetails.put("lastName",lastName);
        userDetails.put("password",password);
        userDetails.put("day",day);
        userDetails.put("month",month);
        userDetails.put("year",year);
        userDetails.put("company",company);
        userDetails.put("address1",address1);
        userDetails.put("address2",address2);
        userDetails.put("city",city);
        userDetails.put("state",state);
        userDetails.put("postalCode",postalCode);
        userDetails.put("others",others);
        userDetails.put("phone",phone);
        userDetails.put("mobile",mobile);
        userDetails.put("alias",alias);
        userDetails.put("country",country);
        automationPage.registerUser(userDetails);
        automationPage.clickSubmitAccount();
        automationPage.verifySignUp(driver);
    }

    @Test(priority = 3)
    @Parameters({"password"})
    public void loginTest(String password){
        String email = (String) WebContext.getValue("userMailid");
        automationPage.login(email,password);
        automationPage.verifySignUp(driver);
    }

    @Test(priority = 4)
    @Parameters({"password"})
    public void checkOutTest(String password){
        String email = (String) WebContext.getValue("userMailid");
        automationPage.login(email,password);
        automationPage.goForShopping();
        automationPage.verifyShopping(driver);
    }
}
