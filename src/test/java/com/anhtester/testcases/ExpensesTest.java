package com.anhtester.testcases;

import com.anhtester.common.BaseTest;
import com.anhtester.constants.ConfigData;
import com.anhtester.helpers.ExcelHelper;
import com.anhtester.pages.DashboardPage;
import com.anhtester.pages.ExpensesPage;
import com.anhtester.pages.LoginPage;
import org.testng.annotations.Test;

public class ExpensesTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    ExpensesPage expensesPage;

    @Test
    public void testAddNewRecordExpense(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        expensesPage = dashboardPage.clickMenuExpenses();
        expensesPage.verifyExpensesPage();

        expensesPage.clickButtonAddRecordExpense();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "Expense");
        expensesPage.addRecordExpense(
                excelHelper.getCellData("EXPENSE_NAME", 1),
                excelHelper.getCellData("NOTE", 1),
                excelHelper.getCellData("EXPENSE_CATEGORY", 1),
                excelHelper.getCellData("EXPENSE_DATE", 1),
                excelHelper.getCellData("AMOUNT", 1),
                excelHelper.getCellData("CUSTOMER", 1),
                excelHelper.getCellData("PROJECT_NAME", 1),
                excelHelper.getCellData("PAYMENT_MODE", 1)
        );

        expensesPage.verifyAddRecordExpenseSuccess();
    }

    @Test
    public void testAddRecordExpenseWithExpenseCategoryNull(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        expensesPage = dashboardPage.clickMenuExpenses();
        expensesPage.verifyExpensesPage();

        expensesPage.clickButtonAddRecordExpense();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "Expense");
        expensesPage.addRecordExpenseWithExpenseCategoryNull(
                excelHelper.getCellData("EXPENSE_NAME", 1),
                excelHelper.getCellData("NOTE", 1),
                excelHelper.getCellData("EXPENSE_DATE", 1),
                excelHelper.getCellData("AMOUNT", 1),
                excelHelper.getCellData("CUSTOMER", 1),
                excelHelper.getCellData("PROJECT_NAME", 1),
                excelHelper.getCellData("PAYMENT_MODE", 1)
        );

        expensesPage.verifyAddRecordExpenseWithExpenseCategoryNull();
    }

    @Test
    public void testAddRecordExpenseWithAmountNull(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        expensesPage = dashboardPage.clickMenuExpenses();
        expensesPage.verifyExpensesPage();

        expensesPage.clickButtonAddRecordExpense();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "Expense");
        expensesPage.addRecordExpenseWithAmountNull(
                excelHelper.getCellData("EXPENSE_NAME", 1),
                excelHelper.getCellData("NOTE", 1),
                excelHelper.getCellData("EXPENSE_CATEGORY", 1),
                excelHelper.getCellData("EXPENSE_DATE", 1),
                excelHelper.getCellData("CUSTOMER", 1),
                excelHelper.getCellData("PROJECT_NAME", 1),
                excelHelper.getCellData("PAYMENT_MODE", 1)
        );

        expensesPage.verifyAddRecordExpenseWithAmountNull();
    }

    @Test
    public void testUpdateRecordExpense(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        expensesPage = dashboardPage.clickMenuExpenses();
        expensesPage.verifyExpensesPage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "Expense");
        //expensesPage.searchRecordExpense(excelHelper.getCellData("EXPENSE_NAME", 1));

        expensesPage.clickButtonEditRecordExpense();
        expensesPage.verifyEditExpensePage();

        expensesPage.editRecordExpense(
                excelHelper.getCellData("EXPENSE_NAME", 1),
                excelHelper.getCellData("NOTE", 1),
                excelHelper.getCellData("EXPENSE_CATEGORY", 1),
                excelHelper.getCellData("EXPENSE_DATE", 1),
                excelHelper.getCellData("AMOUNT", 1),
                excelHelper.getCellData("CUSTOMER", 1),
                excelHelper.getCellData("PROJECT_NAME", 1),
                excelHelper.getCellData("PAYMENT_MODE", 1)
        );

        expensesPage.verifyUpdateExpenseSuccess();
    }

    @Test
    public void testDeleteRecordExpense(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        expensesPage = dashboardPage.clickMenuExpenses();
        expensesPage.verifyExpensesPage();

        expensesPage.deleteRecordExpense();
        expensesPage.verifyDeleteRecordExpenseSuccess();
    }

}
