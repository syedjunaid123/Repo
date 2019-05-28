package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver = null;
	WebDriverWait wait = null;


	@FindBy(xpath="//div[@class='leftLinks']//ul")
	WebElement nav_bar;

	@FindBy(xpath="//li[@ng-class='corporatelCSS']/a")
	WebElement corporate_tab;

	@FindBy(xpath="//li[@ng-class='businessCSS']/a")
	WebElement business_tab;

	@FindBy(xpath="//li[@ng-class='internationalCSS']/a")
	WebElement international_tab;

	@FindBy(xpath="//div[@class='leftLinks']//a[contains(text(),'Private Banking')]")
	WebElement private_banking_tab;

	@FindBy(xpath="//div[@class='leftLinks']//a[contains(text(),'Al Islami')]")
	WebElement al_islami_tab;

	@FindBy(xpath="//div[@class='leftLinks']//a[contains(text(),'Gold')]")
	WebElement gold_tab;

	@FindBy(xpath="//div[@class='leftLinks']//a[contains(text(),'Mashreq Securities')]")
	WebElement mashreq_securities_tab;

	@FindBy(xpath="//div[@class='leftLinks']//a[contains(text(),'Mashreq Capital')]")
	WebElement mashreq_capital_tab;

	@FindBy(xpath="//div[@class='leftLinks']//a[contains(text(),'Mashreq Global Services')]")
	WebElement mashreq_global_services_tab;
	
	@FindBy(xpath="//div[@class='newsBox']")
	WebElement mashreq_news;
	
	@FindBy(xpath="//div[@class='carousel-inner']")
	WebElement inner_news;
	
	@FindBy(xpath="//div[contains(@class, 'buystrip')]//a[contains(@href, 'contactus')]")
	WebElement lnk_contact_us;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(this.driver, 50);		
	}	
	public boolean lbl_Navigation_bar() {
		return nav_bar.isDisplayed();					
	}	
	public String get_corporate_tab() {
		String text = corporate_tab.getAttribute("innerText");
		return text;
	}	
	public String get_business_tab() {
		String text = business_tab.getAttribute("innerText");
		return text;
	}	
	public String get_international_tab() {
		String text = international_tab.getAttribute("innerText");
		return text;
	}	
	public String get_private_banking_tab() {
		String text = private_banking_tab.getAttribute("innerText");
		return text;
	}	
	public String get_al_islami_tab() {
		String text = al_islami_tab.getAttribute("innerText");
		return text;
	}	
	public String get_gold_tab() {
		String text = gold_tab.getAttribute("innerText");
		return text;
	}	
	public String get_mashreq_securities_tab() {
		String text = mashreq_securities_tab.getAttribute("innerText");
		return text;
	}	
	public String get_mashreq_capital_tab() {
		String text = mashreq_capital_tab.getAttribute("innerText");
		return text;
	}
	public String get_mashreq_global_services_tab() {
		String text = mashreq_global_services_tab.getAttribute("innerText");
		return text;
	}
	
	public boolean lbl_mashreq_news_section() {
		return this.wait.until(ExpectedConditions.visibilityOf(mashreq_news)).isDisplayed();					
	}
	
	public boolean lbl_inner_news() {
		return inner_news.isDisplayed();					
	}
	
	public boolean is_lnk_contact_us() {
		return lnk_contact_us.isDisplayed();					
	}
	
	public void click_lnk_contact_us() {
		lnk_contact_us.click();
	}
	
}
