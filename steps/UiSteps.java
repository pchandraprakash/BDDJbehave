package steps;

import java.util.concurrent.TimeUnit;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UiSteps extends Steps {
	static WebDriver driver;

	@Given("User is on Home page")
	public void user_is_on_Home_page() {
		driver = new ChromeDriver();
		String baseUrl = "https://learn.letskodeit.com/p/practice";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@When("User enters UserName and Password")
	public void user_enters_UserName_and_Password() {
		driver.findElement(By.xpath(".//a[@href='/sign_in']")).click();
		driver.findElement(By.id("user_email")).sendKeys("test@email.com");
		driver.findElement(By.id("user_password")).sendKeys("abcabc");
	}

	@When("Clicks on Login button")
	public void clicks_on_Login_button() throws InterruptedException {
		driver.findElement(By.name("commit")).click();
		Thread.sleep(5000);
	}

	@Then("He can vist the practice page")
	public void he_can_vist_the_practice_page() throws Throwable {
		String title = driver.getTitle();
		System.out.println("Welcome to " + title);
		System.out.println("Login Successful and practice page is displayed");
		driver.findElement(By.linkText("All Courses")).click();
		Thread.sleep(3000);
	}

	@When("Clicks on User icon")
	public void clicks_on_User_icon() throws Throwable {
		driver.findElement(By.xpath(".//li[@class='dropdown']")).click();
		Thread.sleep(2000);
	}

	@Then("All the User options will be displayed")
	public void all_the_User_options_will_be_displayed() {
		String title = driver.getTitle();
		System.out.println("The title of this page is: " + title);
		System.out.println("All the options are listed");
	}

	@Then("User clicks on LogOut option")
	public void user_clicks_on_LogOut_option() throws Throwable {
		driver.findElement(By.xpath(".//a[@href='/sign_out']")).click();
		Thread.sleep(2000);
	}

	@Then("User will LogOut")
	public void user_will_LogOut() {
		System.out.println("LogOut Successful");
		String title = driver.getTitle();
		System.out.println("Back to " + title);
		driver.quit();
	}

}
