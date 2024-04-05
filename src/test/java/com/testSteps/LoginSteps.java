package com.testSteps;

import com.pages.FleetStatusPage;
import com.pages.Login;
import com.utils.BaseClass;
import com.utils.ConfigsReader;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends BaseClass {

	Login login;

	@Given("user navigates to Login Page")
	public void user_navigates_to_login_page() {

		Login login = new Login();

		driver.get(ConfigsReader.getProperty("url"));
		boolean logo = login.appLogo.isDisplayed();
		Assert.assertTrue(logo);

	}

	@And("enters valid credentials")
	public void enters_valid_credentials() {

		Login login = new Login();

		login.userName.sendKeys(ConfigsReader.getProperty("username"));
		login.password.sendKeys(ConfigsReader.getProperty("password"));

	}

	@When("the login button is clicked")
	public void the_login_button_is_clicked() {

		Login login = new Login();

		login.logInButton.click();

	}

	@Then("user is redirected to Home Page")
	public void user_is_redirected_to_home_page() throws InterruptedException {

		driver.switchTo().frame("main");

		FleetStatusPage home = new FleetStatusPage();
		Login login = new Login();

		boolean map = login.map.isDisplayed();
		// Assert.assertTrue(homepageMenu);
		Assert.assertTrue(map);

	}

	@Given("provides invalid credentials")
	public void provides_invalid_credentials() {

		Login login = new Login();

		login.userName.sendKeys("invalidUsername");
		login.password.sendKeys("invalidPassword");
	}

	@Then("an error message is displayed")
	public void an_error_message_is_displayed() throws InterruptedException {
		Login login = new Login();
		Thread.sleep(1000);

		boolean loginError = login.loginError.isDisplayed();
		Assert.assertTrue(loginError);
	}

}
