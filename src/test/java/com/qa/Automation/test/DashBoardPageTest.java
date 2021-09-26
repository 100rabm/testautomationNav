package com.qa.Automation.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.Automation.base.BasePage;
import com.qa.Automation.base.BaseTest;
import com.qa.Automation.pages.SingInPage;
import com.qa.Automation.pages.UserDashboard;
import com.qa.Automation.utils.Constants;

public class DashBoardPageTest extends BaseTest{

	
	
//	//reference
//		WebDriver driver;
//		Properties prop;
//		BasePage basepage;
//		SingInPage signuppage;
//		UserDashboard userDashboard;
//		
//		
//			
//			
//			@BeforeTest
//			public void setUp() { 
//			basepage = new BasePage();
//			prop=basepage.init_prop();
//			driver=basepage.init_driver(prop);
//			signuppage = new SingInPage(driver);
//			userDashboard=signuppage.doLogin(prop.getProperty("emailaddress"), prop.getProperty("password"));//pagechaining
//		}
		
	
	@BeforeClass
	public void dashBoardLoginSetup() {
		userDashboard = signuppage.doLogin(prop.getProperty("emailaddress"), prop.getProperty("password"));// pagechaining
	}
	
		@Test
		public void verifyTitleTest() {
		String titleText	=userDashboard.getDashBoardTitle();
		System.out.println("tite of the page--" +titleText);
		System.out.println("after getting title of the page");
		Assert.assertEquals(titleText, Constants.DashBoard_Page_Title);
		}
		
		
		@Test
		public void verifyAccountName() {
			String accountName=userDashboard.getAccountName();
			System.out.println("account name--" + accountName );
			Assert.assertEquals(accountName, prop.getProperty("accountName"));
		}
		
	
}
