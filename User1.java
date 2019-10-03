package com.taxi.user.pages;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;

import Twousers.Mainclass;
import io.appium.java_client.android.AndroidDriver;

public class User1 implements Runnable {
	AndroidDriver<WebElement> driver;

	public void run() {
		//FINZQSEE6DTOGUIF
		//
		Mainclass k = new Mainclass("MZKVA6VW8L4HHEMN", "4723", "VIVO", "user1", "ae.taxishare.user", "ae.taxishare.user.HomeActivity");
		try {
			driver = k.cap();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		if (Mainclass.isfindpassengers) {

			Findtaxi f = new Findtaxi(driver);
			f.findtaxi();

			f.Broadcastbtn();
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (Mainclass.gotoFindtaxitab = true) {
				f.Okay();
				System.exit(0);

			}
		}
	}
}
