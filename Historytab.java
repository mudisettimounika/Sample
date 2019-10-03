package com.taxi.driver.pages;

import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class Historytab {

	AndroidDriver<WebElement>driver;
	public Historytab(AndroidDriver driver) {
    this.driver=driver;
    PageFactory.initElements(driver, this);
    }
	
	
	@FindBy(id="ae.taxishare.driver:id/menu_history")
	public WebElement history;
	
	@FindBy(className="android.widget.LinearLayout")
	 public List<WebElement> listcount;
	
	public void history() {
		history.click();
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
	
	
	public void historylist () {
	System.out.println("count  " + listcount.size());
		
	}
}
