package com.juaracoding.pageobject.main;

import org.openqa.selenium.WebDriver;


import com.juaracoding.pageobject.drivers.DriverSingleton;
import com.juaracoding.pageobject.pages.LoginPage;

public class MainApp {

	public static void main(String[] args) {
		
		DriverSingleton.getInstance("Chrome");
		WebDriver driver = DriverSingleton.getDriver();
		String url = "https://www.google.com";
		driver.get(url);
		
		LoginPage loginPage = new LoginPage();
		loginPage.login("Admin","admin123");
		
		
		
		delay(3);
		driver.quit();

	}
	
	static void delay(int detik) {
		try {
			Thread.sleep(1000*detik);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
