package com.example.tests;

import com.example.pages.MerchanetRegistration;
import com.example.webdriver.DriverInitialization;
import com.example.pages.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class TestClass {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverInitialization.initializeDriver();
        driver.get("https://developer.ipay.lk/ipayBankApp/login");
        driver.manage().window().maximize();
    }

    @Test
    public void loginWithValidCredentials() {
        LoginPage.enterUsername(driver, "shan.lofc");
        LoginPage.enterPassword(driver, "123456");
        LoginPage.clickLoginButton(driver);
    }

    @Test
    public void merchantRegistration() throws InterruptedException {
        LoginPage.enterUsername(driver, "branchofficer.lofc");
        LoginPage.enterPassword(driver, "123456");
        LoginPage.clickLoginButton(driver);
        //Merchant Registration Start
        MerchanetRegistration.clickMerchant(driver);
        MerchanetRegistration.clickMerchantReg(driver);
        MerchanetRegistration.clickBType(driver);
        Thread.sleep(2000);
        MerchanetRegistration.clickType(driver);
        MerchanetRegistration.clickSelect(driver);
        Thread.sleep(4000);
        MerchanetRegistration.empNoSearch(driver,"20291");
        MerchanetRegistration.clickEmpNoSearch(driver);
        MerchanetRegistration.clickNext(driver);
        Thread.sleep(2000);
        MerchanetRegistration.enterMerchantName(driver,"Oshidhie");
        MerchanetRegistration.enterBCode(driver, "1111111111");
        MerchanetRegistration.bCatergoty(driver, "Books & Stationery Shops");
        Thread.sleep(2000);
        MerchanetRegistration.next1(driver);
        Thread.sleep(2000);
        MerchanetRegistration.enterNIC(driver, "200057200456");
        Thread.sleep(2000);
        String imagePath = "D:\\IPay QA Example\\IPay_Web_Sellenium\\src\\main\\resources\\images\\nic.jpg";
        MerchanetRegistration.uploadNic(driver, imagePath);
        MerchanetRegistration.adressLine1(driver, "100/1");
        MerchanetRegistration.adressLine2(driver, "Malwatta Road");
        MerchanetRegistration.cityEnter(driver, "Dehiwala");
        Thread.sleep(2000);
        MerchanetRegistration.next2(driver);
        Thread.sleep(2000);
        MerchanetRegistration.mUsername(driver, "OshidhieP");
        MerchanetRegistration.mMobileNo(driver, "0771414181");
        MerchanetRegistration.next3(driver);
        Thread.sleep(2000);
        MerchanetRegistration.bank(driver, "LOLC Finance PLC");
        MerchanetRegistration.accNo(driver, "10173256032");
        MerchanetRegistration.finish(driver);
    }

    @Test
    public void loginWithInvalidCredentials() {
        LoginPage.enterUsername(driver, "shan.lofc");
        LoginPage.enterPassword(driver, "1234");
        LoginPage.clickLoginButton(driver);

        LoginPage.isErrorMessageDisplayed(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
