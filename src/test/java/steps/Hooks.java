package steps;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.BaseClass;


public class Hooks extends BaseClass{
	
	  @Before
	  public void setUp() throws Exception{
		  testData = new Properties();
		  testData.load(new FileInputStream(new File(System.getProperty("user.dir")+"/src/test/java/data/TestData.properties")));
		  
		  WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		  //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		  driver.manage().window().maximize();
		  driver.navigate().to(testData.getProperty("App_URL"));
	  }
	  
	  @After
	  public void closeDriver() {
		  driver.quit();
	  }
}