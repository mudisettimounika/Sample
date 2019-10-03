package com.taxi.driver.pages;

import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.taxi.driver.utils.scrollmethods;

import io.appium.java_client.android.AndroidDriver;

public class signup {
	AndroidDriver<WebElement> driver;

	public signup(AndroidDriver driver) {
		this.driver = driver;
//        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "ae.taxishare.driver:id/et_name")
	public WebElement name;

	@FindBy(id = "ae.taxishare.driver:id/gender_spinner")
	public WebElement Genderclick;

	@FindBy(xpath = "//android.widget.TextView[contains(@resource-id, 'ae.taxishare.driver:id/name')and @text='Male']")
	public WebElement Gendermale;

	@FindBy(id = "ae.taxishare.driver:id/et_contactno")
	public WebElement contactno;

	@FindBy(id = "ae.taxishare.driver:id/et_email")
	public WebElement email;

	@FindBy(id = "ae.taxishare.driver:id/ll_next")
	public WebElement nextbtn;

	@FindBy(id = "ae.taxishare.driver:id/iv_dropdown")
	public WebElement taxistanddropdown;

	@FindBy(xpath = "//android.widget.TextView[contains(@resource-id,'ae.taxishare.driver:id/tv_taxt_station_name')and @text='madhapur - police station']")
	public WebElement taxistand;

	@FindBy(xpath = "//android.widget.EditText[@text='Car Model']")
	public WebElement carmodel;

	@FindBy(id = "ae.taxishare.driver:id/et_car_no")
	public WebElement carnumber;
	
	@FindBy(id = "ae.taxishare.driver:id/et_password")
	public WebElement pw;
	
	@FindBy(id = "ae.taxishare.driver:id/iv_imagePath")
	public WebElement upload;
	
	@FindBy(xpath="//android.widget.LinearLayout[@index='0']")
	public WebElement recenttap;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id='android:id/title']")
	public WebElement image;
	
	@FindBy(id = "ae.taxishare.driver:id/btn_signup")
	public WebElement signupbtn;
	
	
	@FindBy(id="ae.taxishare.driver:id/et_first")
	public WebElement otp1;
	
	@FindBy(id="ae.taxishare.driver:id/et_second")
	public WebElement otp2;
	
	@FindBy(id="ae.taxishare.driver:id/et_third")
	public WebElement otp3;

	@FindBy(id="ae.taxishare.driver:id/et_fourth")
	public WebElement otp4;

	@FindBy(id="ae.taxishare.driver:id/btn_reset")
	public WebElement submit;
	
//	@FindBy(xpath="//android.widget.LinearLayout[@index='2']")
//	public List<WebElement> otp;
	
	
	public void name() {
		name.sendKeys("kumar");
	}

	public void genderclick() {
		Genderclick.click();
	}

	public void Gendermale() {
		Gendermale.click();
	}

	public void hidekeyboard() {
		// System.out.println("testing");
		driver.hideKeyboard();
	}

	public void contactno()throws InterruptedException {
		contactno.sendKeys(scrollmethods.randomNumber());
	}

	public void email() {
		email.sendKeys(scrollmethods.randomEmail());
	}

	public void nextbtn() {
		nextbtn.click();
	}

	public void taxidropdown() {
		taxistanddropdown.click();
	}

	public void taxistand() {
		taxistand.click();
	}

	public void carmodel() {
		carmodel.sendKeys("testing230");
	}

	public void carnumber() {
		carnumber.sendKeys("Ap04047");
    }
	
	public void password() {
		pw.sendKeys("123456");
    }
	
	public void upload() {
		upload.click();
	}
	
	public void recent() {
		recenttap.click();
	}
	public void image() {
		image.click();
	}
	
	
//	public void waitmethods() {
//		WebDriverWait wait = new WebDriverWait(driver, 20);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("ae.taxishare.driver:id/ll_dropdown")));
//	}
	public void signup() {
		signupbtn.click();
	}
	
//	public void otp() {
//		System.out.println(otp.size());
//		 otp.get(0).sendKeys("1");
//    	 otp.get(1).sendKeys("2");
//    	 otp.get(2).sendKeys("3");
//    	 otp.get(3).sendKeys("4");
//		
//	}
	public void otp1() throws InterruptedException {
		TouchActions ta = new TouchActions(driver);
		ta.singleTap(otp1);
		otp1.sendKeys("1234");
		Thread.sleep(3000);
	}
	
	 public void submit() {
		 submit.click();
		
	}
	
}
