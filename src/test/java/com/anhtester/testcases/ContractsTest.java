package com.anhtester.testcases;

import com.anhtester.common.BaseTest;
import com.anhtester.constants.ConfigData;
import com.anhtester.helpers.ExcelHelper;
import com.anhtester.pages.ContractsPage;
import com.anhtester.pages.DashboardPage;
import com.anhtester.pages.LoginPage;
import org.testng.annotations.Test;

public class ContractsTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    ContractsPage contractsPage;

    @Test
    public void testAddNewContract(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        contractsPage = dashboardPage.clickMenuContracts();
        contractsPage.verifyContractsPage();

        contractsPage.clickButtonAddNewContract();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "Contract");
        contractsPage.addNewContract(
                excelHelper.getCellData("CUSTOMER", 1),
                excelHelper.getCellData("PROJECT_NAME", 1),
                excelHelper.getCellData("SUBJECT", 1),
                excelHelper.getCellData("CONTRACT_VALUE", 1),
                excelHelper.getCellData("CONTRACT_TYPE", 1),
                excelHelper.getCellData("START_DATE", 1),
                excelHelper.getCellData("END_DATE", 1),
                excelHelper.getCellData("DESCRIPTION", 1)
        );

        contractsPage.verifyAddNewContractSuccess();
        contractsPage.clickMenuContracts();
        contractsPage.searchContract(excelHelper.getCellData("SUBJECT", 1));
    }

    @Test
    public void testAddContractWithCustomerNull(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        contractsPage = dashboardPage.clickMenuContracts();
        contractsPage.verifyContractsPage();

        contractsPage.clickButtonAddNewContract();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "Contract");
        contractsPage.addContractWithCustomerNull(
                excelHelper.getCellData("SUBJECT", 1),
                excelHelper.getCellData("CONTRACT_VALUE", 1),
                excelHelper.getCellData("CONTRACT_TYPE", 1),
                excelHelper.getCellData("START_DATE", 1),
                excelHelper.getCellData("END_DATE", 1),
                excelHelper.getCellData("DESCRIPTION", 1)
        );

        contractsPage.verifyAddContractWithCustomerNull();
    }

    @Test
    public void testAddContractWithSubjectNull(){

        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        contractsPage = dashboardPage.clickMenuContracts();
        contractsPage.verifyContractsPage();

        contractsPage.clickButtonAddNewContract();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "Contract");
        contractsPage.addContractWithSubjectNull(
                excelHelper.getCellData("CUSTOMER", 1),
                excelHelper.getCellData("PROJECT_NAME", 1),
                excelHelper.getCellData("CONTRACT_VALUE", 1),
                excelHelper.getCellData("CONTRACT_TYPE", 1),
                excelHelper.getCellData("START_DATE", 1),
                excelHelper.getCellData("END_DATE", 1),
                excelHelper.getCellData("DESCRIPTION", 1)
        );

        contractsPage.verifyAddContractWithSubjectNull();
    }

    @Test
    public void testUpdateContract(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        contractsPage = dashboardPage.clickMenuContracts();
        contractsPage.verifyContractsPage();

        contractsPage.clickButtonEditContract();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "Contract");
        contractsPage.editContract(
                excelHelper.getCellData("CUSTOMER", 1),
                excelHelper.getCellData("PROJECT_NAME", 1),
                excelHelper.getCellData("SUBJECT", 1),
                excelHelper.getCellData("CONTRACT_VALUE", 1),
                excelHelper.getCellData("CONTRACT_TYPE", 1),
                excelHelper.getCellData("START_DATE", 1),
                excelHelper.getCellData("END_DATE", 1),
                excelHelper.getCellData("DESCRIPTION", 1)
        );

        contractsPage.verifyUpdateContractSuccess();
    }

    @Test
    public void testDeleteContract(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        contractsPage = dashboardPage.clickMenuContracts();
        contractsPage.verifyContractsPage();

        contractsPage.deleteContract();
        contractsPage.verifyDeleteContractSuccess();
    }
}
