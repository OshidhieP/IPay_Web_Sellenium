package com.example.tests;

import com.example.pages.MerchantRegistration;
import com.example.utils.TestDataLoader;
import com.example.webdriver.DriverInitialization;
import com.example.pages.LoginPage;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.File;

public class TestClass {

    private WebDriver driver;
    private static JSONObject loginTestData;
    private static JSONObject merchantTestData;

//    @BeforeClass
//    public void setUp() {
//        testData = TestDataLoader.loadTestData();
//        driver = DriverInitialization.initializeDriver();
//        driver.get("https://developer.ipay.lk/ipayBankApp/login");
//        driver.manage().window().maximize();
//    }

    @BeforeMethod
    public void login (){
        driver = DriverInitialization.initializeDriver();
        driver.get("https://developer.ipay.lk/ipayBankApp/login");
        driver.manage().window().maximize();

        loginTestData = TestDataLoader.LoginTestData();
        merchantTestData = TestDataLoader.MerchantTestData();

        LoginPage.enterUsername(driver, loginTestData.get("validUsername").toString());
        LoginPage.enterPassword(driver, loginTestData.get("validPassword").toString());
        LoginPage.clickLoginButton(driver);
    }

    @Test(testName = "Validate the Success Login", priority = 1)
    public void loginValidation() {
        LoginPage.validMessage(driver);//Assertion
    }

    @Test(priority = 2)
    public void loginWithInvalidCredentials() {
        LoginPage.click1(driver);
        LoginPage.click2(driver);
        LoginPage.enterUsername(driver, loginTestData.get("invalidUsername").toString());
        LoginPage.enterPassword(driver, loginTestData.get("invalidPassword").toString());
        LoginPage.clickLoginButton(driver);
        LoginPage.isErrorMessageDisplayed(driver);//Assertion
    }

    @Test(testName = "Verify the response for merchant Customer registration using valid data", priority = 1)
    public void merchantRegistration() throws InterruptedException {
        MerchantRegistration.clickMerchant(driver);
        MerchantRegistration.clickMerchantReg(driver);
        MerchantRegistration.clickBType(driver);
        MerchantRegistration.clickType(driver);
        MerchantRegistration.clickSelect(driver);
        MerchantRegistration.empNoSearch(driver, merchantTestData.get("validEmpNo").toString());
        MerchantRegistration.clickEmpNoSearch(driver);
        MerchantRegistration.clickNext(driver);
        MerchantRegistration.enterMerchantName(driver, merchantTestData.get("merchantName").toString());
        MerchantRegistration.enterBCode(driver, merchantTestData.get("businessCode").toString());
        MerchantRegistration.bCategory(driver, merchantTestData.get("businessCategory").toString());
        MerchantRegistration.next1(driver);
        MerchantRegistration.enterNIC(driver, merchantTestData.get("nicNumber").toString());
        String imagePath = new File("src/main/resources/images/nic.jpg").getAbsolutePath();
        MerchantRegistration.uploadNic(driver, imagePath);
        MerchantRegistration.addressLine1(driver, merchantTestData.get("addressLine1").toString());
        MerchantRegistration.addressLine2(driver, merchantTestData.get("addressLine2").toString());
        MerchantRegistration.cityEnter(driver, merchantTestData.get("city").toString());
        Thread.sleep(3000);
        MerchantRegistration.next2(driver);
        Thread.sleep(2000);
        MerchantRegistration.mUsername(driver, merchantTestData.get("merchantUsername").toString());
        MerchantRegistration.mMobileNo(driver, merchantTestData.get("merchantMobileNo").toString());
        Thread.sleep(3000);
        MerchantRegistration.next3(driver);
        MerchantRegistration.bank(driver, merchantTestData.get("bankName").toString());
        MerchantRegistration.accNo(driver, merchantTestData.get("accountNumber").toString());
        MerchantRegistration.finish(driver);
        MerchantRegistration.invalidMessage(driver);//Assertion
    }

    @Test(testName = "Verify the response for merchant Customer registration without entering mandatory field", priority = 3)
    public void merchantRegistrationNegative() {
        MerchantRegistration.clickMerchant(driver);
        MerchantRegistration.clickMerchantReg(driver);
        MerchantRegistration.clickNext(driver);
        MerchantRegistration.isErrorMessageDisplayed(driver);
    }

