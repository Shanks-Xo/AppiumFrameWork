package com.TestUtils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.google.common.collect.ImmutableMap;
import com.pageObjects.android.FormPage;
import com.utils.AppiumUtils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AndroidBaseTest extends AppiumUtils {

	
	AppiumDriverLocalService service;
	public AndroidDriver driver;

	public FormPage formPage;

	@BeforeTest(alwaysRun=true)
	public void ConfigureAppium() throws MalformedURLException, URISyntaxException {

		service = startAppiumServer();

		UiAutomator2Options options = new UiAutomator2Options();
		// for Vr devices or Emulator
		options.setDeviceName("ZoroPhone");
		
		// For real devices
		// options.setDeviceName("Android Device");

		// options.setChromedriverExecutable("C://chromedriver-win64//chromedriver.exe");
		// //driver version 131
		options.setChromedriverExecutable(
				"C://Users//shank//Downloads//130.0.6723.58 chromedriver-win64//chromedriver-win64//chromedriver.exe");// Version
																														// 130
		// options.setChromedriverExecutable("C://Users//shank//Downloads//chromedriver_win32//chromedriver.exe");
		// driver version 113

		// options.setApp("C://Users//shank//eclipse_Workspace//Appium//src//test//java//resources//ApiDemos-debug.apk");

		options.setApp("C://Users//shank//eclipse_Workspace//AppiumFrameworkDesign//src//test//java//com//resources//General-Store.apk");
		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		formPage = new FormPage(driver); 

	}

	
	@AfterTest(alwaysRun=true)

	public void tearDown() {

		driver.quit();
		service.stop();

	}

}
