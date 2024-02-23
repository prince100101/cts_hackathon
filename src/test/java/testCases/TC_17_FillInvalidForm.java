package testCases;

import org.testng.annotations.Test;

import pageObjects.GiftCardPage;
import testBase.BaseClass;

public class TC_17_FillInvalidForm extends BaseClass {
	
	@Test
	void fillInvalidForm() throws InterruptedException {
		System.out.println("2");
		GiftCardPage gcp = new GiftCardPage(driver);
		gcp.fillForm("Invalid details");
		gcp.confirmForm();
	}
}
