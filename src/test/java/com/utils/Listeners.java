package com.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;

public class Listeners implements ITestListener{
	
	ExtentReports report;
	
	
	public void onTestStart(ITestResult result) {
		System.out.println("Test case started:" + result.getName());

		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test case passed:" + result.getName());

	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test case failed:" + result.getName());

	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test case skipped:" + result.getName());

	}

	public void onStart(ITestContext context) {
		System.out.println("Test started:" + context.getName());
	

	}

	public void onFinish(ITestContext context) {
		System.out.println("Test finished:" + context.getName());
		
		

	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

}
