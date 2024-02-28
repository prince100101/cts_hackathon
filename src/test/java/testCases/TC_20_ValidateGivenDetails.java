package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.GiftCardPage;
import testBase.BaseClass;

public class TC_20_ValidateGivenDetails extends BaseClass {

	@Test(groups= {"regression","master"})
	void confirmInfo() throws IOException {
		GiftCardPage gcp = new GiftCardPage(driver);
		Assert.assertTrue(gcp.confirmInfo());
	}
	
}
