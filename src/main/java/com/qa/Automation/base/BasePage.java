package com.qa.Automation.base;

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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.Automation.utils.OptionsManager;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Sourbh
 *
 */

public class BasePage {

	/**
	 * in the basepage we define the webdriver and two methods.
	 * 
	 * 1 method - init webdriver
	 * 2- method - init property 
	 * 
	 */
	
	WebDriver driver;
	Properties prop;
	OptionsManager optionsManager;
	
	//init driver on the bases of the browser Name
	
	/**
	 * this method use to initialize the driver on the bases of the browser name
	 * @param browserName
	 * @return driver
	 */
	public WebDriver init_driver(Properties prop ) {
		
		String browserName =prop.getProperty("browser");
		System.out.println("Browser name is " + browserName);
		
		optionsManager=new OptionsManager(prop);
		
		if(browserName.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(optionsManager.getChromeOption());
		}
	
		else if(browserName.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("edge")) {
			
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		else {
			System.out.println("Please pass the valid Browser name" + browserName );
		}

	    driver.manage().deleteAllCookies();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	
		
		return driver;
	}
	
	
	/*
	 * // this method will interact with the config file. for that we have to create
	 * a object of the property class and the FileinputStream class.
	 */
	
	
	/**
	 * this method is use to get the properties values from the config file
	 * @return prop
	 */
	public Properties init_prop() {
		
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("src\\main\\java\\com\\qa\\Automation\\config\\config.properties");
		      prop.load(ip);
			}catch (FileNotFoundException e) {
			e.printStackTrace();
		   } catch (IOException e) {
				e.printStackTrace();
			}
		
		return prop;
	}   
	
	
	
	/**
	 * this method use to take screen shot
	 * @return path
	 */
	
	public String getScreenShot() {
		
	File  src	= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String path  =  System.getProperty("user.dir")+"/screnshot/"+System.currentTimeMillis()+".png";	
       
        //moving src to the path(screenshot to path)//Move image file to new destination object created.
        File destination = new File(path);
        
      try {
    	//Copy file at destination
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
        
      return path;
	}
	
}
