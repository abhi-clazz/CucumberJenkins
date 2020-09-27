package demo;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class NewTest {
	WebDriver driver;
	String driverPath="C:\\Users\\ABHI\\Desktop\\chromedriver.exe";
	String testUrl="https://opensource-demo.orangehrmlive.com/";
  @Test(dataProvider = "dp")
  public void f(String n, String s) throws InterruptedException {
	  
		driver.findElement(By.xpath("//*[@id='txtUsername']")).sendKeys(n);
		driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys(s);
		driver.findElement(By.xpath("//*[@id='btnLogin']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='welcome']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='welcome-menu']/ul/li[2]/a")).click();
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "Admin", "admin123" },
      new Object[] { "linda.anderson", "linda.anderson" },
    };
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver",driverPath);
		driver=new ChromeDriver();
		driver.navigate().to(testUrl);
		driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.close();
  }

}
