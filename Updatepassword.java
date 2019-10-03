package com.taxi.driver.pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class Updatepassword {
	
	AndroidDriver<WebElement>driver;
	public Updatepassword(AndroidDriver driver) {
    this.driver=driver;
    PageFactory.initElements(driver, this);
    }

	@FindBy(xpath="//android.widget.TextView[@text='Settings']")
	public WebElement settings;
	
	@FindBy(id="ae.taxishare.driver:id/btn_edit")
	public WebElement editbutton;
	
	@FindBy(id="ae.taxishare.driver:id/et_old_password")
	public WebElement oldpassword;
	
	@FindBy(id="ae.taxishare.driver:id/et_new_password")
	public WebElement newpassword;
	
	@FindBy(id="ae.taxishare.driver:id/et_confirm_password")
	public WebElement confirmpw;
	
	@FindBy(xpath="//android.widget.TextView[@text='Upload Attachements']")
	public WebElement attachements;
	
	@FindBy(id="com.android.documentsui:id/icon_thumb")
	public WebElement attach;
	
	@FindBy(id="ae.taxishare.driver:id/btn_submit")
	public WebElement submit;
	
	public void Settings() {
		settings.click();
		}
	public void editbtn() {
		editbutton.click();
		}
	public void scrollup() {
		Dimension size = driver.manage().window().getSize();
		Double scrollHeightstart = size.getHeight() * 0.5;
		int scrollstart = scrollHeightstart.intValue();

		Double scrollHeightend = size.getHeight() * 0.2;
		int scrollend = scrollHeightend.intValue();

		TouchAction actions = new TouchAction((MobileDriver) driver).press(PointOption.point(0, scrollstart))
				.moveTo(PointOption.point(0, scrollend)).release().perform();
		}
	public void oldpw() {
    oldpassword.sendKeys("123456");		
	}
	public void newpw() {
		newpassword.sendKeys("123456");
	}
	public void confirmpw () {
		confirmpw.sendKeys("123456");
	}
	
	public void Uploadattach() {
		attachements.click();
		}
	
	public void attachimage() {
		attach.click();
	}
	
	public void submitbtn() {
	submit.click();	
	}
}
