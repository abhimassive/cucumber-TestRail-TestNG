package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbase.TestBase;

import java.util.List;

public class MoviesPage extends TestBase {

    @FindBy(xpath = "//div[@class = 'packshot__image packshot__image--poster']")
    WebElement movie_posters;


    @FindBy(xpath = ".//span[text()='Bookmark']")
    WebElement bookmark;

    @FindBy(xpath = ".//span[text()='Bookmarked']")
    WebElement bookmarked;

    @FindBy(xpath = ".//span[text()='Remove Bookmark']")
    WebElement remove_bookmark;

    WebDriver driver;

    public MoviesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void getMoviesList() throws InterruptedException {
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(5000);

        System.out.println("Movie Names Sorted A-Z");
        System.out.println("-----------------------------------------------");

        List<WebElement> movie_title = driver.findElements(By.xpath("//a[@class='packshot packshot--poster packshot-list__packshot col col-phone-8 col-phablet-6 col-laptop-4 col-desktopWide-3']"));
        for (int i = 0; i < movie_title.size(); i++) {
            System.out.println(movie_title.get(i).getAttribute("title"));
        }

    }


    public void setBookmark() {
        bookmark.click();
    }
}






/*
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("packshot__image packshot__image--poster")));

*/
//WebElement movie_title = driver.findElement(By.xpath("//a[@class='packshot packshot--poster packshot-list__packshot col col-phone-8 col-phablet-6 col-laptop-4 col-desktopWide-3']"));

//List<WebElement> movie_list = driver.findElements(By.xpath("//*[contains(concat( \" \", @class, \" \" ), concat( \" \", \"img-r\", \" \" ))]"));

//List<WebElement> movie_list = driver.findElements(By.tagName("img"));

