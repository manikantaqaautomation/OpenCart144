package testCases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

/**
 * Test Case: Account Registration
 * 
 * Steps: 1) Navigate to application URL 
 * 2) Navigate to 'My Account' and click 'Register' 
 * 3) Fill in registration details 
 * 4) Agree to Privacy Policy and submit registration 
 * 5) Validate confirmation message
 */

public class TC001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups={"Regression","Master"})
	public void TS001_TC_RF_001() {
		logger.info("***** Starting TC001_AccountRegistrationTest  ****");
		logger.debug("This is a debug log message");
		try {
		HomePage hp = new HomePage(driver);
		// 2) Navigate to 'My Account' and click 'Register'
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount link.");
		hp.clickRegister();
		logger.info("Clicked on Register link, navigated to Registration page.");
		
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		// 3) Fill in registration details
		logger.info("Entering user details for registration...");
		regpage.setFirstName(randomString().toUpperCase());
		logger.info("First Name set successfully...");
		regpage.setLastName(randomString().toUpperCase());
		logger.info("Last Name set successfully...");
		regpage.setEmail(randomString()+"@mail.com");
		logger.info("Email entered:");
		regpage.setTelephone(randomNumber());
		logger.info("Entered phone number:");
		String password = randomAlphaNumeric();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		logger.info("Entered password and confirmed password successfully.");
		// 4) Agree to Privacy Policy and submit registration
		regpage.setPrivacyPolicy();
		logger.info("Agreed to Privacy Policy.");
		regpage.clickContinue();
		logger.info("Clicked 'Continue' to submit the registration form.");
		// 5) Validate confirmation message
	    logger.info("Validating the confirmation message...");
		String confrmMessage = regpage.getConfirmationMsg();
		if(confrmMessage.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		} else {
			logger.error("Test failed ..");
			logger.debug("Debug logs...");
			Assert.assertTrue(false);
		}
		//Assert.assertEquals(confrmMessage,"Your Account Has Been Created!","Registration failed: Confirmation message mismatch.");
		logger.info("Account registration successful. Confirmation message validated.");
		} catch(Exception e){
			Assert.fail();
		}
		
	}

}
