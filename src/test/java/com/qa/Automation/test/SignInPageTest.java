package com.qa.Automation.test;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.Automation.base.BasePage;
import com.qa.Automation.base.BaseTest;
import com.qa.Automation.pages.SingInPage;

public class SignInPageTest extends BaseTest {

	
	/*
	 * //reference WebDriver driver; Properties prop; BasePage basepage; SingInPage
	 * signuppage;
	 * 
	 * @BeforeTest public void setUp() {
	 * 
	 * basepage = new BasePage(); prop=basepage.init_prop();
	 * driver=basepage.init_driver(prop); signuppage = new SingInPage(driver);; }
	 */
	
	
	
	@Test(priority = 1)
	public void verifySignInPageTitleTest() {
	  String title=	signuppage.getLoginPageTitle();
	  System.out.println("title of the page--" +title);
	  Assert.assertEquals(title,"Login - My Store");
	}
	
	@Test(priority=2)
	public void verifyForgotPassLinkTest() {
	Assert.assertTrue(signuppage.isForgotPassLinkExist());
	}
	
	
	
	@Test(priority = 4, enabled= true)
		public void doLoginTest( ) {
		signuppage.doLogin(prop.getProperty("emailaddress"), prop.getProperty("password"));
	}
	
	@Test(priority=3)
	public void verifyFooterLinkTest() throws InterruptedException {
		List<WebElement> listText=signuppage.isFooterLinkExist();
		
		
	
		   for (WebElement webElement : listText) {
			    
			   
			   String textFooterEle=webElement.getText();
			  
			   if(!textFooterEle.isEmpty()) 
			   {
                	 System.out.println(textFooterEle);
                	  
                	 if(textFooterEle.equals("Best sellers")) {
                		Thread.sleep(1000);
                		 webElement.click(); 
   					  break;
   					  } 
                	 }
			   }
				  
	
				 
		}
}
	
/*
 * @AfterTest public void tearDown() { driver.close(); }
 */

