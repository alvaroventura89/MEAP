package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.utils.BaseClass;
import com.utils.ConfigsReader;
import com.utils.Constants;

public class Login extends BaseClass {
	
	@FindBy(id = "logo-image-primary")
	public WebElement appLogo;
	
	@FindBy(xpath = "//div[@class='input-surround']/input[@name='username']")
	public WebElement userName;
	
	@FindBy(xpath = "//div[@class='input-surround']/input[@name='password']")
	public WebElement password;
	
	@FindBy(xpath = "//input[@type='submit']")
	public WebElement logInButton;
	
	@FindBy(xpath = "//div[@aria-label='Map']")
	public WebElement map;
	
	@FindBy(xpath= "//div[@id='PageStatuses']/p")
	public WebElement loginError;
	

	
	

	public Login() {
		//AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,30);
		PageFactory.initElements(driver, this);
	}

	public static void logIn() {
		
		Login login = new Login();

		driver.get(ConfigsReader.getProperty("url"));
		login.userName.sendKeys(ConfigsReader.getProperty("username"));
		login.password.sendKeys(ConfigsReader.getProperty("password"));
		login.logInButton.click();

	}

}