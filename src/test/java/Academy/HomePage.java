package Academy;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.base;


public class HomePage extends base{
	@BeforeTest
	public void initilize() throws IOException
	{
		driver=initializeDriver();// initlizing webdriver and accessing link 
		
		
	}
	@Test(dataProvider="getData")
	public void basePageNavigation(String username,String password,String text) throws IOException {
		//driver=initializeDriver();// initlizing webdriver and accessing link 
		//driver.get("http://www.qaclickacademy.com/");
		driver.get(prop.getProperty("url"));
		//creating object of landing page to access those class data
		LandingPage l= new LandingPage(driver);
		l.getLogin().click();// it will find login element object with css
		
		LoginPage login= new LoginPage(driver); 
				login.getEmail().sendKeys(username);
				login.getPassword().sendKeys(password);
			//String text = "";
			System.out.println(text);
				login.Submit().click();
				
	}
				@DataProvider
				public Object[][] getData()
				{
					// Row stands for how many different data types test should run
					//coloumn stands for how many values per each test
					
					// Array size is 2
					// 0,1
					Object[][] data=new Object[2][3];
					//0th row
					data[0][0]="nonrestricteduser@qw.com";
					data[0][1]="123456";
					data[0][2]="Restrcited User";
					//1st row
					
					data[1][0]="restricteduser@qw.com";
					data[1][1]="456788";
					data[1][2]= "Non restricted user";
					
					return data;
										
					
				}
				@AfterTest
				public void teardown() 
				{
						driver.close();
				}
				
				
		
	}
	
