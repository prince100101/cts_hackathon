package pageObjects;

import java.io.IOException;
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
import org.testng.log.TextFormatter;

import com.aventstack.extentreports.model.ScreenCapture;

import utilities.ExcelUtilities;

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
	
	@FindBy(xpath="//div[@class='_1CgPp _1smxk _3AMaB']/input")
	List<WebElement> text_form_list2;
	
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
		if(form.equals("Invalid details")) {
			int i=0;
			ArrayList<String> details = new ArrayList<String>();

			for(int j=0;j<7;j++) {
				try {
					details.add(ExcelUtilities.getCellData(form, 1, j));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			for(WebElement e: text_form_list) {
				e.sendKeys(details.get(i++));
				
			}
			try {
				input_pincode_ele.sendKeys(ExcelUtilities.getCellData(form, 1, 7));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}else {

			int i=0;
			ArrayList<String> details = new ArrayList<String>();

			for(int j=0;j<7;j++) {
				try {
					details.add(ExcelUtilities.getCellData(form, 1, j));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
			for(WebElement e: text_form_list2) {
				e.clear();
			}
			for(WebElement e: text_form_list2) {
				e.sendKeys(details.get(i++));
			}
			text_form_list2.get(0).clear();
			text_form_list.get(0).sendKeys(details.get(6));
			input_pincode_ele.clear();;
			try {
				input_pincode_ele.sendKeys(ExcelUtilities.getCellData(form, 1, 7));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
	}
	
	public void confirmForm() {
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(button_confirmform_ele));
		button_confirmform_ele.click();
	}
	
	public void getAlert() {
//			try {
//				ExcelUtilities.writeExcel(input_youremail_ele.getAttribute("validationMessage"));
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
	}
	
		
	
	
	
	
}
