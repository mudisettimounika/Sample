package com.taxi.driver.utils;

import java.util.Random;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.HasOnScreenKeyboard;
import io.appium.java_client.HidesKeyboard;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class scrollmethods {
	public static String randomNumber() {
		String  s="1234567890";
		StringBuilder sb=new StringBuilder();
		Random r=new Random();
		while (sb.length() < 9) {
			int index=(int) (r.nextFloat()*s.length());
			sb.append(s.charAt(index));
		}
		String str=sb.toString();
	    return "9"+str;
	    }
	
	public static String randomEmail() {
		String letters="abcdefghijklmnopqrstuvwxyz";
		StringBuilder lb=new StringBuilder();
		Random letter=new Random();
		while (lb.length()<10) {
			int index2=(int)(letter.nextFloat()*letters.length());
			lb.append(letters.charAt(index2));
					}
		String email=lb.toString();
		return "mounika@"+ email + ".com";
	
	
	}

}
