package Practiseprograms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocator {
	WebDriver driver;
	@Test
	public void locator() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.google.com/intl/en-GB/gmail/about/#");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@href= 'https://accounts.google.com/AccountChooser?service=mail&continue=https://mail.google.com/mail/'])[2]")).click();
	
	}

}
