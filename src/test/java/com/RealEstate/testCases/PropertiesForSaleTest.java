package com.RealEstate.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.RealEstate.pageObjects.HomePage;
import com.RealEstate.pageObjects.PropertiesForSalePage;
import com.RealEstate.testBase.TestBase;

public class PropertiesForSaleTest extends TestBase {
	
	HomePage homepage;
	PropertiesForSalePage propsale;
	
	public PropertiesForSaleTest()
	{
		super();
	}
	
	@BeforeMethod
	public void Setup()
	{
		initialization();
		homepage=new HomePage();
		homepage.search_Property("London");
	}
	
	@Test
	public void List_all_properties_Test() throws InterruptedException
	{
		propsale=new PropertiesForSalePage();
		propsale.List_all_properties();
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

	

}
