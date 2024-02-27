package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.GiftCardPage;
import testBase.BaseClass;

public class TC_14_VerifyBirthDayLink extends BaseClass {

	@Test(groups= {"regression","master"})
	void verifyBirthDayButton() {
		GiftCardPage gcp = new GiftCardPage(driver);
		Assert.assertTrue(gcp.verifyBirthDayLink());
	}
}
