package testCases;

import org.testng.annotations.Test;

import pageObjects.GiftCardPage;
import testBase.BaseClass;

public class TC_19_FillValidForm extends BaseClass{

	@Test(groups= {"regression","master"})
	void fillValidForm() throws InterruptedException {
		GiftCardPage gcp = new GiftCardPage(driver);
		gcp.fillForm("Valid details");
		gcp.confirmForm();
		
	}
}
