package testCases;


import org.testng.annotations.Test;

import pageObjects.GiftCardPage;
import testBase.BaseClass;

public class TC_16_FillPriceDetails extends BaseClass{

	@Test
	void customiseGiftCard(){
		System.out.println("1");
		GiftCardPage gcp = new GiftCardPage(driver);
		gcp.customiseGiftCard();
	}
}
