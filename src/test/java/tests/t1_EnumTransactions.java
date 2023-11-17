package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class t1_EnumTransactions extends BaseTest{

    @Description ("Counts the rows that has an expected column name and cell content of the transaction table")
    @Test
    public void tc01_assertCompletedTransaction () {
        String actualName = LoginPage.login(username,password, HomePage);
        LoginPage.assertEquals(actualName, expectedName);
        int actualResult = recentTransactionsTable.countRowsContain(culomnName, expectedCellContent);
        recentTransactionsTable.assertEquals(actualResult, expectedTransactionNum);
    }
}
