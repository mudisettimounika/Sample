package com.taxi.user.pages;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
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
import io.github.bonigarcia.wdm.WebDriverManager;

public class Abcd {
	WebDriver driver;
	public static ExtentHtmlReporter htmlReport;
	public static ExtentReports extentReport;
	public static ExtentTest extentTest;
	public static ExtentColor color;

	@BeforeSuite
	public void before() throws MalformedURLException {
		htmlReport = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/test-output/User1Extentreport\" + \".html");
		extentReport = new ExtentReports();
		extentReport.attachReporter(htmlReport);
		htmlReport.config().setReportName("gmail");
		htmlReport.config().setDocumentTitle("Gmailapplication");
		htmlReport.config().setTheme(Theme.STANDARD);
		extentReport.setSystemInfo("Environment", "Automation Testing");
		extentReport.setSystemInfo("Username", "Mounika");

	}
	/*
	 * @BeforeClass public void pub() throws MalformedURLException {
	 * DesiredCapabilities cap = new DesiredCapabilities();
	 * cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	 * cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
	 * cap.setCapability(MobileCapabilityType.DEVICE_NAME, "MZKVA6VW8L4HHEMN");
	 * cap.setCapability(MobileCapabilityType.NO_RESET, true);
	 * //cap.setCapability(MobileCapabilityType.UDID, udid); //
	 * cap.setCapability(MobileCapabilityType.APP, "taxi.apk");
	 * 
	 * cap.setCapability("appPackage", "ae.taxishare.user");
	 * cap.setCapability("appActivity", "ae.taxishare.user.HomeActivity");
	 * cap.setCapability("autoLaunch", true); cap.setCapability("unicodeKeyboard",
	 * true); cap.setCapability("resetKeyboard", true);
	 * cap.setCapability("autoGrantPermissions", true);
	 * 
	 * driver = new AndroidDriver<WebElement>(new
	 * URL("http://127.0.0.1:4727/wd/hub"), cap);
	 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); }
	 */
	
	
	@Test
	private void nuujuty() {
		System.out.println("testing");
		extentTest=extentReport.createTest("Selection for testing");
		System.out.println("dfsfsfsfsdv");

	}
	
	private void getresult(ITestResult result) {

 		if (result.getStatus() == ITestResult.FAILURE) {
 			// logger.log(Status.FAIL, "Test Case Failed is "+result.getName());
 			// MarkupHelper is used to display the output in different colors
 			extentTest.log(Status.FAIL,
 					MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
 			extentTest.log(Status.FAIL,
 					MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
 		} else if (result.getStatus() == ITestResult.SKIP) {
 			// logger.log(Status.SKIP, "Test Case Skipped is "+result.getName());
 			extentTest.log(Status.SKIP,
 					MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
 		}

 	}
	@AfterSuite
	public static void endreport() {
 		extentReport.flush();
 	}

	
}
