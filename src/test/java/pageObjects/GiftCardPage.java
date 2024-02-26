package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GiftCardPage extends BasePage {

	public GiftCardPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h3[@class='_21JOl'][contains(text(),'Birthday/Anniversary')]")
	WebElement text_birthday_ele;
	
	@FindBy(xpath="//h3[@class='_21JOl'][contains(text(),'Birthday/Anniversary')]/following-sibling::div/button")
	WebElement button_choosebirthday_ele;
	
	@FindBy(xpath="//div[@class='_3jn98 _23tqD _3k9Vm']/button[1]")
	WebElement button_giftamount_ele;
	
	@FindBy(xpath="//button[@class='_1IFIb _1fVSi action-button _1gIUf _1XfDi']")
	WebElement button_giftnext_ele;
	
	@FindBy(xpath="//div[@class='_1CgPp _1smxk']/input")
	List<WebElement> text_form_list;
	
	@FindBy(xpath="//button[@class='_3Hxyv _1fVSi action-button _1gIUf _1XfDi']")
	WebElement button_confirmform_ele;
	
	@FindBy(xpath="//section[@class='_14QEd _2X0VN']/h2")
	WebElement heading_form_ele;
	
	@FindBy(id="ip_567727260")
	WebElement input_pincode_ele;
	
	@FindBy(id="ip_4081352456")
	WebElement input_youremail_ele;
	
	public String verifyNavigation() {
		return driver.getTitle();
	}
	
	public boolean verifyBirthDayLink() {
		Actions action = new Actions(driver);
		action.moveToElement(text_birthday_ele);
		action.perform();
		return button_choosebirthday_ele.isDisplayed();
	}
	
	public void selectBirthday() {
		button_choosebirthday_ele.click();
	}
	
	public void customiseGiftCard() {
		button_giftamount_ele.click();
		button_giftnext_ele.click();
	}
	
	public void fillForm(String form) {
		if(form.equalsIgnoreCase("Invalid details")) {
			int i=0;
			ArrayList<String> details = new ArrayList<String>();
			details.add("Recipient");
			details.add("Recipient@email.com");
			details.add("9917234567");
			details.add("yourname");
			details.add("youremail.com");
			details.add("9876543210");
			details.add("Address");
			for(WebElement e: text_form_list) {
				e.sendKeys(details.get(i++));
			}
			input_pincode_ele.sendKeys("603103");
		}else {
			int i=0;
			ArrayList<String> details = new ArrayList<String>();
			details.add("Recipient");
			details.add("Recipient@email.com");
			details.add("9917234567");
			details.add("yourname");
			details.add("your@email.com");
			details.add("9876543210");
			details.add("Address");
			for(WebElement e: text_form_list) {
				e.clear();;
			}
			for(WebElement e: text_form_list) {
				e.sendKeys(details.get(i++));
			}
			input_pincode_ele.clear();;
			input_pincode_ele.sendKeys("603103");
		}
		
	}
	
	public void confirmForm() {
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(button_confirmform_ele));
		button_confirmform_ele.click();
	}
	
	public void getAlert() {
			System.out.println(input_youremail_ele.getAttribute("validationMessage"));
	}
	
	//further code
	
	
	
	
	
}
