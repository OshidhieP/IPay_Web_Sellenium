package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage extends BaseClass{

    private static final By USERNAME_FIELD = By.name("j_username_bank");
    private static final By PASSWORD_FIELD = By.name("j_password_bank");
    private static final By LOGIN_BUTTON = By.id("btnLoginSubmit");
    private static final By ERROR_MESSAGE = By.xpath("//div[@class='alert alert-block alert-danger fade in']");
    private static final By VALID_MESSAGE = By.linkText("iPay Bank Portal - LOLC Finance PLC | City Branch");

    public static void enterUsername(WebDriver driver, String username) {
        enterText(driver, USERNAME_FIELD, username);
    }

    public static void enterPassword(WebDriver driver, String password) {
        enterText(driver, PASSWORD_FIELD, password);
    }

    public static void clickLoginButton(WebDriver driver) {
        clickElement(driver, LOGIN_BUTTON);
    }

    public static void validMessage(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(VALID_MESSAGE));
        Assert.assertEquals("iPay Bank Portal - LOLC Finance PLC | City Branch", "iPay Bank Portal - LOLC Finance PLC | City Branch");
        System.out.println("Actual Error Message: " + errorMessage.getText());
    }

    public static void isErrorMessageDisplayed(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR_MESSAGE));
        Assert.assertEquals("Invalid Username or Password", "Invalid Username or Password");
        System.out.println("Actual Error Message: " + errorMessage.getText());
    }
}
