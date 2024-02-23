package testCases;

import org.testng.annotations.Test;

import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_07_VerifyLivingMenu extends BaseClass {
	
	@Test
	void verifyLivingMenu() {
		SearchPage sp = new SearchPage(driver);
		sp.verifyLiving();
	}
	
}
