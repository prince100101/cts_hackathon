package testCases;


import org.testng.annotations.Test;

import pageObjects.GiftCardPage;
import testBase.BaseClass;

public class TC_16_FillPriceDetails extends BaseClass{

	@Test(groups= {"regression","master"})
	void customiseGiftCard(){
		GiftCardPage gcp = new GiftCardPage(driver);
		gcp.customiseGiftCard();
	}
}
