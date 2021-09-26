package com.qa.Automation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.Automation.base.BasePage;

public class SingInPage extends BasePage {

	/*
	 * 3 thing to create in the page class 
	 * 
	 * 1-By locator
	 * 2- create the constructor of the page
	 * 3- page actions
	 */
	
	private WebDriver driver;
	
	
	//By locator
	By emailId = By.id("email");
	By password = By.id("passwd");
	By singinButton = By.xpath("//*[@id='SubmitLogin']");
	By ForgotPasswordLink = By.linkText("Forgot your password?"); 
	By FooterLink = By.xpath("//*[@id='footer']//section//li");
	
	// constructor
	public SingInPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	
	// Page actions
	public String getLoginPageTitle() {
		 return driver.getTitle();
	}
	
	public boolean isForgotPassLinkExist() {
		return driver.findElement(ForgotPasswordLink).isDisplayed();
	}
	
	public UserDashboard doLogin(String emId, String pass) {
		
		driver.findElement(emailId).sendKeys(emId);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(singinButton).click();
		
		// returning next page object
		return new UserDashboard(driver);
	}
	
	public List<WebElement> isFooterLinkExist() {
    List<WebElement> fLinks=driver.findElements(FooterLink);
     //System.out.println("total links are present--" + fLinks.size());
     
     return fLinks;
	}



}
