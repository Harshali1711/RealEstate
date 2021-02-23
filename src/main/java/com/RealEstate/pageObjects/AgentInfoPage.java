package com.RealEstate.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.RealEstate.testBase.TestBase;

public class AgentInfoPage extends TestBase {

	//***************Object Repository********************
	@FindBy(xpath="//h1[@class='bottom-half']/b[1]")
	WebElement AgentnameLabel;

	//***************Initializing the page Factory********
	public AgentInfoPage()
	{
		PageFactory.initElements(driver, this);
	}

	//***************Action Methods************************
	public String AgentLabel()
	{
		return AgentnameLabel.getText();

	}

}
