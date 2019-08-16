package stepDefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Irctc {
	WebDriver driver = null;

	@BeforeClass
	@When("^Launch browser$")
	public void Lunch_browser() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "..\\CucumberTest\\driver\\chromedriver.exe");
		driver = new ChromeDriver(options);
	}

	@Then("^Launch the Irctc site$")
	public void Launch_the_Irctc_site() {
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		boolean popup= driver.findElement(By.xpath("//a[@class='fa fa-window-close pull-right']")).isDisplayed();
		if(popup==true)
		{
			driver.findElement(By.xpath("//a[@class='fa fa-window-close pull-right']")).click();
		}
		

	}

	@Then("^Select the specific calender date$")
	public void Select_the_specific_calender_date() throws InterruptedException {

		
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		String date = "18";

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//span[@class='ng-tns-c14-6 ui-calendar ui-calendar-w-btn']//input")))
				.click();
		WebElement listElement = driver
				.findElement(By.xpath("//table[@class='ui-datepicker-calendar ng-tns-c14-6 ng-star-inserted']"));

		List<WebElement> listtr = listElement.findElements(By.tagName("tr"));

		outerloop: for (int i = 1; i < listtr.size(); i++) {
			List<WebElement> listtd = listtr.get(i).findElements(By.tagName("td"));
			try {
				for (int j = 0; j < listtd.size(); j++) {
					String vals = listtd.get(j).getText();

					if (vals.equals(date)) {
						driver.findElement(By.xpath("//table//tr[" + i + "]//td[" + (j + 1) + "]")).click();
						driver.findElement(By.xpath("//div//button[text()='Find trains']")).click();
						break outerloop;
					}
				}
			} catch (Exception e)

			{
				System.out.println(e.getMessage());
			}

		}

	}

	

	@Then("^Provide From and To stations and find trains$")
	public void StationsDetails() throws InterruptedException {
		WebElement frStation = driver.findElement(By.xpath("//input[@placeholder='From*']"));

		frStation.sendKeys("Dur");
		Thread.sleep(5000);

		WebElement fromStation = driver.findElement(By.xpath(
				"//ul[@class='ui-autocomplete-items ui-autocomplete-list ui-widget-content ui-widget ui-corner-all ui-helper-reset ng-star-inserted']"));
		Thread.sleep(3000);

		List<WebElement> lstFromStations = fromStation.findElements(By.tagName("li"));
		for (WebElement webElementfrm : lstFromStations) {

			String[] sFromStations = webElementfrm.findElement(By.tagName("span")).getText().trim().split("-");

			if (sFromStations[0].trim().equals("DURG")) {
				Thread.sleep(3000);
				webElementfrm.click();
				break;

			}

		}
		WebElement toStation = driver.findElement(By.xpath("//input[@placeholder='To*']"));
		toStation.sendKeys("Mum");
		Thread.sleep(3000);
		WebElement tostation = driver.findElement(By.xpath(
				"//ul[@class='ui-autocomplete-items ui-autocomplete-list ui-widget-content ui-widget ui-corner-all ui-helper-reset ng-star-inserted']"));
		List<WebElement> lstToStations = tostation.findElements(By.tagName("li"));
		for (WebElement webElementTo : lstToStations) {

			String[] sToStations = webElementTo.findElement(By.tagName("span")).getText().trim().split("-");
			if (sToStations[1].trim().equals("MMCT")) {
				webElementTo.click();
				break;

			}

		}

	}
	
	@Then("^Track the train$")
	public void Track_the_train() throws InterruptedException
	{
		WebElement menu = driver.findElement(By.xpath("//a[text()=' TRAINS ']"));
		Actions action = new Actions(driver);
		Action mousetomove =  action.moveToElement(menu).build();
		mousetomove.perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//li//a//span[text()='Train Schedule'])[1]")).click();
		driver.findElement(By.name("trainNumberInput")).sendKeys("");;
		
	}


	@Then("^Login into the site$")
	public void login_into_the_site() {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text() = ' LOGIN ']")));
		WebElement ele=driver.findElement(By.xpath("//a[text() = ' LOGIN ']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);

	}

	@Then("^Enter username and password$")
	public void enter_username_and_password() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("userId")).sendKeys("Neelu0226");
		driver.findElement(By.id("pwd")).sendKeys("Tarun9826");
		driver.findElement(By.id("nlpAnswer")).sendKeys("redBus");
		driver.findElement(By.xpath("//button[text()='SIGN IN']")).click();
	}

	@Then("^Click on the login button$")
	public void click_on_the_login_button() {

	}

	@AfterClass
	@Then("^Close the browser$")
	public void close_the_browser() {
		//driver.close();
	}
	
	@Then("^Javascript method for calender$")
	public void Javascript_method_for_calender() {
		boolean popup = driver.findElement(By.xpath("(//div[@class='ui-dialog-content ui-widget-content']//a)[1]"))
				.isDisplayed();
		System.out.println(popup);
		if (popup == true) {
			driver.findElement(By.xpath("(//div[@class='ui-dialog-content ui-widget-content']//a)[1]")).click();
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement dateInput = driver.findElement(By.xpath(
				"//input[@class='ng-tns-c14-6 ui-inputtext ui-widget ui-state-default ui-corner-all ng-star-inserted']"));
		//DateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		// dateformat.Date date = new Date();
		String date1 = "17-08-2019";// dateformat.format(date);
		js.executeScript("arguments[0].value='" + date1 + "';", dateInput);

	}
	@Given("^login in irctc website$")
	public void login_in_irctc_website()  {
	    // Write code here that turns the phrase above into concrete actions
	   
	}
}
