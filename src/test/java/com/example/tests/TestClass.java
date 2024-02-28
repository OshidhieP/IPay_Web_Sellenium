package com.example.tests;

import com.example.pages.MerchantRegistration;
import com.example.utils.TestDataLoader;
import com.example.webdriver.DriverInitialization;
import com.example.pages.LoginPage;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class TestClass {

    private WebDriver driver;
    private static JSONObject testData;

    @BeforeClass
    public void setUp() {
        testData = TestDataLoader.loadTestData();
        driver = DriverInitialization.initializeDriver();
        driver.get("https://developer.ipay.lk/ipayBankApp/login");
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void login (){
        LoginPage.enterUsername(driver, testData.get("validUsername").toString());
        LoginPage.enterPassword(driver, testData.get("validPassword").toString());
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
        MerchantRegistration.empNoSearch(driver, testData.get("validEmpNo").toString());
        MerchantRegistration.clickEmpNoSearch(driver);
        MerchantRegistration.clickNext(driver);
        MerchantRegistration.enterMerchantName(driver, testData.get("merchantName").toString());
        MerchantRegistration.enterBCode(driver, testData.get("businessCode").toString());
        MerchantRegistration.bCategory(driver, testData.get("businessCategory").toString());
        MerchantRegistration.next1(driver);
        MerchantRegistration.enterNIC(driver, testData.get("nicNumber").toString());
        String imagePath = new File("src/main/resources/images/nic.jpg").getAbsolutePath();
        MerchantRegistration.uploadNic(driver, imagePath);
        MerchantRegistration.addressLine1(driver, testData.get("addressLine1").toString());
        MerchantRegistration.addressLine2(driver, testData.get("addressLine2").toString());
        MerchantRegistration.cityEnter(driver, testData.get("city").toString());
        Thread.sleep(3000);
        MerchantRegistration.next2(driver);
        MerchantRegistration.mUsername(driver, testData.get("merchantUsername").toString());
        MerchantRegistration.mMobileNo(driver, testData.get("merchantMobileNo").toString());
        Thread.sleep(3000);
        MerchantRegistration.next3(driver);
        MerchantRegistration.bank(driver, testData.get("bankName").toString());
        MerchantRegistration.accNo(driver, testData.get("accountNumber").toString());
        MerchantRegistration.finish(driver);
//        MerchantRegistration.invalidMessage(driver);
    }

    @Test
    public void loginWithInvalidCredentials() {
        LoginPage.invalid1(driver);
        LoginPage.invalid2(driver);
        LoginPage.enterUsername(driver, testData.get("invalidUsername").toString());
        LoginPage.enterPassword(driver, testData.get("invalidPassword").toString());
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
        MerchantRegistration.empNoSearch(driver, testData.get("invalidEmpNo").toString());
        MerchantRegistration.errorMessageInIntroducer(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
