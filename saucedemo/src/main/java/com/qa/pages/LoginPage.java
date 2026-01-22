package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.util.Util;

public class LoginPage {
	private WebDriver driver;
	private Util util;
	private By username=By.xpath("//input[@id='user-name']");
	private By password=By.xpath("//input[@id='password']");
	private By Login_btn=By.xpath("//input[@id='login-button']");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		util = new Util(driver);
	}

	public void enter_username(String property) {
		
		util.sendKeys(username, property, 10);
	}


	public void enter_password(String property) {
		util.sendKeys(password, property, 10);
			
	}


	public HomePage click_on_login_button() {
		util.clickElement(Login_btn, 10);
		return new HomePage(driver);
	}

}
