package com.vae.automation.pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.vae.automation.base.BasePage;
import com.vae.automation.utils.ElementUtil;

public class AccountRegistrationPage extends BasePage {
	
	private WebDriver driver;
	ElementUtil elementUtil;
		
	private By emailField = By.xpath("//input[@name='email_create']");
	private By createAnAccountButton = By.xpath("//button[@id='SubmitCreate']");
	private By firstNameField = By.xpath("//input[@id='customer_firstname']");
	private By lastNameField = By.xpath("//input[@id='customer_lastname']");
	private By passwordField = By.xpath("//input[@id='passwd']");
	private By addressFirstNameField = By.xpath("//input[@id='firstname']");
	private By addressLastNameField = By.xpath("//input[@id='lastname']");
	private By addressField = By.xpath("//input[@id='address1']");
	private By cityField = By.xpath("//input[@id='city']");
	private By stateField = By.xpath("//select[@id='id_state']");
	private By zipField = By.xpath("//input[@id='postcode']");
	private By mobileField = By.xpath("//input[@id='phone_mobile']");
	private By registerButton = By.xpath("//button[@id='submitAccount']");
	private By successfulAccountCreateText = By.xpath("//p[@class='info-account']");
	
	public AccountRegistrationPage(WebDriver driver) {
		elementUtil = new ElementUtil(driver);
		this.driver = driver;
	}
	
	public void createNewAccount(String emailId, String firstNameId, String lastNameId, String passwordId, String addressFNId, String addressLNId, String addressId, String cityId, String stateId, String zipId, String mobileId) {
		elementUtil.clickWhenReady(emailField, 5);
		elementUtil.doSendKeys(this.emailField, generateRandomNumber() + emailId);
		elementUtil.clickWhenReady(createAnAccountButton, 5);
		elementUtil.clickWhenReady(firstNameField, 5);
		elementUtil.doSendKeys(this.firstNameField, firstNameId);
		elementUtil.doSendKeys(this.lastNameField, lastNameId);
		elementUtil.doSendKeys(this.passwordField, passwordId);
		elementUtil.doSendKeys(this.addressFirstNameField, addressFNId);
		elementUtil.doSendKeys(this.addressLastNameField, addressLNId);
		elementUtil.doSendKeys(this.addressField, addressId);
		elementUtil.doSendKeys(this.cityField, "Main Street");
		elementUtil.doSelectValuesByVisibleText(this.stateField, stateId);
		elementUtil.clickWhenReady(zipField, 5);
		elementUtil.doSendKeys(this.zipField, zipId);
		elementUtil.doSendKeys(this.mobileField, mobileId);
		elementUtil.clickWhenReady(registerButton, 5);
	}
	
	public String getSuccessfulAccountCreation() {
			elementUtil.waitForElementToBeVisible(successfulAccountCreateText, 5);
			return elementUtil.doGetText(successfulAccountCreateText);
		}
	
	public int generateRandomNumber() {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);
		return randomInt;
	}
	
}
