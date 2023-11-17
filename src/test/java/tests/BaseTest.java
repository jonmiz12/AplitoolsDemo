package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.RecentTransactionsTable;
import utils.Utils;

import java.io.IOException;

public class BaseTest {

    String username = Utils.readProperty("username");
    String password = Utils.readProperty("password");
    String url = Utils.readProperty("url");
    String expectedName = Utils.readProperty("name");
    String culomnName = Utils.readProperty("columnName");
    String expectedCellContent = Utils.readProperty("expectedCellContent");
    int expectedTransactionNum = Integer.parseInt(Utils.readProperty("expectedTransactionNum"));
    WebDriver driver;
    public LoginPage LoginPage;
    public HomePage HomePage;
    public RecentTransactionsTable recentTransactionsTable;

    public void initializeObjects (){
        LoginPage = new LoginPage(driver);
        HomePage = new HomePage(driver);
        recentTransactionsTable = new RecentTransactionsTable(driver);
    }

    @BeforeMethod
    public void setup(){
        try {
            Runtime.getRuntime().exec("taskkill.exe /F /IM chromedriver.exe /T" + "cmd.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Utils.readProperty("url"));
        initializeObjects();
    }

//    @AfterMethod
    public void TearDown(){
        driver.quit();
    }
}
