package com.taxi.user.pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Twousers.Mainclass;
import io.appium.java_client.android.AndroidDriver;

public class AddDepartingFlight {

	AndroidDriver<WebElement> driver;

	public AddDepartingFlight(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//android.widget.TextView[@text='To Airport']")
	public WebElement Toairport;

	// @FindBy(xpath="//android.widget.ImageView[contains(@resource-id,'ae.taxishare.user:id/plusImage')]")
	@FindBy(xpath = "//android.widget.ImageButton[contains(@resource-id,'ae.taxishare.user:id/plusButton')]")
	public WebElement Addbutton;

	@FindBy(id = "ae.taxishare.user:id/travel_date_tv")
	public WebElement dateclick;

	@FindBy(xpath = "//android.view.View[@text='7']")
	public WebElement traveldate;

	@FindBy(xpath = "//android.widget.Button[@text='OK']")
	public WebElement okbtn;

	@FindBy(id = "ae.taxishare.user:id/travel_time_tv")
	public WebElement timeclick;

	@FindBy(id = "android:id/radial_picker/")
	public List<WebElement> time;

	// @FindBy(className="//android.widget.RadialTimePickerView$RadialPickerTouchHelper")
	// public List<WebElement> timeList;

	// @FindBy(xpath="//android.widget.RadialTimePickerView$RadialPickerTouchHelper[@index='10']")
	// public List<WebElement> timeList;

	@FindBy(xpath = "//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc='1']")
	public WebElement Timelist1;

	@FindBy(xpath = "android.widget.RadialTimePickerViewRadialPickerTouchHelper")
	public List<WebElement> timeselect;

	@FindBy(xpath = " //android.widget.TimePicker/android.widget.LinearLayout/android.view.View/android.widget.RadialTimePickerViewRadialPickerTouchHelper")
	public List<WebElement> timeLst;

	
	@FindBy(id="ae.taxishare.user:id/match_before_date_tv")
	public WebElement Matchbeforedate;
	
	@FindBy(id="android:id/button1")
	public WebElement matchdateokbtn;
	
	@FindBy(id="ae.taxishare.user:id/match_before_time_tv")
	public WebElement matchtime;
	
	@FindBy(xpath="//android.view.View[@resource-id='android:id/radial_picker']/*[@index='10']")
	public WebElement selectmatchhourstime;
	
	@FindBy(xpath="//android.view.View[@resource-id='android:id/radial_picker']/*[@index='4']")
	public WebElement selectmatchsectime;

	@FindBy(id="android:id/button1")
	public WebElement matchtimeokbtn;
	
	
	@FindBy(id="ae.taxishare.user:id/genderSpinner")
	 public WebElement preference;
	
	@FindBy(xpath="//android.widget.CheckedTextView[@text='Female']")
	public WebElement female;
	
	@FindBy(xpath="//android.widget.TextView[@text='Post it']")
	public WebElement postit;
	
	
	@FindBy(xpath="android.widget.TextView[@resource-id='ae.taxishare.user:id/okay_tv']")
	public WebElement Okaybtn;
	
	public void Toairport() {
		Toairport.click();
	}

	public void Addbutton() {
		Addbutton.click();
	}

	public void dateclick() {
		dateclick.click();
	}

	public void traveldate() {
		traveldate.click();
	}

	public void okbtn() {
		okbtn.click();
	}

	public void timeclick() {
		timeclick.click();
	}
//	public void traveltime() {
//		traveltime.click();
//	}

	public void date() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

		String myDate = format.format(new Date());
		System.out.println("todaydate is :" + myDate);
	}

	public void timehoursselect() throws InterruptedException {
		driver.findElement(By.xpath("//android.view.View[@resource-id='android:id/radial_picker']/*[@index='10']"))
				.click();
		}

	public void timesecselect() {
		driver.findElement(By.xpath("//android.view.View[@resource-id='android:id/radial_picker']/*[@index='1']")).click();
	}
	 
	public void timeokbtn() {
		driver.findElement(By.id("android:id/button1")).click();
		}
	public void matchbeforedate() {
		Matchbeforedate.click();
	}
	 public void matchdateokbtn() {
		 matchdateokbtn.click();
		}
	 
	 public void matchtime() {
		 matchtime.click();
	}
	  public void selectmatchhourstime() {
		  selectmatchhourstime.click();
		}
	  
	  public void selectmatchsectime() {
		  selectmatchsectime.click();
		}
	  public void matchtimeokbtn() {
		  matchtimeokbtn.click();
		}
	  public void preference() {
		  preference.click();
		}
	  public void genderselect() {
		  female.click();
		}
	  public void postit() {
		  postit.click();
	}
	  public void okaybtn() {
		  Okaybtn.click();
		
	}
	  
	  
}
