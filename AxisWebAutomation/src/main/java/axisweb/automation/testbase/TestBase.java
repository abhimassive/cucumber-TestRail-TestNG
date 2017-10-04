package axisweb.automation.testbase;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;

import axisweb.automation.excelReader.Excel_Reader;

public class TestBase {

	public WebDriver driver;
	Excel_Reader excel;
	public Properties OR = new Properties();
	public ITestResult result;

	String url = "https://qa2.massiveaxis.com/";
	String browser = "firefox";

	public void init() {
		selectBrowser(browser);
		getURL(url);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void selectBrowser(String browser) {
		System.out.println(System.getProperty("os.name"));
		if (System.getProperty("os.name").contains("Window")) {
			if (browser.equals("chrome")) {
				System.out.println(System.getProperty("user.dir"));
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equals("firefox")) {
				System.out.println(System.getProperty("user.dir"));
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "/drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}
		} else if (System.getProperty("os.name").contains("Mac")) {
			if (browser.equals("chrome")) {
				System.out.println(System.getProperty("user.dir"));
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
				driver = new ChromeDriver();
			} else if (browser.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver");
				driver = new FirefoxDriver();
			}
		}
	}

	public void getURL(String url) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get(url);
	}

}
