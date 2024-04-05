package com.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class CommonMethods extends BaseClass {

	public static void selectValueFromDD(WebElement element, String text) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		boolean isSelected = false;
		for (WebElement option : options) {
			String optionText = option.getText();
			if (optionText.equals(text)) {
				select.selectByVisibleText(text);
				System.out.println("Option with text " + text + " is selected");
				isSelected = true;
				break;
			}
		}
		if (!isSelected) {
			System.out.println("Option with text +" + text + "is not available");
		}
	}

	/**
	 * This method will select a specified value from a drop down by its index
	 * 
	 * 
	 * @param Select element, int index
	 */
	public static void selectValueFromDD(WebElement element, int index) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		if (options.size() > index) {
			select.selectByIndex(index);
		} else {
			System.out.println("Invalid index has been passed");
		}
	}

	public static void sendText(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	/**
	 * Method will accept alert
	 * 
	 * @throws NoAlertPresentException if alert is not present
	 */
	public static void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
			System.out.println("Alert was not present");
		}
	}

	/**
	 * Method will dismiss alert
	 * 
	 * @throws NoAlertPresentException if alert is not present
	 */
	public static void dismissAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		} catch (NoAlertPresentException e) {
			System.out.println("Alert was not present");
		}
	}

	/**
	 * Method will get text of an alert
	 * 
	 * @throws NoAlertPresentException if alert is not present
	 * @return String text
	 */
	public static String getAlertText() {

		try {
			Alert alert = driver.switchTo().alert();
			return alert.getText();
		} catch (NoAlertPresentException e) {
			System.out.println("Alert was not present");
			return null;
		}

	}

	/**
	 * Method that will switch control to the specified frame
	 * 
	 * @param frame id or frame name
	 */
	public static void switchToFrame(String idOrName) {
		try {
			driver.switchTo().frame(idOrName);
		} catch (NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
	}

	/**
	 * Method that will switch control to the specified frame
	 * 
	 * @param frame element
	 */
	public static void switchToFrame(WebElement element) {
		try {
			driver.switchTo().frame(element);
		} catch (NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
	}

	/**
	 * Method that will switch control to the specified frame
	 * 
	 * @param frame index
	 */
	public static void switchToFrame(int index) {
		try {
			driver.switchTo().frame(index);
		} catch (NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
	}

	/**
	 * Method that will wait for element to be visible
	 * 
	 * @param WebElement element, int time
	 */
//	public static void waitForElementBeVisible(WebElement element, int time) {
//		WebDriverWait wait = new WebDriverWait(driver, time);
//		wait.until(ExpectedConditions.visibilityOf(element));
//	}
//
//	public static void waitForElementBeVisible(By locator, int time) {
//		WebDriverWait wait = new WebDriverWait(driver, time);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//	}
//
//	public static void waitForElementBeClickable(WebElement element, int time) {
//		WebDriverWait wait = new WebDriverWait(driver, time);
//		wait.until(ExpectedConditions.elementToBeClickable(element));
//	}
//
//	public static void waitForElementBeClickable(By locator, int time) {
//		WebDriverWait wait = new WebDriverWait(driver, time);
//		wait.until(ExpectedConditions.elementToBeClickable(locator));
//	}

	public static byte[] takeScreenshot() {

		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] screen = ts.getScreenshotAs(OutputType.BYTES);

		return screen;
	}

	public static void scrollDown(int pixels) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + pixels + ")");
	}

	public static void scrollUp(int pixels) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-" + pixels + ")");
	}

	public static void jsClick(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public static void click(WebElement element) {
		element.click();
	}

	public static void selectFromList(WebElement element, String text) {

		//List<WebElement> listLocations = element.findElements(By.tagName("li"));
		List<WebElement> listLocations = element.findElements(By.tagName("option"));
		for (WebElement li : listLocations) {
			String liText = li.getAttribute("innerHTML");

			if (liText.contains(text)) {
				System.out.println(liText);
				li.click();
				break;
			}
		}
	}

	public static void zoomOut() throws AWTException {

		Robot robot = new Robot();
		for (int i = 0; i < 2; i++)
			;
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_SUBTRACT);
		robot.keyRelease(KeyEvent.VK_SUBTRACT);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}

	static String jsonFile;

	public static String readJson(String fileName) {

		try {

			jsonFile = new String(Files.readAllBytes(Paths.get(fileName)));

		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonFile;

	}
	
	public static void doubleClick(WebElement element) {
		
		Actions actions = new Actions(driver);
		WebElement elementLocator = element;
		actions.doubleClick(elementLocator).perform();
	}
	
	public static void switchWindow() {
		
		String parent=driver.getWindowHandle();
		
		Set<String>s=driver.getWindowHandles();
		
		Iterator<String> I1= s.iterator();
		
		while(I1.hasNext()) {
			
			String child_window=I1.next();
			if(!parent.contentEquals(child_window)){
				driver.switchTo().window(child_window);
				System.out.println(driver.switchTo().window(child_window).getTitle());

				driver.close();
			}
		}
		//driver.switchTo().window(parent);
	}
	
 
}
