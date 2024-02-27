package testCases;

import org.testng.annotations.Test;

import pageObjects.GiftCardPage;
import testBase.BaseClass;

public class TC_17_FillInvalidForm extends BaseClass {
	
	@Test(groups= {"regression","master"})
	void fillInvalidForm() throws InterruptedException {
		GiftCardPage gcp = new GiftCardPage(driver);
		gcp.fillForm("Invalid details");
		gcp.confirmForm();
	}
}
