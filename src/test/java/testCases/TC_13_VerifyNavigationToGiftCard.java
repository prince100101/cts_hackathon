package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.GiftCardPage;
import testBase.BaseClass;

public class TC_13_VerifyNavigationToGiftCard extends BaseClass{
	
	@Test
	void verifyNvigationToGiftCards() {
		GiftCardPage gcp = new GiftCardPage(driver);
		Assert.assertEquals("Gift Card - Buy Gift Cards & Vouchers Online for Wedding, Birthday | Urban Ladder", gcp.verifyNavigation());
	}
}
