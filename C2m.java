package mounika;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Driver;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class C2m {
	WebDriver driver;

	@Test
	public void homescreen() throws InterruptedException {
		// System.out.println("login");
		driver.findElement(By.id("nkU7VrZLmRvyiHeb")).sendKeys("Mounika.Mudisetti@tvisha.in");
		driver.findElement(By.id("qd04okQbOI9rJvVA")).sendKeys("12345678");
		Thread.sleep(200);
		driver.findElement(By.id("BomCfwW8zEGqPNOh")).click();
	}

	@Test(priority = 1, dataProvider = "agentData")
	private void exceldata(String Name, String Email, String Selectproperty, String Setpermissions)
			throws InterruptedException {
		// System.out.println("settings");
		System.out.println(Name + " " + Email + " " + Selectproperty + " " + Setpermissions + " ");

		// driver.findElement(By.xpath("//a[@href='/settings']")).click();
		driver.findElement(By.xpath("//*[@id=\"right-panel\"]/div/div[1]/div/a[3]/div")).click();
		Thread.sleep(200);
		// agent
		//driver.findElement(By.xpath("//a[@href='#agent']")).click();
		driver.findElement(By.xpath("//*[@id=\"right-panel\"]/div/div[3]/div[1]/ul/li[2]/a")).click();
		Thread.sleep(2000);

		
		// add agent button
		driver.findElement(By.id("addAgentButton")).click();

		driver.findElement(By.xpath(
				"//input[@class='poppins-light font-12 px-3 py-2 border w-100 rounded btn-outline-0 agent_name ']"))
				.sendKeys(Name);
		driver.findElement(By.xpath(
				"//input[@class='poppins-light font-12 px-3 py-2 border w-100 rounded btn-outline-0 agent_email']"))
				.sendKeys(Email);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='property-select-box']/div[2]/div")).click();
		Thread.sleep(3000);


		
		String d=Selectproperty; 
		 String[] values = d.split(",");
		  for (int k=0; k < values.length; k++) 
		  {
			  Thread.sleep(2000);
		List<WebElement> propertyMenu = driver.findElements(By.xpath("//div[@class='ms-res-ctn dropdown-menu']/div"));
		System.out.println(propertyMenu.size());
		  Thread.sleep(2000);

//		  System.out.println("excel value"+values[k]);
		  for(int i=0;i<propertyMenu.size();i++)
		  {
			  System.out.println("excel"+values[k]+">>>"+propertyMenu.get(i).getText());
		  if (values[k].matches((propertyMenu.get(i).getText())))	
		  {
			  System.out.println("clicking"+ " " +propertyMenu.get(i).getText());
			  propertyMenu.get(i).click();
			  Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='property-select-box']/div[2]/div")).click();
           break;
           
           
		  }
		  }
		  }

     List<WebElement> per = driver.findElements(By.xpath("//select[@class='poppins-light font-12 px-3 py-2 border w-100 rounded btn-outline-0 user_role']/option"));
		Thread.sleep(100);
		System.out.println("--->>dasdasdfasd");
		for (int i = 0; i < per.size(); i++) {
			String st = per.get(i).getText();
			System.out.println("---->" + st);
			if (st.equalsIgnoreCase("Agent")) {
				System.out.println("---->");
				per.get(i).click();
				System.out.print("ghj");

			}
		}
//for save button 
		WebElement l=driver.findElement(By.id("YWRkX2FnZW50"));
		l.click();
		}


	@BeforeClass
	public void login() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://testing.click2magic.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@DataProvider(name = "agentData")
	public Object[][] loginData() {
		Object[][] arrayObject = getExcelData("/home/mounika/Desktop/Property.xlsx", "Sheet1");
		return arrayObject;
	}



	/**
	 * @param File  Name
	 * @param Sheet Name
	 * @return
	 */
	public String[][] getExcelData(String fileName, String sheetName) {
		String[][] arrayExcelData = null;
		try {
			String Filepath = "/home/mounika/Desktop/Property.xlsx";

			FileInputStream file = new FileInputStream(Filepath);

			FileInputStream fs = new FileInputStream(fileName);

			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sh = workbook.getSheet("Sheet1");
			XSSFRow row = sh.getRow(0);

			int totalNoOfRows = sh.getLastRowNum();
			// int totalNoOfCols = sh.getRow(0).getPhysicalNumberOfCells();
			int totalNoOfCols = row.getLastCellNum();

			arrayExcelData = new String[totalNoOfRows - 1][totalNoOfCols];

			for (int i = 1; i < totalNoOfRows; i++) {

				for (int j = 0; j < totalNoOfCols; j++) {
    arrayExcelData[i - 1][j] = sh.getRow(i).getCell(j).getStringCellValue();

				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayExcelData;
	}

//  @AfterClass
//  public void afterClass() {
//	  driver.close();
//  }
	
	
	//agent heading
	//driver.findElement(By.xpath("//*[@id=\"right-panel\"]/div/div[3]/div[1]/ul/li[2]/a")).click();
     //add aegnt button 
	//driver.findElement(By.id("addAgentButton")).click();

	
	

}
