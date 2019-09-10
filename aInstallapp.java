package testtroopM_A;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;


public class aInstallapp {
	
	
//	AndroidDriver<AndroidElement> driver;
	static AndroidDriver<MobileElement> driver;
	
	public	static ExtentHtmlReporter htmlReporter;
	public	static ExtentReports extent;
	public	static ExtentTest logger;
	
	String videoName;
	ScreenRecorder sr;
	
	@BeforeTest
	
	public void installapp() throws MalformedURLException, InterruptedException{
		
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/Unread_messages_search.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Tvisha tech");
		extent.setSystemInfo("Environment", "Automation Testing");
		extent.setSystemInfo("User Name", "Rishisri");

		htmlReporter.config().setDocumentTitle("Extent report");
		htmlReporter.config().setReportName("Troop Messenger Android");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		
		File f=new File("src");		
	    File fr=new File(f,"tmtestnew.apk");
	 	DesiredCapabilities capa=new DesiredCapabilities();
//	 	capa.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator1");
		capa.setCapability(MobileCapabilityType.DEVICE_NAME, "rishi");
		capa.setCapability("autoGrantPermissions", "true");
		capa.setCapability("waitForAppScript", "true");
//	    cap.setCapability("platformName",Constant.appPlatform);
		capa.setCapability(MobileCapabilityType.APP, fr.getAbsolutePath());
		capa.setCapability("unicodeKeyboard", true);
		capa.setCapability("resetKeyboard", true);
		capa.setCapability("appPackage", "com.tvisha.troopmessenger");
		capa.setCapability("appActivity", "com.tvisha.troopmessenger.activity.SplashScreenActivity");
		capa.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "120");
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),capa);
		capa.setCapability("newCommandTimeout",120);
  	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  	    
	}

	/*@BeforeSuite
	public void main1() throws MalformedURLException, InterruptedException{
		File f=new File("src");
		//File fr=new File(f,"APK Info_v1.2.11_apkpure.com.apk");
		File fr=new File(f,"troop09-07.apk");
		DesiredCapabilities capa=new DesiredCapabilities();
		//capa.setCapability(MobileCapabilityType.DEVICE_NAME, "Rishiemulator");
		capa.setCapability(MobileCapabilityType.DEVICE_NAME, "Device");
		capa.setCapability("autoGrantPermissions", "true");
		capa.setCapability("waitForAppScript", "true");
		// cap.setCapability("platformName",Constant.appPlatform);
		capa.setCapability(MobileCapabilityType.APP, fr.getAbsolutePath());
		//capa.setCapability("unicodeKeyboard", true);
		//capa.setCapability("resetKeyboard", true);
		
		capa.setCapability("appPackage", "com.tvisha.troopmessenger");
		//capa.setCapability("appActivity", "com.tvisha.troopmessenger.activity.chat.recent.MainActivity");
		//capa.setCapability("", value);
		//capa.setCapability("appWaitActivity", "com.tvisha.troopmessenger.activity.chat.recent.MainActivity");
		//capa.setCapability("resetKeyboard", true);
		capa.setCapability("appActivity","com.tvisha.troopmessenger.activity.login.login.LoginActivity");

		//capa.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "25");
	//	driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),capa);
		
	//	 capa.setCapability("newCommandTimeout",60);
		
	   Thread.sleep(3000);
	}
	*/
	
	@BeforeMethod
	public void executeBeforeMethod() throws InterruptedException {
		sr = new ScreenRecorder();
		sr.startRecording("testvideo");
		System.err.println("recording started");
	}

	@AfterMethod
	public void getResult(ITestResult result) throws InterruptedException {
		System.out.println("after method===============");
			if (result.getStatus() == ITestResult.FAILURE) {
				Thread.sleep(2000);
				sr.stopRecording();
				System.err.println("recording stopped");
				logger.log(Status.INFO,
					"<video width=\"320\" height=\"240\" controls>\n" + "  <source src=\"./mp4Result/" +"testvideo"+ sr.videoName
							+ "\" type=\"video/mp4\">\n" + "Your browser does not support the video tag.\n"
							+ "</video>");
			
			
	// MarkupHelper is used to display the output in different colors
				logger.log(Status.FAIL,
						MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
				logger.log(Status.FAIL,
						MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			} else if (result.getStatus() == ITestResult.SKIP) {
				logger.log(Status.SKIP,
						MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
				logger.log(Status.SKIP,
						MarkupHelper.createLabel(result.getThrowable() + " - Test Case Skipped", ExtentColor.ORANGE));
			}else if (result.getStatus() == ITestResult.SUCCESS) {
				logger.log(Status.PASS,
						MarkupHelper.createLabel(result.getName() + " - Test Case Passed", ExtentColor.GREEN));
				Thread.sleep(1300);
				sr.stopRecording();

				System.err.println("recording stopped");
				logger.log(Status.INFO,
						"<video width=\"320\" height=\"240\" controls>\n" + "  <source src=\"./mp4Result/" +"testvideo"+ sr.videoName
						+ "\" type=\"video/mp4\">\n" + "Your browser does not support the video tag.\n"
						+ "</video>");
			}
	
		}

	@AfterTest
	public void endReport() {
	 //driver.close();
	 extent.flush();
	}
	
	
	
}
