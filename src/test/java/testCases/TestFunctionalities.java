package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.ITestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


import io.github.bonigarcia.wdm.WebDriverManager;
import pages.ContactUsPage;
import pages.HomePage;




import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;

@Listeners(resources.TestNGListeners.class)

public class TestFunctionalities {
	WebDriver driver;
	WebDriverWait wait;

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	static String projectPath;


	Logger logger = LogManager.getLogger(TestFunctionalities.class);
	SoftAssert soft_assert = new SoftAssert();

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.mashreqbank.com/uae/en/personal/home");

		wait = new WebDriverWait(driver, 10, 50);



		projectPath = System.getProperty("user.dir");
		String timestamp = String.valueOf(new Date().getTime());
		htmlReporter = new ExtentHtmlReporter(projectPath+"/ExtentReports/Extent"+timestamp+".html");
		extent = new ExtentReports();	


	}


	@Test
	public void Test_NavigationBar() {	
		extent.attachReporter(htmlReporter);
		ExtentTest test = extent.createTest("Test_NavigationBar", "This test is to check the NavigationBar");
		test.log(Status.INFO, "This TEST has been started(status, details)");

		HomePage navigation_bar_section = new HomePage(driver);

		soft_assert.assertTrue(navigation_bar_section.lbl_Navigation_bar(), "Navigation Bar is displayed in HomePage");
		logger.info("Validating if the Navigation Bar is displayed or not");
		test.pass("Validating if the Navigation Bar is displayed or not");

		soft_assert.assertEquals(navigation_bar_section.get_corporate_tab(), "Corporate");
		logger.info("Validating if the Corporate Tab is displayed or not");
		test.pass("Validating if the Corporate Tab is displayed or not");

		soft_assert.assertEquals(navigation_bar_section.get_business_tab(), "Business");
		logger.info("Validating if the Business Tab is displayed or not");
		test.pass("Validating if the Business Tab is displayed or not");

		soft_assert.assertEquals(navigation_bar_section.get_international_tab(), "International");
		logger.info("Validating if the International Tab is displayed or not");
		test.pass("Validating if the International Tab is displayed or not");	

		soft_assert.assertEquals(navigation_bar_section.get_private_banking_tab(), "Private Banking");
		logger.info("Validating if the Private Banking Tab is displayed or not");
		test.pass("Validating if the Private Banking Tab is displayed or not");

		soft_assert.assertEquals(navigation_bar_section.get_al_islami_tab(), "Al Islami");
		logger.info("Validating if the Al Islami Tab is displayed or not");
		test.pass("Validating if the Al Islami Tab is displayed or not");

		soft_assert.assertEquals(navigation_bar_section.get_gold_tab(), "Gold");
		logger.info("Validating if the Gold Tab is displayed or not");
		test.pass("Validating if the Gold Tab is displayed or not");

		soft_assert.assertEquals(navigation_bar_section.get_mashreq_securities_tab(), "Mashreq Securities");
		logger.info("Validating if the Mashreq Securities Tab is displayed or not");
		test.pass("Validating if the Mashreq Securities Tab is displayed or not");

		soft_assert.assertEquals(navigation_bar_section.get_mashreq_capital_tab(), "Mashreq Capital");
		logger.info("Validating if the Mashreq Capital Tab is displayed or not");
		test.pass("Validating if the Mashreq Capital Tab is displayed or not");

		soft_assert.assertEquals(navigation_bar_section.get_mashreq_global_services_tab(), "Mashreq Global Services");
		logger.info("Validating if the Mashreq Global Services Tab is displayed or not");
		test.pass("Validating if the Mashreq Global Services Tab is displayed or not");

		soft_assert.assertAll();

	}


	@Test
	public void Test_Mashreq_News() {	
		extent.attachReporter(htmlReporter);
		ExtentTest test = extent.createTest("Mashreq_News", "This test is to check the login");
		test.log(Status.INFO, "This TEST has been started(status, details)");

		HomePage mashreq_news = new HomePage(driver);

		soft_assert.assertTrue(mashreq_news.lbl_mashreq_news_section(), "Mashreq News section is displayed in HomePage");
		logger.info("Validating Mashreq News section in Homepage");
		test.pass("Validating Mashreq News section in Homepage");

		soft_assert.assertAll();					
	}


	@Test
	public void Test_Contact_Us_homepage() {	
		extent.attachReporter(htmlReporter);
		ExtentTest test = extent.createTest("Contact_Us_homepage Test", "This test is to check the Contact us");
		test.log(Status.INFO, "This TEST has been started(status, details)");

		HomePage contact_link = new HomePage(driver);


		soft_assert.assertTrue(contact_link.is_lnk_contact_us(), "Contact Us section is displayed in HomePage");
		logger.info("Validating Contact-Us section in Homepage");
		test.pass("Validating Contact-Us section in Homepage");

		contact_link.click_lnk_contact_us();
		logger.info("Click on Contact Us link");
		test.pass("Click on Contact Us link");

		soft_assert.assertAll();					
	}


	@Test
	public void Test_Contact_Us_Mandatory_Fields() {	
		extent.attachReporter(htmlReporter);
		ExtentTest test = extent.createTest("Contact_Us_Mandatory_Fields Test", "This test is to check the Contact_Us_Mandatory_Fields");
		test.log(Status.INFO, "This TEST has been started(status, details)");

		HomePage contact_link = new HomePage(driver);
		ContactUsPage contact_mandatory_fields = new ContactUsPage(driver);

		contact_link.click_lnk_contact_us();
		logger.info("Click on Contact Us link");
		test.pass("Click on Contact Us link");	

		contact_mandatory_fields.click_btn_submit();
		logger.info("Click on Submit button");
		test.pass("Click on Submit button");

		contact_mandatory_fields.verify_mandatory_fields();
		logger.info("Validating the no. of Mandatory fields");
		test.pass("Validating the no. of Mandatory fields");				
	}



	@Test
	public void Test_Field_I_am_looking_into() {	
		extent.attachReporter(htmlReporter);
		ExtentTest test = extent.createTest("I am Looking Into field Test", "This test is to check the field");
		test.log(Status.INFO, "This TEST has been started(status, details)");

		HomePage contact_link = new HomePage(driver);
		ContactUsPage Iam_looking_to_field = new ContactUsPage(driver);

		contact_link.click_lnk_contact_us();
		logger.info("Click on Contact Us link");
		test.pass("Click on Contact Us link");	

		Iam_looking_to_field.select_drd_iam_looking_to();
		logger.info("Select dropdown, I am Looking Into");
		test.pass("Select dropdown, I am Looking Into");			
	}


	@Test
	public void Test_Intial_Sub_Product() {	
		extent.attachReporter(htmlReporter);
		ExtentTest test = extent.createTest("Intial_Sub_Product Test", "This test is to check the login");
		test.log(Status.INFO, "This TEST has been started(status, details)");

		HomePage contact_link = new HomePage(driver);
		ContactUsPage sub_product_field = new ContactUsPage(driver);

		contact_link.click_lnk_contact_us();
		logger.info("Click on Contact Us link");
		test.pass("Click on Contact Us link");	

		sub_product_field.select_drd_initial_sub_product();
		logger.info("Select Initial Sub Product Dropdown");
		test.pass("Select Initial Sub Product Dropdown");

		sub_product_field.select_drd_product();
		logger.info("Select dropdown link");
		test.pass("Select dropdown link");

		sub_product_field.select_drd_sub_product();
		logger.info("Select dropdown sub product");
		test.pass("Select dropdown sub product");

	}

	@Test
	public void Test_Mobile_number() {	
		extent.attachReporter(htmlReporter);
		ExtentTest test = extent.createTest("Mobile_number Test", "This test is to check the Mobile Number");
		test.log(Status.INFO, "This TEST has been started(status, details)");

		HomePage contact_link = new HomePage(driver);
		ContactUsPage mobile_field = new ContactUsPage(driver);

		contact_link.click_lnk_contact_us();
		logger.info("Click on Contact Us link");
		test.pass("Click on Contact Us link");	

		mobile_field.enter_invalid_mobile_number();
		logger.info("Entering invalid phone number");
		test.pass("Entering invalid phone number");	

		mobile_field.enter_valid_mobile_number();
		logger.info("Entering valid phone number");
		test.pass("Entering valid phone number");	

	}




	@AfterMethod(alwaysRun = true)	
	public void afterTestExecution(ITestResult result) {

		extent.attachReporter(htmlReporter);

		if(ITestResult.FAILURE==result.getStatus())
		{
			test.log(Status.FAIL, result.getThrowable());
			try 
			{
				TakesScreenshot ts=(TakesScreenshot)driver;
				File source=ts.getScreenshotAs(OutputType.FILE);
				String timestamp = String.valueOf(new Date().getTime());
				FileUtils.copyFile(source, new File("./ScreenShots/"+result.getName()+ timestamp +".png"));          
			} 
			catch (Exception e)
			{
				System.out.println("Exception while taking screenshot "+e.getMessage());
			}               
		}


		driver.quit();
		extent.flush();
	}

}
