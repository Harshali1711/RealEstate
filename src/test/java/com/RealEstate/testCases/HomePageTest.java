package com.RealEstate.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.RealEstate.pageObjects.HomePage;
import com.RealEstate.testBase.TestBase;

public class HomePageTest extends TestBase {
	
	HomePage homepage;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void Setup()
	{
		initialization();
		homepage=new HomePage();
	}
	
	@Test(priority = 1)
	public void verify_Title_Test()
	{
		String title=homepage.homePage_Title();
		String exptitle="Zoopla > Search Property to Buy, Rent, House Prices, Estate Agents";
		Assert.assertEquals(title, exptitle);
		System.out.println("Title Matched");
	}
	
	@Test(priority = 2)
	public void Search_Property_Test() throws InterruptedException
	{
		homepage.search_Property("London");
		Thread.sleep(2000);
		System.out.println("Searched location");
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
	

}
