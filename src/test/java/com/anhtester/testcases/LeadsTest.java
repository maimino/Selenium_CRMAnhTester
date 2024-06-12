package com.anhtester.testcases;

import com.anhtester.common.BaseTest;
import com.anhtester.constants.ConfigData;
import com.anhtester.helpers.ExcelHelper;
import com.anhtester.pages.DashboardPage;
import com.anhtester.pages.LeadsPage;
import com.anhtester.pages.LoginPage;
import org.testng.annotations.Test;

public class LeadsTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    LeadsPage leadsPage;

    @Test
    public void testAddNewLead(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        leadsPage = dashboardPage.clickMenuLeads();
        leadsPage.verifyLeadsPage();

        leadsPage.clickButtonNewLead();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "Lead");
        leadsPage.addNewLead(
                excelHelper.getCellData("STATUS", 1),
                excelHelper.getCellData("SOURCE", 1),
                excelHelper.getCellData("LEAD_NAME", 1),
                excelHelper.getCellData("POSITION", 1),
                excelHelper.getCellData("EMAIL_ADDRESS", 1),
                excelHelper.getCellData("WEBSITE", 1),
                excelHelper.getCellData("PHONE", 1),
                excelHelper.getCellData("LEAD_VALUE", 1),
                excelHelper.getCellData("COMPANY", 1),
                excelHelper.getCellData("ADDRESS", 1),
                excelHelper.getCellData("CITY", 1),
                excelHelper.getCellData("STATE", 1),
                excelHelper.getCellData("COUNTRY", 1),
                excelHelper.getCellData("ZIP_CODE", 1),
                excelHelper.getCellData("DESCRIPTION", 1)
        );

        leadsPage.verifyAddLeadSuccess();

        leadsPage.searchLead(excelHelper.getCellData("LEAD_NAME", 1));
    }

    @Test
    public void testAddNewLeadWithStatusNull(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        leadsPage = dashboardPage.clickMenuLeads();
        leadsPage.verifyLeadsPage();

        leadsPage.clickButtonNewLead();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "Lead");
        leadsPage.addLeadWithStatusNull(
                excelHelper.getCellData("SOURCE", 1),
                excelHelper.getCellData("LEAD_NAME", 1),
                excelHelper.getCellData("POSITION", 1),
                excelHelper.getCellData("EMAIL_ADDRESS", 1),
                excelHelper.getCellData("WEBSITE", 1),
                excelHelper.getCellData("PHONE", 1),
                excelHelper.getCellData("LEAD_VALUE", 1),
                excelHelper.getCellData("COMPANY", 1),
                excelHelper.getCellData("ADDRESS", 1),
                excelHelper.getCellData("CITY", 1),
                excelHelper.getCellData("STATE", 1),
                excelHelper.getCellData("COUNTRY", 1),
                excelHelper.getCellData("ZIP_CODE", 1),
                excelHelper.getCellData("DESCRIPTION", 1)
        );

        leadsPage.verifyAddLeadWithStatusNull();
    }

    @Test
    public void testAddNewLeadWithSourceNull(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        leadsPage = dashboardPage.clickMenuLeads();
        leadsPage.verifyLeadsPage();

        leadsPage.clickButtonNewLead();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "Lead");
        leadsPage.addLeadWithSourceNull(
                excelHelper.getCellData("STATUS", 1),
                excelHelper.getCellData("LEAD_NAME", 1),
                excelHelper.getCellData("POSITION", 1),
                excelHelper.getCellData("EMAIL_ADDRESS", 1),
                excelHelper.getCellData("WEBSITE", 1),
                excelHelper.getCellData("PHONE", 1),
                excelHelper.getCellData("LEAD_VALUE", 1),
                excelHelper.getCellData("COMPANY", 1),
                excelHelper.getCellData("ADDRESS", 1),
                excelHelper.getCellData("CITY", 1),
                excelHelper.getCellData("STATE", 1),
                excelHelper.getCellData("COUNTRY", 1),
                excelHelper.getCellData("ZIP_CODE", 1),
                excelHelper.getCellData("DESCRIPTION", 1)
        );

        leadsPage.verifyAddLeadWithSourceNull();
    }

    @Test
    public void testAddNewLeadWithNameNull(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        leadsPage = dashboardPage.clickMenuLeads();
        leadsPage.verifyLeadsPage();

        leadsPage.clickButtonNewLead();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "Lead");
        leadsPage.addLeadWithNameNull(
                excelHelper.getCellData("STATUS", 1),
                excelHelper.getCellData("SOURCE", 1),
                excelHelper.getCellData("POSITION", 1),
                excelHelper.getCellData("EMAIL_ADDRESS", 1),
                excelHelper.getCellData("WEBSITE", 1),
                excelHelper.getCellData("PHONE", 1),
                excelHelper.getCellData("LEAD_VALUE", 1),
                excelHelper.getCellData("COMPANY", 1),
                excelHelper.getCellData("ADDRESS", 1),
                excelHelper.getCellData("CITY", 1),
                excelHelper.getCellData("STATE", 1),
                excelHelper.getCellData("COUNTRY", 1),
                excelHelper.getCellData("ZIP_CODE", 1),
                excelHelper.getCellData("DESCRIPTION", 1)
        );

        leadsPage.verifyAddLeadWithNameNull();
    }

    @Test
    public void testUpdateLead(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        leadsPage = dashboardPage.clickMenuLeads();
        leadsPage.verifyLeadsPage();

        leadsPage.clickButtonEditLead();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "Lead");
        leadsPage.editLead(
                excelHelper.getCellData("STATUS", 1),
                excelHelper.getCellData("SOURCE", 1),
                excelHelper.getCellData("LEAD_NAME", 1),
                excelHelper.getCellData("POSITION", 1),
                excelHelper.getCellData("EMAIL_ADDRESS", 1),
                excelHelper.getCellData("WEBSITE", 1),
                excelHelper.getCellData("PHONE", 1),
                excelHelper.getCellData("LEAD_VALUE", 1),
                excelHelper.getCellData("COMPANY", 1),
                excelHelper.getCellData("ADDRESS", 1),
                excelHelper.getCellData("CITY", 1),
                excelHelper.getCellData("STATE", 1),
                excelHelper.getCellData("COUNTRY", 1),
                excelHelper.getCellData("ZIP_CODE", 1),
                excelHelper.getCellData("DESCRIPTION", 1)
        );

        leadsPage.verifyEditLeadSuccess();
    }

    @Test
    public void testDeleteLead() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        leadsPage = dashboardPage.clickMenuLeads();
        leadsPage.verifyLeadsPage();

        leadsPage.deleteLead();
        leadsPage.verifyDeleteProjectSuccess();
    }
}
