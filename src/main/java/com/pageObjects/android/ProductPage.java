package com.pageObjects.android;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class ProductPage extends AndroidActions {
	AndroidDriver driver;

	public ProductPage(AndroidDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='ADD TO CART'])")

	private List<WebElement> addToCart;
	
	
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	
	private WebElement Cart;
	 
	

	public void addItemToCArtByIndex(int index) {

		addToCart.get(index).click();

	}
	
	
	public CartPage  goToCArt() throws InterruptedException {
		
		Cart.click();
		Thread.sleep(2000);
		
	 return new CartPage(driver);
	
	}

}
