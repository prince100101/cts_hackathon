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
	Properties p = BaseClass.p;
	
	@FindBy(id="search")
	WebElement input_searchbox_ele;
	
	@FindBy(xpath="//li[@class='subnav_item 1600']/a/span")
	WebElement button_bookshelves_ele;
	
	@FindBy(id="search_button")
	WebElement button_search_ele;
	
	public String verifyNavigation() {
		return driver.getTitle();
	}
	
	public boolean verifySearchBar() {
		return input_searchbox_ele.isDisplayed();
	}
	
	public void searchBookshelves() {
		input_searchbox_ele.sendKeys(p.getProperty("search"));
	}
	
	public void clickSearch() {
		button_search_ele.click();
	}
}
