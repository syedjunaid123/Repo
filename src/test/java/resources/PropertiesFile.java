package resources;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;


public class PropertiesFile {

	static Properties dataprop = new Properties();
	public static WebDriver driver;
	private static String url;
	private static String InvalidNumber;
	private static String ValidNumber;
	
	
	public static void readPropertiesFile() {
		try {
			InputStream input = new FileInputStream("/Users/xebia/eclipse-workspace/mashreq-assessment/config.properties");
			dataprop.load(input);
			url = dataprop.getProperty("mashreq_url");
			InvalidNumber = dataprop.getProperty("InvalidNumber");
			ValidNumber = dataprop.getProperty("ValidNumber");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getURL() {
		readPropertiesFile();
		return url;
	}
	
	public static String InvalidNumber() {
		readPropertiesFile();
		return InvalidNumber;	
	}
	
	public static String ValidNumber() {
		readPropertiesFile();
		return ValidNumber;	
	}
	
}