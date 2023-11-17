package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tests.BaseTest;

import java.util.List;

public class RecentTransactionsTable extends BasePage {
    final static String transTable = ".table";
    @FindBy (css = transTable)
    WebElement RecentTransactionsTable;
    @FindBy (css = transTable + " tr>th")
    List<WebElement> headerCells;
    @FindBy (css = transTable + ">tbody>tr")
    List<WebElement> tableRows;
    public RecentTransactionsTable(WebDriver driver) {
        super(driver);
    }

    public int countRowsContain (String column, String cellContent) {
        scrollIntoView(RecentTransactionsTable);
        int columnNum = returnCulomnContain(column);
        int rowsContainNum=0;
        List<WebElement> rowCells;
        for (WebElement row : tableRows) {
            rowCells = row.findElements(By.cssSelector("td"));
            if (rowCells.get(columnNum).getText().equals(cellContent)) {
                rowsContainNum++;
            }
        }
        return rowsContainNum;
    }

    private int returnCulomnContain (String column) {
        int columnNum=-1;
        for (int i=0; i<headerCells.size(); i++) {
            if (headerCells.get(i).getText().contains(column)) {
                columnNum=i;
                break;
            }
        }
        return columnNum;
    }
}
