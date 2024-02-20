package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BaseClass{

    private static final By USERNAME_FIELD = By.name("j_username_bank");
    private static final By PASSWORD_FIELD = By.name("j_password_bank");
    private static final By LOGIN_BUTTON = By.id("btnLoginSubmit");
    private static final By ERROR_MESSAGE = By.xpath("//div[@class='alert alert-block alert-danger fade in']");

    public static void enterUsername(WebDriver driver, String username) {
        enterText(driver, USERNAME_FIELD, username);
    }

    public static void enterPassword(WebDriver driver, String password) {
        enterText(driver, PASSWORD_FIELD, password);
    }

    public static void clickLoginButton(WebDriver driver) {
        clickElement(driver, LOGIN_BUTTON);
    }

    public static void isErrorMessageDisplayed(WebDriver driver) {
        clickElement(driver, ERROR_MESSAGE);
    }
}
