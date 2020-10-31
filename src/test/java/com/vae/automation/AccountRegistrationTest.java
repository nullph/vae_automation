package com.vae.automation;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.vae.automation.base.BasePage;
import com.vae.automation.pages.AccountRegistrationPage;
import com.vae.automation.pages.HomePage;
import com.vae.automation.utils.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AccountRegistrationTest {

	AccountRegistrationPage accountRegistrationPage;
	HomePage homePage;
	BasePage basePage;
	Constants constant;
	Properties prop;
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.initialize_prop();
		String browserName = prop.getProperty("browser");
		driver = basePage.initialize_driver(browserName);
		driver.get(prop.getProperty("url"));
		
		homePage = new HomePage(driver);
		accountRegistrationPage = new AccountRegistrationPage(driver);
		
	}

	@Test
	public void accountRegistrationTest() {
		homePage.clickOnSignIn();
		accountRegistrationPage.createNewAccount("abc@gmail.com", "Bob", "Smith", "12345", "Bob", "Smith", "123 Main", "Cedarwood", "Virginia", "22222", "123456789");
		String accountCreationText = accountRegistrationPage.getSuccessfulAccountCreation();
		System.out.println("succcessful account registration message is : " + accountCreationText);
		Assert.assertEquals(accountCreationText, Constants.ACCOUNT_REGISTRATION_TEXT);
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	

	
}
