package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_01_VerifyNavigation extends BaseClass {
	
	@Test
	void verifyNavigation() {
		HomePage hp = new HomePage(driver);
		Assert.assertEquals("Buy Furniture Online and Get up to 50% Off | Shop Now - Urban Ladder", hp.verifyNavigation());}
}
