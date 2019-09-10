package mounika;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Cities {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		 driver= new ChromeDriver();
		driver.get("http://52.45.197.229:4000");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("jaysuryahyd@zoho.com");
		 Thread.sleep(200);
		 driver.findElement(By.xpath("//input[@type='password']")).sendKeys("12345678");
		 Thread.sleep(1000);

		 driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/div/div/div[2]/div[2]/button")).click();
		 Thread.sleep(1000);
		 driver.manage().window().maximize();
		 Thread.sleep(2000);
          driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[1]/div/ul/li[2]/a")).click();
 		 Thread.sleep(2000);
           File f=new File("//home//mounika//Desktop//mounika.xlsx");
          FileInputStream fis = new FileInputStream(f);
          XSSFWorkbook workbook = new XSSFWorkbook(fis); 
          XSSFSheet sheet = workbook.getSheetAt(0);
         // System.out.println("data from excel "+ value1);
          Thread.sleep(300);
//          String value2=sheet.getRow(1).getCell(1).getStringCellValue();
//          System.out.println("data from excel "+ value2); 
         // workbook.close();
          
          int j=0;
         // driver.findElement(By.name("city_name")).sendKeys(value1);
          System.out.println(sheet.getLastRowNum());
        for(int i=1;i<sheet.getLastRowNum()+1;i++){
        	System.out.println(i);
        	Thread.sleep(3000);
         driver.findElement(By.cssSelector("#root > div.wrapper > div.main-panel > div.contentvthbtn > div.row.mx-0.justify-content-between > div:nth-child(2) > button")).click();
          String value1=sheet.getRow(i).getCell(j).getStringCellValue();
          System.out.println(value1); 
          Thread.sleep(3000);
        driver.findElement(By.name("city_name")).sendKeys(value1);
         Thread.sleep(2000);
    	 driver.findElement(By.cssSelector("#addTableModal > div > div > form > div.modal-footer.clearfix.d-block > button")).click();
         Thread.sleep(5000);
         }
        System.out.println("end of the loop");
        
        
        
        
        
        
        
         
        
     // int j=0;
          
      //  int k= sheet.getLastRowNum();
     //    System.out.println(k);
    //     for(int i1=0; i<k; i++) {
//          String valuen=sheet.getRow(i).getCell(1).getStringCellValue();
//            System.out.println("data from excel "+ valuen); 
 }
          //sheet.getRow(0).getCell(0).getStringCellValue()
}
         // }


	



