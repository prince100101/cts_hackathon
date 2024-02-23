package testCases;

import org.testng.annotations.Test;

import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_08_VerifyLivingSubmenus extends BaseClass{
	
	@Test
	void verifyLivingSubmenu() {
		SearchPage sp = new SearchPage(driver);
		sp.hoverLiving();
		sp.verifySebmenu();
	}
}
