package com.juaracoding.pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.pageobject.drivers.DriverSingleton;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(xpath = "//*[@id=\'txtUsername\']")
	private WebElement username;
 
	@FindBy(xpath = "//*[@id=\'txtPassword\']")
	private WebElement password;
	
	@FindBy(xpath = "//*[@id=\'btnLogin\']")
	private WebElement btnLogin;
	
	public void login() {
		username.sendKeys("Admin");
		password.sendKeys("admin123");
		btnLogin.click();
	}
	
	
}
