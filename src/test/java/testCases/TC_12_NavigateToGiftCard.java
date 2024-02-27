package testCases;

import org.testng.annotations.Test;

import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_12_NavigateToGiftCard extends BaseClass{

	@Test(groups= {"sanity","regression","master"})
	void navigateToGiftCards() {
		SearchPage sp = new SearchPage(driver);
		sp.navigateToGiftCards();
	}
}
