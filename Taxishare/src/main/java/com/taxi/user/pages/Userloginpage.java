package com.taxi.user.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class Userloginpage {
	
	AndroidDriver driver;

	public Userloginpage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//android.widget.EditText[@text='Email Address']")
	public WebElement username;

	@FindBy(xpath = "//android.widget.EditText[contains(@resource-id,'ae.taxishare.user:id/password_et')]")
	public WebElement password;
	
	@FindBy(xpath= "//android.widget.Button[contains(@resource-id,'ae.taxishare.user:id/logintButton')]")
	public WebElement loginbtn;

	
	public void username() {
		username.sendKeys("mounikas@gmail.com");
	}
	public void password() {
		password.sendKeys("123456");
	}
	 
	public void hidekeyboard() {
		// System.out.println("testing");
		driver.hideKeyboard();
	}

	
	public void loginbtn() {
		loginbtn.click();
	}

}
