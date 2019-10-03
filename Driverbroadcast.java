package com.taxi.driver.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class Driverbroadcast {

	
	AndroidDriver<WebElement>driver;
	public Driverbroadcast(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//android.widget.TextView[@text='Find Passengers']")
	public WebElement Findpassengers;
	
	
	public void Findpassengers() {
		Findpassengers.click();
		
	}
}
