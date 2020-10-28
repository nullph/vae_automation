package com.vae.automation;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class AccountRegistrationTest {
	
	WebDriver driver;
	
	By signInLink = By.partialLinkText("Sign");
	By emailField = By.xpath("//input[@name='email_create']");
	By firstNameField = By.xpath("//input[@id='customer_firstname']");
	By lastNameField = By.xpath("//input[@id='customer_lastname']");
	By passwordField = By.xpath("//input[@id='passwd']");
	By addressFirstNameField = By.xpath("//input[@id='firstname']");
	By addressLastNameField = By.xpath("//input[@id='lastname']");
	By addressField = By.xpath("//input[@id='address1']");
	By cityField = By.xpath("//input[@id='city']");
	By stateField = By.xpath("//select[@id='id_state']");
	By zipField = By.xpath("//input[@id='postcode']");
	By mobileField = By.xpath("//input[@id='phone_mobile']");
	By registerButton = By.xpath("//button[@id='submitAccount']");
	By successfulAccountCreateText = By.xpath("//p[@class='info-account']");
	
	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void accountRegistrationTest() {
		driver.get("http://automationpractice.com/index.php");
		doClick(signInLink);
		clickWhenReady(emailField, 5);
		doSendKeys(emailField, "abc99997@gmail.com");
		clickWhenReady(By.xpath("//button[@id='SubmitCreate']"), 5);
		clickWhenReady(firstNameField, 5);
		doSendKeys(firstNameField, "Test");
		doSendKeys(lastNameField, "Test");
		doSendKeys(passwordField, "12345");
		doSendKeys(addressFirstNameField, "Test");
		doSendKeys(addressLastNameField, "Test");
		doSendKeys(addressField, "123 ABC");
		doSendKeys(cityField, "Main Street");
		doSelectValuesByVisibleText(stateField, "Maryland");
		clickWhenReady(zipField, 5);
		doSendKeys(zipField, "12345");
		doSendKeys(mobileField, "2401112222");
		clickWhenReady(registerButton, 5);
		String successfulAccountCreation = getElement(successfulAccountCreateText).getText();
		System.out.println(successfulAccountCreation);
		Assert.assertEquals("Welcome to your account. Here you can manage all of your personal information and orders.", successfulAccountCreation);
		
	}
	
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	public WebElement getElement(By locator) {
		WebElement element = driver.findElement(locator);
		return element;
	}
	
	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	public WebElement waitForElementToBeVisible(By locator, int timeOut){
		WebElement element = getElement(locator);
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void clickWhenReady(By locator, int timeOut){
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}
		
	public void doSelectValuesByVisibleText(By locator, String value){
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(value);
	}

	
}
