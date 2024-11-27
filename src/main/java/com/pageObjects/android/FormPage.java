package com.pageObjects.android;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.ImmutableMap;
import com.utils.AndroidActions;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

;

public class FormPage extends AndroidActions {

	AndroidDriver driver;

	public FormPage(AndroidDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	// driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Shanks");

//	driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();

	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	private WebElement nameField;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
	private WebElement maleOption;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
	private WebElement femaleOption;

	@AndroidFindBy(id = "android:id/text1")
	private WebElement selectCountry;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	private WebElement shopButton;

	public void setName(String name) {

		nameField.sendKeys(name);
		// driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.hideKeyboard();

	}

	public void genderSelection(String gender) {

		if (gender.contains("Male")) {

			maleOption.click();

		} else {

			femaleOption.click();

		}

	}

	public void countrySelction(String country) {

		selectCountry.click();
		scrollToText(country);

		driver.findElement(By.xpath("//android.widget.TextView[@text='" + country + "']")).click();

	}

	public void setActivity() {

		// ((JavascriptExecutor) driver).executeScript("mobile: startActivity",
		// ImmutableMap.of("intent",
		// "com.androidsample.generalstore/com.androidsample.generalstore.MainActivity"));
		   ((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent",
	                "com.androidsample.generalstore/com.androidsample.generalstore.MainActivity"));
	}

	public ProductPage submitForm() {

		shopButton.click();

		return new ProductPage(driver);

	}

}
