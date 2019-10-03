package com.taxi.user.pages;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
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

import Twousers.Mainclass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Dummytwoclass {

	WebDriver driver;
	String urlTitle = "Gmail - Free Storage and Email from Google";
	public static ExtentHtmlReporter htmlReport;
	public static ExtentReports extentReport;
	public static ExtentTest extentTest;
	public static ExtentColor color;

	@BeforeSuite
	public void before() throws MalformedURLException {
		htmlReport = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/test-output/UserExtentreport\" + \".html");
		extentReport = new ExtentReports();
		extentReport.attachReporter(htmlReport);
		htmlReport.config().setReportName("gmail");
		htmlReport.config().setDocumentTitle("Gmailapplication");
		htmlReport.config().setTheme(Theme.STANDARD);
		extentReport.setSystemInfo("Environment", "Automation Testing");
		extentReport.setSystemInfo("Username", "Mounika");

	}

	@BeforeTest
	public void pub() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/intl/en-GB/gmail/about/#");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String str = driver.getTitle();
		String title = str.replaceAll(" ", " ");
		System.out.println("title " + title);
		extentTest = extentReport.createTest("Launch App");
		Assert.assertEquals(title, urlTitle, "Title Not Equals");

	}

	@Test
	public void test() throws InterruptedException {
		extentTest=extentReport.createTest("Sign in");
		driver.findElement(By.partialLinkText("Sign in")).click();
		Thread.sleep(5000);
		System.out.println("++++abcd++++");
	}

	@AfterMethod
	public void getresult(ITestResult result) {

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
	public void close() {
		extentReport.flush();
	}

}
