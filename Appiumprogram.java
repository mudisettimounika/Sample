package mounika;

import java.io.File;
import io.appium.java_client.TouchAction;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
//import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Appiumprogram {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AndroidDriver<WebElement> driver;

//		File f=new File("/home/mounika/eclipse-workspace/Selenium/src/app_release.apk");
		File f = new File("app_release.apk");
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.APP, f.getAbsolutePath());
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		//dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.1.1");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability("appPackage", "com.restaurant");
		dc.setCapability("appActivity", "com.restaurant.MainActivity");
		driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), dc); 
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		

		List<WebElement> inputs = driver.findElements(MobileBy.className("android.widget.EditText"));
		inputs.get(0).sendKeys("456789");

		Dimension size = driver.manage().window().getSize();
		Double scrollHeightstart = size.getHeight() * 0.5;
		int scrollstart = scrollHeightstart.intValue();

		Double scrollHeightend = size.getHeight() * 0.2;
		int scrollend = scrollHeightend.intValue();

		TouchAction actions = new TouchAction((MobileDriver) driver)
				.press(PointOption.point(0, scrollstart))
				.moveTo(PointOption.point(0, scrollend)).release().perform();

		inputs.get(1).sendKeys("123456");

		driver.navigate().back();
		
//		TouchAction login=new TouchAction((PerformsTouchActions) driver);
//		login.press(PointOption.point(5, 10)).moveTo(PointOption.point(0, 10)).perform();
		//driver.navigate().back();
//		
	driver.findElement(By.xpath("//android.widget.TextView[@text='Login']")).click();
//           // Thread.sleep(500);
//        driver.findElement(By.xpath("//android.widget.EditText[@index='1']")).sendKeys("rakesh");
//        Thread.sleep(500);
//      driver.findElement(By.xpath("//android.widget.EditText[@index='3']")).sendKeys("A");
//      Thread.sleep(500);
//       WebElement l=driver.findElement(By.xpath("//android.widget.EditText[@index='5']"));
//    		l.sendKeys("3");
//       Thread.sleep(500);
//       Dimension size1= driver.manage().window().getSize();
//	   Double scrollHeightstart1 = size.getHeight() * 0.5;
//	   int scrollstart1 = scrollHeightstart1.intValue();
//
//		Double scrollHeightend1= size.getHeight() * 0.2;
//		int scrollend1 = scrollHeightend.intValue();
//
//		TouchAction actions1 = new TouchAction((MobileDriver) driver)
//				.press(PointOption.point(0, scrollstart))
//				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
//				.moveTo(PointOption.point(0, scrollend)).release().perform();
//       
//       driver.findElement(By.xpath("//android.widget.EditText[@index='7']")).sendKeys("95472555");
//       Thread.sleep(500);
//       
//      driver.findElement(By.xpath("//android.widget.TextView[@text='Book Table']")).click();
		Thread.sleep(500);
		driver.navigate().back();
      driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[1]")).click();
		Thread.sleep(200);

		WebElement l=driver.findElement(By.xpath("//android.widget.TextView[@text='Queue']"));
	    l.click();
       driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[1]/android.widget.ImageView")).click();
	   Thread.sleep(3000);
	   driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[1]")).click();
		Thread.sleep(3000);
		
	   driver.findElement(By.xpath("//android.widget.TextView[@text='Profile'])")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//android.widget.EditText[@text='Email'])")).sendKeys("mounika@gmail.com");
		Thread.sleep(200);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Submit'])")).click();



		}

	
	}

