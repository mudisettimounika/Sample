package Practiseprograms;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Takescreenshotmethod_multipletimes {
	
	WebDriver driver;

		@Test
		public void screenshot() throws IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		Takescreenshotmethod_multipletimes.capturescreenshot(driver);

		driver.get("https://cucumber.io/");
		
		Takescreenshotmethod_multipletimes.capturescreenshot(driver);
		driver.manage().window().maximize();
		Takescreenshotmethod_multipletimes.capturescreenshot(driver);
//		
//       File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//     //  FileUtils.copyFile(f, new File("./Screenshot/cucumber.png"));
//       FileUtils.copyFile(f, new File("/home/mounika/Desktop/Screenshots/abcd.png"));
    
		
		
			
		}
		
		
	public static void capturescreenshot(WebDriver driver) throws IOException {
		
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
		FileUtils.copyFile(f, new File("/home/mounika/Desktop/Screenshots/"+System.currentTimeMillis()+ ".png"));
		}
		catch (IOException e) {
       System.out.println(e.getMessage());		
       }
	}
	

}
