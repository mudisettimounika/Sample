package Com.taxi.user.base;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.taxi.user.pages.Userloginpage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Userbaseclass {
	public static ExtentHtmlReporter htmlReport;
	public static ExtentReports extentReport;
	public static ExtentTest extentTest;
	public static ExtentColor color;

	public AndroidDriver<WebElement> driver;

	@BeforeSuite
	public void extentreport() {
		System.out.println("Extent report");
		htmlReport = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/test-output/ProfileImageExtentreport\" + \".html");
		extentReport = new ExtentReports();
		extentReport.attachReporter(htmlReport);
		htmlReport.config().setReportName("User");
		htmlReport.config().setDocumentTitle("Extent Report");
		htmlReport.config().setTheme(Theme.STANDARD);
		extentReport.setSystemInfo("Environment", "Automation Testing");
		extentReport.setSystemInfo("Username", "Mounika");

		extentTest = extentReport.createTest(" Upload Profile ");
	}

	@BeforeTest
	public void userlogin() throws MalformedURLException, InterruptedException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "FINZQSEE6DTOGUIF");
		// dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.1.1");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		// dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

		dc.setCapability("appPackage", "ae.taxishare.user");
		dc.setCapability("appActivity", "ae.taxishare.user.HomeActivity");
		dc.setCapability("noReset", true);
		dc.setCapability("autoGrantPermissions", true);
		dc.setCapability("unicodeKeyboard", true);
		dc.setCapability("resetKeyboard", true);
		driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

}
