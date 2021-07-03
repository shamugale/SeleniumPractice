package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebDriver driver;
	
	By emailID= By.id("user_email"); 
	By password= By.cssSelector("input[id='user_password']");
	By loginButton=  By.xpath("//input[@name='commit']");
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement getEmail() {
		return driver.findElement(emailID);
		
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	public WebElement Submit() {
		return driver.findElement(loginButton);
	}
}
