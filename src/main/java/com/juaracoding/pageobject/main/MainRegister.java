package com.juaracoding.pageobject.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.juaracoding.pageobject.drivers.DriverSingleton;
import com.juaracoding.pageobject.pages.RegisterPage;

public class MainRegister {

	public static void main(String[] args) {
		
		DriverSingleton.getInstance("Chrome");
		WebDriver driver = DriverSingleton.getDriver();
		String url = "https://shop.demoqa.com/";
		driver.get(url);
		driver.findElement(By.xpath("//a[normalize-space()='My Account']")).click();
		
//		TEST REGISTER
		RegisterPage registerPage = new RegisterPage();
		registerPage.register("hendi1234", "hdinata04@gmail.com", "Posttest14");
		
		
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
