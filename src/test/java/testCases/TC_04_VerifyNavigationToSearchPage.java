package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_04_VerifyNavigationToSearchPage extends BaseClass {

	@Test(groups= {"regression","master"})
	void verifyNavigation() {
		SearchPage sp = new SearchPage(driver);
		Assert.assertTrue(sp.verifyNavigation());
	}
}
