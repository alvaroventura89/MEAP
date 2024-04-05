package com.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.BaseClass;



public class FleetStatusPage extends BaseClass {
	
	@FindBy(xpath="//ul[@id='Navigation']")
	public WebElement navigationMenu;
	
	@FindBy(id="admin_menu")
	public WebElement adminMenu;
	
	@FindBy(xpath = "//div[@aria-label='Map']")
	public WebElement map;
	
	@FindBy(xpath = "//ul[@id='Navigation']/li[2]")
	public WebElement eventsReports;
	
	@FindBy(id = "Content")
	public WebElement reportRunner;
	
	@FindBy(xpath = "//div[contains(@class,'trackableLocoName')]")
	public List<WebElement> trainList;
	
	public FleetStatusPage() {
		PageFactory.initElements(driver, this);
	}

}
