package com.taxi.user.pages;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Twousers.Mainclass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestRakesh {

	AndroidDriver<WebElement> driver;
	
	@Test
	public void test() throws MalformedURLException {
		Mainclass m = new Mainclass("FINZQSEE6DTOGUIF", "4720", "vivo", "user1", "", "");
//		Mainclass m = new Mainclass("emulator-5554", "4720", "moto", "user1");
		//Mainclass m = new Mainclass("9fe06a407d14", "4720", "moto", "user1");
		
		//ZZ2222NML3
		driver = m.cap();
		Userone s=new Userone(driver);
		s.fromdropdown();
		s.fromlocation();
		s.todropdown();
		s.tolocation();
		s.broadcastbtn();
		
		s.paynowbtn();

	}
}
	

