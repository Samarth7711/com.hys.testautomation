package com.hyr.testautomation;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class WindowHandles extends BaseSetup {
	@Test(priority=1)
	public void practiceselenium() {
		 WebElement seleniumPracticeLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Selenium Practice")));
	        action.moveToElement(seleniumPracticeLink).perform();
	        
	        WebElement WindowsHandle=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Window Handles")));
	        WindowsHandle.click();
	}
	@Test(priority=2)
	public void NewWindowOpen() {
		String parent=driver.getWindowHandle();
		System.out.println("Parent: "+parent);
		
		WebElement newwindowButton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"newWindowBtn\"]")));
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", newwindowButton);
		newwindowButton.click();
		
		Set<String>child=driver.getWindowHandles();
		System.out.println("child: "+child);
		for(String handle:child) {
			if(!handle.equals(parent)) {
				driver.switchTo().window(handle);
				driver.manage().window().maximize();
				driver.close();
			}
			driver.switchTo().window(parent);
			WebElement newTabButton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"newTabBtn\"]")));
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", newTabButton);
			newTabButton.click();
			driver.switchTo().newWindow(WindowType.TAB);
			
		}
		
		
	}
}
    
    