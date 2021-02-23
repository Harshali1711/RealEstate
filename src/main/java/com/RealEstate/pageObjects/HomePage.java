package com.RealEstate.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.RealEstate.testBase.TestBase;

public class HomePage extends TestBase {

	//****************Page Objects**************************
	@FindBy(xpath="//input[@id='search-input-location']")
	WebElement propertyLocation;
	
	@FindBy(xpath="//button[@id='search-submit']")
	WebElement searchButton;
	
	//****************Initializing Page Factory**************
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//****************Action Methods for Home Page***********
	
	public String homePage_Title()
	{
		return driver.getTitle();
	}
	
	public PropertiesForSalePage search_Property(String location)
	{
		propertyLocation.sendKeys(location);
		searchButton.click();
		
		return new PropertiesForSalePage();
		
	}
	
}
