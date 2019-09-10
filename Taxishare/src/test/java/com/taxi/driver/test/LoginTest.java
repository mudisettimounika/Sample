package com.taxi.driver.test;

import org.testng.annotations.Test;

import com.taxi.driver.base.App;
import com.taxi.driver.pages.LoginPage;


public class LoginTest extends App {

	
	
	@Test
	private void logintest() throws Exception {
		LoginPage t = new LoginPage(driver);
		//t.username();
		Thread.sleep(2000);
		//t.Password();
		//t.loginbtn();
		t.createaccount();
		
		

	}

}
