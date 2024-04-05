package com.testSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AssetRegistrationSteps {
	
	@When("User clicks the add button")
	public void user_clicks_the_add_button() {

	}

	@Then("a form displays")
	public void a_form_displays() {

	}

	@Then("User can enter required information {string} {string} {string}")
	public void user_can_enter_required_information(String SerialNumber, String DisplayName, String FleetName) {

	}

	@And("click save")
	public void click_save() {

	}

	@Then("new unit will display")
	public void new_unit_will_display() {

	}
	
	@And("User can click on the unit link")
	public void user_can_click_on_the_unit_link() {

	}
	
	@Then("unit detail view will display for new device")
	public void unit_detail_view_will_display_for_new_device() {

	}

	@Then("new registered unit will reflect in database")
	public void new_registered_unit_will_reflect_in_datablas() {

	}
	
	@When("User navigates to Fleet Configuration View")
	public void user_navigates_to_fleet_configuration_view() {
	
	}

	@When("clicks edit")
	public void clicks_edit() {

	}

	@When("selects newly registered asset {string} {string}")
	public void selects_newly_registered_asset(String FleetName, String DisplayName) {

	}

	@When("edits unit {string} {string} {string}")
	public void edits_unit(String EditSerialN, String EditName, String EditFleet) {
	
	}

	@And("clicks submit")
	public void clicks_submit() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("changes should display {string} {string} {string}")
	public void changes_should_display(String EditSerialN, String EditName, String EditFleet) {

	}
	
	@When("User navigates to Firmware repository")
	public void user_navigates_to_firmware_repository() {

	}

	@When("uploads new firmware {string}")
	public void uploads_new_firmware(String fileLocation) {

	}

	@When("selects newly registered {string}")
	public void selects_newly_registered(String string) {

	}

	@When("clicks apply")
	public void clicks_apply() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("a success message displays")
	public void a_success_message_displays() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}


}
