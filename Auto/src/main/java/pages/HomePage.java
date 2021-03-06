package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbase.TestBase;

import java.util.List;

public class HomePage extends TestBase {

    @FindBy(linkText = "Sign In")
    public WebElement signIn;
    @FindBy(id = "email")
    public WebElement login_email;
    @FindBy(id = "password")
    public WebElement login_password;
    @FindBy(xpath = "//button[@class='account-btn__input account-btn__input--primary sign-in-form__sign-in']")
    public WebElement login_button;
    @FindBy(css = ".profile-icon__initial.uppercase")
    public WebElement profile_icon;
    @FindBy(css = ".sign-in-form__error")
    public WebElement login_error_msg;
    @FindBy(xpath = "//div[@class='profile-circle__letter uppercase']")
    public WebElement profiles_circle;
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickSignIn() {
        signIn.click();
    }

    public void clickLoginButton() {
        login_button.submit();
    }

    public String whosWatching() {

        boolean found = driver.findElement(By.xpath("//span[@class='profile-icon__initial uppercase']")).isDisplayed();

        if (found == false) {
            List<WebElement> listOfWatchers = driver.findElements(By.xpath("//div[@class='profile-circle__letter uppercase']"));
            listOfWatchers.get(0).click();
            getProfileIconLetter();

        } else {
            getProfileIconLetter();
        }

        return getProfileIconLetter();
    }

    public String getProfileIconLetter() {
        return profile_icon.getText();
    }

    public String actualLoginErrorMessage() throws InterruptedException {

        return login_error_msg.getText();


    }
}


