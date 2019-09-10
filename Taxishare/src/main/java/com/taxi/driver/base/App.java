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

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;

	// private final static String APP_PACKAGE_NAME = "ae.taxishare.driver";
	// private final static String APP_ACTIVITY_NAME =
	// "ae.taxishare.driver.activities.MenuActivity";

	@BeforeTest
	public void baseclass() throws MalformedURLException {

		htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/test-output/Unread_messages_search.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Tvisha tech");
		extent.setSystemInfo("Environment", "Automation Testing");
		extent.setSystemInfo("User Name", "MOUnika");

		htmlReporter.config().setDocumentTitle("Extent report");
		htmlReporter.config().setReportName("Taxi share");

		// htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
		// dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");

		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "92011639ac06c34b");
//		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
//		dc.setCapability(MobileCapabilityType.BROWSER_NAME, "");	
		dc.setCapability("appPackage", "ae.taxishare.user");
		dc.setCapability("appActivity", "ae.taxishare.user.HomeActivity");
		// dc.setCapability("appPackage", "ae.taxishare.driver");
		// dc.setCapability("appActivity",
		// "ae.taxishare.driver.activities.MenuActivity");
		dc.setCapability("noReset", true);
		dc.setCapability("autoGrantPermissions", true);

		driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), dc);
		System.err.println(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	/*
	 * @AfterMethod // public void pub() {
	 * 
	 * public void passtest() { logger = extent.createTest("passtest");
	 * Assert.assertTrue(true); logger.log(Status.PASS,
	 * MarkupHelper.createLabel("test case passed is pass test",
	 * ExtentColor.GREEN)); }
	 * 
	 * public void failtest() { logger = extent.createTest("Failtest");
	 * Assert.assertTrue(true); logger.log(Status.FAIL,
	 * MarkupHelper.createLabel("test case failed is failed test",
	 * ExtentColor.RED)); }
	 * 
	 * public void skipinfo() { logger = extent.createTest("skiptest"); throw new
	 * SkipException("Skipping - This is not ready for testing "); }
	 * 
	 * private void getresult(ITestResult result) {
	 * 
	 * if (result.getStatus() == ITestResult.FAILURE) { // logger.log(Status.FAIL,
	 * "Test Case Failed is "+result.getName()); // MarkupHelper is used to display
	 * the output in different colors logger.log(Status.FAIL,
	 * MarkupHelper.createLabel(result.getName() + " - Test Case Failed",
	 * ExtentColor.RED)); logger.log(Status.FAIL,
	 * MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed",
	 * ExtentColor.RED)); } else if (result.getStatus() == ITestResult.SKIP) { //
	 * logger.log(Status.SKIP, "Test Case Skipped is "+result.getName());
	 * logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() +
	 * " - Test Case Skipped", ExtentColor.ORANGE)); }
	 * 
	 * }
	 * 
	 * }
	 */
	/*
	 * @AfterTest public void htmlClose() {
	 * System.out.println("============Scenario completed===========");
	 * 
	 * sr.stopRecording(); //driver.close(); //
	 * System.err.println("recording stopped"); extentReport.flush();
	 * System.out.println("Execution Done!!!");
	 * 
	 * 
	 * }
	 */

	/*
	 * @AfterMethod public void getResult(ITestResult result) throws IOException,
	 * InterruptedException { if (result.getStatus() == ITestResult.FAILURE) {
	 * 
	 * System.err.println("recording stopped"); extentTest.log(Status.INFO,
	 * "<video width=\"320\" height=\"240\" controls>\n" +
	 * "  <source src=\"./mp4Result/" +"testvideo"+ sr.videoName +
	 * "\" type=\"video/mp4\">\n" + "Your browser does not support the video tag.\n"
	 * + "</video>");
	 * extentTest.addScreenCaptureFromPath(getScreenshot(driver,test));
	 * Thread.sleep(2000); // MarkupHelper is used to display the output in
	 * different colors extentTest.log(Status.FAIL,
	 * MarkupHelper.createLabel(result.getName() + " - Test Case Failed",
	 * ExtentColor.RED));
	 * 
	 * } else if (result.getStatus() == ITestResult.SKIP) {
	 * extentTest.log(Status.SKIP, MarkupHelper.createLabel(result.getName() +
	 * " - Test Case Skipped", ExtentColor.ORANGE)); extentTest.log(Status.SKIP,
	 * MarkupHelper.createLabel(result.getThrowable() + " - Test Case Skipped",
	 * ExtentColor.ORANGE)); } else if (result.getStatus() == ITestResult.SUCCESS) {
	 * 
	 * extentTest.log(Status.PASS, MarkupHelper.createLabel(result.getName() +
	 * " - Test Case Passed", ExtentColor.GREEN)); Thread.sleep(1300);
	 * 
	 * 
	 * extentTest.log(Status.INFO, "<video width=\"320\" height=\"240\" controls>\n"
	 * + "  <source src=\"./mp4Result/" +"testvideo"+ sr.videoName +
	 * "\" type=\"video/mp4\">\n" + "Your browser does not support the video tag.\n"
	 * + "</video>");
	 * 
	 * } }
	 * 
	 * 
	 * private String getScreenshot(WebDriver driver, String screenshotName) throws
	 * IOException { String dateName = new
	 * SimpleDateFormat("yyyyMMddhhmmss").format(new Date()); TakesScreenshot ts =
	 * (TakesScreenshot) driver; File source = ts.getScreenshotAs(OutputType.FILE);
	 * // after execution, you could see a folder "FailedTestsScreenshots" // under
	 * src folder String destination = System.getProperty("user.dir") +
	 * "/FailedTestsScreenshots/" + screenshotName + dateName + ".png"; File
	 * finalDestination = new File(destination); FileUtils.copyFile(source,
	 * finalDestination); return destination;
	 */
}
