package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import resources.PropertiesFile;

public class ContactUsPage {

	WebDriver driver = null;
	WebDriverWait wait = null;

	@FindBy(xpath="//button[@id='btnSubmit']")
	WebElement btn_submit;

	@FindBy(id="reachoutforproduct")
	WebElement drd_iam_looking;
	
	@FindBy(id="product")
	WebElement drd_initial_sub_product;

	@FindBy(id="need")
	WebElement drd_product;
	
	@FindBy(id="mobile")
	WebElement input_phno;	
	
	@FindBy(xpath="//span[contains(@ng-show, 'mobile')]")
	WebElement phno_error;

	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(this.driver, 50);		
	}

	public void click_btn_submit() {
		this.wait.until(ExpectedConditions.visibilityOf(btn_submit)).click();
	}

	public void verify_mandatory_fields() {

		int num_of_mandatory_fields = 9;
		List<WebElement> mandatory_fields = driver.findElements(By.xpath("//*[contains(@class, 'has-error')]"));
		Assert.assertEquals(mandatory_fields.size(), num_of_mandatory_fields, "Mandatory Fields displayed are not 9 in number");

	}

	public void select_drd_iam_looking_to() {

		int num_of_options_in_drd = 4;
		Select drd_looking_into = new Select(drd_iam_looking);
		List<WebElement> drd_options = drd_looking_into.getOptions();
		Assert.assertEquals((drd_options.size() - 1), num_of_options_in_drd, "More than 4 options are displayed in the list");
	}
	
	public void select_drd_initial_sub_product() {
		Select drd_sub_product = new Select(drd_initial_sub_product);
		List<WebElement> drd_options = drd_sub_product.getOptions();
		System.out.println(drd_options);	
	}
	
	public void select_drd_sub_product() {
		int num_of_options_in_drd = 6;
		Select drd_sub_product = new Select(drd_initial_sub_product);
		drd_sub_product.selectByVisibleText("Home Loan UAE Resident");
		List<WebElement> drd_options = drd_sub_product.getOptions();
		Assert.assertEquals((drd_options.size() - 1), num_of_options_in_drd, "More than 6 options are displayed in the list");
		
	}
	
	public void select_drd_product() {		
		Select drd_select_product = new Select(drd_product);
		drd_select_product.selectByVisibleText("Loans");
	}
	
	public void enter_invalid_mobile_number() {
		String InvalidNumber = PropertiesFile.InvalidNumber();	
		this.wait.until(ExpectedConditions.visibilityOf(input_phno)).sendKeys(InvalidNumber);
		phno_error.isDisplayed();
		
	}
			
	public void enter_valid_mobile_number() {
		String ValidNumber = PropertiesFile.ValidNumber();
		input_phno.clear();
		input_phno.sendKeys(ValidNumber);		
	}	
}



