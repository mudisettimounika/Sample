package com.taxi.driver.pages;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;

import Twousers.Mainclass;
import io.appium.java_client.android.AndroidDriver;

public class Drivermodule  implements Runnable{

	
	AndroidDriver<WebElement>driver;

	public void run() {
		Mainclass k=new Mainclass("FINZQSEE6DTOGUIF", "4720", "Gionee A1", "driver", "ae.taxishare.driver", "ae.taxishare.driver.activities.MenuActivity");
		try {
			driver=k.cap();
		}
		catch(MalformedURLException e) {
			e.printStackTrace();
		}
		
		Driverbroadcast b=new Driverbroadcast(driver);
		b.Findpassengers();
		
		
		Mainclass.isfindpassengers=true;

		
	}
	
}
