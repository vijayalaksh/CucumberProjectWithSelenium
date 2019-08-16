package stepDefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepslogin {
	WebDriver driver = null;
	
	
	@Given("^Open the chrome browser and application should be lunched$")
	public void open_the_chrome_browser_and_application_should_be_lunched()  {
		System.setProperty("webdriver.chrome.driver", "..\\CucumberTest\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://freecrm.com/");
		driver.manage().window().maximize();
	}

	@When("^Enter the \"(.*)\" and \"(.*)\"$")
	public void enter_the_Username_and_Password(String Username , String Password)  
	{
		driver.findElement(By.xpath("//span[text()='Log In']")).click(); 	
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement userid = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='email']")));
		userid.sendKeys(Username);
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(Password);
		driver.findElement(By.xpath("//div[text()='Login']")).click();
		
	   
	}

	@Then("^User should be reach on home page$")
	public void user_should_be_reach_on_home_page()  
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		String sName =driver.getTitle();
		System.out.println(sName);
	    Assert.assertEquals("CRM", sName);
	    //driver.close();
	}
	
	@Then("^Before adding a new contact delete the if it is already exists$")
	public void Check_Duplicat_Contact()
	{
		
		
		driver.findElement(By.xpath("//span[text()='Contacts']")).click();	
		List<String> duplicateUser = new ArrayList<String>();
		List<WebElement> tr = driver.findElements(By.xpath("//table//tbody//tr"));
		System.out.println(tr.size());
		for (int i = 1; i <= tr.size(); i++) 
		{
			WebElement User = driver.findElement(By.xpath("(//table//tbody//tr["+ i +"]//td)[2]"));
			String userName =User.getText().trim();
			if(duplicateUser.size()!=0)
			{
				if(duplicateUser.contains(userName))
				{
					driver.findElement(By.xpath("//tr["+i+"]//td//button//i[@class='trash icon']")).click();
					driver.findElement(By.xpath("//button[text()='Delete']")).click();
					
				}
				
			}
			else
			{
			duplicateUser.add(userName);
			}
								
		}

	}
	
	@Then("^Create a new contact with \"(.*)\" and \"(.*)\" and add rating and event for contact$")
	public void Add_rating_and_event_for_contact(String sFirstName,String sLastName)
	{
		driver.findElement(By.xpath("//button[text()='New']")).click();	
		driver.findElement(ByName.name("first_name")).sendKeys(sFirstName);
		driver.findElement(ByName.name("last_name")).sendKeys(sLastName);
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		driver.findElement(By.xpath("//div[@class='ui star rating']//i[@aria-posinset=4]")).click();
		driver.findElement(By.xpath("//a//button//i[@class='calendar icon']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(ByName.name("title")));
		driver.findElement(ByName.name("title")).sendKeys("AugustBash");
		driver.findElement(By.xpath("//div[@name='category']")).click();
		driver.findElement(By.xpath("//div[@name='category']//div//span[text()='Private']")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//i[@class='trash icon']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//i[@class='remove icon']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='New']")));
		driver.findElement(By.xpath("//button[text()='New']")).click();
		driver.findElement(By.xpath("//span[text()='Contacts']")).click();
		
		
	}
	
	
	
	

}
