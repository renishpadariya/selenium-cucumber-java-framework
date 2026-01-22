package com.qa.util;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Util {

	private WebDriver driver;
	public Util(WebDriver driver) {
        this.driver = driver;
	}
	public void clickElement(By locator, int waitTimeInSeconds) {
        new WebDriverWait(driver, Duration.ofSeconds(waitTimeInSeconds))
                .until(ExpectedConditions.elementToBeClickable(locator))
                .click();
	}
	public void sendKeys(By locator, String text, int waitTimeInSeconds) {
        new WebDriverWait(driver, Duration.ofSeconds(waitTimeInSeconds))
                .until(ExpectedConditions.visibilityOfElementLocated(locator))
                .sendKeys(text);
	}
	public List<WebElement> findElements(By locator, int waitTimeInSeconds) {
	    return new WebDriverWait(driver, Duration.ofSeconds(waitTimeInSeconds))
	            .until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
}
