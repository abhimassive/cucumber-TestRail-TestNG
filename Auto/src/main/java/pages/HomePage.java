package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    //WebDriver driver;

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
    public WebElement actual_login_error_msg;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickSignIn() {
        signIn.click();
    }


    public void enterCredenials(String email_id, String password) {
        login_email.sendKeys(email_id);
        login_password.sendKeys(password);
    }

    public void clickLoginButton() {
        login_button.submit();
    }

    public String getProfileIconLetter() {
        return profile_icon.getText();
    }

    public String actualLoginErrorMessage() {
        return actual_login_error_msg.getText();
    }
/*
       profile
        return "abcd";

    }

    public String getLoginErrorMsg() {

       /*WebDriverWait wait = new WebDriverWait(driver, 30);

        try {
            login_error = wait
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='sign-in-form__error']")));

            String error_msg_txt = login_error.getText();

            System.out.println("Actual Error Message is : " + error_msg_txt);
            return error_msg_txt;

        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }*/

}


