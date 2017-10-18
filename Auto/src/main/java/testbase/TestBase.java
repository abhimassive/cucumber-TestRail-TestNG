package testbase;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver; //******DON'T REMOVE "static" KEYWORD FROM WEBDRIVER******* 17-OCT-2017
    public String nodeURL;
    //TestListener lis;

    public WebDriver getDriver() {
        return driver;
    }


    //String browserName = "grid";

    public void setupTest() {
        String browser = null;
        try {
            File fXmlFile = new File("/Users/abhi/Auto/Axis_Sprint_1.xml");
            //File fXmlFile = new File(System.getProperty("user.dir") + "/Axis_Sprint_1.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("parameter");

            System.out.println("----------------------------");

            for (int temp = 0; temp < nodeList.getLength(); temp++) {

                Node nNode = nodeList.item(temp);

                //System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;
                    if (eElement.getAttribute("name").equalsIgnoreCase("browserName")) {
                        browser = eElement.getAttribute("value");
                        break;
                    }

                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        init(browser);
    }


    public void init(String brow) {
        //lis = new TestListener(driver);
        selectBrowser(brow);
    }

    public void selectBrowser(String browserName) {
        if (System.getProperty("os.name").contains("Window")) {
            if (browserName.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver",
                        System.getProperty("user.dir") + "/drivers/chromedriver.exe");
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("firefox")) {
                System.out.println(System.getProperty("user.dir"));
                System.setProperty("webdriver.gecko.driver",
                        System.getProperty("user.dir") + "/drivers/geckodriver.exe");
                driver = new FirefoxDriver();
            }
        } else if (System.getProperty("os.name").contains("Mac")) {
            if (browserName.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver");
                driver = new FirefoxDriver();
            } else if (browserName.equalsIgnoreCase("opera")) {
                System.setProperty("webdriver.opera.driver", System.getProperty("user.dir") + "/drivers/operadriver");
                driver = new OperaDriver();
            } else if (browserName.equalsIgnoreCase("safari")) {
                driver = new SafariDriver();
            } else if (browserName.equalsIgnoreCase("phantom")) {
                System.setProperty("phantomjs.binary.path", System.getProperty("user.dir") + "/drivers/phantomjs");
                driver = new PhantomJSDriver();
            } else if (browserName.equalsIgnoreCase("HeadlessChrome")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("headless");
                driver = new ChromeDriver(options);
            } else if (browserName.equalsIgnoreCase("unit")) {
                java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(java.util.logging.Level.OFF);
                java.util.logging.Logger.getLogger("org.apache.http").setLevel(java.util.logging.Level.OFF);
                driver = new HtmlUnitDriver();
            } else if (browserName.equalsIgnoreCase("grid")) {
                try {
                    nodeURL = "http://10.0.2.111:5555/wd/hub";
                    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                    capabilities.setBrowserName("chrome");
                    capabilities.setPlatform(Platform.MAC);
                    driver = new RemoteWebDriver(new URL(nodeURL), capabilities);
                    System.out.println("DRIVER  " + driver);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    }

    /*public void waitForElement(WebDriver driver, int timeOutInSeconds, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }*/

    public WebElement waitForElement(WebDriver driver, WebElement element, long timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;


    }

}













































    /* Cucumber Setup */

    /*@Before
    public void setup() {

        System.out.println(System.getProperty("os.name"));

        if (System.getProperty("os.name").contains("Window")) {
            if (browserName.equals("chrome")) {
                System.out.println(System.getProperty("user.dir"));
                System.setProperty("webdriver.chrome.driver",
                        System.getProperty("user.dir") + "/drivers/chromedriver.exe");
                driver = new ChromeDriver();
            } else if (browserName.equals("firefox")) {
                System.out.println(System.getProperty("user.dir"));
                System.setProperty("webdriver.gecko.driver",
                        System.getProperty("user.dir") + "/drivers/geckodriver.exe");
                driver = new FirefoxDriver();
            }
        } else if (System.getProperty("os.name").contains("Mac")) {
            if (browserName.equals("chrome")) {
                System.out.println(System.getProperty("user.dir"));
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
                driver = new ChromeDriver();
            } else if (browserName.equals("firefox")) {
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



