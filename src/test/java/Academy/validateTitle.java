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


public class validateTitle extends base{
	@BeforeTest
	public void initilize() throws IOException
	{
		driver=initializeDriver();// initlizing webdriver and accessing link 
		driver.get(prop.getProperty("url"));
		
	}
	@Test()
	public void basePageNavigation(String emailID,String password) throws IOException {
		driver=initializeDriver();// initlizing webdriver and accessing link 
		driver.get(prop.getProperty("url"));
		
		//creating object of landing page to access those class data
		LandingPage l= new LandingPage(driver);
		l.getLogin().click();// it will find login element object with css
		Assert.assertEquals(l.getTitle().getText(), "Featured Courses");
		
			
		
	}
	@AfterTest
	public void teardown() 
	{
			driver.close();
	}
	
}
	
