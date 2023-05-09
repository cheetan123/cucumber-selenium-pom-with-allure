package info.seleniumcucumber.steps;

import info.seleniumcucumber.factory.DriverFactory;
import info.seleniumcucumber.pages.LoginPage;
import info.seleniumcucumber.utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Properties;

public class LoginPageSteps {

	private static String title;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	ConfigReader configReader = new ConfigReader();
	Properties prop = configReader.init_prop();

	@Given("user is on login page")
	public void user_is_on_login_page() {

		DriverFactory.getDriver()
				.get(prop.getProperty("url"));
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = loginPage.getLoginPageTitle();
		System.out.println("Page title is: " + title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {
		Assert.assertTrue(title.contains(expectedTitleName));
	}

	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
		loginPage.enterUserName(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
		loginPage.enterPassword(password);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		loginPage.clickOnLogin();
	}


}