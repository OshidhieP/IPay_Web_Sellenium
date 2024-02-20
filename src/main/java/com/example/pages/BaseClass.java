package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseClass {

    protected static void clickElement(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    protected static void enterText(WebDriver driver, By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.sendKeys(text);
    }
}
