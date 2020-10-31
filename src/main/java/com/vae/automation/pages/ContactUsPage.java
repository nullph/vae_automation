package com.vae.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.vae.automation.base.BasePage;
import com.vae.automation.utils.ElementUtil;

public class ContactUsPage extends BasePage {
	
	private WebDriver driver;
	ElementUtil elementUtil;
	
	public ContactUsPage(WebDriver driver) {
		elementUtil = new ElementUtil(driver);
		this.driver = driver;
	}

}
