package mounika;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.record.DimensionsRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class HorizontalSwiping {
	static AndroidDriver<MobileElement> driver;

//	@Test
//	private void launch() throws MalformedURLException, InterruptedException {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		// File f = new File("tm_app_debug.apk");
		DesiredCapabilities dc = new DesiredCapabilities();
		

		// for all permissions
		dc.setCapability("autoGrantPermissions", true);
		// dc.setCapability(MobileCapabilityType.APP, f.getAbsolutePath());
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		// dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.1.1");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		
		
		dc.setCapability("appPackage", "com.tvisha.troopmessenger");
		dc.setCapability("appActivity", "com.tvisha.troopmessenger.activity.SplashScreenActivity");
		dc.setCapability("noReset", true);
//		dc.setCapability("unicodeKeyboard", true);
//		dc.setCapability("resetKeyboard", true);
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.startRecordingScreen();
		
//		driver.findElement(By.id("com.tvisha.troopmessenger:id/userId")).sendKeys("mounika.mudisetti@tvisha.in");
//		driver.findElement(By.id("com.tvisha.troopmessenger:id/password")).sendKeys("mounika@T123");
//		Thread.sleep(1000);
//		driver.findElement(By.id("com.tvisha.troopmessenger:id/submitImg")).click();
//		Thread.sleep(9000);
		
		WebElement banner = driver.findElement(By.xpath("//android.widget.TextView[@text='Raghu Sambari is not a member anymore']"));
		
		 Point bannerPoint=banner.getLocation();
		 Dimension size=driver.manage().window().getSize();
		 int startx=Math.toIntExact(Math.round(size.getWidth()*0.9));
		 int endx=0;
		 TouchAction action=new TouchAction(driver);
		 action.press(PointOption.point(startx, bannerPoint.getY()))
		 .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
		 .moveTo(PointOption.point(endx, bannerPoint.getY())).release();
		 driver.performTouchAction(action);
		 
//		String l=driver.stopRecordingScreen();
//		System.out.println(l);
		
		 
		 
		
	
	}
	//android.widget.LinearLayout[@index='1']
	// @Test
	// private void login() throws InterruptedException {


//		public static void swipeHorizontal(WebDriver driver, double startPercentage, double finalPercentage, double anchorPercentage, int duration) throws Exception {
//	        Dimension size = driver.manage().window().getSize();
//            int anchor = (int) (size.height * anchorPercentage);
//	        int startPoint = (int) (size.width * startPercentage);
//	        int endPoint = (int) (size.width * finalPercentage);
//	        new TouchAction(driver).press(startPoint, anchor).waitAction(Duration.ofMillis(duration)).moveTo(endPoint, anchor).release().perform();
//	    }

	WebElement username = driver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']"));

//		TouchActions t = new TouchActions(driver);
//		t.flick(username, 1, 10, 10);
//		t.perform();
	
	
	
	
//	Point bannerPoint = banner.getLocation();
//	// Get size of device screen
//	Dimension screenSize = driver.manage().window().getSize();
//	// Get start and end coordinates for horizontal swipe
//	int startX = Math.toIntExact(Math.round(screenSize.getWidth() * 0.8));
//	int endX = 0;
//
//	TouchAction action = new TouchAction(driver);
//	action.press(PointOption.point(startX, bannerPoint.getY()))
//			.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
//			.moveTo(PointOption.point(endX, bannerPoint.getY())).release();
//	driver.performTouchAction(action);

}
