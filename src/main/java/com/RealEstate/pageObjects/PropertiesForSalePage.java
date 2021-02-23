package com.RealEstate.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.RealEstate.testBase.TestBase;

public class PropertiesForSalePage extends TestBase {

	//***************Object Repository********************
	@FindBy(xpath="//a[@class='ui-agent__details' and @data-track-label='Agent block 1']//h4[@class='ui-agent__name']")
	WebElement AgentName;

	//***************Initializing the page Factory********
	public PropertiesForSalePage()
	{
		PageFactory.initElements(driver,this);
	}

	//***************Action Methods************************
	public String property_title()
	{
		return driver.getTitle();
	}

	public void List_all_properties() throws InterruptedException
	{
		List<WebElement> listofproperties=driver.findElements(By.xpath("//a[@data-testid='listing-details-link']"));

		for(int i=0;i<listofproperties.size();i++)
		{
			//list of properties
			System.out.println(listofproperties.get(i).getText());
		}

		//Get 5th property
		listofproperties.get(5).click();
		Thread.sleep(3000);

	}	

	public String Agent_ContactDetails() {
		return AgentName.getText();


	}

	public AgentInfoPage AgentINFO()
	{
		AgentName.click();
		return new AgentInfoPage();
	}
}
