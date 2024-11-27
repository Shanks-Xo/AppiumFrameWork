package com.utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumUtils {
	AppiumDriverLocalService service;
	
	
	public AppiumDriverLocalService  startAppiumServer() {
		
		service = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("C://Users//shank//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		
		return service;
	}
	
	
	
	public Double getFormattedAmount(String amount) {

		Double price = Double.parseDouble(amount.substring(1));

		return price;
	}
	public void waitForElementToAppear(WebElement ele,AppiumDriver driver) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(ele, "text", "Cart"));
		
		
	}
	
	
	public String getScreenshotPath(String testCaseName,AppiumDriver driver) throws IOException {
		   File source = driver.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"//reports"+ testCaseName+".png";  
		
		FileUtils.copyFile(source, new File(destinationFile));
		
		return destinationFile;
	}
	
	
}
