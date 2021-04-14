package com.Way2.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Testbase {
	
	public	WebDriver driver;
	public static Properties properties= new Properties(); 
	String browser="chrome";
	@BeforeSuite
	public void launchBrowser() throws Throwable
	{
		FileInputStream fis =new FileInputStream(System.getProperty("user.dir")+"//PropertiesFile//config.properties");
		properties.load(fis);
		
		if(properties.getProperty("browser").equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//Driver//geckodriver.exe");
			 driver=new FirefoxDriver();
			
		}else
			if(properties.getProperty("browser").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Driver//chromedriver.exe");
				driver=new ChromeDriver();		
		}
		
		
		//WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get(properties.getProperty("url"));
	}
	
	@AfterSuite
	public void tearDown()
	{
		driver.close();
	}

}
