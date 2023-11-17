package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy (css = "#username")
    WebElement UsernameField;
    @FindBy (css = "#password")
    WebElement passwordField;
    @FindBy (css = "#log-in")
    WebElement LoginBtn;
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public String login (String username, String password, HomePage HomePage) {
        fillText(UsernameField, username);
        fillText(passwordField, password);
        click(LoginBtn);
        return HomePage.getLoggedUsername();
    }
}
