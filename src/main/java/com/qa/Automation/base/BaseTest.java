package com.qa.Automation.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


import com.qa.Automation.pages.SingInPage;
import com.qa.Automation.pages.UserDashboard;

public class BaseTest {

	
	
	// reference
	WebDriver driver;
	public Properties prop;
	BasePage basepage;
	public SingInPage signuppage;
	public UserDashboard userDashboard;

	
	
	@Parameters({"browser"})
	@BeforeTest
	public void setUp(String browserName) {
		basepage = new BasePage();
		prop = basepage.init_prop();
		//Changing the value at the run (xmal)
		prop.setProperty("browser", browserName);
		driver = basepage.init_driver(prop);
		signuppage = new SingInPage(driver);
		
	}

}
