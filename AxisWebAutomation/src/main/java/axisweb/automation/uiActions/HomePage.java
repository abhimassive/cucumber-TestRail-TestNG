package axisweb.automation.uiActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Sign In")
	WebElement signIn;

	@FindBy(id = "email")
	WebElement login_email;

	@FindBy(id = "password")
	WebElement login_password;

	@FindBy(xpath = "//button[@class='account-btn__input account-btn__input--primary sign-in-form__sign-in']")
	WebElement login_button;

	WebElement login_error;

	public void loginToWebApp(String email_id, String password) {

		signIn.click();
		login_email.sendKeys(email_id);
		login_password.sendKeys(password);
		login_button.submit();

	}

	public String getPageTitle() {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.titleContains("Home"));

		return driver.getTitle();

	}

	public String getLoginErrorMsg() {

		WebDriverWait wait = new WebDriverWait(driver, 30);

		try {
			login_error = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='sign-in-form__error']")));

			String error_msg_txt = login_error.getText();

			System.out.println("Actual Error Message is : " + error_msg_txt);
			return error_msg_txt;

		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}

	}

}
