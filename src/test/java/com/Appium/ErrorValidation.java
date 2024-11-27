package com.Appium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TestUtils.AndroidBaseTest;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class ErrorValidation extends AndroidBaseTest {



	//	@BeforeMethod
	public void preSetup() {

		// adb shell dumpsys window | find "mCurrentFocus"  ---- Windows

		//// adb shell dumpsys window | grep -E "mCurrentFocus" ------ MAC

		// To move to direct page what ever page u want //App Package & //App Activity
	

		((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent",
				"com.androidsample.generalstore/com.androidsample.generalstore.MainActivity"));

	}

	@Test

	public void FillForm_ErrorValidation() throws InterruptedException {

		// driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Shanks");

		// driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.hideKeyboard();

		driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();

		driver.findElement(By.id("android:id/text1")).click();

		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Austria\"));"));

		driver.findElement(By.xpath("//android.widget.TextView[@text='Austria']")).click();

		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		String ToastMSg = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");

		Assert.assertEquals(ToastMSg, "Please enter your nam");

	}

	@Test

	public void FillForm_PositiveFlow() throws InterruptedException {

		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Shanks");

		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.hideKeyboard();

		driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();

		driver.findElement(By.id("android:id/text1")).click();

		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Austria\"));"));

		driver.findElement(By.xpath("//android.widget.TextView[@text='Austria']")).click();

		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		Assert.assertTrue(driver.findElements(By.xpath("//android.widget.Toast[1]")).size() < 1);

	}
}
