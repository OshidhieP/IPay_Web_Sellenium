package com.example.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverInitialization {

    public static WebDriver initializeDriver() {
        return new ChromeDriver();
    }
}