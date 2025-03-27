package com.hyr.testautomation;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

public class BaseSetup {
    WebDriver driver;
    WebDriverWait wait;
    Actions action;
    
    @BeforeClass
    public void openUrl() throws InterruptedException {
        // Set path for the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Samarth Patil\\eclipse-workspace\\com.hyr.testautomation\\Resources\\chromedriver.exe");
        
        // Initialize WebDriver
        driver = new ChromeDriver();
        
        // Initialize WebDriverWait with a timeout
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // Initialize Actions object
        action = new Actions(driver);
        
        // Open the URL and maximize the browser window
        driver.get("https://www.hyrtutorials.com/#");
        driver.manage().window().maximize();
        
        // Wait for the page to load
        Thread.sleep(1000);
    }
}
