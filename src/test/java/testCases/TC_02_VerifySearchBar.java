package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_02_VerifySearchBar extends BaseClass{
	
	@Test(groups= {"sanity","master"})
	void verifySearchBar() {
		HomePage hp = new HomePage(driver);
		Assert.assertTrue(hp.verifySearchBar());		
	}
}
