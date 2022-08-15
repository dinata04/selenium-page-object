package com.juaracoding.pageobject.pages;

import org.openqa.selenium.By;
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
	
	@FindBy(xpath = "//input[@id='username']")
	private WebElement username;
 
	@FindBy(xpath = "//input[@id='password']")
	private WebElement password;
	
	@FindBy(xpath = "//input[@id='rememberme']")
	private WebElement rememberme;
	
	@FindBy(xpath = "//button[@name='login']")
	private WebElement btnLogin;
	
//	LOST PASSWORD
	@FindBy(xpath = "//a[normalize-space()='Lost your password?']")
	private WebElement lostpassword;
	
	
	public void login( String username, String password) {
		this.username.sendKeys(username);
		this.password.sendKeys(password);
		rememberme.click();
		btnLogin.click();
		
		
		String txtInvalidLogin = driver.findElement(By.xpath("//strong[normalize-space()='ERROR']")).getText();
		if(txtInvalidLogin.equals("Error")) {
			lostpassword.click();
			System.out.println("The username or password you entered is incorrectregistered");
		}else{
			System.out.println("Login Success");
		}
	}
	
	
}
