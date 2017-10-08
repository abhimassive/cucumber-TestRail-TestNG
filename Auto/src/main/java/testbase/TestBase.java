package testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public WebDriver driver;
    //public ITestResult result;
    String browser = "firefox";

    public void init() {
        selectBrowser(browser);
    }

    /*public WebDriver getDriver() {
        return driver;
    }*/

    public void selectBrowser(String browser) {
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
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }


    /* Cucumber Setup */

    /*@Before
    public void setup() {

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

        System.out.println("Driver  " + driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }


    @After
    public void endTest() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();

    }*/


}
