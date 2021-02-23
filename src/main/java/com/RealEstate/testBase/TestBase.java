package com.RealEstate.testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() 
	{
		try { 
			prop=new Properties();
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\RealEstate\\configurations\\config.properties");
			prop.load(fis);
			
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void initialization()
	{
		String browsername=prop.getProperty("browser");
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") +"\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browsername.equals("FireFox"))
		{
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") +"\\Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		driver.manage().deleteAllCookies();
		
		driver.get(prop.getProperty("url"));
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
