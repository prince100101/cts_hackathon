package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_01_VerifyNavigation extends BaseClass {
	
	@Test(groups= {"sanity","master"})
	void verifyNavigation() {
		HomePage hp = new HomePage(driver);
		Assert.assertEquals(p.getProperty("mainPageTitle"), hp.verifyNavigation());
	}
}
