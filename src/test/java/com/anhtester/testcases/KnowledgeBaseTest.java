package com.anhtester.testcases;

import com.anhtester.common.BaseTest;
import com.anhtester.constants.ConfigData;
import com.anhtester.helpers.ExcelHelper;
import com.anhtester.pages.DashboardPage;
import com.anhtester.pages.KnowledgeBasePage;
import com.anhtester.pages.LoginPage;
import org.testng.annotations.Test;

public class KnowledgeBaseTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    KnowledgeBasePage knowledgeBasePage;

    @Test
    public void testAddNewArticle(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        knowledgeBasePage = dashboardPage.clickMenuKnowledgeBase();
        knowledgeBasePage.verifyKnowledgeBasePage();

        knowledgeBasePage.clickButtonNewArticle();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "Knowledge Base");
        knowledgeBasePage.addNewArticle(
                excelHelper.getCellData("ARTICLE_NAME", 1),
                excelHelper.getCellData("GROUP", 1),
                excelHelper.getCellData("ARTICLE_DESCRIPTION", 1)
        );

        knowledgeBasePage.verifyAddArticleSuccess();
        knowledgeBasePage.searchLead(excelHelper.getCellData("ARTICLE_NAME", 1));
    }

    @Test
    public void testAddArticleWithSubjectNull(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        knowledgeBasePage = dashboardPage.clickMenuKnowledgeBase();
        knowledgeBasePage.verifyKnowledgeBasePage();

        knowledgeBasePage.clickButtonNewArticle();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "Knowledge Base");
        knowledgeBasePage.addArticleWithSubjectNull(
                excelHelper.getCellData("GROUP", 1),
                excelHelper.getCellData("ARTICLE_DESCRIPTION", 1)
        );

        knowledgeBasePage.verifyAddArticleWithSubjectNull();
    }

    @Test
    public void testAddArticleWithGroupNull(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        knowledgeBasePage = dashboardPage.clickMenuKnowledgeBase();
        knowledgeBasePage.verifyKnowledgeBasePage();

        knowledgeBasePage.clickButtonNewArticle();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "Knowledge Base");
        knowledgeBasePage.addArticleWithGroupNull(
                excelHelper.getCellData("ARTICLE_NAME", 1),
                excelHelper.getCellData("ARTICLE_DESCRIPTION", 1)
        );

        knowledgeBasePage.verifyAddArticleWithGroupNull();
    }

    @Test
    public void testUpdateArticle(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        knowledgeBasePage = dashboardPage.clickMenuKnowledgeBase();
        knowledgeBasePage.verifyKnowledgeBasePage();

        knowledgeBasePage.clickButtonEditArticle();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "Knowledge Base");
        knowledgeBasePage.editArticle(
                excelHelper.getCellData("ARTICLE_NAME", 1),
                excelHelper.getCellData("GROUP", 1),
                excelHelper.getCellData("ARTICLE_DESCRIPTION", 1)
        );

        knowledgeBasePage.verifyEditArticleSuccess();
    }

    @Test
    public void testDeleteArticle(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        knowledgeBasePage = dashboardPage.clickMenuKnowledgeBase();
        knowledgeBasePage.verifyKnowledgeBasePage();

        knowledgeBasePage.clickButtonDeleteArticle();
        knowledgeBasePage.verifyDeleteArticleSuccess();
    }
}
