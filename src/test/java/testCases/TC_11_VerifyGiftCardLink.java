package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_11_VerifyGiftCardLink extends BaseClass {
	
	@Test
	void verifyGiftCardLink() {
		SearchPage sp = new SearchPage(driver);
		Assert.assertTrue(sp.verifyGiftCard());
	}
}
