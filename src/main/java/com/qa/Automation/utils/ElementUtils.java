package com.qa.Automation.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

	
	
	WebDriver driver;
	
	
	public ElementUtils(WebDriver driver) {
		this.driver=driver;
	}
	
	
	
	


	
	/**
	 * this is used to create the WebElement on the basis of the By locator.
	 * @param locator
	 * @return element
	 */
	public WebElement getWebElement(By locator) {
		 WebElement element =driver.findElement(locator);
		 return element;
	}
	
	
	public List<WebElement> getWebElements(By locator) {
		List<WebElement> elements =driver.findElements(locator);
	return	elements;
	}
	
	
	public String waitForTitlePresent(String titleValue, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.titleIs(titleValue));
		return driver.getTitle();
	}
	
	
	/**
	 * this is used to send the value.
	 * @param locator
	 * @param value
	 */
	public void doSendKey(By locator , String value) {
		
	      getWebElement(locator).sendKeys(value);
	}
	
	/**
	 * this is used to click on the element.
	 * @param locator
	 */
	public void doClick(By locator) {
		getWebElement(locator).click();
	}
	
	/**
	 * this method is getting the text value of the element.
	 * @param locator
	 * @return String
	 */
	public String doGettext(By locator) {
		return getWebElement(locator).getText();
	}
	
	/**
	 * 
	 * @param locator
	 * @return boolean
	 */
	public boolean doIsDisplay(By locator) {
		return getWebElement(locator).isDisplayed();
	}
	
	
	
	/**
	 * this is use to click on the link 
	 * @param linkList
	 * @param value
	 */
public  void doLinkClick(List<WebElement> linkList, String value) {
     
        
		System.out.println("total lang options are availabe-->"  + linkList.size());
		
		for (WebElement ele : linkList) {
			
			String text=ele.getText();
			System.out.println(text);
			
			if(text.equals(value)) {
			ele.click();
			break;
			}
			
		}
		
}	
		
		public void getActionMovetoElement(WebElement element ) {
			Actions act = new Actions(driver);
			
			act.moveToElement(element).perform();
		
	}



             

}
