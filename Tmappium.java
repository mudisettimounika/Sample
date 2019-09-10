package mounika;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Tmappium {
	static AndroidDriver<MobileElement> driver;
   @BeforeTest
  private void pub() throws InterruptedException, MalformedURLException {
	
	DesiredCapabilities dc = new DesiredCapabilities();
	  // for all permissions
		dc.setCapability("autoGrantPermissions", true);
		// dc.setCapability(MobileCapabilityType.APP, f.getAbsolutePath());
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		//dc.setCapability("noReset", true);

		// dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.1.1");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability("appPackage", "com.tvisha.troopmessenger");
		dc.setCapability("appActivity", "com.tvisha.troopmessenger.activity.SplashScreenActivity");
		//dc.setCapability("unicodeKeyboard", true);
//		dc.setCapability("resetKeyboard", true);
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
		//driver.startRecordingScreen();
		driver.findElement(By.id("com.tvisha.troopmessenger:id/userId")).sendKeys("mounika.mudisetti@tvisha.in");
		driver.findElement(By.id("com.tvisha.troopmessenger:id/password")).sendKeys("mounika@T123");
		Thread.sleep(1000);
		driver.findElement(By.id("com.tvisha.troopmessenger:id/submitImg")).click();
		Thread.sleep(9000);
		
		
	}
	@Test
	private void Search() throws InterruptedException {
          driver.findElement(By.id("com.tvisha.troopmessenger:id/fabsearchChat")).click();
		Thread.sleep(200);
		String name="Mounika";
       driver.findElement(By.xpath("//android.widget.EditText[@text='Search']")).sendKeys(name);
       List<MobileElement> p= driver.findElements(By.id("com.tvisha.troopmessenger:id/userName"));
    		  for(int i=0; i<=p.size(); i++) {
    			  String s=p.get(i).getText();
    			  System.out.println("------>"+s);
    			  s=s.replace(" ", "");
    			  if(s.equalsIgnoreCase("Me")) {
    				  p.get(i).click();
    				  break;
    				  
    				  
    				  
    				  
    			  }
    			  }
    		  
    		  
    		   
      }
	
   
   @Test
	private void selectelement() {
	
	  
   
	
}

	
}

