package testCases;

import org.testng.annotations.Test;

import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_10_PrintSubMenuInfo extends BaseClass{
	
	@Test(groups= {"master"})
	void printSubmenu() {
		SearchPage sp = new SearchPage(driver);
		sp.printSubmenu();
	}

}
