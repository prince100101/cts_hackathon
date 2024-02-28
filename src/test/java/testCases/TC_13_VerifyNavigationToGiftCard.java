package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.GiftCardPage;
import testBase.BaseClass;

public class TC_13_VerifyNavigationToGiftCard extends BaseClass{
	
	@Test(groups= {"sanity","master"})
	void verifyNvigationToGiftCards() {
		GiftCardPage gcp = new GiftCardPage(driver);
		Assert.assertEquals(p.getProperty("giftPageTitle"), gcp.verifyNavigation());
	}
}
