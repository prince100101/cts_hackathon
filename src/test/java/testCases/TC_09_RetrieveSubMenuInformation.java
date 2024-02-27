package testCases;

import org.testng.annotations.Test;

import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_09_RetrieveSubMenuInformation extends BaseClass{

	@Test(groups= {"master"})
	void retrieveInfo() {
		SearchPage sp = new SearchPage(driver);
		sp.hoverLiving();
		sp.retrieveSubmenu();
	}
}
