package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	@Test(groups={"Sanity","Master"})
	public void TS002_TC_LF_001() {
		
		try {
		
		logger.info("****** Startign TC_001_LoginTest *****");
		
		HomePage hp = new HomePage(driver);
		
		// 2) Navigate to 'My Account' and click 'Register'
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount link.");
		
		// 3) Click on Login link		
		hp.clickLogin();
		
		LoginPage lp = new LoginPage(driver);
		
		// 4) Entering valid email
		lp.setEmail(p.getProperty("email"));
		
		// 5) Entering valid password
		lp.setPassword(p.getProperty("password"));
		
		// 6) Click on Login button
		lp.clickLogin();
		
		//Validate the MyAccountPage
		
		MyAccountPage map = new MyAccountPage(driver);
		
        boolean targetPage=map.isMyAccountPageExists();
		
		Assert.assertTrue(targetPage);//Assert.assertEquals(targetPage, true,"Login failed");
		
		} catch(Exception e){
			
			Assert.fail();
		}
		
		
		logger.info("****** Finished TC_002_LoginTest *****");
		
	}
	
	
	

}
