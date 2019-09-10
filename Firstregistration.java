package Salon_web_Reg;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.github.javafaker.Faker;

import net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.ForAbstractMethod;

public class Firstregistration{
	public WebDriver driver;
	Select s;
    public Firstregistration(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
    @FindBy(id="mobileNumberInput")
	private WebElement mobilenumber; 
    @FindBy( id="checkMobileBtn")
    private WebElement nextbtn;
    @FindBy(xpath="//input[@type='number']")
    private List<WebElement> otp;
   @FindBy(id="verifyOtpBtn")
   private WebElement verifyotpnextbtn;
   
   @FindBy(id="registrationFirstNameInput")
   private WebElement Firstname;
    	
   @FindBy(id="registrationLastNameInput")
   private WebElement Lastname;
   
   @FindBy(id="registrationEmailInput")
   private WebElement email;
    
   @FindBy(id="registrationPasswordInput")
   private WebElement password;
          
     @FindBy(id="registrationGenderInput")
     private WebElement Gender;
     
     @FindBy(id="countrySelected")
     private WebElement country;
     
     
     @FindBy(id="registrationBtn")
     private WebElement regnextbtn;
     
     @FindBy(id="salonNameInput")
     private WebElement salonname;
     
     
     @FindBy(id="salonAliasNameInput")
     private WebElement salonAliasName;
     
     @FindBy(id="salonContactNumberInput")
     private WebElement contactnumber;
     
     @FindBy(id="salonAdminEmailInput")
     private WebElement adminemail;
     
//     @FindBy(id="//input[@id='day1']/../label")
//     private WebElement monday;
     
     
     
	
	public void mobilenumber() throws InterruptedException {
		mobilenumber.sendKeys(Utils.randomNumber());
		Thread.sleep(1000);
	}
    
    public void nextbtn() {
    	nextbtn.click();
    }
     public void otp() {
    	 otp.get(0).sendKeys("1");
    	 otp.get(1).sendKeys("2");
    	 otp.get(2).sendKeys("3");
    	 otp.get(3).sendKeys("4");
    	  }
    public void verifyotpnextbtn() {
    	verifyotpnextbtn.click();
    }
    public void Firstname() {
    	Firstname.sendKeys("abcd");
    }
     public void lastname() {
    	 Lastname.sendKeys("XYZ");
     }

    public void email() {
    	email.sendKeys(Utils.randomEmail());
		}
    
    public void password() {
		password.sendKeys("123456");
	}
    
    public void Gender() {
    	s=new Select(Gender);
    	s.selectByVisibleText("female");
	}
    public void coutnry() {
    	s=new Select(country);
    	s.selectByVisibleText("India");
	}
     public void Regnextbn() {
    	 System.out.println("next page");
    	 regnextbtn.click();
	}
 public void salonname() {
	 salonname.sendKeys("jagan");
	 }
 public void salonaliasname() {
	 salonAliasName.sendKeys("ys");
	
}
     public void contactnumber() {
    	 contactnumber.sendKeys(Utils.randomNumber());		
	}
     
    public void adminemail() {
    	adminemail.sendKeys(Utils.randomEmail());
		}
    
    
//    public void scrolldown() throws InterruptedException {
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//		Thread.sleep(3000);
//	}

    
//    public void monday() {
//     monday.click();		
//	}
    
    
    String []a = {"10", "00"};
    String []b= {"21",  "00" };
     
    
    public void selecttimgs() throws InterruptedException {
    	//int k=0;
    	
    	int j=0;
    	int inc;
    	for(int i=0; i<7; i++) {
    		inc=11+j;
    		//System.out.println(k);
    		Thread.sleep(1000);
    	    driver.findElement(By.id("shiftStart" +inc)).click();
    	     starttimings(a[0], a[1], i);
        	Thread.sleep(1000);
    	    driver.findElement(By.id("shiftEnd" +inc)).click();
    	    endtimings(b[0], b[1], i+1);
    	    //k=k+1;
    	    j=j+10;
    	    
    	   if(inc==51) {
    		JavascriptExecutor js = (JavascriptExecutor) driver;
    	   js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    	   Thread.sleep(3000);
    	   
    	   }
        }
	}
    
    
    
    
    public void starttimings(String starttime, String endtime, int startend ) throws InterruptedException {
    	//int slot=startend+1;
    	driver.findElement(By.xpath("//div[contains(@class,'hours')]//div[text()=' " + starttime + "'])[" + 2+  "]"));
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//div[contains(@class,'minutes')]//div[text()=' " + endtime + "'])[" + 2+  "]"));
	}
    public void endtimings(String starttime, String endtime, int startend ) throws InterruptedException {
    	//int slot=startend+1;
    	driver.findElement(By.xpath("//div[contains(@class,'hours')]//div[text()=' " + starttime + "'])[" + 2+  "]"));
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//div[contains(@class,'minutes')]//div[text()=' " + endtime + "'])[" + 2+  "]"));
	
    	}
    
    
    
}
