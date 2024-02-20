package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    public static void enterUsername(WebDriver driver, String username) {
        WebElement usernameElement = driver.findElement(By.name("j_username_bank"));
        usernameElement.sendKeys(username);
    }

    public static void enterPassword(WebDriver driver, String password) {
        WebElement passwordElement = driver.findElement(By.name("j_password_bank"));
        passwordElement.sendKeys(password);
    }

    public static void clickLoginButton(WebDriver driver) {
        WebElement loginButton = driver.findElement(By.id("btnLoginSubmit"));
        loginButton.click();
    }

    // Check if the error message is displayed
    public static void isErrorMessageDisplayed(WebDriver driver) {
            WebElement errorMessage = driver.findElement(By.xpath("//div[@class='alert alert-block alert-danger fade in']"));
            errorMessage.isDisplayed();
    }
}
