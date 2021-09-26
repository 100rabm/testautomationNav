package com.qa.Automation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.Automation.base.BasePage;
import com.qa.Automation.utils.Constants;
import com.qa.Automation.utils.ElementUtils;

public class UserDashboard extends BasePage {

	WebDriver driver;
	ElementUtils elementUtils;
	
	
	By logOut = By.xpath("//a[@class='logout']");
	By accountName = By.xpath("//a[@class='account']/span");
	By menuText = By.xpath("//a[@class='sf-with-ul']");
	By phoneNoHeard = By.xpath("//span[@class='shop-phone']");
	
	
	
	
	public UserDashboard(WebDriver driver) {
		elementUtils = new ElementUtils(driver);
		this.driver= driver;
	}
	
	
	
	
	public String getDashBoardTitle() {
		//return driver.getTitle();
		return elementUtils.waitForTitlePresent(Constants.DashBoard_Page_Title, 10);
	}
	
	
	public String getPhoneNumber() {
	//	if(driver.findElement(phoneNoHeard).isDisplayed()) {
	  // return	driver.findElement(phoneNoHeard).getText();
	  if( elementUtils.doIsDisplay(phoneNoHeard)) {
		  return elementUtils.doGettext(phoneNoHeard);
	}
            return null;
	
}
	
	public String getAccountName() {
		if(driver.findElement(accountName).isDisplayed()) {
			return driver.findElement(accountName).getText();
		}
		return null;
	}
	
	
	public List<WebElement> getMenuText() {
		List<WebElement> meunList=driver.findElements(menuText);
		 
		   for (WebElement webElement : meunList) {
			   String Menutext=webElement.getText();
			   System.out.println(Menutext);
		}
		   return  meunList;

		   	}




}
