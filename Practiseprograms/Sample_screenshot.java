package Practiseprograms;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample_screenshot {
	public static ExtentHtmlReporter htmlReport;
	public static ExtentReports extentReport;
	public static ExtentTest extentTest;
	public static ExtentColor color;

	WebDriver driver;
	
	@BeforeSuite
	public void extentreport() {
		htmlReport = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/test-output/SamplescreensshotExtentreport\" + \".html");
		extentReport = new ExtentReports();
		extentReport.attachReporter(htmlReport);
		htmlReport.config().setReportName("User");
		htmlReport.config().setDocumentTitle("Extent Report");
		htmlReport.config().setTheme(Theme.STANDARD);
		extentReport.setSystemInfo("Environment", "Automation Testing");
		extentReport.setSystemInfo("Username", "Mounika");

		//extentTest = extentReport.createTest(" Upload Profile ");
		
	}
	
	

	@Test
	public void screenshot() throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		extentTest=extentReport.createTest("Driver initialized successfully");
 		extentTest.log(Status.PASS, MarkupHelper.createLabel("success", ExtentColor.BLUE));
 		
 		driver.get("https://www.guru99.com/maven-jenkins-with-selenium-complete-tutorial.html");
		
		extentTest=extentReport.createTest("Website Launched");
 		extentTest.log(Status.PASS, MarkupHelper.createLabel("success", ExtentColor.GREEN));
		driver.manage().window().maximize();
		extentTest=extentReport.createTest("Website Maximized");
 		extentTest.log(Status.PASS, MarkupHelper.createLabel("success", ExtentColor.ORANGE));
		Thread.sleep(2000);
		
		
		File g=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(g, new File("/home/mounika/Desktop/test1.png"));
		
		extentTest=extentReport.createTest("Screenshot Captured");
 		extentTest.log(Status.PASS, MarkupHelper.createLabel("success", ExtentColor.INDIGO));	   
 		extentReport.flush();
	}

}
