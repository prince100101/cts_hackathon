package testCases;

import org.testng.annotations.Test;

import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_05_FilterBookshelves extends BaseClass {
	
	@Test(priority = 0, groups= {"regression","master"})
	void sortBy() {
		SearchPage sp = new SearchPage(driver);
		sp.sortBy();
	}
	
	@Test(priority = 1, groups= {"regression","master"})
	void excludeOutOfStock() {
		SearchPage sp = new SearchPage(driver);
		sp.tickChceckbox();
	}
	
	@Test(priority = 2, groups= {"regression","master"})
	void setPrice() throws InterruptedException {
		Thread.sleep(3000);
		SearchPage sp = new SearchPage(driver);
		sp.setPrice();
	}
	
	@Test(priority = 3, groups= {"regression","master"})
	void setCategory() {
		SearchPage sp = new SearchPage(driver);
		sp.setCategory();
	}
	
	
	
}
