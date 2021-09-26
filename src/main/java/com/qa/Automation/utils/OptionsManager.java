package com.qa.Automation.utils;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {

	
	//this class is responsible for the handle the browser options (headless, incognito mode) will use this class in Base Page.
	
	
	
	Properties prop;
	ChromeOptions co;
	FirefoxOptions fo;
	
	
	//Constructor
	public OptionsManager(Properties prop) {
		this.prop = prop;
	}
	
	
	public ChromeOptions getChromeOption() {
		co = new ChromeOptions();
		if(Boolean.parseBoolean( prop.getProperty("headless")))  // converting string to boolean, headless key is a string.
		co.addArguments("--headless");
		if(Boolean.parseBoolean( prop.getProperty("incognito"))) co.addArguments("--incognito");
		
		return co;
	}
	
	public FirefoxOptions getFirefoxOption() {
		fo = new FirefoxOptions ();
		if(Boolean.parseBoolean( prop.getProperty("headless")))  // converting string to boolean, headless key is a string.
		fo.addArguments("--headless");
		if(Boolean.parseBoolean( prop.getProperty("incognito"))) co.addArguments("--incognito");
		
		return fo;
	}
	
}
