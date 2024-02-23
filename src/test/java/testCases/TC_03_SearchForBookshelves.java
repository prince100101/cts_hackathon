package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_03_SearchForBookshelves extends BaseClass {

	@Test
	void searchForBookshelves() {
		HomePage hp = new HomePage(driver);
		hp.searchBookshelves();
		hp.clickSearch();
	}
}
