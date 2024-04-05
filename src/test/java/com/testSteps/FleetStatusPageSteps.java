package com.testSteps;

import com.pages.FleetStatusPage;
import com.pages.Login;
import com.utils.BaseClass;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;

public class FleetStatusPageSteps extends BaseClass {

	Login login = new Login();
	FleetStatusPage home = new FleetStatusPage();

	@Given("User is logged in")
	public void user_is_logged_in() {

		login = new Login();

		Login.logIn();
		driver.switchTo().frame("main");
		boolean map = login.map.isDisplayed();
		Assert.assertTrue(map);
	}

	@And("User clicks module")
	public void user_clicks_module() {

		System.out.println("Clicking Module");
	}

	@Then("all Fleet Status Page elements load")
	public void all_Fleet_Status_Page_elements_load() {

		home = new FleetStatusPage();

		boolean map = home.map.isDisplayed();
		boolean menu = home.navigationMenu.isDisplayed();

		Assert.assertTrue(map);
		Assert.assertTrue(menu);

	}

	@Then("User is able to access Fleet configuration and firmware repository")
	public void user_is_able_to_access_fleet_configuration_and_firmware_repository() throws InterruptedException {
		home = new FleetStatusPage();

		home.eventsReports.click();
		Thread.sleep(2000);

		boolean report = home.reportRunner.isDisplayed();
		Assert.assertTrue(report);

	}

	@Then("User can see fleet config changes status")
	public void user_can_see_fleet_config_changes_status() {

	}

	@And("User can click on fleet to view units")
	public void user_can_click_on_fleet_to_view_units() {

	}

	@And("User can view unit config changes status")
	public void user_can_view_unit_config_changes_status() {

	}

	@And("User has access to status filter")
	public void user_has_access_to_status_filter() {

	}
}
