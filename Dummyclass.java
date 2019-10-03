package com.taxi.user.pages;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Dummyclass {
	AndroidDriver<WebElement> driver;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;	
	
	 @BeforeTest
	 public void beforetest() {
	//	public AndroidDriver<WebElement> cap() throws MalformedURLException {
	    	 htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/Taxishare\" + \".html");
	 		extent = new ExtentReports();

	 		// htmlReporter.setAppendExisting(true);
	 		extent.attachReporter(htmlReporter);

	 		extent.setSystemInfo("Host Name", "Tvisha tech");
	 		extent.setSystemInfo("Environment", "Live");
	 		extent.setSystemInfo("User Name", "Mounika");
	 		extent.setSystemInfo("Tool used", "Appium");

	 		htmlReporter.config().setDocumentTitle("Taxishare");
	 		htmlReporter.config().setReportName("Share taxi");
	 		//htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
	 		htmlReporter.config().setTheme(Theme.STANDARD);
	 		 }
	
	@Test
	public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.2");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "devicename");
		cap.setCapability(MobileCapabilityType.NO_RESET, true);
		//cap.setCapability(MobileCapabilityType.UDID, udid);
		cap.setCapability(MobileCapabilityType.APP, "/home/mounika/eclipse-workspace/Taxishare/src/main/java/taxi.apk");

		cap.setCapability("appPackage", "ae.taxishare.user");
	    cap.setCapability("appActivity", "ae.taxishare.user.HomeActivity");
		cap.setCapability("autoLaunch", true);
		cap.setCapability("unicodeKeyboard", true);
		cap.setCapability("resetKeyboard", true);
		cap.setCapability("autoGrantPermissions", true);

		driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger=extent.createTest("Launch App");

		driver.findElement(By.id("ae.taxishare.user:id/from_llView")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Chennai International Airport  Terminal 1']")).click();
		
		logger=extent.createTest("Selected fromloation");
}
	 @AfterMethod
	 	private void getresult(ITestResult result) {

	 		if (result.getStatus() == ITestResult.FAILURE) {
	 			// logger.log(Status.FAIL, "Test Case Failed is "+result.getName());
	 			// MarkupHelper is used to display the output in different colors
	 			logger.log(Status.FAIL,
	 					MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
	 			logger.log(Status.FAIL,
	 					MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
	 		} else if (result.getStatus() == ITestResult.SKIP) {
	 			// logger.log(Status.SKIP, "Test Case Skipped is "+result.getName());
	 			logger.log(Status.SKIP,
	 					MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
	 		}

	 	}
	     
	     @AfterTest
	 	public void endreport() {
	 		extent.flush();
	 	}
	
}
