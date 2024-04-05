package com.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
//import org.testng.ITestResult;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BaseClass  {

	public static WebDriver driver;

	public static ExtentHtmlReporter htmlReport;
	public static ExtentReports report;
	public static ExtentTest logger;

	@BeforeMethod
	public static void setUp() {
                
            String envPropertiesFile = GetEnvironmentProperties();
            ConfigsReader.readProperties(envPropertiesFile);
            
            String browser = ConfigsReader.getProperty("browser");

            if (browser.equalsIgnoreCase("chrome")) {
            	WebDriverManager.chromedriver().setup();

    			ChromeOptions options = new ChromeOptions();

    			Map<String, Object> prefs = new HashMap<>();

    			prefs.put("profile.default_content_setting_values.media_stream_mic", 1);
    			options.setExperimentalOption("prefs", prefs);
    			options.addArguments("--no-sandbox");

    			driver = new ChromeDriver(options);


            } else if (browser.equalsIgnoreCase("firefox")) {
                    System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver");
                    driver = new FirefoxDriver();

            } else if (browser.equalsIgnoreCase("ie")) {
                    System.setProperty("webdriver.ie.driver", "src/test/resources/drivers/IEDriverServer");
                    driver = new InternetExplorerDriver();

            } else if (browser.equalsIgnoreCase("headless")) {
                    System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver89.exe");

                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless");
                    options.addArguments("use-fake-ui-for-media-stream");
                    options.addArguments("--no-sandbox");  

                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                    options.merge(capabilities);	


                    driver = new ChromeDriver(options);

            } else {
                    System.out.println("browser given is wrong");
            }
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.manage().window().maximize();

	}

	//@AfterMethod(alwaysRun = true)
	public static void tearDown() {
		driver.quit();
	}
	
	@AfterMethod(alwaysRun = true)
	public void AfterMethod(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL, MarkupHelper
					.createLabel(result.getName() + " Test case FAILED due to below issues:", ExtentColor.RED));
			logger.fail(result.getThrowable());
			String Base64StringofScreenshot = "";
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(src);
			Base64StringofScreenshot = "data:image/png;base64," + Base64.getEncoder().encodeToString(fileContent);
			logger.addScreenCaptureFromBase64String(Base64StringofScreenshot);
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			//logger.log(Status.PASS,
		//march 28			//MarkupHelper.createLabel(result.getName() + " Executed", ExtentColor.TEAL));
			
			//logger.log(Status.PASS,
					//MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
		} else {
			logger.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.ORANGE));
			logger.skip(result.getThrowable());
		}

		BaseClass.tearDown();
	}


	@BeforeTest(alwaysRun = true)
	public static  void generateReport() throws UnsupportedEncodingException {

            String reportEnvironment = GetCurrentEnvironment();
            String reportPath = GetCurrentReportPath();

            String envPropertiesFile = GetEnvironmentProperties();
            ConfigsReader.readProperties(envPropertiesFile);
            htmlReport = new ExtentHtmlReporter(reportPath);

            report = new ExtentReports();
            report.attachReporter(htmlReport);
            report.setSystemInfo("Environment", reportEnvironment);
            report.setSystemInfo("Browser", "Chrome");
            //report.setSystemInfo("Browser", ConfigsReader.getProperty("browser"));
            report.setSystemInfo("OS", Constants.OS_NAME);
		
	}


	@AfterMethod(alwaysRun = true)
	public void flushReport() {
		report.flush();
	}

        public static String GetCurrentEnvironment()
        {
            ConfigsReader.readProperties(Constants.BASE_PROPERTIES_FILEPATH);
            String reportEnvironment = ConfigsReader.getProperty("baseEnvironment"); 
            String reportSystemEnvironment = System.getProperty("jenkins.reportenv");

            if (!StringUtils.isEmpty(reportSystemEnvironment))
            {
                    reportEnvironment = reportSystemEnvironment;
            }

            return reportEnvironment;
        }
        
        public static String GetCurrentReportPath()
        {
            ConfigsReader.readProperties(Constants.BASE_PROPERTIES_FILEPATH);
            String reportPath = ConfigsReader.getProperty("baseReportPath"); 
            String reportSystemPath = System.getProperty("jenkins.reportpath");

            if (!StringUtils.isEmpty(reportSystemPath))
            {
                    reportPath = reportSystemPath;
            }
            
            return reportPath + Constants.REPORT_FILENAME;
        }
        
        public static String GetEnvironmentProperties()
        {
            String reportEnvironment = GetCurrentEnvironment();
            return Constants.CREDENTIALS_FILEPATH + reportEnvironment + Constants.CREDENTIALS_FILENAME;
        }
}
