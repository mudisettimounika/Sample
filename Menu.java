package com.taxi.driver.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.gherkin.model.And;

import io.appium.java_client.android.AndroidDriver;

public class Menu {
	AndroidDriver<WebElement>driver;
	
	public Menu(AndroidDriver driver) {
		this.driver = driver;
//        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="ae.taxishare.driver:id/iv_menu")
	public WebElement menu;
	
	@FindBy(xpath="//android.widget.CheckedTextView[@text='About Us']")
	public WebElement Aboutus;
	
	@FindBy(id="ae.taxishare.driver:id/iv_left_arrow")
	public WebElement backarrow;
	
	@FindBy(xpath="//android.widget.CheckedTextView[@text='FAQs']")
	public WebElement FAQS;
	
	@FindBy(xpath="//android.widget.CheckedTextView[@text='Contact Us']")
	public WebElement Contactus;
	
	@FindBy(xpath="//android.widget.TextView[@text='Logout']")
	 public WebElement logout;
	
	
	public void menu() {
		menu.click();
		}
	public void Aboutus() {
		Aboutus.click();
		}
	public void backarrow() {
		backarrow.click();
	}
	 public void FAQS() {
		 FAQS.click();
		}
	 public void Contactus() {
		Contactus.click();
	}
	 public void logout() {
		 logout.click();
		
	}
}
