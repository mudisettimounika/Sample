package com.taxi.user.pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Uploadimage {

	public AndroidDriver<WebElement> driver;

	public Uploadimage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//android.widget.TextView[@text='Settings']")
	public WebElement settingtab;

	@FindBy(xpath = "//android.widget.FrameLayout[@resource-id='ae.taxishare.user:id/editProfileLayout']")
	public WebElement editbutton;

	@FindBy(xpath = "//android.widget.TextView[@text='Photos']")
	public WebElement photos;

	@FindBy(xpath = "//android.view.View[@resource-id='com.google.android.apps.photos:id/image']")
	public WebElement selectimage;

	@FindBy(xpath = "//android.view.ViewGroup[@index='1']")
	public WebElement image;

	public void tapsettings() {
		System.out.println("setting tab");
		settingtab.click();

	}

	public void editbtn() {
		editbutton.click();
	}

	public void photos() {
		photos.click();
	}

	public void selectimage() {
		selectimage.click();
	}

	public void image() {
		image.click();
	}


	
	
	public void toastmessage() throws TesseractException {
		ITesseract image=new Tesseract();
		try {
			//image.setDatapath("/home/mounika/eclipse-workspace/Taxishare/TessData");
		String s=image.doOCR(new File("/home/mounika/Desktop/a.png"));
		
		System.out.println("Data from the image is"+s);
		}
		catch(TesseractException e) {
			System.out.println("Execption "+e.getMessage());
		}
		
	}

}
