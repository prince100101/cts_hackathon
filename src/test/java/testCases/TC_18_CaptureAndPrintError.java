package testCases;

import org.testng.annotations.Test;

import pageObjects.GiftCardPage;
import testBase.BaseClass;

public class TC_18_CaptureAndPrintError extends BaseClass{

	@Test(groups= {"regression","master"})
	void getAlert() {
		GiftCardPage gcp = new GiftCardPage(driver);
		gcp.getAlert();
	}
}
