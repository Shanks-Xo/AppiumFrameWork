package com.TestUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	
	static ExtentReports extent;
	
	
	public  static ExtentReports getReporterObject() {
		
		
		
		// ExtentReporter , ExtentSparkReporter
		
	            String path = 	System.getProperty("user.dir")+"\\reports\\index.html";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		
		
		reporter.config().setReportName("Android Testing");
		reporter.config().setDocumentTitle("Test Result");
		
		
		 extent = new ExtentReports();
		
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Shanks");
		return extent;
		
		
		 
	}
			
			
	
	
	
	
	

}
