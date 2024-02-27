package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_01_VerifyNavigation extends BaseClass {
	
	@Test(groups= {"sanity","master"})
	void verifyNavigation() {
		HomePage hp = new HomePage(driver);
		//logger.info("TC_01_VerifyNavigation started");
		Assert.assertEquals("Buy Furniture Online and Get up to 50% Off | Shop Now - Urban Ladder", hp.verifyNavigation());
		//logger.info("Navigation to Urbanladder verified");
	}
}
