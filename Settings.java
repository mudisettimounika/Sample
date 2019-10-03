package com.taxi.user.pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Twousers.Mainclass;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class Settings {
	public AndroidDriver<WebElement> driver;

	public Settings(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//android.widget.TextView[@text='Settings']")
	public WebElement settingtab;

	@FindBy(id = "ae.taxishare.user:id/edit")
	public WebElement Editbutton;

	@FindBy(id = "ae.taxishare.user:id/old_password_et")
	public WebElement oldpassword;

	@FindBy(id = "ae.taxishare.user:id/password_et")
	public WebElement newpassword;

	@FindBy(id = "ae.taxishare.user:id/confirm_password_et")
	public WebElement confirmpassword;

	@FindBy(id = "ae.taxishare.user:id/save")
	public WebElement savebtn;

	public void tapsettings() {
		System.out.println("setting tab");
		settingtab.click();

	}

	public void editbutton() {
		Editbutton.click();
	}

	public void scrollupscreen() {
		Dimension size = driver.manage().window().getSize();
		Double scrollHeightstart = size.getHeight() * 0.5;
		int scrollstart = scrollHeightstart.intValue();

		Double scrollHeightend = size.getHeight() * 0.2;
		int scrollend = scrollHeightend.intValue();

		TouchAction actions = new TouchAction((MobileDriver) driver).press(PointOption.point(0, scrollstart))
				.moveTo(PointOption.point(0, scrollend)).release().perform();
	}

	public void old() {
		oldpassword.sendKeys("123456");

	}

	public void newpassword() {
		newpassword.sendKeys("123456");

	}

	public void confimpassword() {
		confirmpassword.sendKeys("123456");

	}

	public void savebtn() {
		savebtn.click();
	}

	
	
}
