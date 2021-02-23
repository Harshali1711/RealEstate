package com.RealEstate.testCases;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.RealEstate.pageObjects.AgentInfoPage;
import com.RealEstate.pageObjects.HomePage;
import com.RealEstate.pageObjects.PropertiesForSalePage;
import com.RealEstate.testBase.TestBase;



public class PropertiesForSaleTest extends TestBase {
	
	HomePage homepage;
	PropertiesForSalePage propsale;
	AgentInfoPage agentinfo;
	
	public PropertiesForSaleTest()
	{
		super();
	}
	
	@BeforeClass
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
	}
	
	@Test
	public void Verify_AgentDetailsTest() throws InterruptedException
	{
		String Agentname=propsale.Agent_ContactDetails();
		System.out.println(Agentname);
		propsale.AgentINFO();
		Thread.sleep(2000);
		agentinfo=new AgentInfoPage();
		String AgentInfoName=agentinfo.AgentLabel();
		System.out.println(AgentInfoName);
		
		Assert.assertEquals(Agentname, AgentInfoName);
		System.out.println("Agent has been verified");
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}

	

}
