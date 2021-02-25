package com.RealEstate.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.RealEstate.pageObjects.AgentInfoPage;
import com.RealEstate.pageObjects.HomePage;
import com.RealEstate.pageObjects.PropertiesForSalePage;
import com.RealEstate.testBase.TestBase;

public class AgentInfoTest extends TestBase{

	HomePage homepage;
	PropertiesForSalePage propsale;
	AgentInfoPage agentinfo;
	String Agentname;

	public AgentInfoTest()
	{
		super();
	}

	@BeforeClass
	public void Setup() throws Exception
	{
		initialization();
		homepage=new HomePage();
		homepage.search_Property("London");
		propsale=new PropertiesForSalePage();
		propsale.List_all_properties();	
		Agentname=propsale.Agent_ContactDetails();
		System.out.println(Agentname);
		propsale.AgentINFO();
		Thread.sleep(2000);
		agentinfo=new AgentInfoPage();
	}

	@Test
	public void verifyAgentLabel()
	{
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
