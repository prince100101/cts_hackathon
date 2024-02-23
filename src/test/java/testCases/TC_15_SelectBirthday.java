package testCases;

import org.testng.annotations.Test;

import pageObjects.GiftCardPage;
import testBase.BaseClass;

public class TC_15_SelectBirthday extends BaseClass {

	@Test
	void selectBirthdayOption() {
		GiftCardPage gcp = new GiftCardPage(driver);
		gcp.selectBirthday();
	}
}
