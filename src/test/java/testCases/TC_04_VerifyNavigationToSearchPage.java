package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_04_VerifyNavigationToSearchPage extends BaseClass {

	@Test
	void verifyNavigation() {
		SearchPage sp = new SearchPage(driver);
		System.out.println(driver);
		Assert.assertTrue(sp.verifyNavigation());
	}
}
