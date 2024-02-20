package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;

public class MerchanetRegistration {

    public static void clickMerchant(WebDriver driver) {
        WebElement merchant = driver.findElement(By.xpath("//a/i[@class='fa fa-bookmark']"));
        merchant.click();
    }

    public static void clickMerchantReg(WebDriver driver) {
        WebElement merchant = driver.findElement(By.xpath("//a[@href='/ipayBankApp/merchant/merchantEnrollment']"));
        merchant.click();
    }

    public static void clickBType(WebDriver driver){
        WebElement merchant = driver.findElement(By.id("businessType"));
        merchant.click();
    }

    public static void clickType(WebDriver driver){
        WebElement merchant = driver.findElement(By.xpath("//select[@id='businessType']/option[@value='1']"));
        merchant.click();
    }
    public static void clickSelect(WebDriver driver){
        WebElement merchant = driver.findElement(By.id("btnSelect"));
        merchant.click();
    }

    public static void empNoSearch(WebDriver driver, String empNo){
        WebElement merchant = driver.findElement(By.id("empNoSearch"));
        merchant.sendKeys(empNo);
    }

    public static void clickEmpNoSearch(WebDriver driver){
        WebElement merchant = driver.findElement(By.xpath("//tr/td[@role='gridcell']"));
        Actions actions = new Actions(driver);
        actions.doubleClick(merchant).perform();
    }

    public static void clickNext(WebDriver driver){
        WebElement merchant = driver.findElement(By.id("btnNextStep1"));
        merchant.click();
    }

    public static void enterMerchantName(WebDriver driver, String merchantName){
        WebElement merchant = driver.findElement(By.id("merchantName"));
        merchant.sendKeys(merchantName);
    }

    public static void enterBCode(WebDriver driver, String businessCode){
        WebElement merchant = driver.findElement(By.id("merchantCode"));
        merchant.sendKeys(businessCode);
    }

    public static void bCatergoty(WebDriver driver, String category){
        WebElement mClick = driver.findElement(By.xpath("//button[@class='btn dropdown-toggle btn-default']"));
        WebElement type = driver.findElement(By.xpath("(//input[@class='form-control'])[3]"));
        mClick.click();
        type.sendKeys(category);
        type.sendKeys(Keys.RETURN);
    }

    public static void next1(WebDriver driver){
        WebElement next = driver.findElement(By.id("btnNextStep2"));
        next.click();
    }

    public static void enterNIC(WebDriver driver, String nicNo){
        WebElement idNo = driver.findElement(By.id("nic"));
        idNo.sendKeys(nicNo);
    }

    public static void uploadNic(WebDriver driver, String imagePath) {
        WebElement upload = driver.findElement(By.id("merchantnic"));
        upload.sendKeys(imagePath);
    }

    public static void adressLine1(WebDriver driver, String address1){
        WebElement adress1 = driver.findElement(By.id("adressLine1"));
        adress1.sendKeys(address1);
    }

    public static void adressLine2(WebDriver driver, String address2){
        WebElement adress2 = driver.findElement(By.id("adressLine2"));
        adress2.sendKeys(address2);
    }

    public static void cityEnter(WebDriver driver, String city){
        WebElement cityy = driver.findElement(By.id("city"));
        cityy.sendKeys(city);
    }

    public static void next2(WebDriver driver){
        WebElement next = driver.findElement(By.id("btnNextStep3"));
        next.sendKeys(Keys.RETURN);
        next.click();
    }

    public static void mUsername(WebDriver driver, String username){
        WebElement userName = driver.findElement(By.id("superUserName"));
        userName.sendKeys(username);
    }

    public static void mMobileNo(WebDriver driver, String mobileNo){
        WebElement userName = driver.findElement(By.id("superUserMobile"));
        userName.sendKeys(mobileNo);
    }

    public static void next3(WebDriver driver){
        WebElement next = driver.findElement(By.id("btnNextStep5"));
        next.click();
    }

    public static void bank(WebDriver driver, String category){
        WebElement mClick = driver.findElement(By.xpath("(//button[@class='btn dropdown-toggle btn-default']) [2]"));
        WebElement type = driver.findElement(By.xpath("(//input[@class='form-control']) [17]"));
        mClick.click();
        type.sendKeys(category);
        type.sendKeys(Keys.RETURN);
    }

    public static void accNo(WebDriver driver, String accountNo){
        WebElement no = driver.findElement(By.id("accountNo"));
        no.sendKeys(accountNo);
    }

    public static void finish(WebDriver driver){
        WebElement next = driver.findElement(By.id("btnFinish"));
        next.click();
    }
}
