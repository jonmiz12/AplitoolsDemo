package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    @FindBy (css = ".logged-user-name")
    WebElement loggedUserName;
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getLoggedUsername() {
        waitFor(loggedUserName);
        String loggedUsername = loggedUserName.getText();
        return loggedUsername;
    }
}
