package com.taxi.user.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;


public class Userone{
	public AndroidDriver<WebElement>driver;
	
	public Userone(AndroidDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "ae.taxishare.user:id/from_llView")
	public WebElement From;

	@FindBy(id = "ae.taxishare.user:id/to_llView")
	public WebElement To;

	@FindBy(xpath = "//android.widget.CheckedTextView[@text='Chennai International Airport  Terminal 1']")
	public WebElement fromlocation;

	@FindBy(xpath = "//android.widget.CheckedTextView[@text='Maitrivanam  Ameerpet']")
	public WebElement tolocation;

	@FindBy(id = "ae.taxishare.user:id/broadcastLayout")
	public WebElement Broadcast;

	@FindBy(xpath="//android.widget.TextView[@text='Pay Now']")
	public WebElement paynowbtn;
	
	public void fromdropdown() {
		
		From.click();
	}

	public void todropdown() {
		To.click();
	}

	public void fromlocation() {
		fromlocation.click();
	}

	public void tolocation() {
		tolocation.click();
	}

	public void broadcastbtn() {
		Broadcast.click();
	}

	public void paynowbtn() {
		paynowbtn.click();
		
	}

}
