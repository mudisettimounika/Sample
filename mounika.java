package com.taxi.driver.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class mounika {
	WebDriver driver;

	String urlTitle = "Gmail - Free Storage and Email from Google";
	public static ExtentHtmlReporter htmlReport;
	public static ExtentReports extentReport;
	public static ExtentTest extentTest;
	public static ExtentColor color;
	
	String test = "testSrcshot";
	VideoClass sr;
	
	@BeforeSuite
	public void extentreport() {
   //htmlReport=new ExtentHtmlReporter("");
		htmlReport=new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/Extentreport\" + \".html");
		extentReport=new ExtentReports();
		extentReport.attachReporter(htmlReport);
		htmlReport.config().setReportName("gmail");
		htmlReport.config().setDocumentTitle("Gmailapplication");
		htmlReport.config().setTheme(Theme.STANDARD);
		extentReport.setSystemInfo("Environment", "Automation Testing");
		extentReport.setSystemInfo("Username", "Mounika");
		
	}
		
	@BeforeTest
	public void extentreport2() {
		sr=new VideoClass();
		sr.startRecording("testvideo");
		extentTest=extentReport.createTest("Launch App");
	      WebDriverManager.chromedriver().setup();
	      driver=new ChromeDriver();
        driver.get("https://www.google.com/intl/en-GB/gmail/about/#");
        driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
		String str=driver.getTitle();
		String title=str.replaceAll(" ", " ");
		System.out.println("title "+ title);
		Assert.assertEquals(title, urlTitle, "Title Not Equals");
		
		if(urlTitle.contentEquals(title)) {
			extentTest.log(Status.INFO,MarkupHelper.createLabel("Application Title Matched ,Tittle is	:"+title, color.BLUE));
		     extentTest.log(Status.PASS,MarkupHelper.createLabel("Application is launched", color.GREEN)); 
		}
		
		else {
			extentTest.log(Status.INFO,MarkupHelper.createLabel("Application Title Not Matched ,Tittle is	:"+title, color.BLUE));
			extentTest.log(Status.INFO,MarkupHelper.createLabel("Application is launched ,Tittle is	:"+title, color.RED));
             }
		
	}
	
	@AfterTest
	public void htmlClose() {
		System.out.println("============Scenario completed===========");

		sr.stopRecording();
		// driver.close();
		System.err.println("recording stopped");
		extentReport.flush();
		System.out.println("Execution Done!!!");

}
	@AfterMethod
	public void getResult(ITestResult result) throws IOException, InterruptedException 
	{
				if (result.getStatus() == ITestResult.FAILURE)
				{
					
					System.err.println("recording stopped");
					extentTest.log(Status.INFO,
									"<video width=\"320\" height=\"240\" controls>\n" + "  <source src=\"./mp4Result/" +"testvideo"+ sr.videoName
											+ "\" type=\"video/mp4\">\n" + "Your browser does not support the video tag.\n"
											+ "</video>");
					extentTest.addScreenCaptureFromPath(getScreenshot(driver,test));
					Thread.sleep(2000);
				// MarkupHelper is used to display the output in different colors
				extentTest.log(Status.FAIL,
				MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
				
				} 
				else if (result.getStatus() == ITestResult.SKIP)
				{
					extentTest.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
					extentTest.log(Status.SKIP,
					MarkupHelper.createLabel(result.getThrowable() + " - Test Case Skipped", ExtentColor.ORANGE));
				}
				else if (result.getStatus() == ITestResult.SUCCESS) 
				{
		
						extentTest.log(Status.PASS,
					MarkupHelper.createLabel(result.getName() + " - Test Case Passed", ExtentColor.GREEN));
					Thread.sleep(1300);
		
		
					extentTest.log(Status.INFO,
									"<video width=\"320\" height=\"240\" controls>\n" + "  <source src=\"./mp4Result/" +"testvideo"+ sr.videoName
											+ "\" type=\"video/mp4\">\n" + "Your browser does not support the video tag.\n"
											+ "</video>");

				}
	}
	
	
	
	private String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		String dateName=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()); 
		TakesScreenshot s=(TakesScreenshot)driver;
			File source=s.getScreenshotAs(OutputType.FILE);
			String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
					+ ".png";
		
		File finalDestination=new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination ;
		
	}
	
	
	
	
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	

