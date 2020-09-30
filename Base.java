package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	public String url;
	public String searchUrl;
	public WebDriver driver;
	public WebDriver initalizeDriver() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"/Users/reemabdallah/eclipse-workspace/Makemytrip_Project/src/main/java/resources/data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("Browser");
		url = prop.getProperty("url");
		searchUrl = prop.getProperty("searchUrl");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/reemabdallah/Desktop/Automation_Udemy/chromedriver");
			driver = new ChromeDriver();

		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/reemabdallah/Desktop/Automation_Udemy/geckodriver");
			driver = new FirefoxDriver();
		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
}
