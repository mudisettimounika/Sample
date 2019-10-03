package com.taxi.driver.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class Driversettings {
	
	AndroidDriver<WebElement>driver;
	public Driversettings(AndroidDriver driver) {
    this.driver=driver;
    PageFactory.initElements(driver, this);
    }
	

	@FindBy(xpath="//android.widget.TextView[@text='Settings']")
	public WebElement settings;
	
	@FindBy(id="ae.taxishare.driver:id/iv_edit")
	public WebElement edit;
	
	@FindBy(id="ae.taxishare.driver:id/ll_gallery")
	public WebElement gallery;
	
	@FindBy(xpath="//android.widget.RelativeLayout[@index='5']")
	public WebElement Selectimage;
	
	@FindBy(xpath="//android.view.ViewGroup[@index='1']")
	public WebElement image;
	
	
	
	
	public void Settings() {
		settings.click();
		}
	
	public void edit() {
		edit.click();
		}
	 public void Gallery() {
		gallery.click();
	}
	 public void selectimage() {
		Selectimage.click();
		
	}
	public void Image() {
		image.click();
		}
	
	
	
	
	
	
	
	
	
	
	
}
