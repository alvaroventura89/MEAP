package com.testSteps;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.pages.FleetStatusPage;
import com.pages.Login;
import com.utils.BaseClass;

public class ServicesCheck extends BaseClass {
	
	
	@Test(groups = {"log","smoke"})
	public static void check() {
		
		logger = report.createTest("Login");
		
		Login.logIn();
		
		trainList();
		
		
	}

	
	public static void trainList() {
		
		FleetStatusPage fl = new FleetStatusPage();
		
		for(int i =0; i<fl.trainList.size(); i++) {
			
			WebElement element = fl.trainList.get(i);
			String elementName = element.getText();
			
			ExtentTest fleet = logger.createNode(elementName);
			
		}
		
		
		
		
	}
	
}
