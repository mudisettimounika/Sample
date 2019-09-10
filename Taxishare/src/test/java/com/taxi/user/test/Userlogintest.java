package com.taxi.user.test;

import org.testng.annotations.Test;

import com.taxi.driver.base.App;
import com.taxi.user.pages.AddDepartingFlight;
import com.taxi.user.pages.Userloginpage;

public class Userlogintest extends App {
	@Test(priority = 0)
	private void userlogin() throws Exception {
		Userloginpage k = new Userloginpage(driver);
		Thread.sleep(2000);
		k.username();
		k.hidekeyboard();
		Thread.sleep(3000);
		k.password();
		Thread.sleep(3000);
		k.hidekeyboard();
     k.loginbtn();

	
	}

	@Test(priority = 1)
	private void AddDepartingFlight() throws InterruptedException {
		AddDepartingFlight m = new AddDepartingFlight(driver);
		Thread.sleep(6000);
        m.Toairport();
		Thread.sleep(2000);
		m.Addbutton();
		Thread.sleep(2000);
		m.dateclick();
		Thread.sleep(2000);
		//m.traveldate();
		//Thread.sleep(1000);
		m.date();
        Thread.sleep(2000);
        m.okbtn();
        m.timeclick();
        Thread.sleep(2000);
        
        //m.traveltime();
        m.timeselect();
        
        
	
	
	}

}
