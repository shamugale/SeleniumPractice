package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Shreyas\\Documents\\eclipse_project\\E2EProjecy\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browsername = prop.getProperty("browser");
		

		if (browsername.equals("chrome")) 
			//browsername=="chrome"
		{
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Shreyas\\Documents\\sham\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println(browsername);

		} else if (browsername.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browsername.equals("IE")) {
			// driver= new I

		}

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
		
	}
	public void getScreenShotPath(String TestCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts =(TakesScreenshot) driver;
		File Source=ts.getScreenshotAs(OutputType.FILE);
		String DestinationFile = System.getProperty("user.dir")+"//reports"+TestCaseName+".png";
	FileUtils.copyFile(Source,new File(DestinationFile));
	}
}
