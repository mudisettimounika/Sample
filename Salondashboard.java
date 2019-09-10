package Salon_web_Reg;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Salondashboard {
	public WebDriver driver;

	public Salondashboard(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//tr/td[2]/div/a")
	private WebElement salon;

	
	@FindBy(xpath = "//input[@id='day5']/../label")
	private WebElement friday;

	@FindBy(id = "shiftStart51")
	private WebElement shiftStrattime;

	@FindBy(xpath = "//div[contains(@class,'hours')]//div[text()='9']")
	private WebElement Mrng9;

	@FindBy(xpath = "//div[contains(@class,'minutes')] //div[text()='00']")
	private WebElement minutes;

	@FindBy(id = "shiftEnd51")
	private WebElement shiftEndtime;

//	@FindBy(xpath="(//div[contains(@class,'hours')]//div[text()='9'])[2]")
//	private WebElement evening21;
//	
//	@FindBy(xpath="(//div[contains(@class,'minutes')] //div[text()='00'])[2]")
//	private WebElement eveningminutes;

	@FindBy(xpath = "(//div[contains(@class,'hours')]//div[text()='21'])[2]")
	private WebElement closinghours;

	@FindBy(xpath = "(//div[contains(@class,'minutes')] //div[text()='00'])[2]")
	private WebElement closingminutes;

	@FindBy(xpath = "(//button[contains(@class, 'add-more')] )[5]")
	private WebElement addmore;

	
	@FindBy(id="basicInfoSubmitBtn")
	private WebElement save;

	public void salon() {
		salon.click();
	}

	public void scrolldown() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(3000);
	}

	
	public void friday() throws InterruptedException {
		friday.click();
	}

	public void shiftStarttime() throws InterruptedException {
		shiftStrattime.click();
	}

	public void Mrng9() throws InterruptedException {
		Mrng9.click();
	}

	public void minutes() {
		minutes.click();
	}

	public void shiftEndtime() throws InterruptedException {
		shiftEndtime.click();
		Thread.sleep(1000);
	}

//	 public void evening21() {
//		 evening21.click();
//	 }
//
//	 public void eveningminutes() {
//		 eveningminutes.click();
//	 }

	public void closinghours() {
		closinghours.click();
	}

	public void closingminutes() {
		closingminutes.click();
	}

	public void addmore() throws InterruptedException {
		for (int i = 0; i < 2; i++) {
			System.out.println(i);
			addmore.click();
			Thread.sleep(2000);
		}

		
//		String[] starttime = { "12", "30", "18", "45", "20", "20" };
//
//		String[] endtime = { "17", "10", "19", "25", "21", "20" };
//
//		/*
//		 * String[] starttime = { "12", "30" };
//		 * 
//		 * String[] endtime = { "17", "30" };
//		 */
//		int increment;
//		//int j=0;
//		int k=0;
//		for (int i = 0; i < starttime.length; i=i+2) {
//			System.out.println("value of k"+k);
//			increment = 51 + k;
//			Thread.sleep(3000);
//			driver.findElement(By.id("shiftStart" + increment)).click();
//			Thread.sleep(1000);
//			selectstartTime(starttime[i], starttime[i + 1], i);
//			Thread.sleep(500);
//			driver.findElement(By.id("shiftEnd" + increment)).click();
//			selectEndTime(endtime[i], endtime[i + 1], i+1);
//			//j=j+2;
//			k=k+1;
//			
//			
//
//			
//		}
//	}
//
//	public void selectstartTime(String hours, String minutes, int startorEnd) throws InterruptedException {
//		int start=startorEnd + 1;
////		driver.findElement(
////				By.xpath("(//div[contains(@class,'hours')]//div[text()='" + hours + "'])[" + startorEnd + 1 + "]"))
////				.click();
//		
//		
//		driver.findElement(
//				By.xpath("(//div[contains(@class,'hours')]//div[text()='" + hours + "'])["+start+"]"))
//				.click();
//		Thread.sleep(1000);
//		driver.findElement(
//				By.xpath("(//div[contains(@class,'minutes')]//div[text()='" + minutes + "'])[" + start+"]"))
//				.click();
//
//	}
//
//	public void selectEndTime(String hours, String minutes, int startorEnd) throws InterruptedException
//
//	{
//		int start=startorEnd + 1;
//		driver.findElement(
//				By.xpath("(//div[contains(@class,'hours')]//div[text()='" + hours + "'])[" + start+ "]"))
//				.click();
//		Thread.sleep(1000);
//		driver.findElement(
//				By.xpath("(//div[contains(@class,'minutes')]//div[text()='" + minutes + "'])[" + start + "]"))
//				.click();
//	}
		
	String [] abcd= {"10", "00", "13", "00", "18", "00"};
	String [] xyz= {"12", "20", "17", "30", "19", "00"};
	int k=0;
	int increment;
	for (int i = 0; i < abcd.length; i=i+2) {
		
		increment=51+k;
		System.out.println("value of k"+k);
		Thread.sleep(2000);
		driver.findElement(By.id("shiftStart" + increment)).click();
	    firstslottime(abcd[i], abcd[i+1], i);
	    Thread.sleep(1000);
		driver.findElement(By.id("shiftEnd" + increment)).click();
       secondtimeslot(xyz[i], xyz[i+1], i+1);
	    k=k+1;
		
	    
	    
	    
	    
	}	
	
	}
	
	
	
	
		 public void firstslottime(String hours, String minutes, int slotvalue) throws InterruptedException {
			 
			 int start=slotvalue+1;
			 driver.findElement(By.xpath("(//div[contains(@class,'hours')]//div[text()='" +hours+ "'])[" +start+ "]")).click();
			 Thread.sleep(1000);
		   driver.findElement(By.xpath("(//div[contains(@class,'minutes')]//div[text()='" +minutes+ "'])[" +start+ "]")).click();

		 }
		   
		 
        public void secondtimeslot(String hours, String minutes, int slotvalue) throws InterruptedException {
			 
			 int start=slotvalue+1;
			 driver.findElement(By.xpath("(//div[contains(@class,'hours')]//div[text()='" +hours+ "'])[" +start+ "]")).click();
			  Thread.sleep(1000);
		   driver.findElement(By.xpath("(//div[contains(@class,'minutes')]//div[text()='" +minutes+ "'])[" +start+ "]")).click();

		
        }
		
		public void savebtn() throws InterruptedException {
			Thread.sleep(1000);
			save.click();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
        
		
		
		
	}

	

