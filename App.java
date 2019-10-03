package com.taxi.driver.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
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

public class App {

	public AndroidDriver driver;

	public static ExtentHtmlReporter htmlReport;
	public static ExtentReports extentReport;
	public static ExtentTest extentTest;
	public static ExtentColor color;

	@BeforeSuite
	public void extentreport() {
		System.out.println("Extent report");
		htmlReport = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/test-output/MenuExtentreport\" + \".html");
		extentReport = new ExtentReports();
		extentReport.attachReporter(htmlReport);
		htmlReport.config().setReportName("Driver");
		htmlReport.config().setDocumentTitle("Extent Report");
		htmlReport.config().setTheme(Theme.STANDARD);
		extentReport.setSystemInfo("Environment", "Automation Testing");
		extentReport.setSystemInfo("Username", "Mounika");

		extentTest = extentReport.createTest(" Menu Options ");
	}

	@BeforeTest
	public void baseclass() throws MalformedURLException {

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
		// dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "FINZQSEE6DTOGUIF");
//		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		dc.setCapability("appPackage", "ae.taxishare.user");
		dc.setCapability("appActivity", "ae.taxishare.user.HomeActivity");
		dc.setCapability("appPackage", "ae.taxishare.driver");
		dc.setCapability("appActivity", "ae.taxishare.driver.activities.MenuActivity");
		dc.setCapability("noReset", true);
		dc.setCapability("autoGrantPermissions", true);
		dc.setCapability("unicodeKeyboard", true);
		dc.setCapability("resetKeyboard", true);

		driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), dc);
		System.err.println(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

}
