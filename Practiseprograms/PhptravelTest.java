package Practiseprograms;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.IllegalFormatException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PhptravelTest {
	
	@Test(dataProvider="Providerslist",priority=0)
	public void test(HashMap<String, String> hash) throws InterruptedException {
		System.out.println("Testing");
		System.out.println("data --->"+hash.get("Providers"));
		
		String data=hash.get("Providers");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://phptravels.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);

		WebElement l = driver.findElement(
				By.xpath("(//div[@class=\"popover-wrapper js-popover-dropdown popover-wrapper--dropdown\"])[4]"));
		l.click();
		Thread.sleep(200);
		driver.findElement(By.xpath(
				"(//div[@class=\"popover popover--right\"])[8]/div/ul/li[5]//a[@href='https://phptravels.com/providers/']"))
				.click();

	//	JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		//js.executeScript("window.scrollBy(0,1000)");

		// driver.findElement(By.xpath("(//div[@class=\"partnerbox\"])[10]//img")).click();

		List<WebElement> k = driver.findElements(By.xpath("//div[@class=\"partnerbox\"]"));
		System.out.println(k.size());

		// k.get(4).click();
		
		for (int i = 0; i <k.size(); i++) {

			String str = driver.findElement(By.xpath("(//div[@class='partnerbox'])[\"+1+\"]/p/strong")).getText();
			//System.out.println(k.get(i).getText());
			if (data.equals(str)) {
				k.get(i).click();
			} else {
				System.out.println("Not matched");
			}

		}

	}
	
	
	
	@DataProvider
	public Object[][] Providerslist() throws IllegalFormatException, InvalidFormatException, IOException {
		return GetExcelData.getData("/home/mounika/Desktop/Example.xlsx","Sheet2");
	}
	


}
