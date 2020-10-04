package StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Login {
	WebDriver driver;
	@Before
	public void bt()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABHI\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@After
	public void at() throws InterruptedException
	{
		
		Thread.sleep(3000);
		driver.close();
	}
	
	
	@Given("i am able to naviagte on to login page")
	public void i_am_able_to_naviagte_on_to_login_page() {
		driver.get("http://opensource-demo.orangehrmlive.com/");
	    
	}




	@When("i update the username as {string}")
	public void i_update_the_username_as(String string) {
		  driver.findElement(By.id("txtUsername")).sendKeys(string);
	    
	}
	@When("i update the password as {string}")
	public void i_update_the_password_as(String string) {
		  driver.findElement(By.id("txtPassword")).sendKeys(string);
	   
	}
	@When("i Click on the login button")
	public void i_click_on_the_login_button() {
		 driver.findElement(By.id("btnLogin")).click();
		
	  
	}
	@Then("i should see the username as {string}")
	public void i_should_see_the_username_as(String string) throws InterruptedException {
	    Thread.sleep(6000);
	    String expected = driver.findElement(By.id("welcome")).getText();
		   Assert.assertEquals(expected, string);
		   Thread.sleep(3000);
		   driver.findElement(By.id("welcome")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id='welcome-menu']/ul/li[2]/a")).click();
	}

	@Then("i should see the error message  as {string}")
	public void i_should_see_the_error_message_as(String string) throws InterruptedException {
		 Thread.sleep(6000);
		    String expected = driver.findElement(By.xpath("//*[@id='spanMessage']")).getText();
		    Assert.assertEquals(expected, string);
	}
}