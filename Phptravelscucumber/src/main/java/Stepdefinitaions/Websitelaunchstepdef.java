package Stepdefinitaions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Websitelaunchstepdef {

	WebDriver d;
	
	@Given("^User is in home page$")
	public void user_is_in_home_page() {
		WebDriverManager.chromedriver().setup();
		WebDriver d=new ChromeDriver();
		d.get("https://phptravels.com/");
		d.manage().window().maximize();
		}
	
	@When("^Click on services drop down$")
	public void Click_on_services_drop_down() throws InterruptedException {
		WebElement k=d.findElement(By.xpath("//div[@class=\"popover-wrapper js-popover-dropdown popover-wrapper--dropdown\"])[4]"));
				k.click();
		Thread.sleep(2000);
		}
	
	@Then("^Click on providers option$")
	public void Click_on_providers_option() {
	d.findElement(By.xpath("//div[@class=\"popover popover--right\"])[8]/div/ul/li[5]//a[@href='https://phptravels.com/providers/']")).click();

	}
}
