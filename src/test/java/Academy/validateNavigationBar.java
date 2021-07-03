package Academy;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.base;


public class validateNavigationBar extends base{
	@BeforeTest
	public void initilize() throws IOException
	{
		driver=initializeDriver();// initlizing webdriver and accessing link 
		driver.get(prop.getProperty("url"));
		
	}
	@Test()
	public void basePageNavigation(String emailID,String password) throws IOException
	{
		
		
		//creating object of landing page to access those class data
		LandingPage l= new LandingPage(driver);
		Assert.assertTrue(l.getNavigationBar().isDisplayed());// it will find login element object with css
		
			
		
		
		
	}
	@AfterTest
	public void teardown() 
	{
			driver.close();
	}
	
}
	
