package com.juaracoding.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.pageobject.drivers.DriverSingleton;

public class RegisterPage {
	
	public WebDriver driver;
	
	public RegisterPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(xpath = "//input[@id='reg_username']")
	private WebElement username;
	
	@FindBy(xpath = "//input[@id='reg_email']")
	private WebElement email;
	
	@FindBy(xpath = "//input[@id='reg_password']")
	private WebElement password;
	
	@FindBy(xpath = "//button[@name='register']")
	private WebElement btnRegister;
	
	public void register(String username, String email, String password) {
		this.username.sendKeys(username);
		this.email.sendKeys(email);
		this.password.sendKeys(password);
		btnRegister.click();
		
		String txtInvalidRegister = driver.findElement(By.xpath("//strong[normalize-space()='Error:']")).getText();
		if(txtInvalidRegister.contains("Error")) {
			System.out.println("Register Error, account is already registered");
		}else{
			System.out.println("Register Success");
		}
	}
	
	

}

