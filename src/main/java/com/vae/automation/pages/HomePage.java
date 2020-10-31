package com.vae.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.vae.automation.base.BasePage;
import com.vae.automation.utils.ElementUtil;

public class HomePage extends BasePage {
	
	private WebDriver driver;
	ElementUtil elementUtil;
	
	
	private By signInLink = By.partialLinkText("Sign");
	private By contactUsLink = By.partialLinkText("Contact");
	private By cartLink = By.xpath("//a[@title='View my shopping cart']");
	
	public HomePage(WebDriver driver) {
		elementUtil = new ElementUtil(driver);
		this.driver = driver;
	}
	
	public AccountRegistrationPage navigateToAccountRegistrationPage() {
		clickOnSignIn();
		return new AccountRegistrationPage(driver);
	}
	
	public ContactUsPage navigateToContactUsPage() {
		clickOnSignIn();
		return new ContactUsPage(driver);
	}
	
	public void clickOnSignIn() {
		elementUtil.doClick(signInLink);
	}
	
	public void clickOnContactUs() {
		elementUtil.doClick(signInLink);
	}
	
	public void clickOnCart() {
		elementUtil.doClick(cartLink);
	}
	

}
