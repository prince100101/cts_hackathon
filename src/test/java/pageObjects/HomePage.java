package pageObjects;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	Properties p = BaseClass.p; //properties variable for accessing config.properties
	
	//webelements required on the home page
	
	@FindBy(id="search")
	WebElement input_searchbox_ele;
	
	@FindBy(xpath="//li[@class='subnav_item 1600']/a/span")
	WebElement button_bookshelves_ele;
	
	@FindBy(id="search_button")
	WebElement button_search_ele;
	
	//verifying navigation to home page
	public String verifyNavigation() {
		return driver.getTitle();
	}
	
	//verifying the presence of search bar
	public boolean verifySearchBar() {
		return input_searchbox_ele.isDisplayed();
	}
	
	//search for bookshelves
	public void searchBookshelves() {
		input_searchbox_ele.sendKeys(p.getProperty("search"));
	}
	
	//click search button
	public void clickSearch() {
		button_search_ele.click();
	}
}
