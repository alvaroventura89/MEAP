package com.utils;

import java.io.UnsupportedEncodingException;

import org.apache.commons.lang3.StringUtils;
//import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;


public class SetUpTearDown {

	@Before
	public void start(Scenario scenario) throws UnsupportedEncodingException {
		
	BaseClass.setUp();
	System.out.println("Starting test: "+scenario.getName());

	}
	
	@After
	public void tearDown(Scenario scenario) {
		
		BaseClass.tearDown();
		
	}
	
	@Before
	public void startReport() throws UnsupportedEncodingException  {
		BaseClass.generateReport();
	}
	
	public static ExtentHtmlReporter  extentHtmlReporter;
	public static ExtentReports  extentReports;
	public static ExtentTest logger;

//	@Before
//	public static void customExtentReporter() {
//		String reportEnvironment = GetCurrentEnvironment();
//		String reportPath = GetCurrentReportPath();
//
//		String envPropertiesFile = GetEnvironmentProperties();
//		ConfigsReader.readProperties(envPropertiesFile);
//		extentHtmlReporter = new ExtentHtmlReporter(reportPath);
//		extentReports = new ExtentReports();
//		extentReports.attachReporter(extentHtmlReporter);
//		extentReports.setSystemInfo("Environment", reportEnvironment);
//		extentReports.setSystemInfo("Browser", "Chrome");
//		extentReports.setSystemInfo("OS", Constants.OS_NAME);
//
//	}

	
//	public static void reportResult(ITestResult result) {
//
//		switch (result.getStatus()) {
//		case ITestResult.FAILURE:
//			logger.log(Status.FAIL, MarkupHelper
//					.createLabel(result.getName() + " Test case FAILED due to below issues:", ExtentColor.RED));
//			logger.fail(result.getThrowable());
//			break;
//		case ITestResult.SUCCESS:
//			logger.log(Status.PASS,
//					MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
//			break;
//		default:
//			logger.log(Status.SKIP,
//					MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.ORANGE));
//			logger.skip(result.getThrowable());
//			break;
//		}
//	}

	public static void flushReport() {
		extentReports.flush();
	}

	public static String GetCurrentEnvironment() {
		ConfigsReader.readProperties(Constants.BASE_PROPERTIES_FILEPATH);
		String reportEnvironment = ConfigsReader.getProperty("baseEnvironment");
		String reportSystemEnvironment = System.getProperty("jenkins.reportenv");

		if (!StringUtils.isEmpty(reportSystemEnvironment)) {
			reportEnvironment = reportSystemEnvironment;
		}

		return reportEnvironment;
	}

	public static String GetCurrentReportPath() {
		ConfigsReader.readProperties(Constants.BASE_PROPERTIES_FILEPATH);
		String reportPath = ConfigsReader.getProperty("baseReportPath");
		String reportSystemPath = System.getProperty("jenkins.reportpath");

		if (!StringUtils.isEmpty(reportSystemPath)) {
			reportPath = reportSystemPath;
		}

		return reportPath + Constants.REPORT_FILENAME;
	}

	public static String GetEnvironmentProperties() {
		String reportEnvironment = GetCurrentEnvironment();
		return Constants.CREDENTIALS_FILEPATH + reportEnvironment + Constants.CREDENTIALS_FILENAME;
	}
	

	
}
