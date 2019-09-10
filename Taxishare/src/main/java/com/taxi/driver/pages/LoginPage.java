package com.taxi.driver.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class LoginPage {

	AndroidDriver driver;

	public LoginPage(AndroidDriver driver) {
		this.driver = driver;
//        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		PageFactory.initElements(driver, this);
	}

	

	@FindBy(id = "ae.taxishare.driver:id/et_user_email")
	public WebElement username;

	@FindBy(id = "ae.taxishare.driver:id/et_user_password")
	public WebElement Password;

	@FindBy(id="ae.taxishare.driver:id/btn_login")
	public WebElement loginbtn;
	
	@FindBy(id="ae.taxishare.driver:id/et_create_account")
	public WebElement createaccount;
	
	
	
	public void username() {
		username.sendKeys("mounikamm@gmail.com");
	}

	public void Password() {
		Password.sendKeys("123456");
	}
	
	public void hidekeyboard() {
		// System.out.println("testing");
		driver.hideKeyboard();
	}
	 public void loginbtn() {
		loginbtn.click();
	}
	 public void createaccount() {
		 createaccount.click();
	}
	

}
