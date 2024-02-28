package com.example.tests;

import com.example.pages.MerchantRegistration;
import com.example.webdriver.DriverInitialization;
import com.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class TestClass {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = DriverInitialization.initializeDriver();
        driver.get("https://developer.ipay.lk/ipayBankApp/login");
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void login (){
        LoginPage.enterUsername(driver, "branchofficer.lofc");
        LoginPage.enterPassword(driver, "123456");
        LoginPage.clickLoginButton(driver);
//        LoginPage.validMessage(driver);
    }

    @Test(testName = "Verify the response for merchant Customer registration using valid data")
    public void merchantRegistration() throws InterruptedException {
        MerchantRegistration.clickMerchant(driver);
        MerchantRegistration.clickMerchantReg(driver);
        MerchantRegistration.clickBType(driver);
        MerchantRegistration.clickType(driver);
        MerchantRegistration.clickSelect(driver);
        MerchantRegistration.empNoSearch(driver,"20291");
        MerchantRegistration.clickEmpNoSearch(driver);
        MerchantRegistration.clickNext(driver);
        MerchantRegistration.enterMerchantName(driver,"Oshidhie");
        MerchantRegistration.enterBCode(driver, "1111111111");
        MerchantRegistration.bCategory(driver, "Books & Stationery Shops");
        MerchantRegistration.next1(driver);
        MerchantRegistration.enterNIC(driver, "200057200456");
        String imagePath = new File("src/main/resources/images/nic.jpg").getAbsolutePath();
        MerchantRegistration.uploadNic(driver, imagePath);
        MerchantRegistration.addressLine1(driver, "100/1");
        MerchantRegistration.addressLine2(driver, "Malwatta Road");
        MerchantRegistration.cityEnter(driver, "Dehiwala");
        Thread.sleep(3000);
        MerchantRegistration.next2(driver);
        MerchantRegistration.mUsername(driver, "OshidhieP");
        MerchantRegistration.mMobileNo(driver, "0771414181");
        Thread.sleep(3000);
        MerchantRegistration.next3(driver);
        MerchantRegistration.bank(driver, "LOLC Finance PLC");
        MerchantRegistration.accNo(driver, "10173256032");
        MerchantRegistration.finish(driver);
//        MerchantRegistration.invalidMessage(driver);
    }

    @Test
    public void loginWithInvalidCredentials() {
        LoginPage.invalid1(driver);
        LoginPage.invalid2(driver);
        LoginPage.enterUsername(driver, "shan.lofc");
        LoginPage.enterPassword(driver, "1234");
        LoginPage.clickLoginButton(driver);
        LoginPage.isErrorMessageDisplayed(driver);
    }

    @Test(testName = "Verify the response for merchant Customer registration without entering mandatory field")
    public void merchantRegistrationNegative() {
        MerchantRegistration.clickMerchant(driver);
        MerchantRegistration.clickMerchantReg(driver);
        MerchantRegistration.clickNext(driver);
        MerchantRegistration.isErrorMessageDisplayed(driver);
    }

    @Test(testName = "Invalid data enter")
    public void merchantNameInvalidInRegistration() {
        MerchantRegistration.clickMerchant(driver);
        MerchantRegistration.clickMerchantReg(driver);
        MerchantRegistration.clickBType(driver);
        MerchantRegistration.clickType(driver);
        MerchantRegistration.clickSelect(driver);
        MerchantRegistration.empNoSearch(driver,"000000");
        MerchantRegistration.errorMessageInIntroducer(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
