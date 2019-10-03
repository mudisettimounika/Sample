package com.taxi.user.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class Findtaxi {
	
	AndroidDriver<WebElement>driver;
	public Findtaxi(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//android.widget.TextView[@text='Find Taxi']")
	public WebElement Findtaxitab;
	
	@FindBy(xpath="//android.widget.LinearLayout[@resource-id='ae.taxishare.user:id/broadcastLayout']")
	public WebElement broadcastbutton;
	
	
	@FindBy(id="ae.taxishare.user:id/okay_tv")
	public WebElement okay;
	
	public void findtaxi() {
		Findtaxitab.click();
	}
	 
	public void Broadcastbtn() {
		broadcastbutton.click();
	}
	
	public void Okay() {
		okay.click();
		
	}

}
