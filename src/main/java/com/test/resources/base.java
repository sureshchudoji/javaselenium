package com.test.resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	
	public WebDriver driver;
	public Properties prop;
	public FileInputStream fis;
	
	public WebDriver initializeDriver() throws IOException
	{
		String basePath = System.getProperty("user.dir");
		
		prop = new Properties();
		fis = new FileInputStream(basePath+"\\src\\main\\java\\com\\test\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
				
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", basePath+"\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} 
		else if(browserName.equals("firefox")) {
			//FireFox Browser
		}
		else if (browserName.equals("edge")) {
			//Edge Browser
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		return driver;
		
	}

}
