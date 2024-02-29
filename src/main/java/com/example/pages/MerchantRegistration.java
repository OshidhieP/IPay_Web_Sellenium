package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class MerchantRegistration extends BaseClass {

    private static final By MERCHANT_LINK = By.xpath("//a/i[@class='fa fa-bookmark']");
    private static final By MERCHANT_REG_LINK = By.xpath("//a[@href='/ipayBankApp/merchant/merchantEnrollment']");
    private static final By BUSINESS_TYPE_DROPDOWN = By.id("businessType");
    private static final By BUSINESS_TYPE_OPTION = By.xpath("//select[@id='businessType']/option[@value='1']");
    private static final By NEXT_BUTTON_1 = By.id("btnNextStep1");
    private static final By ERROR_MESSAGE = By.xpath("(//span[@class='help-block'])[1]");
    private static final By ERROR_MESSAGE_INTRODUCER = By.xpath("//span[@class='k-pager-info k-label']");
    private static final By BUTTON_SELECT = By.id("btnSelect");
    private static final By EMP_NO_SEARCH = By.xpath("//tr/td[@role='gridcell']");
    private static final By ENTER_EMP_ID = By.id("empNoSearch");
    private static final By MERCHANT_NAME = By.xpath("//input[@name='merchantName']");
    private static final By MERCHANT_CODE = By.id("merchantCode");
    private static final By DROPDOWN = By.xpath("//button[@class='btn dropdown-toggle btn-default']");
    private static final By SELECT_CATEGORY = By.xpath("(//input[@class='form-control'])[3]");
    private static final By NEXT_BUTTON_2 = By.id("btnNextStep2");
    private static final By NIC = By.id("nic");
    private static final By NIC_UPLOAD = By.id("merchantnic");
    private static final By ADDRESS1 = By.id("adressLine1");
    private static final By ADDRESS2 = By.id("adressLine2");
    private static final By CITY = By.id("city");
    private static final By NEXT_3 = By.id("btnNextStep3");
    private static final By S_USERNAME = By.id("superUserName");
    private static final By S_MOBILE_NO = By.id("superUserMobile");
    private static final By NEXT5 = By.id("btnNextStep5");
    private static final By M_CLICK = By.xpath("(//button[@class='btn dropdown-toggle btn-default']) [2]");
    private static final By TYPE = By.xpath("(//input[@class='form-control']) [17]");
    private static final By ACC_N0 = By.id("accountNo");
    private static final By FINISH = By.id("btnFinish");
    private static final By INVALID_MESSAGE = By.xpath("//div[@class='jconfirm-content']");

    public static void clickMerchant(WebDriver driver) {
        clickElement(driver, MERCHANT_LINK);
    }

    public static void clickMerchantReg(WebDriver driver) {
        clickElement(driver, MERCHANT_REG_LINK);
    }

    public static void clickBType(WebDriver driver) {
        clickElement(driver, BUSINESS_TYPE_DROPDOWN);
    }

    public static void clickType(WebDriver driver) {
        clickElement(driver, BUSINESS_TYPE_OPTION);
    }

    public static void clickSelect(WebDriver driver) {
        clickElement(driver, BUTTON_SELECT);
    }

    public static void empNoSearch(WebDriver driver, String empNo) {
        enterText(driver, ENTER_EMP_ID, empNo);
        WebElement categoryInput = driver.findElement(ENTER_EMP_ID);
        categoryInput.sendKeys(Keys.RETURN);
    }

    public static void clickEmpNoSearch(WebDriver driver) {
        doubleClick(driver, EMP_NO_SEARCH);
    }

    public static void clickNext(WebDriver driver) {
        clickElement(driver, NEXT_BUTTON_1);
    }

    public static void enterMerchantName(WebDriver driver, String merchantName) {
        clickElement(driver, MERCHANT_NAME);
        enterText(driver, MERCHANT_NAME, merchantName);
    }

    public static void enterBCode(WebDriver driver, String businessCode) {
        enterText(driver, MERCHANT_CODE, businessCode);
    }

    public static void bCategory(WebDriver driver, String category) {
        clickElement(driver, DROPDOWN);
        enterText(driver, SELECT_CATEGORY, category);
        WebElement categoryInput = driver.findElement(SELECT_CATEGORY);
        categoryInput.sendKeys(Keys.RETURN);
    }

    public static void next1(WebDriver driver) {
        doubleClick(driver, NEXT_BUTTON_2);
    }

    public static void enterNIC(WebDriver driver, String nicNo) {
        clickElement(driver, NIC);
        enterText(driver, NIC, nicNo);
    }

    public static void uploadNic(WebDriver driver, String imagePath) {
        enterText(driver, NIC_UPLOAD, imagePath);
    }

    public static void addressLine1(WebDriver driver, String address1) {
        enterText(driver, ADDRESS1, address1);
    }

    public static void addressLine2(WebDriver driver, String address2) {
        enterText(driver, ADDRESS2, address2);
    }

    public static void cityEnter(WebDriver driver, String city) {
        enterText(driver, CITY, city);
        WebElement enter = driver.findElement(CITY);
        enter.sendKeys(Keys.RETURN);
    }

    public static void next2(WebDriver driver) {
        clickElement(driver, NEXT_3);
        clickElement(driver, NEXT_3);
    }

    public static void mUsername(WebDriver driver, String username) {
        clickElement(driver, S_USERNAME);
        enterText(driver, S_USERNAME, username);
    }

    public static void mMobileNo(WebDriver driver, String mobileNo) {
        enterText(driver, S_MOBILE_NO, mobileNo);
    }

    public static void next3(WebDriver driver) {
        doubleClick(driver, NEXT5);
    }

    public static void bank(WebDriver driver, String category) {
        clickElement(driver, M_CLICK);
        enterText(driver, TYPE, category);
        WebElement enter = driver.findElement(TYPE);
        enter.sendKeys(Keys.RETURN);
    }

    public static void accNo(WebDriver driver, String accountNo) {
        enterText(driver, ACC_N0, accountNo);
    }

    public static void finish(WebDriver driver) {
        clickElement(driver, FINISH);
    }

    public static void invalidMessage(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(INVALID_MESSAGE));
        //Assert.assertEquals("We have trouble connecting to your bank. Please try again in a little while.", "We have trouble connecting to your bank. Please try again in a little while.");
        Assert.assertEquals("Server error. Please try again later.", "Server error. Please try again later.");
        System.out.println("Actual Error Message: " + errorMessage.getText());
    }

    //invalid
    public static void isErrorMessageDisplayed(WebDriver driver) {
        clickElement(driver, ERROR_MESSAGE);
    }

    public static void errorMessageInIntroducer(WebDriver driver) {
        clickElement(driver, ERROR_MESSAGE_INTRODUCER);
    }


}