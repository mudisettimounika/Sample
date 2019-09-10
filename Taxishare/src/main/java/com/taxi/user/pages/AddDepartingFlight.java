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

import io.appium.java_client.android.AndroidDriver;

public class AddDepartingFlight  {
	
	AndroidDriver driver;
	 
	public AddDepartingFlight(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
   @FindBy(xpath="//android.widget.TextView[@text='To Airport']")
   public WebElement Toairport;
   
   
   //@FindBy(xpath="//android.widget.ImageView[contains(@resource-id,'ae.taxishare.user:id/plusImage')]")
  @FindBy(xpath="//android.widget.ImageButton[contains(@resource-id,'ae.taxishare.user:id/plusButton')]")
   public WebElement Addbutton;
	
   
   @FindBy(id="ae.taxishare.user:id/travel_date_tv")
   public WebElement dateclick;
   
   @FindBy(xpath="//android.view.View[@text='7']")
   public WebElement traveldate;
   
   @FindBy(xpath="//android.widget.Button[@text='OK']")
   public WebElement okbtn;
   
   @FindBy(id="ae.taxishare.user:id/travel_time_tv")
   public WebElement timeclick;
   
   
   
  @FindBy(id="android:id/radial_picker/")
   public List<WebElement>time;
   
  // @FindBy(className="//android.widget.RadialTimePickerView$RadialPickerTouchHelper")
  // public List<WebElement> timeList;
   
  // @FindBy(xpath="//android.widget.RadialTimePickerView$RadialPickerTouchHelper[@index='10']")
   //public List<WebElement> timeList;
   
   
   @FindBy(xpath="//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc='1']")
    public WebElement Timelist1;
     
     @FindBy(xpath="android.widget.RadialTimePickerViewRadialPickerTouchHelper")
     public List<WebElement>timeselect;
     
     @FindBy(xpath=" //android.widget.TimePicker/android.widget.LinearLayout/android.view.View/android.widget.RadialTimePickerViewRadialPickerTouchHelper")
     public List<WebElement> timeLst;
     
    // /hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout
    

   public void Toairport() {
	   Toairport.click();
}
	public void Addbutton() {
		Addbutton.click();
	}

	public void  dateclick() {
		dateclick.click();
	}

	public void  traveldate() {
		traveldate.click();
	}

	public void  okbtn() {
		okbtn.click();
	}
	
	public void timeclick() {
		timeclick.click();
	}
//	public void traveltime() {
//		traveltime.click();
//	}
	
	
	public void date() {
		SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd",Locale.getDefault());

		String myDate = format.format(new Date());
		System.out.println("todate is :"  +myDate);
		}

	public void timeselect() throws InterruptedException {
		//WebDriverWait wt=new WebDriverWait(10);
		//wt.until(e)
		//Timelist1.click();
		
		Thread.sleep(3000);
	//System.out.println(timeLst.size());
	List<WebElement> lst=driver.findElements(By.xpath("//android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.TimePicker/android.widget.LinearLayout/android.view.View/android.widget.RadialTimePickerViewRadialPickerTouchHelper"));
	//List<WebElement> lst=driver.findElements(By.className("android.widget.RadialTimePickerViewRadialPickerTouchHelper"));
		
		 int i=timeLst.size(); 
		 System.out.println("sasfsf -----?"+i);
		 //String str=timeLst.get() for
		 
	//timeLst.get(3).click();
		}
	

	
	
}
