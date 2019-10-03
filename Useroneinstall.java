package com.taxi.user.pages;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Twousers.Mainclass;
import io.appium.java_client.android.AndroidDriver;

public class Useroneinstall implements Runnable {
	AndroidDriver driver;

	public void run() {
//		Mainclass m=new Mainclass("9fe06a407d14","4723", "Redmi", "user1");
		Mainclass m = new Mainclass("MZKVA6VW8L4HHEMN", "4720", "moto", "user1", "","");

		try {
			driver = m.cap();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		Userone s = new Userone(driver);
		s.fromdropdown();
		s.fromlocation();
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		s.todropdown();
		s.tolocation();
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		s.broadcastbtn();

		Mainclass.isFirstBrodcasted = true;

//	while(true)
//
//		{
//		if (Mainclass.isSeconUserDone) {
//			s.paynowbtn();
//			//driver.findElement(By.xpath("//android.widget.TextView[@text='Pay Now']")).click();			
//		}
//	}

	}

}
