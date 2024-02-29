package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ExcelUtilities;

public class SearchPage extends BasePage {

	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	//webelements required on search page
	
	@FindBy(xpath="//h2[@class='withsubtext']")
	WebElement text_searchpaageheading_ele;
	
	@FindBy(xpath="//div[@class='item']")
	WebElement button_sortby_ele;
	
	@FindBy(xpath="//li[contains(text(),'Price: High to Low')]")
	WebElement button_sortby_price_ele;
	
	@FindBy(id="filters_availability_In_Stock_Only")
	WebElement checkbox_stock_ele;
	
	@FindBy(xpath="//li[@data-group='price'][@class='item']")
	WebElement dropdown_price_ele;
	
	@FindBy(xpath="//li[@data-group='category'][@class='item']")
	WebElement dropdown_category_ele;
	
	@FindBy(id="filters_primary_category_Kids_Bookshelves")
	WebElement input_category_ele;
	
	@FindBy(xpath="//span[@class='range-max']")
	WebElement slider_price_ele;
	
	@FindBy(xpath="//div[@class='product-title product-title-sofa-mattresses']/span")
	List<WebElement> text_bookshelf_title_list;
	
	@FindBy(xpath="//div[@class='product_brand_name']/div")
	List<WebElement> text_bookshelf_brand_list;
	
	@FindBy(xpath="//div[@class='price-number']/span")
	List<WebElement> text_bookshelf_price_list;
	
	@FindBy(xpath="//li[@class='topnav_item livingunit']")
	WebElement dropdown_living_ele;
	
	@FindBy(xpath="//li[@class='topnav_item livingunit']/div/div/ul/li[1]/ul/li/a/span")
	List<WebElement> text_submenuitems_list;
	
	@FindBy(xpath="//li[@class='topnav_item livingunit']/div/div/ul/li/div/a")
	WebElement text_submenuheading_ele;
	
	@FindBy(xpath="//*[@class='featuredLinksBar__linkContainer']/li[3]/a")
	WebElement link_giftcards_ele;
	
	@FindBy(xpath="//a[@class='close-reveal-modal hide-mobile']")
	WebElement button_closepopup_ele;
	
	@FindBy(xpath="//div[@class='noUi-base']/div[2]")
	WebElement button_dragprice_ele;
	
	@FindBy(xpath="//div[@class='noUi-handle noUi-handle-lower']")
	WebElement slider_dropprice_ele;
	
	@FindBy(xpath="//span[@class='range-max']")
	WebElement text_targetprice_ele;
	
	
	ArrayList<String> submenu = new ArrayList<String>(); //for storing string in submenu webelemnts
	
	//verifying navigation to search page
	public boolean verifyNavigation() {
		handlePopup();
		return text_searchpaageheading_ele.isDisplayed();
	}
	
	//sorting results
	public void sortBy() {
		handlePopup();
		Actions action = new Actions(driver);
		action.moveToElement(button_sortby_ele);
		action.perform();
		button_sortby_price_ele.click();
	}
	
	//exclude out of stock
	public void tickChceckbox() {
		handlePopup();
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(checkbox_stock_ele));
		checkbox_stock_ele.click();
	}
	
	//filtering search results based on price
	public void setPrice() throws InterruptedException {
		handlePopup();
		
		Actions action = new Actions(driver);
		action.moveToElement(dropdown_price_ele).perform();;
		Thread.sleep(3000);
		action.clickAndHold(button_dragprice_ele).moveByOffset(-210, 0).perform();
		System.out.println(text_targetprice_ele.getText());
		//wait.until(ExpectedConditions.textToBePresentInElement(text_targetprice_ele, "15000"));

		action.release().perform();
	}
	
	//filtering search results according to category
	public void setCategory() {
		handlePopup();
		
		Actions action = new Actions(driver);
		action.moveToElement(dropdown_category_ele).perform();
		input_category_ele.click();
	}
	
	//printing bookshelves info
	public void printInfo() {
		handlePopup();
		ArrayList<String> title = new ArrayList<String>();
		ArrayList<String> brand = new ArrayList<String>();
		ArrayList<String> price = new ArrayList<String>();
		
		for(WebElement e : text_bookshelf_title_list) {
			title.add(e.getText());
		}
		
		for(WebElement e : text_bookshelf_brand_list) {
			brand.add(e.getText());
		}
		
		for(WebElement e : text_bookshelf_price_list) {
			price.add(e.getText());
		}
		
		System.out.println(title);
		System.out.println(brand);
		System.out.println(price);
		try {
			ExcelUtilities.writeExcel(title,"Bookshelves", 1, 0);
			ExcelUtilities.writeExcel(brand,"Bookshelves", 1, 1);
			ExcelUtilities.writeExcel(price,"Bookshelves", 1, 2);
		}catch(Exception e) {
			e.printStackTrace();
		}
		

		
	}
	
	//verifying presence of living menu
	public boolean verifyLiving() {
		return dropdown_living_ele.isDisplayed();
	}
	
	//hovering over living menu
	public void hoverLiving() {
		Actions action = new Actions(driver);
		action.moveToElement(dropdown_living_ele);
		action.perform();
	}
	
	//verifying presence of living submenus
	public boolean verifySebmenu() {
		return text_submenuheading_ele.isDisplayed();
	}
	
	//retrieving submenu info
	public void retrieveSubmenu() {
		
		for(WebElement e: text_submenuitems_list) {
			submenu.add(e.getText());
		}
	}
	
	//print submenu info
	public void printSubmenu() {
		retrieveSubmenu();
		System.out.println(text_submenuheading_ele.getText());
		System.out.println(submenu);
		try {
			ExcelUtilities.writeExcel(submenu,"Submenu",1,0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//verifying presence of gift card link
	public boolean verifyGiftCard() {
		scrollToElement(link_giftcards_ele);
		return link_giftcards_ele.isDisplayed();
	}
	
	//navigation to gift card
	public void navigateToGiftCards() {
		link_giftcards_ele.click();
	}
	
	//for handling pop up
	public void handlePopup() {
		if(button_closepopup_ele.isDisplayed()) {
			button_closepopup_ele.click();
		}
		scrollToElement(dropdown_price_ele);
	}
	
	//for scrolling
	public void scrollToElement(WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
	    js.executeScript("arguments [0].scrollIntoView();", e);
	}
	
	
	
	

}
