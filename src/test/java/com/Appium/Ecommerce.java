package com.Appium;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.TestUtils.AndroidBaseTest;
import com.pageObjects.android.CartPage;
import com.pageObjects.android.FormPage;
import com.pageObjects.android.ProductPage;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Ecommerce extends AndroidBaseTest {


	@Test(dataProvider = "getData", groups = {"Smoke"})

	public void CartPage(String name, String gender, String country) throws InterruptedException {

		formPage.setName(name);
		formPage.genderSelection(gender);
		formPage.countrySelction(country);

		ProductPage productPage = formPage.submitForm();

		productPage.addItemToCArtByIndex(0);
		productPage.addItemToCArtByIndex(0);

		CartPage cartpage = productPage.goToCArt();
	

		double totalSum = cartpage.getProductSum();
		double displayFormattedSum = cartpage.getTotalAmountDiaplayed();
		Assert.assertEquals(totalSum, displayFormattedSum);
		cartpage.acceptTermsConditions();
		cartpage.submitOrder();

	}
	
	@BeforeMethod (alwaysRun=true)
	
	public void preSetup() {
		
		formPage.setActivity();
	}
	

	@DataProvider

	public Object[][] getData() {

		return new Object[][] { { "Shanks", "Male", "Austria" },{ "Nigga", "Female", "Chad" } };

	}

}
