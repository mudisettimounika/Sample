package com.taxi.user.pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class Chatscreen {
  public AndroidDriver<WebElement> driver;
  
	public Chatscreen(AndroidDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//android.widget.TextView[@text='To Airport']")
	public WebElement Toairport;
	
	@FindBy(id="ae.taxishare.user:id/statusImage")
	public WebElement msgicon;
	
	@FindBy(id="ae.taxishare.user:id/chat_et")
	public WebElement chattextbox;
	
	@FindBy(id="ae.taxishare.user:id/sendImage")
	public WebElement sendbtn;
	
	
	public void toairport() {
		Toairport.click();
	}
	
	
	public void msgicon() {
		msgicon.click();
	}
	
	public void chattextbox() {
		chattextbox.sendKeys("Hi, this is mounika.");
	}
	 public void sendbtn() {
		 sendbtn.click();
	}

	public void scrollupscreen1() {
		Dimension size = driver.manage().window().getSize();
		Double scrollHeightstart = size.getHeight() * 0.5;
		int scrollstart = scrollHeightstart.intValue();

		Double scrollHeightend = size.getHeight() * 0.2;
		int scrollend = scrollHeightend.intValue();

		TouchAction actions = new TouchAction((MobileDriver) driver).press(PointOption.point(0, scrollstart))
				.moveTo(PointOption.point(0, scrollend)).release().perform();		
	}
	
	
	
}
