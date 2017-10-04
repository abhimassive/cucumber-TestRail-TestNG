package axisweb.automation.uiActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountDetails {
	
	WebDriver driver;

	public AccountDetails(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".profile-icon__initial.uppercase")
	WebElement account_badge;
	
	public void clickOnAccountBadge() {
		System.out.println("account_badge   "+account_badge);
		account_badge.click();
	}

}