    @Test(testName = "Invalid data enter", priority = 4)
    public void merchantNameInvalidInRegistration() throws InterruptedException {
        MerchantRegistration.clickMerchant(driver);
        MerchantRegistration.clickMerchantReg(driver);
        MerchantRegistration.clickBType(driver);
        MerchantRegistration.clickType(driver);
        MerchantRegistration.clickSelect(driver);
        MerchantRegistration.empNoSearch(driver, merchantTestData.get("invalidEmpNo").toString());
        Thread.sleep(2000);
        MerchantRegistration.errorMessageInIntroducer(driver);
    }

    @Test(testName = "Check Invalid NIC no", priority = 5)
    public void invalidNicNo() throws InterruptedException {
        MerchantRegistration.clickMerchant(driver);
        MerchantRegistration.clickMerchantReg(driver);
        MerchantRegistration.clickBType(driver);
        MerchantRegistration.clickType(driver);
        MerchantRegistration.clickSelect(driver);
        MerchantRegistration.empNoSearch(driver, merchantTestData.get("validEmpNo").toString());
        MerchantRegistration.clickEmpNoSearch(driver);
        MerchantRegistration.clickNext(driver);
        MerchantRegistration.enterMerchantName(driver, merchantTestData.get("merchantName").toString());
        MerchantRegistration.enterBCode(driver, merchantTestData.get("businessCode").toString());
        MerchantRegistration.bCategory(driver, merchantTestData.get("businessCategory").toString());
        MerchantRegistration.next1(driver);
        MerchantRegistration.enterNIC(driver, merchantTestData.get("invalidNicNumber").toString());
        String imagePath = new File("src/main/resources/images/nic.jpg").getAbsolutePath();
        MerchantRegistration.uploadNic(driver, imagePath);
        MerchantRegistration.addressLine1(driver, merchantTestData.get("addressLine1").toString());
        MerchantRegistration.addressLine2(driver, merchantTestData.get("addressLine2").toString());
        MerchantRegistration.cityEnter(driver, merchantTestData.get("city").toString());
        Thread.sleep(3000);
        MerchantRegistration.invalidNIC(driver); //Assertion
    }

    @Test(testName = "Check Invalid Merchant Mobile No", priority = 6)
    public void invalidMerchantMobileNo() throws InterruptedException {
        MerchantRegistration.clickMerchant(driver);
        MerchantRegistration.clickMerchantReg(driver);
        MerchantRegistration.clickBType(driver);
        MerchantRegistration.clickType(driver);
        MerchantRegistration.clickSelect(driver);
        MerchantRegistration.empNoSearch(driver, merchantTestData.get("validEmpNo").toString());
        MerchantRegistration.clickEmpNoSearch(driver);
        Thread.sleep(3000);
        MerchantRegistration.clickNext(driver);
        MerchantRegistration.enterMerchantName(driver, merchantTestData.get("merchantName").toString());
        MerchantRegistration.enterBCode(driver, merchantTestData.get("businessCode").toString());
        MerchantRegistration.bCategory(driver, merchantTestData.get("businessCategory").toString());
        MerchantRegistration.next1(driver);
        MerchantRegistration.enterNIC(driver, merchantTestData.get("nicNumber").toString());
        String imagePath = new File("src/main/resources/images/nic.jpg").getAbsolutePath();
        MerchantRegistration.uploadNic(driver, imagePath);
        MerchantRegistration.addressLine1(driver, merchantTestData.get("addressLine1").toString());
        MerchantRegistration.addressLine2(driver, merchantTestData.get("addressLine2").toString());
        MerchantRegistration.cityEnter(driver, merchantTestData.get("city").toString());
        Thread.sleep(3000);
        MerchantRegistration.next2(driver);
        Thread.sleep(2000);
        MerchantRegistration.mUsername(driver, merchantTestData.get("merchantUsername").toString());
        MerchantRegistration.mMobileNo(driver, merchantTestData.get("invalidMobileNo").toString());
        MerchantRegistration.next3(driver);
        Thread.sleep(3000);
        MerchantRegistration.invalidMerchantMobileNo(driver); //Assertion
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
