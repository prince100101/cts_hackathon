package testCases;

import org.testng.annotations.Test;

import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_06_PrintBookshelves extends BaseClass {
	
	@Test(groups= {"regression","master"})
	void printInfo() throws InterruptedException {
		SearchPage sp = new SearchPage(driver);
		Thread.sleep(3000);
		sp.printInfo();
	}
}
