package stepDefinition;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepsDeal {

	WebDriver driver = null;

	@Given("^Open the browser and application should be lunched$")
	public void open_the_browser_and_application_should_be_lunched() {
		System.setProperty("webdriver.chrome.driver", "..\\CucumberTest\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://freecrm.com/");
		driver.manage().window().maximize();

	}

	@When("^User will enter the username and password$")
	public void user_will_enter_the_username_and_password(DataTable dtcredetials) {

		for (Map<String, String> data : dtcredetials.asMaps(String.class, String.class))

		{
			driver.findElement(By.xpath("//li//a[text()='Login']")).click();
			WebDriverWait wait = new WebDriverWait(driver, 40);
			WebElement userid = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='email']")));
			userid.sendKeys(data.get("username"));
			WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
			password.sendKeys(data.get("password"));
			driver.findElement(By.xpath("//div[text()='Login']")).click();

		}

	}

	@Then("^User should reach on home page$")
	public void user_should_reach_on_home_page() {
		String title = driver.getTitle();
		Assert.assertEquals("CRM", title);

	}

	@Then("^User should click the deal page and create the new deal$")
	public void user_should_click_the_deal_page_and_create_the_new_deal(DataTable dtDeals) throws InterruptedException 
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Deals']")).click();
		driver.findElement(By.xpath("//button[text()='New']")).click();
	   for(Map<String, String> deals :  dtDeals.asMaps(String.class, String.class)) 
	   {
		    JavascriptExecutor js =(JavascriptExecutor)driver;

			driver.findElement(By.name("title")).sendKeys(deals.get("title"));  
			driver.findElement(By.name("amount")).sendKeys(deals.get("amount"));
			driver.findElement(By.name("probability")).sendKeys(deals.get("probability"));
			driver.findElement(By.name("next_step")).sendKeys(deals.get("next_step"));
			Thread.sleep(6000);
		    driver.findElement(By.xpath("//button[text()='Save']")).click();
		    driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		    driver.findElement(By.xpath("//span[text()='Contacts']")).click();
		    driver.findElement(By.xpath("//span[text()='Deals']")).click();
		    WebElement web = driver.findElement(By.xpath("//button[text()='New']"));
		    js.executeScript("arguments[0].click();", web);//using js for clicking the button
		    //driver.findElement(By.xpath("//button[text()='New']")).click();
		   

	}
	}
}

	// @Then("^Verify that deal is created sucessfully$")
	// public void verify_that_deal_is_created_sucessfully()
	// {
	//
	// }
	//
	// @Then("^Close the browser$")
	// public void close_the_browser() {
	//
	// }


