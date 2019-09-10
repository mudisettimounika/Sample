package com.taxi.driver.test;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.taxi.driver.base.VideoClass;

public class VideoExtentReport {

	WebDriver driver;
	public static ExtentHtmlReporter htmlReport;
	public static ExtentReports extentReport;
	public static ExtentTest extentTest;
	public static ExtentColor color;
	
	
	String k="Testscreenshot";
	VideoClass sr;
	
	@BeforeSuite
	public void pub() {
		htmlReport=new ExtentHtmlReporter(System.getProperty(("user.dir") + "/test-output/ExtentReport_Ver_3.html"));
		extentReport=new ExtentReports();
		extentReport.attachReporter(htmlReport);
		htmlReport.config().setReportName("Gmail");
		htmlReport.config().setDocumentTitle("Gmailtitle");
		 htmlReport.config().setTheme(Theme.STANDARD);

			htmlReport.config().setDocumentTitle("Extent report");
			htmlReport.config().setReportName("TimeDynamo");
			
		 extentReport.setSystemInfo("HostName", "tvisha-desktop");
		 extentReport.setSystemInfo("Filename", "Gmail");

	}
	@BeforeTest
	public void webStart() throws MalformedURLException {
		sr=new VideoClass();
		sr.startRecording("testvideo");
		extentTest=extentReport.createTest("Application_Launch");
		
		
	
	}
}
