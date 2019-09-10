package com.taxi.driver.test;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentEmailReporter;
import com.taxi.driver.base.App;
import com.taxi.driver.pages.LoginPage;
import com.taxi.driver.pages.signup;
import com.taxi.driver.utils.scrollmethods;

public class Signuptest extends App {
	@Test
	private void logintest() throws Exception {
		
		logger=extent.createTest("SignUp functionality");
		LoginPage t = new LoginPage(driver);
		 t.username();
		Thread.sleep(2000);
		 t.Password();
		 t.hidekeyboard();
		 t.loginbtn();
	//	t.createaccount();

	}

//	@Test
//	private void signuptest() throws Exception {
//		signup s = new signup(driver);
//		s.name();
//		s.hidekeyboard();
//		Thread.sleep(1000);
//		s.genderclick();
//		Thread.sleep(1000);
//		s.Gendermale();
//		s.contactno();
//		s.hidekeyboard();
//       Thread.sleep(1000);
//		s.email();
//		s.hidekeyboard();
//		s.nextbtn();
//		// s.waitmethods();
//		Thread.sleep(5000);
//		s.taxidropdown();
//		Thread.sleep(5000);
//		System.out.println("++++abcds+++++");
//		s.taxistand();
//		Thread.sleep(500);
//		s.carmodel();
//		s.hidekeyboard();
//       Thread.sleep(500);
//		s.carnumber();
//		s.hidekeyboard();
//		s.password();
//		Thread.sleep(2000);
//		s.hidekeyboard();
//		s.upload();
//		Thread.sleep(1000);
//        s.recent();
//        Thread.sleep(2000);
//		s.image();
////s.waitmethods();
//		//s.signup();
//
////       s.otp();
//
//		System.out.println("sssss");
//		Thread.sleep(3000);
//
//		s.otp1();
//		System.out.println("otp");
//
////		 s.otp2(); 
////		 s.otp3(); 
////		 s.otp4();
//		System.out.println("otp=" + 1234);
//		Thread.sleep(500);
//
//		s.submit();
//
//	}

}
