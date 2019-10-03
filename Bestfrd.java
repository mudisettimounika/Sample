package com.taxi.driver.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Bestfrd extends mounika {
	@Test
	public void execute() throws InterruptedException {
		
		Thread.sleep(5000);
		driver.findElement(By.partialLinkText("Sign in")).click();
		//WebElement k=driver.findElement(By.xpath("(//a[@href='https://accounts.google.com/AccountChooser?service=mail&continue=https://mail.google.com/mail/'])[1]"));
		Thread.sleep(5000);
       System.out.println("++++abcd++++"); 
       
		
	
}

}
