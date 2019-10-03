package com.taxi.user.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class Chatlistscreen {
	public AndroidDriver<WebElement> driver;

	
	public Chatlistscreen(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath="//android.widget.TextView[@text='Chats']")
	public WebElement chatstab;
	
	@FindBy(xpath="//android.widget.ImageView[@index='0']")
	public List<WebElement>Listcount;
	
	public void chatstab() {
		chatstab.click();
	}
	 public void Listcount() {
		System.out.println(Listcount.size());
		}
}



