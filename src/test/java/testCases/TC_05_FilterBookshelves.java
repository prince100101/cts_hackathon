package testCases;

import org.testng.annotations.Test;

import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_05_FilterBookshelves extends BaseClass {
	
	@Test(priority = 0)
	void sortBy() {
		SearchPage sp = new SearchPage(driver);
		sp.sortBy();
	}
	
	@Test(priority = 1)
	void excludeOutOfStock() {
		SearchPage sp = new SearchPage(driver);
		sp.tickChceckbox();
	}
	
	@Test(priority = 2)
	void setPrice() throws InterruptedException {
		Thread.sleep(3000);
		SearchPage sp = new SearchPage(driver);
		sp.setPrice();
	}
	
	@Test(priority = 3)
	void setCategory() {
		SearchPage sp = new SearchPage(driver);
		sp.setCategory();
	}
	
	
	
}
